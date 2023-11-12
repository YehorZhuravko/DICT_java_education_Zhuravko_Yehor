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
        char[] guessedWord = new char[secretWord.length()];
        for (int i = 0; i < secretWord.length(); i++) {
            guessedWord[i] = '_';
        }

        int attemptsLeft = 8;
        Scanner scanner = new Scanner(System.in);

        while (attemptsLeft > 0) {
            System.out.print("Current word: ");
            displayWord(guessedWord);
            System.out.println("Attempts left: " + attemptsLeft);
            System.out.print("Guess a letter: ");
            char userGuess = scanner.next().charAt(0);

            if (containsLetter(secretWord, userGuess)) {
                if (alreadyGuessed(guessedWord, userGuess)) {
                    System.out.println("No improvements. You already guessed that letter.");
                    attemptsLeft--;
                } else {
                    System.out.println("Good guess!");
                    updateGuessedWord(secretWord, guessedWord, userGuess);
                }
            } else {
                System.out.println("That letter doesn't appear in the word.");
                attemptsLeft--;
            }

            if (isWordGuessed(guessedWord)) {
                System.out.println("Congratulations! You guessed the word!");
                return;
            }
        }

        System.out.println("Thanks for playing! The secret word was: " + secretWord);
        System.out.println("Let's see how well you do next time.");
    }

    public static boolean containsLetter(String word, char letter) {
        return word.indexOf(letter) != -1;
    }

    public static boolean alreadyGuessed(char[] guessedWord, char letter) {
        for (char c : guessedWord) {
            if (c == letter) {
                return true;
            }
        }
        return false;
    }

    public static void updateGuessedWord(String secretWord, char[] guessedWord, char letter) {
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                guessedWord[i] = letter;
            }
        }
    }

    public static boolean isWordGuessed(char[] guessedWord) {
        for (char c : guessedWord) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    public static void displayWord(char[] guessedWord) {
        for (char c : guessedWord) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}

