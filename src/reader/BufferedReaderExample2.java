package reader;

//we are connecting the BufferedReader stream with the InputStreamReader stream
// for reading the line by line data from the keyboard.

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedReaderExample2 {
    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your name: ");
        String name = reader.readLine();
        System.out.println("Welcome " +name);

    }
}
