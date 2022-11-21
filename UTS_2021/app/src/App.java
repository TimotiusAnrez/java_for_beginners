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

        int price1 = 100000;
        int price2 = 50000;
        int tmp = 0;

        System.out.println("price 1 adalah " + price1);
        System.out.println("price 2 adalah " + price2);

        tmp = price2;
        price2 = price1; // price 2 = 100.000

        System.out.println("price 1 adalah " + price1);
        System.out.println("price 2 adalah " + price2);

        price1 = tmp; // price 1 = 50.000

        System.out.println("price 1 adalah " + price1);
        System.out.println("price 2 adalah " + price2);

        int[] priceList = { 100000, 110000, 50000, 300000 };

        // for (int i = 0; i < priceList.length; i++) {
        // for(int j = i + 1; j< priceList.length; j++){
        // if(priceList[i] > priceList[j]){
        // tmp = priceList[j];
        // priceList[j] = priceList[i];
        // priceList[i] = tmp;
        // }
        // }
        // }
        // Scanner sc = new Scanner(System.in);

        Item barang1 = new Item(1, "HP", 10000000, 0.1f);
        Item barang2 = new Item(2, "Stylus", 10000, 0.2f);
        Item barang3 = new Item(3, "Casing", 5000, 0.15f);
        Item barang4 = new Item(4, "Charger", 10000, 0.2f);
        Item temp;

        Item[] listBarang = { barang1, barang2, barang3, barang4 };

        for (int i = 0; i < listBarang.length; i++) {
            for (int j = i + 1; j < listBarang.length; j++) {
                if (listBarang[i].getPrice() > listBarang[j].getPrice()) {
                    temp = listBarang[j];
                    listBarang[j] = listBarang[i];
                    listBarang[i] = temp;
                }
            }
        }

        for (int i = 0; i < listBarang.length; i++) {
            System.out.printf("harga barang %s kalau dibeli adalah %.2f\n\n", listBarang[i].getName(), listBarang[i].getTotal());
        }

        // System.out.println(Arrays.toString(priceList));

        User budi = new User(1, "Budi", "BudiGanteng");

        User.lapar();
        budi.printString();

        Staff adi = new Staff();

        adi.satu(); //initialize dulu baru bisa dipake method nya
        Staff.dua(); //static panggil method langsung dari object nya

        /**
         * import class sanner
         * 
         * initialisasi variable sc dengan menggunakan tipe data object scanner
         * declare variable x dengan menggunakan input integer dari scanner
         * declare variable y dengan menggunakan input integer dari scanner
         * declare variable z dengan menggunakan input integer dari scanner
         * declare variable NilaiTengah;
         * 
         * jika((y<x dan x<z) atau (y>x dan x>z))
         *      maka nilai tengah adalah x
         * selain itu jika ((x<y dan y<z) atau (x>y dan y>z))
         *      maka nilai tengah adalah y 
         * selain itu jika ((x<z dan z<y) atau (x>z dan z>y))
         *      maka nilai tengah adalah z
         * selain itu
         *      tidak ada nilai tengah
         * 
         * print nilai tengah
         */
        Scanner sc = new Scanner(System.in);
        // int x,y,z;
        int x= sc.nextInt();
        int y = sc.nextInt();
        int z =sc.nextInt();

        int nilaiTengah;

        if((y<x && x<z) || (y>x && x>z)){
            nilaiTengah = x; 
        }else if((x<y && y<z) || (x>y && y>z)){
            nilaiTengah = y;
        }else if((x<z && z<y) || (x>z && z>y)){
            nilaiTengah = z;
        }else{
            nilaiTengah = 0;
        }

        System.out.println(nilaiTengah);

    }
}

class Item {
    int id;
    String name;
    int price;
    float promo;
    int ongkir = 15000;
    float totalHarga;

    // cara masukan data
    Item(int id, String name, int price, float promo) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.promo = promo;
    }

    String getName() {
        return this.name;
    }

    int getPrice() {
        return this.price;
    }

    float getTotal() {
        return price - (price * promo) + ongkir;
    }

    float getPromo(){
        return this.price * this.promo;
    }

    public void printString() {
        System.out.printf("id:%d\nname:%s\nprice:%d\npromo:%.2f\n", this.id, this.name, this.price, this.promo);
    }
}

class User {
    int id;
    String name;
    String password;
    Vector<Item> cart = new Vector<Item>(); // [0,0,0,0,0,0,0]


    // constructor adalah cara untuk memasukan data disaat object dipakai pertama
    // kali
    User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public void addItem(Item item){
        cart.add(item);
    }

    static void lapar(){
        System.out.println("Aku lapar");
    }

    // cara atau program yang berguna untuk melakukan sesuatu
    public void printString() {
        System.out.printf("id:%d\nname:%s\npassword:%s\n", this.id, this.name, this.password);
    }
}

class Staff{
    void satu(){
        System.out.println("satu");
    }

    static void dua(){
        System.out.println("dua");
    }
}