import java.net.*;
import java.io.*;
import java.net.*;


public class Main {
    public static void main(String[] args) throws MalformedURLException {
        InetAddress myIP = null;
        try {
            myIP = InetAddress.getLocalHost();}
        catch (UnknownHostException e) {}
        System.out.println(myIP);

        InetAddress bsu = null;
        try {
            bsu = InetAddress.getByName("www.sutkt.ru"); }
        catch (UnknownHostException e){ }
        System.out.println(bsu);

        URL aURL = new URL("http://java.sun.com:80/docs/books/tutorial"
                + "/index.html?name=networking#DOWNLOADING");
        System.out.println("protocol = " + aURL.getProtocol());
        System.out.println("authority = " + aURL.getAuthority());
        System.out.println("host = " + aURL.getHost());
        System.out.println("port = " + aURL.getPort());
        System.out.println("path = " + aURL.getPath());
        System.out.println("query = " + aURL.getQuery());
        System.out.println("filename = " + aURL.getFile());
        System.out.println("ref = " + aURL.getRef());

        Socket s = null;
        try {//посылка строки клиенту
            ServerSocket server = new ServerSocket(3456);
            s = server.accept();
            PrintStream ps = new PrintStream(s.getOutputStream());
            ps.println("Какое-то прикольное сообщение!!!!");
            ps.flush();
            s.close(); // разрыв соединения
        }catch (IOException e){System.out.println("ошибка: " + e); }

    }
}
