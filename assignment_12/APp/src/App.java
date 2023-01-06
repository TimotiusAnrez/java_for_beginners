import java.util.ArrayList;
import java.util.Scanner;

public class App {

    Scanner sc = new Scanner(System.in);
    ArrayList<User> userList = new ArrayList<>();

    void menu1() {
        User user = new User();
        System.out.print("\nName : ");
        String name = sc.next();
        user.setName(name);
        System.out.print("\nPass : ");
        String pass = sc.next();
        user.setPassword(pass);
        System.out.print("\nPhone : ");
        String phone = sc.next();
        user.setPhone(phone);
        userList.add(user);
        System.out.println("New data added is added");
    }

    void menu2() {
        System.out.println("=============================================");
        System.out.printf("|%-10s|%-10s|%-10s|%-10s|\n", "No", "Name", "Pass", "Phone");
        System.out.println("=============================================");
        for(int i = 0; i < userList.size(); i++){
            User element = userList.get(i);
            System.out.printf("|%-10d|%-10s|%-10s|%-10s|\n", i+1, element.name, element.password, element.phone);
        }
        System.out.println("=============================================");
    }

    void menu3() {
        System.out.println("Input data number to be deleted");
        int input = sc.nextInt();
        userList.remove(input - 1);
        System.out.println("Data is removed");
    }

    void menu4() {

        User tmp;

        for (int i = 0; i < userList.size(); i++) {
            for (int j = i + 1; j < userList.size(); j++) {
                int compare = userList.get(i).name.compareTo(userList.get(j).name);
                int compare2 = userList.get(j).name.compareTo(userList.get(i).name);
                
                if(compare > compare2){
                    tmp = userList.get(i);
                    userList.set(i, userList.get(j));
                    userList.set(j, tmp);
                }
            }
        }
    }

    void printMenu() {
        System.out.println("1. Input Data");
        System.out.println("2. Show Data");
        System.out.println("3. Delete Data");
        System.out.println("4. Sorting Data");
        System.out.println("5. Exit");
    }

    void main() {
        int inputMenu = 0;

        while (!(inputMenu > 0 && inputMenu <= 5)) {
            try {
                printMenu();
                System.out.println("Your choice: ");
                inputMenu = sc.nextInt();
            } catch (Exception e) {
                sc.next();
            }
        }
        switch (inputMenu) {
            case 1:
                menu1();
                main();
                break;
            case 2:
                menu2();
                main();
                break;
            case 3:
                menu3();
                main();
                break;
            case 4:
                menu4();
                main();
                break;
            default:
                System.exit(0);
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        new App().main();
    }
}

class User {
    String name;
    String password;
    String phone;
    Scanner sc = new Scanner(System.in);

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}