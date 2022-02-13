import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket servSocket = new ServerSocket(23444);

        while (true) {
            try (Socket socket = servSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String line;
                while ((line = in.readLine()) != null) {
                    if (line.equals("end")) {
                        break;
                    }

                    int fiboNumber = Integer.parseInt(line);
                    out.println(fiboNumber + " число Фибоначчи = " + fibonacci(fiboNumber));
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    public static BigInteger fibonacci(int n) {
        if (n == 1 || n == 2)
            return BigInteger.valueOf(1);
        return fibonacci(n - 1).add(fibonacci(n - 2));
    }
}
