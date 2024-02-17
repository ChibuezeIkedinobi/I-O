package reader;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReaderExample {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("output.pdf"));
        int i;

        while ((i=reader.read())!=-1) {
            System.out.print((char) i);
        }
        reader.close();
    }
}
