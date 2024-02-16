import java.io.FileOutputStream;

public class FileOutputStreamExample {
    public static void main(String[] args) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
            fileOutputStream.write(50);
            fileOutputStream.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
