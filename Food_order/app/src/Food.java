import java.util.Scanner;

public class Food {
    String[] foodTypeList = { "Appetizer", "Main Course", "Dessert" };
    String foodType;
    String name;
    float calories;
    int price;
    Scanner sc = new Scanner(System.in);

    public double getCalories() {
        return calories;
    }

    public String getFoodType() {
        return foodType;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    /**
     * @param calories
     * 
     *                 calories has to be >= 1.0 && <= 4.0
     */

    public void setCalories() {
        float input = 0f;

        while (!(input >= 1.0f && input <= 4.0f)) {
            try {
                System.out.println("Input food's calories[1.0..4.0]: ");
                input = sc.nextFloat();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        this.calories = input;
    }

    /**
     * @param foodType
     *                 String match from input scanner
     *                 if input doesn't match with given stringArray element
     *                 ! ask to input again
     * 
     */
    public void setFoodType() {
        String input = "";

        while (!(input.equals(foodTypeList[0]) || input.equals(foodTypeList[1]) || input.equals(foodTypeList[2]))) {
            System.out.println("Input food's type [Appetizer : Main Course : Dessert]: ");
            input = sc.nextLine();
        }

        this.foodType = input;
    }

    /**
     * @param name
     * 
     *             name must be >= 3 && <= 20
     *             !if not ask to input again
     */
    public void setName() {
        String input = "";

        while (!(input.length() >= 3 && input.length() <= 20)) {
            System.out.println("Input food's name [3-20]: ");
            input = sc.nextLine();
        }

        this.name = input;
    }

    /**
     * @param price
     * 
     *              price has to be >= 10000 && <= 50000
     *              !if not ask to input again
     */
    public void setPrice() {

        int input = 0;

        while (!(input >= 10000 && input <= 50000)) {
            try {
                System.out.println("Input food's price [10000..50000]: ");
                input = sc.nextInt();
            } catch (Exception e) {
                // TODO: handle exception
                sc.next();
            }
        }

        this.price = input;
    }

    @Override
    public String toString() {
        return ("\n1.Type\t\t: " + this.foodType + 
                "\n2.Name\t\t: " + this.name + 
                "\n3.Calories\t: " + this.calories+ 
                "\n4.Price\t\t: " + this.price + "\n");
    }
}
