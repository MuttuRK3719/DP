package socketprogram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

class ClientHandler extends Thread {
    private final Socket socket;
    private final ChatServer server;
    private PrintWriter out;
    private BufferedReader in;

    ClientHandler(Socket socket, ChatServer server) {
        super("ClientHandler-" + socket.getRemoteSocketAddress());
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        System.out.println("[Server] Client connected: " + socket.getRemoteSocketAddress());
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

            String line;
            while ((line = in.readLine()) != null) {
                // Optional: light validation (length, base64 looks sane)
                if (line.length() < 16) continue; // ignore obviously invalid frames
                server.broadcast(line, this);
            }
        } catch (IOException e) {
            // client likely disconnected
        } finally {
            closeQuietly();
            server.remove(this);
            System.out.println("[Server] Client disconnected: " + socket.getRemoteSocketAddress());
        }
    }

    void send(String line) {
        try {
            if (out != null) out.println(line);
        } catch (Exception ignored) {}
    }

    private void closeQuietly() {
        try { if (in != null) in.close(); } catch (Exception ignored) {}
        try { if (out != null) out.close(); } catch (Exception ignored) {}
        try { socket.close(); } catch (Exception ignored) {}
    }
}