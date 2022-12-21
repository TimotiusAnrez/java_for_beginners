import java.util.ArrayList;
import java.util.Scanner;

public class App {

    ArrayList<Food> orderList = new ArrayList<Food>(); //arrayList with Food generic type
    Scanner sc = new Scanner(System.in);
    int input = 0;

    void addFood() {
        System.out.println("Input id : ");
        int inputId = sc.nextInt();
        System.out.println("\nInput name :");
        String inputName = sc.next();
        System.out.println("\nInput price : ");
        int inputPrice = sc.nextInt();

        Food newOrder = new Food(inputId, inputName, inputPrice); //using constructor to create object

        System.out.println("\n" + newOrder.toString());
        orderList.add(newOrder); //add object to orderList arrayList
    }

    void getAllFood() {
        orderList.forEach((element) -> { //arrayList foreach 
            System.out.println(element.toString());
        });
    }

    void updateFood() {

        getAllFood();
        System.out.println("Type id you want to update : ");
        int input = sc.nextInt();

        orderList.forEach(element -> {
            if (element.id == input) {
                System.out.println("\nInput name update : ");
                String name = sc.next();
                element.setName(name); //update data using setName method from food object
                System.out.println("\nInput price update : ");
                int price = sc.nextInt();
                element.setPrice(price); //update data using setPrice method from food object
            }
        });
    }
    //simple delete
    void deleteFood(){
        getAllFood();
        System.out.println("Type id you want to delete : ");
        int input = sc.nextInt();
        
        for(int i = 0; i < orderList.size(); i++){
            if(orderList.get(i).getId() == input){
                System.out.println("Do you want to delete?");
                String confirm = sc.next();
                if(confirm.equals("Y")){
                    orderList.remove(i); //array list method to delete using index as parameter
                }else if(confirm.equals("N")){
                    reset();
                }
            }
        }
    }

    void reset(){
        input = 0;
        printMenu();
    }

    void printMenu() {

        System.out.println("\nChoose menu");
        System.out.println("=====================");
        System.out.println("1. add item");
        System.out.println("2. get all item");
        System.out.println("3. update item");
        System.out.println("4. delete item");
        System.out.println("5. exit");

        while(!(input >= 1 && input <= 5)){
            System.out.println("Select menu >> ");
            input = sc.nextInt();
        }

        switch (input) {
            case 1:
                addFood();
                reset();
                break;
            case 2:
                getAllFood();
                reset();
                break;
            case 3:
                updateFood();
                reset();
                break;
            case 4:
                deleteFood();
                reset();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        App app =  new App();
        app.printMenu();
    }
}

class Food {
    int id;
    String name;
    int price;

    Food(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ("id\t: " + this.id + "\n" +
                "name\t: " + this.name + "\n" +
                "price\t:" + this.price + "\n");
    }
}