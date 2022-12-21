import java.util.Scanner;

public class App {

    Scanner sc = new Scanner(System.in);

    int validate(String message){
        
        int input = 0;


        try {
            System.out.println(message);
            input = sc.nextInt();
        } catch (Exception e) {
            sc.next();
            // TODO: handle exception
        }

        return input;
    }

    void start(){
        int price = 0;
        while(!(price > 0)){
            price = validate("2. price for user : ");
        }

        System.out.println(price);
    }

    public static void main(String[] args) throws Exception {
         App init = new App();
        init.start();
    }
}
