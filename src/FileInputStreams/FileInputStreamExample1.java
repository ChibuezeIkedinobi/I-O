package FileInputStreams;

import java.io.FileInputStream;

public class FileInputStreamExample1 {

    public static void main(String[] args) {

        try {
            FileInputStream fileInputStream = new FileInputStream("testout2.txt");
            int i = fileInputStream.read();
            System.out.print((char) i);
            fileInputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
