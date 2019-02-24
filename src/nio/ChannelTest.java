package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @program: arithmatictest
 * @description:
 * @author: LLS
 * @create: 2019-02-22 21:00
 **/
public class ChannelTest {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        RandomAccessFile aFile = new RandomAccessFile("C:\\Users\\LLS\\IdeaProjects\\arithmatictest\\src\\nio\\nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);

        System.out.println(bytesRead);

        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
