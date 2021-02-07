import java.io.*;
import java.net.*;
public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        try {//получение строки клиентом
            socket = new Socket("localhost", 3456);
            BufferedReader dis = new BufferedReader(new
                    InputStreamReader(socket.getInputStream()));
            String msg = dis.readLine();
            System.out.println(msg);
        } catch (IOException e) {
            System.out.println("ошибка: " + e);
        }
    }
}