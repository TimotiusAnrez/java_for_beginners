package Crepe;

import java.util.Scanner;

public class Crepe {
    int quantity;
    int slices;
    String name;
    String size;
    String flavor;
    int price;
    String id;
    Scanner sc = new Scanner(System.in);
    String[] flavorSelection = { "Tiramisu", "Cheese", "Matcha" };
    String[] cakeSize = { "Regular", "Large" };

    public String getFlavor() {
        return flavor;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSize() {
        return size;
    }

    public int getSlices() {
        return slices;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    // prompt user to input name input must be between 3 and 15
    public void setName() {

        String input = "";
        while (!(input.length() <= 15 && input.length() >= 3)) {
            System.out.println("input customer name [3 - 15 characters] : ");
            input = sc.nextLine();
        }

        this.name = input;
    }

    public void setFlavor() {
        String input = "";

        while (!(input.equals(flavorSelection[0]) || input.equals(flavorSelection[1])
                || input.equals(flavorSelection[2]))) {
            System.out.println("Choose crepe flavor [Tiramisu | Cheese | Matcha] (Case Insensitive)");
            input = sc.nextLine();
        }

        this.flavor = input;
    }

    public void setQuantity() {
        int input = 0;

        while (!(input >= 1)) {
            System.out.println("Input crepe cake qty (min. 1) : ");
            input = sc.nextInt();
        }

        this.quantity = input;
    }

    public void setSize() {
        String input = "";

        while (!(input.equals(cakeSize[0]) || input.equals(cakeSize[1]))) {
            System.out.println("Choose crepe cake size [Regular | Large] (Case Sensitive) : ");
            input = sc.nextLine();
        }

        this.size = input;
    }

    public void setSlices() {
        int input = 0;
        while (!(input >= 1 && input % 2 == 0)) {
            System.out.println("Input crepe cake slice (must be even number)");
            input = sc.nextInt();
        }

        this.slices = input;
    }

    public void setId() {
        String pool = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int random = (int) Math.random() * pool.length();
        int randomNumber = (int) Math.random() * 99;
        this.id = this.size.charAt(0) + pool.charAt(random) + randomNumber + " ";
    }

    public void setPrice() {

        int total = 0;
        int sizeValue = (this.size.equals(cakeSize[0])) ? 1 : 2;

        if (flavor.matches(flavorSelection[0])) {
            total += 50000;
        } else if (flavor.matches(flavorSelection[1])) {
            total += 55000;
        } else {
            total += 60000;
        }

        this.price = total * this.quantity * sizeValue;
    }

    @Override
    public String toString() {
        return (
                "name\t:" + this.name +
                "\nid\t:" + this.id +
                "\nqty\t:" + this.quantity +
                "\nslice\t:" + this.slices +
                "\nsize\t:" + this.size +
                "\nflavor\t:" + this.flavor +
                "\nprice\t:" + this.price +
                "\n"
            );
    }

}