import java.util.Scanner;
import java.util.ArrayList;

public class App {

    ArrayList<Worker> workerList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int menuInput = 0;

    void addWorker(){
        String fullName = Worker.validateFullName();
        String role = Worker.validateRoleTitle();
        String email = Worker.validateEmail();
        String address = Worker.validateAddress();
        String id = Worker.generateId(fullName, role);

        Worker newWorker = new Worker(id, role, fullName, email, address);

        workerList.add(newWorker);
    }

    void viewWorker(){
        
        System.out.println("Worker List :");
        Worker tmp;
        for(int i = 0; i < workerList.size(); i++){
            for(int j = i+1; j < workerList.size(); j++){
                if(workerList.get(i).getFullName().compareTo(workerList.get(j).getFullName()) < 0){
                    tmp = workerList.get(j);
                    workerList.set(j, workerList.get(i));
                    workerList.set(i, tmp);
                }
            }
        }

        workerList.forEach(worker -> {
            System.out.println(worker.toString());
        });
    }

    void deleteWorker(){
        viewWorker();
        System.out.println("Enter worker ID");
        String inputId = sc.next();

        for(int i = 0; i < workerList.size(); i++){
            if(workerList.get(i).getWorkerId().equals(inputId)){
                workerList.remove(i);
            }
        }
    }

    void reset(){
    //    System.out.println("\033[H\033[2j");
    //    System.out.flush();
       menuInput = 0;
       mainMenu();
    }

    void pressEnter(){
        System.out.println("Press enter to continue");
        sc.nextLine();
        reset();
    }

    void printMenu(){
        System.out.println("Welcome to worker management system");
        System.out.println("===================================");
        System.out.println("1. add worker");
        System.out.println("2. view worker");
        System.out.println("3. delete worker");
        System.out.println("4. exit");
        System.out.println("====================================");
        System.out.println("Choose: ");
    }

    void mainMenu(){
        while(!(menuInput > 0 && menuInput <= 4)){
            try {
                printMenu();
                menuInput = sc.nextInt();
            } catch (Exception e) {
                // TODO: handle exception
                sc.next();
            }
        }

        switch (menuInput) {
            case 1:
                addWorker();
                pressEnter();
                reset();
                break;
            case 2:
                viewWorker();
                pressEnter();
                reset();
                break;
            case 3:
                deleteWorker();
                pressEnter();
                reset();
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        new App().mainMenu();
    }
}
