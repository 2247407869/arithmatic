import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest {
    private static void useNio(){
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile("/Users/sschen/Documents/SerialVersion.txt", "rw");
            FileChannel inChannel = aFile.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            int byteReader = inChannel.read(byteBuffer);

            while (byteReader != -1) {
                System.out.println("Read:" + byteReader);
                byteBuffer.flip();

                while (byteBuffer.hasRemaining()) {
                    System.out.println((char)byteBuffer.get());
                }

                byteBuffer.clear();

                byteReader = inChannel.read(byteBuffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                aFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
