package comp1721.cwk1;

import java.util.Scanner;


public class Guess {
  // Use this to get player input in readFromPlayer()
  private static final Scanner INPUT = new Scanner(System.in);
  private  int guessNumber;
  private String chosenWord;

  // TODO: Implement constructor with int parameter
  public Guess(int num) {
    if (num < 1 || num > 6) {
      throw new GameException("Wrong guess number");
    }
    this.guessNumber = num;
  }

  // TODO: Implement constructor with int and String parameters
  public Guess(int num, String word) {

    if (word.length() != 5) {
      throw new GameException("Wrong word");
    }
    for (char c : word.toCharArray()) {
      if (!Character.isAlphabetic(c)) {
        throw new GameException("Wrong word");
      }
    }
    this.chosenWord = word.toUpperCase();
  }

  // TODO: Implement getGuessNumber(), returning an int
  public int getGuessNumber() {

    return guessNumber;
  }

  // TODO: Implement getChosenWord(), returning a String
  public String getChosenWord() {

    return chosenWord;
  }

  // TODO: Implement readFromPlayer()
  public void readFromPlayer() {

    chosenWord = INPUT.nextLine().toUpperCase();
  }

  // TODO: Implement compareWith(), giving it a String parameter and String return type
  public String compareWith(String target) {
    StringBuilder w1 = new StringBuilder();
    for (int i = 0; i < target.length(); i++) {
      if (chosenWord.charAt(i) == target.charAt(i)) {
        w1.append(String.format("\033[30;102m %c \033[0m", chosenWord.charAt(i)));
      } else if (target.indexOf(chosenWord.charAt(i)) != -1) {
        w1.append(String.format("\033[30;103m %c \033[0m", chosenWord.charAt(i)));
      } else {
        w1.append(String.format("\033[30;107m %c \033[0m", chosenWord.charAt(i)));
      }
    }
    return w1.toString();
  }

  // TODO: Implement matches(), giving it a String parameter and boolean return type
  public boolean matches(String target) {
    return chosenWord.equals(target);
  }
}
