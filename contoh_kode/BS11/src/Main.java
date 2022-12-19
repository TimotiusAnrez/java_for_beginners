import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	// ArrayList untuk store single data type
	ArrayList<String> subjects = new ArrayList<>();
	
	// Vector untuk store object
	Vector<Food> foods = new Vector<>();
	
	public Main() {
		// variable untuk store input menu
		int input = 0;
		// scanner
		Scanner scan = new Scanner(System.in);
		
		// menu (looping & selection)
		do {
			// display menu
			menuView();
			
			// scan input
			try {
				input = scan.nextInt();
			} catch (Exception e) {
				System.out.println("Please input an integer");
			} 
			scan.nextLine(); // supaya string kosong (enter) tidak terhitung sebagai input
			
			// pilihan tiap menu (switch case)
			switch(input) {
			case 1:
				String ch = choice("insert", scan);
				
				if(ch.equals("subjects")) {
					// subject length > 5
					String subName = "";
					do {
						System.out.print("Input subject name: ");
						subName = scan.nextLine();
					} while(subName.length() <= 5);
					
					// add
					subjects.add(subName);
				}
				else if(ch.equals("foods")) {
					String name, type, id = "FD";
					int price;
					
					// name (length 5 - 15)
					do {
						System.out.print("Input food name: ");
						name = scan.nextLine();
					} while(name.length() < 5 || name.length() > 15);
					
					// type (starts with "[TP]")
					// end with (endsWith)
					do {
						System.out.print("Input food type: ");
						type = scan.nextLine();
					} while(!type.startsWith("[TP]"));
					
					// price (more than 15000)
					do {
						System.out.println("Input food price: ");
						price = scan.nextInt();
						scan.nextLine();
					} while(price <= 15000);
					
					// generate id (FDXXX [random number from 0 - 9])
					Random ran = new Random();
					
					for(int i = 0; i < 3; i++) {
						// concat/ append dengan random number
						id = id + ran.nextInt(9);
					}
					
					Food f = new Food(id, name, type, price);
					foods.add(f);
				}
				
				break;
			case 2:
				showAll(scan);
				
				System.out.println("Press enter to continue....");
				scan.nextLine();
				break;
			case 3:
				// scan index untuk di update
				String ch1 = choice("update", scan);
				
				if(ch1.equals("subjects")) {
					int upd = -1;
					do {
						System.out.print("Input index to update [1 - " + subjects.size() + "]: ");
						upd = scan.nextInt();
						scan.nextLine();
					} while(upd < 0 || upd > subjects.size());
					
					String subName = "";
					
					do {
						System.out.print("Input subject name: ");
						subName = scan.nextLine();
					} while(subName.length() <= 5);
					
					// set subject
					subjects.set(upd - 1, subName);
				}
				else if(ch1.equals("foods")) {
					int upd = -1;
					do {
						System.out.print("Input index to update [1 - " + foods.size() + "]: ");
						upd = scan.nextInt();
						scan.nextLine();
					} while(upd < 0 || upd > foods.size());
					
					String name, type;
					int price;
					
					// name (length 5 - 15)
					do {
						System.out.print("Input food name: ");
						name = scan.nextLine();
					} while(name.length() < 5 || name.length() > 15);
					
					// type (starts with "[TP]")
					// end with (endsWith)
					do {
						System.out.print("Input food type: ");
						type = scan.nextLine();
					} while(!type.startsWith("[TP]"));
					
					// price (more than 15000)
					do {
						System.out.println("Input food price: ");
						price = scan.nextInt();
						scan.nextLine();
					} while(price <= 15000);
					
					Food f = foods.get(upd - 1);
					f.setName(name);
					f.setType(type);
					f.setPrice(price);
				}
				break;
			case 4:
				/*
				 * input element to delete [1 - 10]
				 * 1 - 10
				 * array -> index 0 
				 * 0 - 9
				 * 
				 * 1 - 1 = 0
				 * */
				// scan index untuk di delete
				String ch2 = choice("update", scan);
				
				if(ch2.equals("subjects")) {
					int del = -1;
					do {
						System.out.print("Input index to delete [1 - " + subjects.size() + "]: ");
						del = scan.nextInt();
						scan.nextLine();
					} while(del < 0 || del > subjects.size());
					
					subjects.remove(del - 1);
				}
				else if(ch2.equals("foods")) {
					int del = -1;
					do {
						System.out.print("Input index to delete [1 - " + foods.size() + "]: ");
						del = scan.nextInt();
						scan.nextLine();
					} while(del < 0 || del > foods.size());
					
					foods.remove(del - 1);
				}
				break;
			case 5:
				// thankyou message
				System.out.println("Thankyou for using BS11 Program");
				break;
			}
		} while(input != 5);
	}
	
	// show all
	public void showAll(Scanner scan) {
		String action = "show";
		String ch = choice(action, scan);
		
		if(ch.equals("subjects")) {
			System.out.println("SUBJECTS");
			for(String sub: subjects) {
				System.out.println(sub);
			}
		}
		else if(ch.equals("foods")) {
			System.out.println("FOODS");
			for(Food fo: foods) {
				System.out.println("ID: " + fo.getId() + " Name: " + fo.getName() + " Type: " + fo.getType() + " Price: " + fo.getPrice());
			}
		}
	}
	
	// method menu
	public void menuView() {
		System.out.println("BS11 Program");
		System.out.println("---------------------------");
		System.out.println("1. Insert Data");
		System.out.println("2. View Data");
		System.out.println("3. Update Data");
		System.out.println("4. Delete Data");
		System.out.println("5. Exit");
		System.out.print(">> ");
	}
	
	public String choice(String action, Scanner scan) {
		String inp = "";
		
		do {
			System.out.print("Which one do you want to " + action + " ['subjects' | 'foods']: ");
			inp = scan.nextLine();
			
			// case sensitive (equals())
			// case insensitive (equalsIgnoreCase())
		} while (!inp.equals("subjects") && !inp.equals("foods"));
		
		return inp;
	}

	public static void main(String[] args) {
		// panggil constructor kelas supaya code di constructor bisa ke run
		new Main();
	}

}
