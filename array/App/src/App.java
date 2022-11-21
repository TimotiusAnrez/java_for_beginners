import java.util.*;

public class App {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        // int[] arrInt = { 1, 2, 3, 4 };
        // int[] arr2Int = { 5, 6, 7, 8 };
        // int[] arr3Int = { 9, 10, 11, 12 };
        // int[][] arrCombine = { arrInt, arr2Int, arr3Int };
        // int[][] arrCombine2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

        // Integer arrInteger[] = new Integer[3];
        // Integer arrInteger2[][] = new Integer[3][3];
        // Integer arrInteger3[][][] = new Integer[3][3][3];

        // boolean flag1 = false, flag2 = false;
        // for (int i = 0; i < arrInteger.length; i++) {
        //     if (!flag1 && !flag2) {
        //         arrInteger[i] = i;
        //     }
        //     if (i == arrInteger.length - 1 && !flag1 && !flag2) {
        //         i = 0;
        //         flag1 = true;
        //     }

        //     if (flag1) {
        //         arrInteger2[i] = arrInteger;
        //     }

        //     if (i == arrInteger.length - 1 && flag1 && !flag2) {
        //         i = 0;
        //         flag2 = true;
        //     }

        //     if (flag2) {
        //         arrInteger3[i] = arrInteger2;
        //     }

        // }
        // System.out.println(Arrays.deepToString(arrInteger3));

        Order customerOrder = new Order();
        String[] itemsName = {"Americano","Cafe Latte", "Espresso", "Machiato", "Moccachino", "Cappucino", "Matcha Latte", "English Breakfast", "Earl Gray", "Mint Citrus"};
        Integer[] itemsPrice = {32000,42000,23000,45000,47000,52000,47000,52000,27000,27000,27000};

        for(int i = 0; i < itemsName.length; i++){
            Menu items = new Menu(i, itemsName[i], itemsPrice[i]);
            customerOrder.addMenu(items);
        }

        customerOrder.seeMenu();

    }
}

class Menu {
    int id;
    String name;
    Integer price;

    Menu(int id, String name, Integer price) {
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

    public Integer getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    
}

class Order{
    Vector<Menu> orderList = new Vector<Menu>();

    public void addMenu(Menu item){
        orderList.add(item);
    }

    public void deleteItem(int id){
        orderList.remove(id);
    }

    public void seeMenu(){
        for(Menu menuItems : orderList){
            System.out.println(menuItems);
        }
    }

}