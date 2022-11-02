import java.util.Random;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        String name = "";
        String major = "";
        while (!(name.length() >= 5 && name.length() <= 30)) {
            System.out.println("Please input name [5 - 30] : ");
            name = sc.nextLine();
        }

        while (!(major.matches("Computer Science") || major.matches("Information System"))) {
            System.out.println("Please input major [Computer Science or Information System && case sensitive] :");
            major = sc.nextLine();
        }

        int price = 0;

        if (major.matches("Computer Science")) {
            price = 200000;
        } else {
            price = 150000;
        }

        int quantity = 0;
        float discount = 0f;

        while (!(quantity >= 1 && quantity <= 10)) {
            System.out.println("Please input quantity [1 - 10] : ");
            quantity = sc.nextInt();
        }

        if (quantity >= 3) {
            discount = 0.1f;
        }

        if (quantity >= 5) {
            discount = 0.2f;
        }

        float total = (quantity * price) - (discount * price * quantity);

        System.out.printf("name:  %s\nmajor: %s\nquantity: %d\ndiscount :%.1f\ntotal price: %.1f\n", 
                name, major, quantity, discount, total);
        
        System.out.println("Hello World");        
        
    }
}
