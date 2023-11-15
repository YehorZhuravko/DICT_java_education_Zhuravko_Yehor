package Hangman;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Hangman {

    public static void main(String[] args) {
        System.out.println("HANGMAN");
        showMenu();
    }

    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Type \"Play\" to play the game, \"Exit\" to quit: ");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("play")) {
                playHangman();
            } else if (choice.equals("exit")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please type \"Play\" or \"Exit\".");
            }
        }
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
        Set<Character> guessedLetters = new HashSet<>();

        while (attemptsLeft > 0) {
            System.out.print("Current word: ");
            displayWord(guessedWord);
            System.out.println("Attempts left: " + attemptsLeft);
            System.out.print("Input a letter: ");
            String userInput = scanner.next().toLowerCase();

            if (userInput.length() != 1 || !Character.isLetter(userInput.charAt(0))) {
                System.out.println("You should input a single letter");
                continue;
            }

            char userGuess = userInput.charAt(0);

            if (userGuess < 'a' || userGuess > 'z') {
                System.out.println("Please enter a lowercase English letter");
                continue;
            }

            if (userGuessesLetter(guessedLetters, userGuess)) {
                System.out.println("You've already guessed this letter");
                continue;
            }

            guessedLetters.add(userGuess);

            if (containsLetter(secretWord, userGuess)) {
                System.out.println("Good guess!");
                updateGuessedWord(secretWord, guessedWord, userGuess);
            } else {
                System.out.println("That letter doesn't appear in the word");
                attemptsLeft--;
            }

            if (isWordGuessed(guessedWord)) {
                System.out.println("You guessed the word " + secretWord + "!");
                System.out.println("You survived!");
                break;
            }
        }

        System.out.println("Thanks for playing! The secret word was: " + secretWord);
    }

    public static boolean containsLetter(String word, char letter) {
        return word.indexOf(letter) != -1;
    }

    public static boolean userGuessesLetter(Set<Character> guessedLetters, char letter) {
        return guessedLetters.contains(letter);
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
