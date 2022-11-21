public class App {
    public static void main(String[] args) throws Exception {
        int x = 30;
        int y = 10;
        int z = 0;

        if (x == 30) {
            if (y == 10) {
                System.out.println("X = 30 and Y = 10");
            }
        } else {
            System.out.println("x is " + x);
        }

        switch (x + 3) {
            case 6:
                y = 1;
            default:
                y += 1;
        }

        System.out.println(y);

        int a = 1;

        switch (a) {
            case 1:
                x += 5;
                break;
            case 2:
                x+= 10;
                break;
            case 3:
                x += 16;
                break;
            case 4:
                x += 34;
                break;
        }

        System.out.println(x > 65 ? "Passed" : "Failed");
    }
}
