package filterInputStreams;

import java.io.*;

public class FilterExample {
    public static void main(String[] args) throws IOException {

        FilterInputStream filter = new BufferedInputStream(new FileInputStream(new File("testout2.txt")));

        int k = 0;
        while((k=filter.read())!=-1) {
            System.out.print((char) k);
        }

        filter.close();
    }
}
