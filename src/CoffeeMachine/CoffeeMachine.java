package CoffeeMachine;
import java.util.Scanner;
import java.util.Arrays;


public class CoffeeMachine {
    static int water = 400;
    static int espressoWater = 250;
    static int latteWater = 350;
    static int cappuccinoWater = 200;
    static int totalWater = water;
    static int milk = 540;
    static int latteMilk = 75;
    static int cappuccinoMilk = 100;
    static int totalMilk = milk;
    static int beans = 120;
    static int espressoBeans = 16;
    static int latteBeans = 20;
    static int cappuccinoBeans = 12;
    static int totalBeans = beans;
    static int money = 550;
    static int espressoCost = 4;
    static int latteCost = 7;
    static int cappuccinoCost = 6;
    static int totalMoney = money;
    static int cups = 9;
    static int totalCups = cups;
    static Scanner scan;
    public static void main(String[] args) {
        scan = new Scanner(System.in);
        all();
        menu();
    }
    public static void all() {
        System.out.println("\nThe coffee machine has: \n" +
                totalWater +
                " ml of water \n" +
                totalMilk +
                " ml of milk \n" +
                totalBeans +
                " of coffee beans \n" +
                totalCups +
                " of disposable cups \n" +
                totalMoney +
                " of money \n");

    }
    private static void menu() {
        System.out.print("Write action (buy, fill, take):\n> ");
        String menuUser = scan.nextLine();
        switch (menuUser) {
            case "buy" -> buy();
            case "fill" -> fill();
            case "take" -> take();
            default -> System.out.println("\n ERROR ");
        }
    }
    private static void buy() {
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:\n> ");
        switch (scan.nextInt()) {
            case 1 -> {
                espresso();
                all();
            }
            case 2 -> {
                latte();
                all();
            }
            case 3 -> {
                cappuccino();
                all();
            }
            default -> System.out.println("\n ERROR ");
        }
    }
    public static void espresso(){
        totalMoney += espressoCost;
        totalWater -= espressoWater;
        totalBeans -= espressoBeans;
        totalCups -= 1;
    }
    public static void latte(){
        totalMoney += latteCost;
        totalWater -= latteWater;
        totalMilk -= latteMilk;
        totalBeans -= latteBeans;
        totalCups -= 1;
    }
    public static void cappuccino(){
        totalMoney += cappuccinoCost;
        totalWater -= cappuccinoWater;
        totalMilk -= cappuccinoMilk;
        totalBeans -= cappuccinoBeans;
        totalCups -= 1;
    }

    public static void fill() {
        System.out.print("Write how many ml of water you want to add:\n> ");
        totalWater += scan.nextInt();
        System.out.print("Write how many ml of milk you want to add:\n> ");
        totalMilk += scan.nextInt();
        System.out.print("Write how many grams of coffee beans you want to add:\n> ");
        totalBeans += scan.nextInt();
        System.out.print("Write how many disposable coffee cups you want to add:\n> ");
        totalCups += scan.nextInt();
        all();
    }
    public static void take() {
        System.out.println("I gave you " + totalMoney);
        totalMoney = 0;
        all();
    }
}
