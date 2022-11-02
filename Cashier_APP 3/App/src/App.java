import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Input item's name [5..30 characters] : ");
        String name = sc.nextLine();

        while (!(name.length() >= 5 && name.length() <= 30)) {
            System.out.println("Input item's name [5..30 characters] : ");
            name = sc.nextLine();
        }

        System.out.println("Input item's price [use decimal numbers | 10.0 - 2000.0]: $ ");

        float price = 0;
        boolean flag = true;

        while (!sc.hasNextFloat() || flag) {
            try {
                price = sc.nextFloat();
                if (!(price >= 10.0 && price <= 2000.0)) {
                    throw new Exception();
                } else {
                    break;
                }

            } catch (Exception e) {
                if (!sc.hasNextFloat()) {
                    System.out.println("Input must be number!");
                } else {

                    System.out.println("Input item's price [use decimal numbers | 10.0 - 2000.0]: $ ");
                }

                sc.next();
                // TODO: handle exception
            }
        }
        
        int quantity = 0;
        int buyQuantity = 0;
        int discount = 0;
        float money = 0f;
        float change = 0f;

        do {
            System.out.println("\n1. Sell item");
            System.out.println("2. Restock item");
            System.out.println("3. Exit");
            int inputMenu = sc.nextInt();

            switch (inputMenu) {
                case 1:
                    if (quantity == 0) {
                        System.out.println("The item is out of stock, please restock!");
                        continue;
                    }
                    System.out.printf("Input item's quantity [1..%d] : ", quantity);
                    boolean flag3 = true;

                    buyQuantity = Utilty.checkInt(quantity, "Input must be number!", "Out of stock!");

                    System.out.println("Input item's discount [1..50] : ");
                    discount = Utilty.checkInt(50, "Input item's discount [1..50] : ", "Input item's discount [1..50] :");

                    float total = price * buyQuantity * (100 - discount) / 100;

                    System.out.printf("\nItem's name: %s", name);
                    System.out.printf("\nItem's Price: %.1f", price);
                    System.out.printf("\nItem's quantity: %d", buyQuantity);
                    System.out.printf("\nItem's discount: %d", discount);
                    System.out.printf("\n\nYou have to pay $%.2f", total);

                    System.out.printf("Input your money [using decimal numbers | min %.1f] : $", total);
                    money = Utilty.checkFloat(total, "Input your money [using decimal numbers | min " + total + "] : $",
                            "Money not enough!");

                    System.out.println("Thanks for purchasing!");
                    System.out.printf("Your change : $%.1f", money - total);
                    change = money - total;
                    break;
                case 2:

                    System.out.println("Input item's quantity [1..50] : ");
                    quantity = Utilty.checkInt(50, "Input item's quantity [1..50]",
                            "Input item's quantity [1..50]");

                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    break;
            }
            if (change > 0) {
                change = 0;
            }
        } while (!(change > 0f));

    }
}

class Utilty {

    static Scanner sc = new Scanner(System.in);

    static int checkInt(int limit, String userPrompt, String warningMessage) {

        int output = 0;
        boolean flag = true;
        while (!sc.hasNextInt() || flag) {
            System.out.println(userPrompt);
            try {
                output = sc.nextInt();
                if (!(output >= 1 && output <= 50)) {
                    throw new Exception();
                } else {
                    break;
                }

            } catch (Exception e) {
                if (!sc.hasNextInt()) {
                    System.out.println("Input must be number!");
                } else {
                    System.out.println(warningMessage);
                }

                System.out.println(userPrompt);
                sc.next();

                // TODO: handle exception
            }
        }

        return output;
    }

    static float checkFloat(float limit, String userPrompt, String warningMessage) {

        float output = 0f;
        boolean flag = true;
        while (!sc.hasNextFloat() || flag) {
            System.out.println(userPrompt);
            try {
                output = sc.nextFloat();
                if (output < limit) {
                    throw new Exception();
                } else {
                    break;
                }

            } catch (Exception e) {
                if (!sc.hasNextInt()) {
                    System.out.println("Input must be number!");
                } else {
                    System.out.println(warningMessage);
                }

                System.out.println(userPrompt);
                sc.next();

                // TODO: handle exception
            }
        }

        return output;
    }
}