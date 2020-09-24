package EjemploFuncionamiento;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    public static void main(String[] args) throws IOException {

        ServerSocket ss=new ServerSocket(3333);
        System.out.println("Escuchando peticiones");
        Socket s= ss.accept();

        DataInputStream din= new DataInputStream(s.getInputStream());

        String str= din.readUTF();

        System.out.println("client says: " + str);
        din.close();
        s.close();
        ss.close();

    }
}
