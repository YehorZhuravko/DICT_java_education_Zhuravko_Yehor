package CoffeeMachine;
import java.util.Scanner;
import java.util.Arrays;


public class CoffeeMachine {
    public static void main(String[] args) {
        System.out.println("Write how many ml of water the coffee machine has:");
        Scanner scan = new Scanner(System.in);
        int water = scan.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scan.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beans = scan.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cups = scan.nextInt();
        int nowWater = (int)water/200;
        int nowMilk = (int)milk/50;
        int nowBeans = (int)beans/15;
        int[] manyCaps = {nowWater, nowMilk, nowBeans};
        Arrays.sort(manyCaps);
        int cf = manyCaps[0];
        if(cups == cf) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            if (cups > cf) {
                System.out.println("No, I can make only "+ cf + " cups of coffee.");
            } else {
                if (cups < cf) {
                    System.out.println("Yes, I can make that amount of coffee (and even " + (cf-cups) + " more than that)");
                }
            }
        }
    }
}