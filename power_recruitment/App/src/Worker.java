import java.util.Scanner;
import java.util.Random;

public class Worker {
    private String workerId;
    private String roleTitle;
    private String fullName;
    private String email;
    private String address;


    public Worker(String workerId, String roleTitle, String fullName, String email, String address) {
        this.workerId = workerId;
        this.roleTitle = roleTitle;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
    }


    public String getWorkerId() {
        return this.workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public String getRoleTitle() {
        return this.roleTitle;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static String validateFullName(){
        Scanner sc = new Scanner(System.in);
        String nameInput = "";

        while(!(nameInput.length() >= 12)){
            System.out.println("input new worker name [minimum 12 character with spaces betweeen name] : ");
            nameInput = sc.nextLine();
            System.out.println("\n");
        }
        

        return nameInput;
    }

    public static String validateRoleTitle(){
        Scanner sc = new Scanner(System.in);
        String roleInput = "";
        String[] roleList = {"Account", "Sales", "Marketing", "IT", "Manager"};
        Boolean flag = true;

        while(flag){
            System.out.println("Select role to be filled in [Account | Sales | Marketing | IT | Manager ] : ");
            roleInput = sc.next();

            for(int i = 0; i < roleList.length; i++){
                if(roleInput.equals(roleList[i])){
                    flag = false;
                }
            }
        }
    
        return roleInput;
    }

    public static String validateEmail(){
        Scanner sc = new Scanner(System.in);
        String emailInput = "";

        while(!(emailInput.length() > 10 && !(emailInput.contains(" ")))){
            System.out.println("Please input email handle [minimum 10 characters]");
            emailInput = sc.nextLine();
        }
        
        return emailInput + "@corpo.com";
    }

    public static String validateAddress(){
        Scanner sc = new Scanner(System.in);
        String addressInput = "";

        while(!(addressInput.length() > 10 && addressInput.endsWith("street"))){
            System.out.println("Input Address [Ends with street]");
            addressInput = sc.nextLine();
        }
        
        return addressInput;
    }

    public static String generateId(String fullName, String role){
        Random rand = new Random();
        String[] fullNameSplit = fullName.split(" ");
        String id = "";
        
        id += role.charAt(0);
        
        for(int i = 0; i < fullNameSplit.length; i++){
            id += fullNameSplit[0].charAt(0);
        }

        id += rand.nextInt(99);
        
        return id;
    
    }

    @Override
    public String toString() {
        return "{" +
            " workerId='" + getWorkerId() + "'" +
            ", roleTitle='" + getRoleTitle() + "'" +
            ", fullName='" + getFullName() + "'" +
            ", email='" + getEmail() + "'" +
            ", address='" + getAddress() + "'" +
            "}";
    }


}
