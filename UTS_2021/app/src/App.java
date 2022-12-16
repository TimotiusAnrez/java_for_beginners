import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        /**
         * *1. Algoritma menampilkan produk promo sesuai urutan harga
         * Asumsi Ascending
         * 
         * *2. total = Sigma n (harga normal - diskon + ongkir)
         * 
         * *3. validasi login kalau salah satu username / password salah return salah
         * 
         * *4. Validasi register kalau username exist maka return masukin lagi yang baru
         * 
         * *5. Selection switch case cara pembayaran
         * 
         * 
         * Object
         * Array
         * Sorting algorithm
         * Selection (if else)
         * Validasi (register: username exist minta yang baru, kalo login salah satu
         * salah minta masukin lagi)
         * Selection (switch case)
         */

        /**
         * Buble sort = itu setiap element itu di cek dengan element yang lain bila
         * element itu lebih besar dari element yang di cek maka ditukar
         * 
         * siapkan variable tmp (ini tempat untuk naro element sementara)
         * 
         * looping array price dari i = 0 sampai i < array.length
         * looping array price dari j = i + 1 sampai j < array.length
         * if i > j
         * tmp = j //=> price2
         * j = i //=> price2 = price1
         * i = tmp //=> price1 = price2
         * 
         */

        Item item1 = new Item(1, "HP Samsung", 10000000);

        User tim = new User(1, "Tim", "TimGanteng");

        Db database = new Db();

        database.addItem(item1);
        database.registerUser(tim);

        // database.printUserDatabase();
        database.printItemDatabase();

        /**
         * set variable scanner with scanner object initialization
         * set variable x with input int initialization
         * set variable y with input int initialization
         * set variable z with input int initialization
         * set variable NilaiTengah
         * if ((y<x and x<z) or (y>x and x>z))
         * set NilaiTengah as x
         * else if((x<y and y<z) or (x>y and y>z))
         * set NilaiTengah as y
         * else if((x<z and z<y) or (x>z and z>y))
         * set NilaiTengah as z
         * else
         * set NilaiTengah as NULL
         * print NilaiTengah
         * 
         */
        int[] arr = { 100, 4, 10, 12, 100, 23, 5, 7 };
        int tmp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}

class Db {

    Vector<User> userDatabase = new Vector<User>();
    Vector<Item> itemDatabase = new Vector<Item>();

    public void printUserDatabase() {
        for (int i = 0; i < userDatabase.size(); i++) {
            userDatabase.elementAt(i).printUser();
        }
    }

    public void printItemDatabase() {
        for (int i = 0; i < itemDatabase.size(); i++) {
            itemDatabase.elementAt(i).toString();
        }
    }

    public void registerUser(User newUser) {
        userDatabase.add(newUser);
    }

    public void addItem(Item item) {
        itemDatabase.add(item);
    }

}

class Item {
    int id;
    String name;
    int price;
    float discount;
    int delivery;
    float total;

    Item(int id, String name, int price) {
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

    public float getDiscount() {
        return discount;
    }

    public int getDelivery() {
        return delivery;
    }

    public float getTotal() {
        return total;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // set discount and delivery first
    public void setTotal() {
        this.total = this.price - this.discount + delivery;
    }

    public void setDiscount(float discount) {
        this.discount = discount * this.price;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }

    @Override
    public String toString() {
        return "{\n\tid: " + this.id + "\n\t" + "name: " + this.name + "\n\t" + "price: " + this.price + "\n\t"
                + "discount: "
                + this.discount + "\n\t" + "delivery: " + this.delivery + "\n\t" + "total: " + this.total + "\n}";
    }
}

class User {
    int id;
    String userName;
    String password;
    Vector<Item> cart = new Vector<Item>();

    User(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public void addItem(Item item) {
        cart.add(item);
    }

    public void printUser() {
        System.out.printf("id: %d\nuserName: %s\n", this.id, this.userName);
        if (cart.size() == 0) {
            System.out.println("[]");
        } else {
            System.out.println("[");
            for (int i = 0; i < cart.size(); i++) {
                System.out.println("   " + cart.elementAt(i).toString());
                ;
            }
            System.out.println("]");
        }
    }

}