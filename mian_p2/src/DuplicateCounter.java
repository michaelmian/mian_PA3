import java.util.Scanner;
import java.util.HashSet;
import java.util.HashMap;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;

public class DuplicateCounter {
    public HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();

    public void count(String dataFile) throws IOException {
        HashSet<String> duplicateWords = new HashSet<String>();
        FileInputStream stream = null;
        Scanner scnr = null;
        String tempString;
        int i;
        int key;

        stream = new FileInputStream(dataFile);
        scnr = new Scanner(stream);

        while(scnr.hasNext()) {
            tempString = scnr.next();

            if ((wordCounter.get(tempString)) == null) {
                wordCounter.put(tempString, 1);
            } else {
                key = wordCounter.get(tempString);
                wordCounter.put(tempString, key + 1);
            }
        }

        System.out.println(wordCounter);

        stream.close();
    }

    public void write(String outputFile) throws IOException {
        FileOutputStream stream = null;
        PrintWriter output = null;

        stream = new FileOutputStream(outputFile);
        output = new PrintWriter(stream);

        output.print(wordCounter.keySet());
        output.print(wordCounter.values());
        output.flush();

        stream.close();
    }

    public static void main(String[] args) throws IOException {

    }
}