import java.util.Scanner;
import java.util.HashSet;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;

public class DuplicateRemover {

    public String uniqueWords = "";

    public void remove(String dataFile) throws IOException {
        HashSet<String> duplicateWords = new HashSet<String>();
        FileInputStream stream = null;
        Scanner scnr = null;
        String tempString;
        int i;

        stream = new FileInputStream(dataFile);
        scnr = new Scanner(stream);

        while (scnr.hasNext()) {
            tempString = scnr.next();

            if (!(duplicateWords.contains(tempString))) {
                uniqueWords = uniqueWords + tempString + " ";
            }

            duplicateWords.add(tempString);
        }

        stream.close();
    }

    public void write(String outputFile) throws IOException {
        FileOutputStream stream = null;
        PrintWriter output = null;

        stream = new FileOutputStream(outputFile);
        output = new PrintWriter(stream);

        output.print(uniqueWords);
        output.flush();

        stream.close();
    }

    public static void main(String[] args) throws IOException {

    }
}