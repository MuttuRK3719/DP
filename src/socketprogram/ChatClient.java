package socketprogram;
import javax.crypto.SecretKey;
import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ChatClient {
    private final String host;
    private final int port;
    private final String username;
    private final SecretKey key;

    public ChatClient(String host, int port, String username, SecretKey key) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.key = key;
    }

    public void start() {
        int backoff = 1000; // ms
        while (true) {
            try (Socket socket = new Socket(host, port)) {
                socket.setTcpNoDelay(true);
                System.out.println("[Client] Connected to " + host + ":" + port);

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

                Thread reader = new Thread(() -> readLoop(in));
                Thread writer = new Thread(() -> writeLoop(out));
                reader.setDaemon(true);
                writer.setDaemon(true);
                reader.start();
                writer.start();

                // Wait for either to finish (disconnect or EOF)
                reader.join();
                System.out.println("[Client] Disconnected. Reconnecting…");
            } catch (Exception e) {
                System.out.println("[Client] Connection failed: " + e.getMessage());
            }
            // Exponential backoff up to 16s
            try { Thread.sleep(backoff); } catch (InterruptedException ignored) {}
            backoff = Math.min(backoff * 2, 16_000);
        }
    }

    private void readLoop(BufferedReader in) {
        String line;
        try {
            while ((line = in.readLine()) != null) {
                try {
                    String msg = Crypto.decrypt(line, key);
                    // Protocol: "sender\tmessage"
                    int tab = msg.indexOf('\t');
                    if (tab > 0) {
                        String from = msg.substring(0, tab);
                        String text = msg.substring(tab + 1);
                        System.out.println("[" + from + "] " + text);
                    } else {
                        System.out.println(msg);
                    }
                } catch (Exception ex) {
                    // Skip malformed frames
                }
            }
        } catch (IOException ignored) {}
    }

    private void writeLoop(PrintWriter out) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String text = scanner.nextLine();
            if (text == null) break;
            if (text.equalsIgnoreCase("/quit")) {
                System.out.println("[Client] Bye!");
                System.exit(0);
            }
            String stamped = username + "\t" + text;
            try {
                String enc = Crypto.encrypt(stamped, key);
                out.println(enc);
            } catch (Exception e) {
                System.out.println("[Client] Failed to send message: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String host = args.length > 0 ? args[0] : "127.0.0.1";
        int port = args.length > 1 ? Integer.parseInt(args[1]) : 5000;
        String user = args.length > 2 ? args[2] : (System.getProperty("user.name", "user") + (int)(Math.random()*1000));
        String secret = System.getenv().getOrDefault("CHAT_SECRET", "changeme-please");
        SecretKey key = Crypto.deriveKey(secret.toCharArray());

        System.out.println("[Client] User: " + user + ", server: " + host + ":" + port);
        System.out.println("Type messages and press Enter to send. Use /quit to exit.");

        new ChatClient(host, port, user, key).start();
    }
}

