package comp1721.cwk1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordList {

    private final List<String> words;

    // TODO: Implement constructor with a String parameter
    public WordList(String fileName) throws IOException {
        words = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String word;
        while ((word = reader.readLine()) != null) {
            words.add(word);
        }
        reader.close();
    }

    // TODO: Implement size() method, returning an int
    public int size() {
        return words.size();
    }

    // TODO: Implement getWord() with an int parameter, returning a String
    public String getWord(int num) {
        if (num < 0 || num >= words.size()) {
            throw new GameException("Wrong game number");
        }
        return words.get(num);
    }
}
