package comp1721.cwk1;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private  WordList wordList;
    private  List<Guess> guesses = new ArrayList<>(GuessNumber);
    private  int gameNumber;
    private  String target;
    public static  int GuessNumber = 6;

    // TODO: Implement constructor with String parameter
    public Game(String fileName) throws IOException {
        this.wordList = new WordList(fileName);
        gameNumber = (int) LocalDate.of(2021, 6, 19).until(LocalDate.now(), ChronoUnit.DAYS);
        this.target = this.wordList.getWord(gameNumber);
    }

    // TODO: Implement constructor with int and String parameters
    public Game(int num, String fileName) throws IOException {
        this.wordList = new WordList(fileName);
        this.gameNumber = num;
        this.target = this.wordList.getWord(gameNumber);
    }

    // TODO: Implement play() method
    public void play() {
        for (int n = 1; n <= GuessNumber; n++) {
            Guess guess = new Guess(n);

            System.out.printf("Enter guess (%d/6): ", n);
            guess.readFromPlayer();
            guesses.add(guess);

            System.out.println(guess.compareWith(target));
            if (guess.matches(target)) {
                if (n == 1) {
                    System.out.println("Superb - Got it in one!");
                } else if (n <= 5) {
                    System.out.println("Well done!");
                } else {
                    System.out.println("That was a close call!");
                }
                break;
            }
        }
    }

    // TODO: Implement save() method, with a String parameter
    public void save(String fileName) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(fileName);
        for (Guess guess : guesses) {
            printWriter.println(guess.compareWith(target));
        }
        printWriter.close();
    }
}
