package Hangman;

import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {
        System.out.println("HANGMAN");
        playHangman();
    }

    public static void playHangman() {
        String secretWord = "java";
        char[] guessedWord = new char[secretWord.length()];
        for (int i = 0; i < secretWord.length(); i++) {
            guessedWord[i] = '_';
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Guess the word: ");
        String userGuess = scanner.next();

        if (userGuess.equals(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}
