package main;

import java.util.*;

import javax.lang.model.element.Element;

public class App {

	Scanner sc = new Scanner(System.in);
	int menuInput = 0;
	ArrayList<Todo> todoList = new ArrayList<>();

	void printMenu() {
		System.out.println("Select Menu");
		System.out.println("==========================");
		System.out.println("1. Add todo");
		System.out.println("2. View all todo");
		System.out.println("3. Complete todo");
		System.out.println("4. Delete todo");
		System.out.println("5. Exit");
		System.out.println("==========================");
		System.out.println("Select number:");
	}

	void clear() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	void enterBlock() {
		System.out.println("Press enter to continue");
		sc.nextLine();
		sc.nextLine();
	}

	void menu1() {
		Todo itemTodo = new Todo();

		String characterString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int randomNumber = (int) Math.ceil(Math.random() * characterString.length());
		String idString = "" + characterString.charAt(randomNumber) + randomNumber * 12;
		System.out.println("Add new todo: ");
		sc.nextLine();
		String inputTodo = sc.nextLine();
		
		itemTodo.setId(idString);
		itemTodo.setTodo(inputTodo);
		todoList.add(itemTodo);

		System.out.println("Todo Item Created");
		enterBlock();
	}

	void menu2() {
		System.out.printf("|%-10s|%-10s|%-10s\n", "ID", "Todo Item", "Status");

		if (todoList.size() == 0) {
			System.out.println("\tNo item at todo list");
			enterBlock();
			reset();
		}

		todoList.forEach(element -> {
			element.printString();
		});
	}

	void menu3() {
		menu2();
		System.out.println("==============================");
		System.out.println("Enter id to complete : ");
		String idInputString = sc.next();
		todoList.forEach(element -> {
			if (element.id.equals(idInputString)) {
				element.setTodoStatus(true);
			}
		});
		System.out.println("\nTodo completed");
		menu2();
		enterBlock();
	}

	void menu4() {
		menu2();
		System.out.println("============================");
		System.out.println("Enter id to delete");
		String idInputString = sc.next();
		for (int i = 0; i < todoList.size(); i++) {
			if (todoList.get(i).id.equals(idInputString)) {
				todoList.remove(i);
			}
		}
		System.out.println("Todo item deleted");
		menu2();
		enterBlock();
	}

	void reset() {
		menuInput = 0;
		clear();
		mainMenu();
	}

	void mainMenu() {
		while (!(menuInput > 0 && menuInput <= 5)) {
			try {
				printMenu();
				menuInput = sc.nextInt();
			} catch (Exception e) {
				sc.next();
			}
		}

		switch (menuInput) {
		case 1:
			menu1();
			reset();
			break;
		case 2:
			menu2();
			enterBlock();
			reset();
			break;
		case 3:
			menu3();
			reset();
			break;
		case 4:
			menu4();
			reset();
			break;
		case 5:
			System.out.println("Good bye!");
			System.exit(0);
			break;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new App().mainMenu();
	}

}
