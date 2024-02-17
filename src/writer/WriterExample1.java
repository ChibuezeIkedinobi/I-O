package writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterExample1 {
    public static void main(String[] args) {

        try {
            Writer writer = new FileWriter("output1.txt");
            String content = "God is in Control.";
            writer.write(content);
            writer.close();
            System.out.println("Success...");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
