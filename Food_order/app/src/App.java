import java.util.ArrayList;
import java.util.Scanner;

import javax.lang.model.element.Element;

public class App {

    Scanner sc = new Scanner(System.in);
    ArrayList orderList = new ArrayList<Food>();
    int input = 0;
    
    public void menu1() {
        Food newOrder = new Food();

        newOrder.setFoodType();
        newOrder.setName();
        newOrder.setCalories();
        newOrder.setPrice();
        
        orderList.add(newOrder);
    }

    public void menu2() {
        for(int i = 0; i < orderList.size(); i++){
            System.out.println("No\t: "+i);
            System.out.println("==================");
            System.out.println(orderList.get(i).toString());
        }
    }

    public void menu3() {

    }

    public void menu4() {

    }
    
    public void reset(){
        this.input = 0;
        printMenu();
    }

    public void printMenu() {

        while (!(input >= 1 && input <= 5)) {
            System.out.println("Food Order");
            System.out.println("1. Insert new food");
            System.out.println("2. List of food");
            System.out.println("3. Search food");
            System.out.println("4. Delete food");
            System.out.println("5. Exit");
            System.out.println("Choose :");
            input = sc.nextInt();
        }

        switch (input) {
            case 1:
                menu1();
                reset();
                break;
            case 2:
                menu2();
                break;
            case 3:
                menu3();
                break;
            case 4:
                menu4();
                break;
            case 5:
                System.exit(0);
                break;

            default:
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        new App().printMenu();
    }
}
