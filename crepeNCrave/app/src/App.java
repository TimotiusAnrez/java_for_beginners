import java.util.*;

import Crepe.Crepe;

public class App {
    Scanner sc = new Scanner(System.in);
    ArrayList<Crepe> orderList = new ArrayList<Crepe>();
    String input = "";

    // print menu
    public void printMenu() {
        System.out.println("Crepe N Crave");
        System.out.println("======================");
        System.out.println("1. Add Mille Crepe");
        System.out.println("2. View All Crepes");
        System.out.println("3. Delete Mille Crepe");
        System.out.println("4. Exit");
        System.out.println("Choose >>");
    }

    public void pressEnter() {
        System.out.println("Press enter to continue...");
        sc.nextLine();
        sc.nextLine();
    }

    public void menu1() {
        Crepe orderCrepe = new Crepe();
        orderCrepe.setName();
        orderCrepe.setQuantity();
        orderCrepe.setSlices();
        orderCrepe.setSize();
        orderCrepe.setFlavor();
        orderCrepe.setId();
        orderCrepe.setPrice();
        orderList.add(orderCrepe);
        System.out.println("Successfully ordered!");
        pressEnter();
    }

    public void menu2() {
        System.out.println("Crepe List");
        for (int i = 0; i < orderList.size(); i++) {
            System.out.println("=============================");
            System.out.printf("No. %d\n", i + 1);
            System.out.println(orderList.get(i).toString());
            ;
        }
        System.out.println("============================");
    }

    public void menu3() {
        String input = "";
        boolean flag = false;
        String validate = "";
        while (!flag) {
            menu2();
            System.out.println("select which one do you want to delete?");
            input = sc.nextLine();
            for (Integer i = 0; i < orderList.size(); i++) {
                if (input.equals(Integer.toString(i+1))) {
                    System.out.println("Delete the order? [Y | N] (Case Sensitive)");
                    validate = sc.nextLine();
                    if (validate.equals("Y")) {
                        orderList.remove((int) i);
                        System.out.println("Successfully deleted!");
                        flag = true;
                    } else if (validate.equals("N")) {
                        flag = true;
                    }
                }
            }
        }
        pressEnter();
    }

    public void menu4() {
        System.out.println("Good bye");
        System.exit(0);
    }

    public void mainMenu() {
        while (!(this.input.equals("1")
                || this.input.equals("2")
                || this.input.equals("3")
                || this.input.equals("4"))) {
            printMenu();
            this.input = sc.next();
        }
    }

    public void reset() {
        this.input = "";
        start();
    }

    public void start() {
        mainMenu();

        switch (input) {
            case "1":
                menu1();
                reset();
                break;
            case "2":
                if (orderList.size() == 0) {
                    System.out.println("There is no order!");
                    pressEnter();
                    reset();
                } else {
                    menu2();
                    pressEnter();
                    reset();
                }
                break;
            case "3":
                if (orderList.size() == 0) {
                    System.out.println("There is no order!");
                    pressEnter();
                    reset();
                } else {
                    menu3();
                    reset();
                }
                break;
            case "4":
                menu4();
                break;
            default:
                break;
        }

    }

    public static void main(String[] args) throws Exception {
        new App().start();
    }
}
