package reader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//  we are reading and printing the data until the user prints stop.

public class BufferedReaderExample3 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = "";

        while (!name.equals("stop")) {
            System.out.println("Enter data: ");
            name = reader.readLine().toLowerCase();
            System.out.println("data is :" + name);
        }
        reader.close();
    }
}
