package FileOutputStreamz;

import java.io.FileOutputStream;

public class FileOutputStreamExample {
    public static void main(String[] args) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
            fileOutputStream.write(52);
            fileOutputStream.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
