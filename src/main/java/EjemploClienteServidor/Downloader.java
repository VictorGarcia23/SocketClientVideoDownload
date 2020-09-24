package EjemploClienteServidor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.HashMap;

public class Downloader {

    HashMap<String, String> hashMapURL = new HashMap<String, String>();

    public static void realizaDescargaDeLaWeb(DataOutputStream dataOutputStream, String url) throws IOException {

        URLConnection conn = new URL(url).openConnection();
        conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");

        ReadableByteChannel readableByteChannel = Channels.newChannel(conn.getInputStream());
        WritableByteChannel writableByteChannel = Channels.newChannel(dataOutputStream);

        final ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        while (readableByteChannel.read(buffer) != -1) {
            buffer.flip();
            writableByteChannel.write(buffer);
            buffer.compact();
        }
        buffer.flip();
        while (buffer.hasRemaining()) {
            writableByteChannel.write(buffer);
        }

        System.out.println("Descarga finalizada en el servidor");

    }

}
