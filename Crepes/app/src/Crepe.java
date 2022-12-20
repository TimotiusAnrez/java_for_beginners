import java.util.Scanner;

public class Crepe {
    String[] sizeList = { "Regular", "Large" };
    String[] flavorList = { "Tiramisu", "Cheese", "Matcha" };
    String name;
    int quantity;
    int slice;
    String size;
    String flavor;
    String id;
    int price;
    Scanner sc = new Scanner(System.in);
    // fungsi utama program crepes

    public String getName() {
        return name;
    }

    public String getFlavor() {
        return flavor;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSize() {
        return size;
    }

    public int getSlice() {
        return slice;
    }

    public String getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    // Input customer name [3-15 characters] :
    // name >= 3 <=15
    public void setName() {
        String input = "";
        while (!(input.length() >= 3 && input.length() <= 15)) {
            System.out.println("\nInput customer name [3-15 characters] : ");
            input = sc.next();
        }

        this.name = input;
    }

    // Input crepe cake qty (min. 1) :
    // quantity >= 1
    public void setQuantity() {
        int input = 0;
        while (!(input >= 1)) {
            try {
                System.out.println("\nInput crepe cake qty (min. 1) : ");
                input = sc.nextInt();
            } catch (Exception e) {
                sc.next();
                // TODO: handle exception
            }
        }

        this.quantity = input;
    }

    // Input crepe cake slice (must be even number) :
    // slice % 2 == 0
    public void setSlice() {
        int input = 0;

        while (!(input%2 == 0 && input > 0)) {
            try {
                System.out.println("\nInput crepe cake slice (must be even number) : ");
                input = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                sc.next();
                // TODO: handle exception
            }
        }

        this.slice = input;
    }

    // Choose crepe cake size [Regular | large] (Case Sensitive) :
    // size Regular/Large case sensitive
    public void setSize() {
        String input = "";
        while (!(input.equals(sizeList[0]) || input.equals(sizeList[1]))) {
            System.out.println("\nChoose crepe cake size [Regular | Large] (Case Sensitive) :");
            input = sc.nextLine();
        }
        this.size = input;
    }

    // Choose crepe cake flavor [Tiramisu | Cheese | Matcha] (Case Insensitive) :
    // flavor Tiramisu/Cheese/Matcha
    public void setFlavor() {
        String input = "";
        while (!(input.equals(flavorList[0]) || input.equals(flavorList[1]) || input.equals(flavorList[2]))) {
            System.out.println("\nChoose crepe cake flavor [Tiramisu | Cheese | Matcha] (Case Insensitive) :");
            input = sc.next();
        }
        this.flavor = input;
    }

    public void setPrice() {
        int flavorPrice = 0;
        int sizeValue = (this.size.equals(sizeList[0])) ? 1 : 2;

        if (this.flavor.equals(flavorList[0])) {
            flavorPrice = 50000;
        } else if (this.flavor.equals(flavorList[1])) {
            flavorPrice = 55000;
        } else if (this.flavor.equals(flavorList[2])) {
            flavorPrice = 60000;
        }

        this.price = flavorPrice * this.quantity * sizeValue;
    }

    public void setId() {
        char sizeInital = size.charAt(0);
        char randomChar = (char) Math.floor((Math.random() * (90 - 65)) + 65);
        int randomNumber = (int) Math.floor(Math.random() * 9);
        int randomNumber2 = (int) Math.floor(Math.random() * 9);

        this.id = "" + sizeInital + randomChar + randomNumber + randomNumber2;
    }

    @Override
    public String toString() {
        return ("Crepe ID : " + this.id + "\n" +
                "Cust Name : " + this.name + "\n" +
                "Quantity : " + this.quantity + "\n" +
                "Slices : " + this.slice + "\n" +
                "Size : " + this.size + "\n" +
                "Flavor : " + this.flavor + "\n" +
                "Price : " + this.price + "\n");
    }

}
