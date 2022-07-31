import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class HTTPServer {
    public static void main(String[] args) throws IOException {
        final int port = 8080;
        final ServerSocket server = new ServerSocket(port);
        System.out.println(String.format("Listening for connection on port %d", port));
        while (true) {
            try (Socket client = server.accept()) {
                Date date = new Date();
                String response = "HTTP/1.1 200 OK\r\n\r\n" + date;
                client.getOutputStream()
                        .write(response.getBytes("UTF-8"));
                System.out.println("Responded");
                break;
            }
        }
    }
}