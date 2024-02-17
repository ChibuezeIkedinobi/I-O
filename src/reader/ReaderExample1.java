package reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderExample1 {
    public static void main(String[] args) {

        try {
            Reader reader = new FileReader("output1.txt");
            int data = reader.read();
            while (data!=-1) {
                System.out.print((char) data);
                data = reader.read();
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
