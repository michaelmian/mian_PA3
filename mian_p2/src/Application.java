import java.io.IOException;

public class Application extends DuplicateCounter {
    public static void main(String[] args) throws IOException {
        DuplicateCounter duplicateCounter = new DuplicateCounter();

        duplicateCounter.count("problem2.txt");
        duplicateCounter.write("unique_word_counts.txt");

    }
}

