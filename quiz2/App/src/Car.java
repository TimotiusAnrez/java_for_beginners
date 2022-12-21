import java.util.Scanner;
public class Car {
    Scanner sc = new Scanner(System.in);
    String[] typeList = { "Sport", "SUV", "Sedan" };
    String[] brandList = { "Toyota", "Mitsubishi", "Honda" };
    String name;
    String type;
    String brand;
    int brandCost;
    int roomPrice;
    int washDuration;
    int total;

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public int getTotal() {
        return total;
    }

    public String getType() {
        return type;
    }

    public int getBrandCost() {
        return brandCost;
    }
    public int getRoomPrice() {
        return roomPrice;
    }

    public int getWashDuration() {
        return washDuration;
    }
    // Input the owner's name [min 8 characters] : 
    public void setName() {
        String input = "";
        while(!(input.length() >= 8)){
            System.out.println("Input the owner's name [min 8 characters] :");
            input = sc.next();
        }

        this.name = input;
    }
    // Input car's type [Sport, SUV, Sedan] (Case sensitive):
    public void setType() {
        String input = "";
        while(!(input.matches(typeList[0]) || input.matches(typeList[1]) || input.matches(typeList[2]))){
            System.out.println("Input car's type [Sport, SUV, Sedan] (Case sensitive):");
            input = sc.next();
        }
        this.type = input;
    }

    // Input car's brand [Toyota, Mitubishi, Honda] (Case sensitive):
    public void setBrand() {

        String input = "";

        while(!(input.matches(brandList[0]) || input.matches(brandList[1]) || input.matches(brandList[2]))){
            System.out.println("Input car's brand [Toyota, Mitsubishi, Honda] (Case sensitive):");
            input = sc.next();
        }
        this.brand = input;
    }
    // Input wash duration [more than 5]
    public void setWashDuration() {

        int input = 0;

        while(!(input > 5)){
            try {
                System.out.println("Input wash duration [more than 5]: ");
                input = sc.nextInt();
            } catch (Exception e) {
                sc.next();
            }
        }

        this.washDuration = input;
    }
    //totyota = 150000, mistubishi = 350000, sedan = 300000
    public void setBrandCost() {
        if(this.brand.equals(brandList[0])){
            this.brandCost = 150000;
        }else if(this.brand.equals(brandList[1])){
            this.brandCost = 350000;
        }else if(this.brand.equals(brandList[2])){
            this.brandCost = 300000;
        }
    }
    //Sport = 500000, SUV = 250000, Sedan = 300000
    public void setRoomPrice() {

        if(this.type.equals(typeList[0])){
            this.roomPrice = 500000;
        }else if (this.type.equals(typeList[1])){
            this.roomPrice = 250000;
        }else if (this.type.equals(typeList[2])){
            this.roomPrice = 300000;
        }

    }
    //total = roomPrice + brandCost
    public void setTotal() {
        this.total = this.brandCost + this.roomPrice;
    }

    @Override
    public String toString() {

        return "|"+this.name + "\t\t|" 
                + this.type +"\t|"  
                + this.brand + "\t|" 
                + this.washDuration + "\t\t|" 
                + this.total + "\t|";
    }
}
