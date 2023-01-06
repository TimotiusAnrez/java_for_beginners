import java.util.ArrayList;
import java.util.Scanner;

public class App {

    int inputMenu;
    Scanner sc = new Scanner(System.in);
    ArrayList orderList = new ArrayList<Crepe>();

    void printMenu() {
        System.out.println("Crepe N Crave");
        System.out.println("======================");
        System.out.println("1. Add Mille Crepe");
        System.out.println("2. View All Crepes");
        System.out.println("3. Search Mille Crepe");
        System.out.println("4. Update Mille Crepe");
        System.out.println("5. Delete Mille Crepe");
        System.out.println("6. Exit");
        System.out.println("Choose >>");
    }

    void menu1() {
        Crepe order = new Crepe();
        order.setName();
        order.setQuantity();
        order.setSlice();
        order.setSize();
        order.setFlavor();
        order.setPrice();
        order.setId();
        System.out.println(order.toString());
        orderList.add(order);
    }

    void menu2() {
        System.out.println("Crepe List");
        System.out.println("========================");
        for (int i = 0; i < orderList.size(); i++) {
            System.out.printf("No. %d\n", i + 1);
            System.out.println(orderList.get(i).toString());
            ;
        }

        System.out.println("==========================");
    }

    void menu3() {
        System.out.println("Input order id: ");
        String input = sc.next();

        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.contains(input)) {
                System.out.println("Found");
            }
        }

        System.out.println("Not found");
    }

    void menu4() {
        menu2();
        System.out.println("Pick number you want to update : ");
        int input = sc.nextInt();
        for (int i = 0; i < orderList.size(); i++) {
            if (input == i + 1) {
                Crepe newOrder = new Crepe();
                newOrder.setName();
                newOrder.setQuantity();
                newOrder.setSlice();
                newOrder.setSize();
                newOrder.setFlavor();
                newOrder.setPrice();
                orderList.set(i, newOrder);
            }
        }
        reset();
    }

    void menu5() {
        menu2();
        int input = 0;
        String confirmation = "";

        while (!(input > 0)) {
            System.out.printf("Input number to be deleted [1..%d] [0 for cancel] : ", orderList.size());
            input = sc.nextInt();
            if (input == 0) {
                reset();
            }
            for (int i = 0; i < orderList.size(); i++) {
                if (input == i + 1) {
                    System.out.println("Delete the order? [Y | N] (Case Sensitive) : ");
                    confirmation = sc.next();
                }

                if (confirmation.matches("Y")) {
                    orderList.remove(i);
                    pressEnter();
                } else {
                    pressEnter();
                    reset();
                }
            }
        }
    }

    void reset() {
        inputMenu = 0;
        main();
    }

    void pressEnter() {
        System.out.println("Press enter to continue...");
        sc.nextLine();
        sc.nextLine();
    }

    // mainin menu
    void main() {

        while (!(inputMenu >= 1 && inputMenu <= 6)) {
            try {
                printMenu();
                inputMenu = sc.nextInt();
            } catch (Exception error) {
                sc.next();
            }
        }

        switch (inputMenu) {
            case 1:
                menu1();
                reset();
                break;
            case 2:
                if (orderList.isEmpty()) {
                    System.out.println("There is no order!");
                    pressEnter();
                } else {
                    menu2();
                    pressEnter();
                }
                reset();
                break;
            case 3:
                if (orderList.isEmpty()) {
                    System.out.println("There is no order!");
                    pressEnter();
                } else {
                    menu3();
                }
                reset();
                break;
            case 4:
                menu4();
                break;
            case 5:
                menu5();
                break;
            case 6:
                System.exit(0);
                break;

            default:
                break;
        }

    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        new App().main();
    }
}