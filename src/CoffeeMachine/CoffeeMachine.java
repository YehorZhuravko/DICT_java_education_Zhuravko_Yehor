package CoffeeMachine;
import java.util.Scanner;


public class CoffeeMachine {
    static int water = 500;
    static int milk = 640;
    static int beans = 140;
    static int money = 450;
    static int cups = 10;

    //Espresso
    static int espressoWater = 250;
    static int espressoBeans = 16;
    static int espressoCost = 4;

    //Latte
    static int latteWater = 350;
    static int latteMilk = 75;
    static int latteBeans = 20;
    static int latteCost = 7;

    //Cappuccino
    static int cappuccinoWater = 200;
    static int cappuccinoMilk = 100;
    static int cappuccinoBeans = 12;
    static int cappuccinoCost = 6;

    //Remainder
    static int totalWater = water;
    static int totalMilk = milk;
    static int totalBeans = beans;
    static int totalMoney = money;
    static int totalCups = cups;

    static Scanner scan;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        menu();
    }

    private static void menu() {
        do {
            System.out.print("Write action (buy, fill, take, remaining, exit):\n> ");
            String menuUser = scan.nextLine();
            processUserInput(menuUser);
        } while (true);
    }

    private static void processUserInput(String input) {
        processInput(input);
    }

    public static void processInput(String input) {
        switch (input) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "remaining":
                remaining();
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("ERROR");
                break;
        }
    }

    private static void buy() {
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:\n> ");
        String buyUser = scan.nextLine();
        switch (buyUser) {
            case "1" -> {
                espresso();
            }
            case "2" -> {
                latte();
            }
            case "3" -> {
                cappuccino();
            }
            case "back" -> menu();
            default -> {
                System.out.println("ERROR ");
                buy();
            }
        }
    }
    public static void espresso(){
        if (totalWater < espressoWater){
            System.out.println("Sorry, not enough water!");
        }
        if (totalBeans < espressoBeans) {
            System.out.println("Sorry, not enough beans!");
        }
        if (totalCups < 1) {
            System.out.println("Sorry, not enough cups!");
        }
        if (totalWater >= espressoWater && totalBeans >= espressoBeans && totalCups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            totalMoney += espressoCost;
            totalWater -= espressoWater;
            totalBeans -= espressoBeans;
            totalCups -= 1;
        }
    }
    public static void latte(){
        if (totalWater < latteWater){
            System.out.println("Sorry, not enough water!");
        }
        if (totalBeans < latteBeans) {
            System.out.println("Sorry, not enough beans!");
        }
        if (totalMilk < latteMilk) {
            System.out.println("Sorry, not enough milk!");
        }
        if (totalCups < 1) {
            System.out.println("Sorry, not enough cups!");
        }
        if (totalWater >= latteWater && totalBeans >= latteBeans && totalCups >= 1 && totalMilk >= latteMilk) {
            System.out.println("I have enough resources, making you a coffee!");
            totalMoney += latteCost;
            totalWater -= latteWater;
            totalMilk -= latteMilk;
            totalBeans -= latteBeans;
            totalCups -= 1;
        }
    }
    public static void cappuccino(){
        if (totalWater < cappuccinoWater){
            System.out.println("Sorry, not enough water!");
        }
        if (totalBeans < cappuccinoBeans) {
            System.out.println("Sorry, not enough beans!");
        }
        if (totalMilk < cappuccinoMilk) {
            System.out.println("Sorry, not enough milk!");
        }
        if (totalCups < 1) {
            System.out.println("Sorry, not enough cups!");
        }
        if (totalWater >= cappuccinoWater && totalBeans >= cappuccinoBeans && totalCups >= 1 && totalMilk >= cappuccinoMilk) {
            System.out.println("I have enough resources, making you a coffee!");
            totalMoney += cappuccinoCost;
            totalWater -= cappuccinoWater;
            totalMilk -= cappuccinoMilk;
            totalBeans -= cappuccinoBeans;
            totalCups -= 1;
        }
    }
    public static void fill() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Write how many ml of water you want to add:\n> ");
        totalWater += sc.nextInt();
        System.out.print("Write how many ml of milk you want to add:\n> ");
        totalMilk += sc.nextInt();
        System.out.print("Write how many grams of coffee beans you want to add:\n> ");
        totalBeans += sc.nextInt();
        System.out.print("Write how many disposable coffee cups you want to add:\n> ");
        totalCups += sc.nextInt();
    }
    public static void take() {
        System.out.println("I gave you " + totalMoney + "");
        totalMoney = 0;
    }

    public static void remaining() {
        System.out.println("The coffee machine has: \n" +
                totalWater +
                " ml of water \n" +
                totalMilk +
                " ml of milk \n" +
                totalBeans +
                " of coffee beans \n" +
                totalCups +
                " of disposable cups \n" +
                totalMoney +
                " of money");
    }
}