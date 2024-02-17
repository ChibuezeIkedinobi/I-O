package writer;

//  used to write character-oriented data to a file
// Java BufferedWriter class is used to provide buffering for Writer instances. It makes the performance fast.

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferedWriterExample {
    public static void main(String[] args) throws Exception{

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
        bufferedWriter.write("Thank God for the gift of life");
        bufferedWriter.close();
        System.out.println("Success...");
    }
}
