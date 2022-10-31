import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        /**
         * print menu
         * 
         * Keyboard with price 49.99
         * Mouse 19.99
         * monitor $99.99
         */
        Scanner sc = new Scanner(System.in);
        Item defaultSelect = new Item(0, "default", 0);
        Item keyboard = new Item(1, "Keyboard", 49.99f);
        Item mouse = new Item(2, "Mouse", 19.99f);
        Item monitor = new Item(3, "Monitor", 99.99f);

        /**
         * choose menu
         */
        keyboard.printMenu();
        mouse.printMenu();
        monitor.printMenu();
        System.out.println("\n4. Exit");
        System.out.println("\nChoose : ");

        int inputMenu = sc.nextInt();
        String selectedMenu = defaultSelect.getName();
        float selectedPrice = defaultSelect.getPrice();

        switch (inputMenu) {
            case 1:
                selectedMenu = keyboard.getName();
                selectedPrice = keyboard.getPrice();
                break;
            case 2:
                selectedMenu = mouse.getName();
                selectedPrice = mouse.getPrice();
                break;
            case 3:
                selectedMenu = monitor.getName();
                selectedPrice = monitor.getPrice();
                break;
            case 4:
                System.out.println("Thank you for using this application :D");
                System.exit(0);
                break;
            default:
                System.out.println("Please select available item");
                System.exit(0);
                break;
        }

        /**
         * selection if greater than the stock, out of stock sytem.exit()
         */
        System.out.println("Input quantity [1..20] : ");

        int inputQuantity = sc.nextInt();
        float total = inputQuantity * selectedPrice;

        if (inputQuantity > 20) {
            System.out.println("Out of stock!!!");
            System.exit(0);
        }

        /**
         * if valid display invoice:
         * choosen item name
         * choosen item price
         * inputed bought quantity
         * total price = item price * bought quantity
         */

        System.out.printf("\nItem's name: %s", selectedMenu);
        System.out.printf("\nPrice: %.2f ", selectedPrice);
        System.out.printf("\nQuantity: %d", inputQuantity);
        System.out.printf("\nTotal: %.2f", total);

        /**
         * input amount of money
         * if less than total price
         * display message
         * system.exit()
         * 
         * display
         * thanks for purchasing
         * your change : input money - total price
         * 
         * exit
         */
        System.out.printf("\nInput your money [min %.2f] : ", total);
        float inputMoney = sc.nextFloat();

        if (inputMoney < total) {
            System.out.println("Not enough money !");
        } else {
            System.out.println("Thanks for purchasing!");
            System.out.printf("Your change : %.2f", inputMoney - (total));
        }

        System.out.println("\n\nThanks for using this application :D");

    }
}

class Item {
    int id;
    String name;
    float price;
    int inputQuantity = 0;
    float total = 0;

    Item(int inputId, String inputName, float inputPrice) {
        this.id = inputId;
        this.name = inputName;
        this.price = inputPrice;
    }

    String getName() {
        return this.name;
    }

    float getPrice() {
        return this.price;
    }

    float getTotal(){
        return this.total;
    }

    int getInputQuantity(){
        return this.inputQuantity;
    }

    void setInputQuantity(int quantity){
        this.inputQuantity = quantity;
    }

    void setTotal(){
        this.total = this.inputQuantity * this.price;
    }

    void printMenu() {
        System.out.printf("\n%d. %s - $%.2f", this.id, this.name, this.price);
    }
    void printInvoice(){
        System.out.printf("\nItem's name: %s", this.name);
        System.out.printf("\nPrice: %.2f ", this.price);
        System.out.printf("\nQuantity: %d", this.inputQuantity);
        System.out.printf("\nTotal: %.2f", this.total);
    }
}
