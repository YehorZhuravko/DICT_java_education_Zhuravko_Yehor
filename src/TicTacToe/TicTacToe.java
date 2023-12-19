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
            String move = scan.nextLine();
            if (board.containsKey(move)) {
                if(board.get(move).equals(" ")) {
                    board.put(move, XO);
                    System.out.println("-----");
                    System.out.println("|" + board.get("1 3") + board.get("2 3") + board.get("3 3") + "|");
                    System.out.println("|" + board.get("1 2") + board.get("2 2") + board.get("3 2") + "|");
                    System.out.println("|" + board.get("1 1") + board.get("2 1") + board.get("3 1") + "|");
                    System.out.println("-----");
                }
            }

        }
    }
}