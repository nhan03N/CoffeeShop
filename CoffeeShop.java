import java.util.Scanner;
public class CoffeeShop {
    //this is a constant for the price of a small coffee
    private static final double smallPrice = 1.75;
    //this is a constant for the price of a medium coffee
    private static final double mediumPrice = 1.90;
    //this is a constant for the price of a large coffee
    private static final double largePrice = 2.00;

    private static int smallCupCount = 0;
    private static int mediumCupCount = 0;
    private static int largeCupCount = 0;
    private static double totalMoneyMade = 0;
    private static int totalCoffeeSold = 0;

    //this is the method for (a), to print the menu
    public static void printMenu() {
        System.out.println("1: Enter 1 to order coffee.");
        System.out.println("2: Enter 2 to check the total money made up to this time.");
        System.out.println("3: Enter 3 to check the total amount of coffee sold up to this time.");
        System.out.println("4: Enter 4 to check the number of cups of coffee of each size sold.");
        System.out.println("5: Enter 5 to print the data.");
        System.out.println("9: Enter 9 to exit the program.");
    }

    //this is the method for (b), to order coffee (Option 1)
    public static void orderCoffee(Scanner scanner) {
        int sizeChoice;
        double orderTotal = 0;

        int smallCupOrderCount = 0;
        int mediumCupOrderCount = 0;
        int largeCupOrderCount = 0;

        do {
            System.out.println(" ");
            System.out.println("1: Enter 1 to buy coffee in a small cup size (9 oz)");
            System.out.println("2: Enter 2 to buy coffee in a medium cup size (12 oz)");
            System.out.println("3: Enter 3 to buy coffee in a large cup size (15 oz)");
            System.out.println("9: Enter 9 to exit.");

            sizeChoice = Integer.parseInt(scanner.nextLine());

            if (sizeChoice == 9) {
                //this will calculate the total cost
                orderTotal = (smallCupOrderCount * smallPrice) + (mediumCupOrderCount * mediumPrice) + (largeCupOrderCount * largePrice);
                System.out.println(" ");
                System.out.println("Please pay $" + String.format("%.2f", orderTotal));
                System.out.println(" ");
                totalMoneyMade += orderTotal;

                //this will update the number of cups sold for each size, everytime a cup is sold
                smallCupCount += smallCupOrderCount;
                mediumCupCount += mediumCupOrderCount;
                largeCupCount += largeCupOrderCount;

                //this will update the total number of cups sold in total
                totalCoffeeSold += (smallCupOrderCount * 9) + (mediumCupOrderCount * 12) + (largeCupOrderCount * 15);

                return;
            }

            int cupCount;
            switch (sizeChoice) {
                case 1:
                    //this is for if the user wants a small cup
                    System.out.println(" ");
                    System.out.print("Enter the number of small cups: ");
                    cupCount = Integer.parseInt(scanner.nextLine());
                    smallCupOrderCount += cupCount;
                    break;
                case 2:
                    //this is for if the user wants a medium cup
                    System.out.println(" ");
                    System.out.print("Enter the number of medium cups: ");
                    cupCount = Integer.parseInt(scanner.nextLine());
                    mediumCupOrderCount += cupCount;
                    break;
                case 3:
                    //this is for if the user wants a large cup
                    System.out.println(" ");
                    System.out.print("Enter the number of large cups: ");
                    cupCount = Integer.parseInt(scanner.nextLine());
                    largeCupOrderCount += cupCount;
                    break;
                default:
                    //this is the user asks for a size that is unavialable
                    System.out.println(" ");
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (true);
    }

    //this is the method for (c), to check the total money made up (Option 2)
    public static void checkTotalMoneyMade() {
        System.out.println(" ");
        System.out.println("Total money made: $" + String.format("%.2f", totalMoneyMade));
        System.out.println(" ");
    }

    //this is the method for (d), to check the total amount of coffee sold up (Option 3)
    public static void checkTotalCoffeeSold() {
        System.out.println(" ");
        System.out.println("Total amount of coffee sold: " + totalCoffeeSold + " oz");
        System.out.println(" ");
    }

    //this is the method for (e) to check the number of cups of coffee sold for each cup size (Option 4)
    public static void checkCupCounts() {
        System.out.println(" ");
        System.out.println("Small cup count: " + smallCupCount);
        System.out.println("Medium cup count: " + mediumCupCount);
        System.out.println("Large cup count: " + largeCupCount);
        System.out.println(" ");
    }

    //this is the method for (f), to print the data (Option 5)
    public static void printData() {
        System.out.println(" ");
        System.out.println("Small cup count: " + smallCupCount);
        System.out.println("Medium cup count: " + mediumCupCount);
        System.out.println("Large cup count: " + largeCupCount);
        System.out.println("Total amount of coffee sold: " + totalCoffeeSold + " oz");
        System.out.println("Total money made: $" + String.format("%.2f", totalMoneyMade));
        System.out.println(" ");
    }

    //this is the main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            printMenu();
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    orderCoffee(scanner);
                    break;
                case 2:
                    checkTotalMoneyMade();
                    break;
                case 3:
                    checkTotalCoffeeSold();
                    break;
                case 4:
                    checkCupCounts();
                    break;
                case 5:
                    printData();
                    break;
                case 9:
                    System.out.println("Thanks for stopping by, have a nice day!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (choice != 9);

        scanner.close();
    }
}
