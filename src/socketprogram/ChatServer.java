package socketprogram;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import javax.crypto.SecretKey;

public class ChatServer {
    private final int port;
    private final SecretKey key; // kept for optional verification, not required for forwarding
    private final Set<ClientHandler> clients = ConcurrentHashMap.newKeySet();

    public ChatServer(int port, SecretKey key) {
        this.port = port;
        this.key = key;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("[Server] Listening on port " + port + " …");
            while (true) {
                Socket socket = serverSocket.accept();
                socket.setTcpNoDelay(true);
                ClientHandler handler = new ClientHandler(socket, this);
                clients.add(handler);
                handler.start();
            }
        }
    }

    void broadcast(String encryptedLine, ClientHandler from) {
        for (ClientHandler ch : clients) {
            if (ch != from) {
                ch.send(encryptedLine);
            }
        }
    }

    void remove(ClientHandler ch) {
        clients.remove(ch);
    }

    public static void main(String[] args) throws Exception {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : 5000;
        String secret = System.getenv().getOrDefault("CHAT_SECRET", "changeme-please");
        SecretKey key = Crypto.deriveKey(secret.toCharArray());
        new ChatServer(port, key).start();
    }
}