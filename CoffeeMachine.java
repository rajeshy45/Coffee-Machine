//package machine;
import java.util.Scanner;

public class CoffeeMachine {

    static int money = 550, water = 400, milk = 540, beans = 120, cups = 9;
    final static int espressoCost = 4, latteCost = 7, cappuccinoCost = 6;
    final static int espressoWater = 250, latteWater = 350, cappuccinoWater = 200;
    final static int latteMilk = 75, cappuccinoMilk = 100;
    final static int espressoBeans = 16, latteBeans = 20, cappuccinoBeans = 12;
    final static Scanner scanner = new Scanner(System.in);
    static String  coffeeSelect;

    public static void main(String[] args) {

        while (true) {

            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            if (action.equals("buy")) {

                System.out.print("What do you want to buy? ");
                System.out.println("1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                coffeeSelect = scanner.next();
                if (coffeeSelect.equals("back")) {
                    continue;
                } else {
                    buy();
                }

            } else if (action.equals("fill")) {
                fill();
            } else if (action.equals("take")) {
                take();
            } else if (action.equals("remaining")) {
                status();
            } else {
                break;
            }

        }
    }

    public static void status() {

        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");

    }

    public static void buy() {

        if (coffeeSelect.equals("1")) {
            if (totalEspressoCups() > 0) {
                System.out.println("I have enough resources, making you a coffee!");
                water = water - espressoWater;
                beans = beans - espressoBeans;
                money = money + espressoCost;
                cups = cups - 1;
            } else {
                if (water / espressoWater == 0) {
                    System.out.println("Sorry, not enough water!");
                } else {
                    System.out.println("Sorry, not enough coffee beans!");
                }
            }
        } else if (coffeeSelect.equals("2")) {
            if (totalLatteCups() > 0) {
                System.out.println("I have enough resources, making you a coffee!");
                water -= latteWater;
                milk -= latteMilk;
                beans -= latteBeans;
                money += latteCost;
                cups -= 1;
            } else {
                if (water / latteWater == 0) {
                    System.out.println("Sorry, not enough water!");
                } else if (beans / latteBeans == 0) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else {
                    System.out.println("Sorry, not enough milk!");
                }
            }
        } else if (coffeeSelect.equals("3")) {
            if (totalCappuccinoCups() > 0) {
                System.out.println("I have enough resources, making you a coffee!");
                water -= cappuccinoWater;
                milk -= cappuccinoMilk;
                beans -= cappuccinoBeans;
                money += cappuccinoCost;
                cups -= 1;
            } else {
                if (water / cappuccinoWater == 0) {
                    System.out.println("Sorry, not enough water!");
                } else if (beans / cappuccinoBeans == 0) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else {
                    System.out.println("Sorry, not enough milk!");
                }
            }
        } else {
            System.out.println("Enter valid action");
        }

    }

    public static void fill() {

        System.out.println("Write how many ml of water do you want to add:");
        int fillWater = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int fillMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int fillBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int fillCups = scanner.nextInt();

        water += fillWater;
        milk += fillMilk;
        beans += fillBeans;
        cups += fillCups;

    }

    public static void take() {

        System.out.println("I gave you $" + money);
        money = 0;

    }

    public static int totalEspressoCups() {
        return Math.min(water / espressoWater, beans / espressoBeans);
    }

    public static int totalLatteCups() {
        return Math.min(Math.min(water / latteWater, milk / latteMilk), beans / latteBeans);
    }

    public static int totalCappuccinoCups() {
        return Math.min(Math.min(water / cappuccinoWater, milk / cappuccinoMilk), beans / cappuccinoBeans);
    }

}