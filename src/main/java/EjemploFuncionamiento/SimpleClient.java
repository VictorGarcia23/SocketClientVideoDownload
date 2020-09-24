package EjemploFuncionamiento;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient {

    public static void main(String args[]) throws Exception {

        Scanner sc=new Scanner(System.in);

        Socket s = new Socket("localhost", 3333);
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        System.out.println("Escribe el mensaje");
        dout.writeUTF(sc.nextLine());
        dout.close();
        s.close();
    }
}
