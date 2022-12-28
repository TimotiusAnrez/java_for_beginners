import java.util.ArrayList;
import java.util.Scanner;

public class App {
    Scanner sc = new Scanner(System.in);
    ArrayList<Car> carList = new ArrayList<Car>();
    int input = 0;

    void printMenu() {
        System.out.println("Car Wash");
        System.out.println("================");
        System.out.println("1. Add Car");
        System.out.println("2. View Cars list");
        System.out.println("3. Exit");
        System.out.println(">>");
    }

    void reset() {
        input = 0;
        mainMenu();
    }

    void menu1() {
        Car newCar = new Car();
        newCar.setName();
        newCar.setType();
        newCar.setBrand();
        newCar.setBrandCost();
        newCar.setRoomPrice();
        newCar.setWashDuration();
        newCar.setTotal();

        carList.add(newCar);
    }

    void menu2() {
        if (carList.size() == 0) {
            System.out.println("There is no car in the list");
            System.out.println("Press enter to continue");
            sc.nextLine();
            sc.nextLine();
            reset();
        }

        System.out.println("+====================================================+");
        System.out.println("+                        Car List                    +");
        System.out.println("+====================================================+");
        System.out.println("|Owner \t\t\t| Type\t| Brand\t| Duration\t| Cost \t|");
        carList.forEach(element -> {
            System.out.println(element.toString());
            ;
        });

        System.out.println("Press enter to continue");
        sc.nextLine();
        sc.nextLine();
        reset();
    }

    /**
     * <access modifier> <return type> <method name>(parameter list){
     *      method body
     * }
     * 
     * 
     */

   

    public void mainMenu() {
        while (!(input > 0)) {
            try {
                printMenu();
                input = sc.nextInt();
            } catch (Exception e) {
                sc.next();
                // TODO: handle exception
            }

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
                System.exit(0);
                break;
            default:
                reset();
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        new App().mainMenu();
        
    }
}
