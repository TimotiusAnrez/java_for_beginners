import java.util.*;

import Crepe.Crepe;

public class App {
    Scanner sc = new Scanner(System.in);
    ArrayList orderList = new ArrayList<Crepe>();
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
        System.out.println("==================================");

        for (int i = 0; i < orderList.size(); i++) {
            System.out.println("No. " + i);
            System.out.println(orderList.get(i).toString());;
        }
        System.out.println("==================================");
        pressEnter();
    }

    public void menu3() {
        System.out.println("menu 3");
    }

    public void menu4() {
        System.out.println("Good bye");
        System.exit(0);
    }

    public void mainMenu() {
        while (!(this.input.equals("1") || this.input.equals("2") || this.input.equals("3")
                || this.input.equals("4"))) {
            printMenu();
            this.input = sc.next();
        }
    }

    public void start() {
        mainMenu();

        switch (input) {
            case "1":
                menu1();
                this.input = "";
                start();
                break;
            case "2":
                if (orderList.size() == 0) {
                    System.out.println("There is no order!");
                    pressEnter();
                    this.input = "";
                    start();
                } else {
                    menu2();
                }
                break;
            case "3":
                menu3();
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
