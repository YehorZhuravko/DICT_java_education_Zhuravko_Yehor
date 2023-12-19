package TicTacToe;
import java.util.HashMap;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, String> board = new HashMap<>();
        board.put("1 3", " ");
        board.put("2 3", " ");
        board.put("3 3", " ");
        board.put("1 2", " ");
        board.put("2 2", " ");
        board.put("3 2", " ");
        board.put("1 1", " ");
        board.put("2 1", " ");
        board.put("3 1", " ");
        String XO = "X";
        int choice = 9;
        boolean game = true;
        boolean scam = true;
        while (scam){
            System.out.println("-----");
            System.out.println("|" + board.get("1 3") + board.get("2 3") + board.get("3 3") + "|");
            System.out.println("|" + board.get("1 2") + board.get("2 2") + board.get("3 2") + "|");
            System.out.println("|" + board.get("1 1") + board.get("2 1") + board.get("3 1") + "|");
            System.out.println("-----");
            System.out.print("\nEnter the coordinates:\n> ");
            String move = scan.nextLine();
            if (board.containsKey(move)) {
                if(board.get(move).equals(" ")) {
                    board.put(move, XO);
                    choice -= 1;
                    game = true;
                }else {
                    System.out.println("This cell is occupied! Choose another one!");
                    game = false;
                }
            }else {
                move = move.replaceAll(" ", "");
                if(Character.isDigit(Integer.parseInt(move))) {
                    System.out.println("Coordinates should be from 1 to 3!");
                }else{
                    System.out.println("You should enter numbers!");
                }

            }
            if (choice <= 5){
                if ((board.get("1 3").equals(board.get("2 3")) && board.get("2 3").equals(board.get("3 3")))
                        != (board.get("1 3").equals(board.get(" ")) && board.get("2 3").equals(board.get(" "))
                        && board.get("3 3").equals(board.get(" ")))) {
                    System.out.println(XO + " wins");
                    scam = false;
                }
                if ((board.get("1 2").equals(board.get("2 2")) && board.get("2 2").equals(board.get("3 2")))
                        != (board.get("1 2").equals(board.get(" ")) && board.get("2 2").equals(board.get(" "))
                        && board.get("3 2").equals(board.get(" ")))) {
                    System.out.println(XO + " wins");
                    scam = false;
                }
                if ((board.get("1 1").equals(board.get("2 1")) && board.get("2 1").equals(board.get("3 1")))
                        != (board.get("1 1").equals(board.get(" ")) && board.get("2 1").equals(board.get(" "))
                        && board.get("3 1").equals(board.get(" ")))) {
                    System.out.println(XO + " wins");
                    scam = false;
                }
                if ((board.get("1 3").equals(board.get("1 2")) && board.get("1 2").equals(board.get("1 1")))
                        != (board.get("1 3").equals(board.get(" ")) && board.get("1 2").equals(board.get(" "))
                        && board.get("1 1").equals(board.get(" ")))) {
                    System.out.println(XO + " wins");
                    scam = false;
                }
                if ((board.get("2 3").equals(board.get("2 2")) && board.get("2 2").equals(board.get("2 1")))
                        != (board.get("2 3").equals(board.get(" ")) && board.get("2 2").equals(board.get(" "))
                        && board.get("2 1").equals(board.get(" ")))) {
                    System.out.println(XO + " wins");
                    scam = false;
                }
                if ((board.get("3 3").equals(board.get("2 3")) && board.get("2 3").equals(board.get("3 3")))
                        != (board.get("1 3").equals(board.get(" ")) && board.get("2 3").equals(board.get(" "))
                        && board.get("3 3").equals(board.get(" ")))) {
                    System.out.println(XO + " wins");
                    scam = false;
                }
                if ((board.get("1 3").equals(board.get("2 3")) && board.get("2 3").equals(board.get("3 3")))
                        != (board.get("1 3").equals(board.get(" ")) && board.get("2 3").equals(board.get(" "))
                        && board.get("3 3").equals(board.get(" ")))) {
                    System.out.println(XO + " wins");
                    scam = false;
                }
                if ((board.get("1 3").equals(board.get("2 3")) && board.get("2 3").equals(board.get("3 3")))
                        != (board.get("1 3").equals(board.get(" ")) && board.get("2 3").equals(board.get(" "))
                        && board.get("3 3").equals(board.get(" ")))) {
                    System.out.println(XO + " wins");
                    scam = false;
                }
            }

        }
    }
}