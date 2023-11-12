package Hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {
        System.out.println("HANGMAN");
        playHangman();
    }

    public static void playHangman() {
        String[] wordList = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();
        String secretWord = wordList[random.nextInt(wordList.length)];
        String partialWord = getPartialWord(secretWord);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Guess the word " + partialWord + ": ");
        String userGuess = scanner.next();

        if (userGuess.equals(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost! The correct word was: " + secretWord);
        }
    }

    public static String getPartialWord(String word) {
        char[] partialWordChars = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (i < 2) {
                partialWordChars[i] = word.charAt(i);
            } else {
                partialWordChars[i] = '-';
            }
        }
        return new String(partialWordChars);
    }
}

