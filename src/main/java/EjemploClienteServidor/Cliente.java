package EjemploClienteServidor;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

public class Cliente {

    public static void main(String args[]) throws IOException {

        Scanner sc = new Scanner(System.in);
        Socket s = new Socket("localhost", 3333);

        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        DataInputStream din = new DataInputStream(s.getInputStream());

        mostrarMenu();
        dout.writeUTF(sc.nextLine());

        //while (true) {

        try {
            String str = din.readUTF();
            System.out.println("El servidor responde: " + str);
            realizarDescargaEnCliente(s);

        } catch (SocketException e) {
            e.printStackTrace();
        }
            //}
        }

        public static void finalizaCliente (Socket s, DataInputStream din, DataOutputStream dout) throws IOException {

            din.close();
            s.close();
            dout.close();
        }

        public static void mostrarMenu () {

            System.out.println("Seleccione la opción para descargar el archivo (elegir opción 1 para descargar el vídeo-ejemplo):\n 1.Vídeo-Conejo" +
                    "\n 2.Osuosl\n 3.Ubuntu");

        }

        public static void realizarDescargaEnCliente (Socket socket) throws IOException {

            System.out.println("Comienza la descarga desde la clase cliente");

            ReadableByteChannel readableByteChannel = Channels.newChannel(socket.getInputStream());
            FileOutputStream fileOutputStream = new FileOutputStream("film.mp4");

            FileChannel fileChannel = fileOutputStream.getChannel();
            fileChannel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);

            System.out.println("Acaba la descarga del archivo en el cliente");

        }

    }

