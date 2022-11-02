import java.lang.reflect.Array;
import java.util.Scanner;

public class App {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Character menuInput = '0';
        String name = "";
        String address = "";
        String inputCriteria = "";
        String potionName = "";
        int ammount = 0;
        String criteria1 = "Destructive";
        String criteria2 = "Recovery";
        String criteria3 = "Buff";
        int total = 0;

        do {

        System.out.println("Welcome to BreWs");
        System.out.println("=================");
        System.out.println("1. Buy Potion");
        System.out.println("2. Exit");
        System.out.println("Choose menu: ");
        menuInput = sc.nextLine().charAt(0);
            switch (menuInput) {
                case '1':
                    while (name.length() < 5) {
                        System.out.println("Input Your name [more than 5 characters]");
                        name = sc.nextLine();
                    }
    
                    while (!(address.endsWith("road"))) {
                        System.out.println("Input your address [end with 'road']");
                        address = sc.nextLine();
                    }
    
                    while (!(inputCriteria.matches(criteria1) || inputCriteria.matches(criteria2) || inputCriteria.matches(criteria3))) {
                        System.out.println("Input potion's type [Destructive, Recovery, Buff] : ");
                        inputCriteria = sc.nextLine();
                    }
    
                    System.out.printf("Input potion's name [starts with 'Buff'] : %s ", inputCriteria);
                    potionName = sc.nextLine();
    
                    while (ammount == 0) {
                        try {
                            System.out.println("Input Amount of your potion [more than 0]: ");
                            ammount = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println("Please input a number");
                            sc.next();
                            // TODO: handle exception
                        }
                    }
    
                    if (inputCriteria.matches(criteria1)) {
                        total = ammount * 15000;
                    } else if (inputCriteria.matches(criteria2)) {
                        total = ammount * 10000;
                    } else if (inputCriteria.matches(criteria3)) {
                        total = ammount * 8000;
                    }
    
                    System.out.println("Potion's detail");
                    System.out.println("================");
                    System.out.printf("\nPotion's name : %s", potionName);
                    System.out.printf("\nPotion's Type : %s", inputCriteria);
                    System.out.printf("\nAmount : %d", ammount);
                    System.out.printf("\nAddress : %s", address);
                    System.out.println("\n================");
                    System.out.printf("Total Price : %d", total);
    
                    int money = 0;
    
                    while (!(money >= total)) {
                        try {
                            System.out.println("\nInput your payment : $ ");
                            money = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println("\nPlease input number");
                            sc.next();
                            // TODO: handle exception
                        }
                    }
    
                    System.out.printf("\nYour Change is : $%d", money - total);
                    System.out.println("\nPress enter...");
                    sc.nextLine();
                    sc.nextLine();
                    break;
                case '2':
                    System.out.println("Thank your for using the app!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please input a menu");
                    inputCriteria = "";
                    break;
            }
        } while (!(menuInput.equals('1')));
    }
}
