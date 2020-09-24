package EjemploSemaforos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Servidor {

    public static void main(String[] args) throws IOException {

        String web1 = ("https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4");
        String web2 = ("http://ftp.osuosl.org/pub/ubuntu/pool/main/m/mysql-5.7/mysql-server-5.7_5.7.31-0ubuntu0.16.04.1_amd64.deb");
        String web3 = ("http://za.archive.ubuntu.com/ubuntu/pool/main/m/mysql-5.7/mysql-server-5.7_5.7.31-0ubuntu0.16.04.1_amd64.deb");

        HashMap<String, String> hashMapURL = new HashMap<String, String>();

        hashMapURL.put("VideoConejo", web1);
        hashMapURL.put("Osuosl", web2);
        hashMapURL.put("Ubuntu", web3);

        ServerSocket ss = new ServerSocket(3333);
        System.out.println("Escuchando peticiones");
        Socket s = ss.accept();

        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());

        int str = Integer.parseInt(din.readUTF());
        System.out.println("El cliente dice: " + str);

        switch (str) {

            case 1:
                System.out.println("El mensaje es correcto");
                dout.writeUTF("Realizando descarga vía LearningContainer");
                Downloader.realizaDescargaDeLaWeb(dout,hashMapURL.get("VideoConejo"));
                break;

            case 2:
                System.out.println("El mensaje es correcto");
                dout.writeUTF("Realizando descarga vía Osuosl");
                Downloader.realizaDescargaDeLaWeb(dout, hashMapURL.get("Osuosl"));
                break;

            case 3:
                System.out.println("El mensaje es correcto");
                dout.writeUTF("Realizando descarga vía Ubuntu");
                Downloader.realizaDescargaDeLaWeb(dout,hashMapURL.get("Ubuntu"));
                break;

            default:
                System.out.println("Opción no válida");
                dout.writeUTF("Opción No Válida, no se pudo realizar la descarga");
        }

    }

    public static void finalizaServer(Socket s, DataInputStream din, ServerSocket ss) throws IOException {

        din.close();
        s.close();
        ss.close();

    }

}
