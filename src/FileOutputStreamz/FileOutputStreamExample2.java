package FileOutputStreamz;

import java.io.FileOutputStream;

public class FileOutputStreamExample2 {

    public static void main(String[] args) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("testout2.txt");
            String s = "Welcome to the Land of Milk and Honey.";
            byte[] sample = s.getBytes();  // converting the strings into bytes
            fileOutputStream.write(sample);
            fileOutputStream.close();
            System.out.println("Success...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
