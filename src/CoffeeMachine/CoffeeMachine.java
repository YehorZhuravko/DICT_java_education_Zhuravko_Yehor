package CoffeeMachine;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        System.out.println("Write how many cups of coffee you will need:");
        Scanner scan = new Scanner(System.in);
        int coffee = scan.nextInt();
        System.out.print("For " + coffee + " cups of coffee you will need:\n"
                + 200*coffee + " ml of water\n"
                + 50*coffee + " ml of milk\n"
                + 15*coffee + " g of coffee beans");
    }
}