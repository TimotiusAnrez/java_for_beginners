package main;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Todo {
	String id;
	String todo;
	DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	String timeStampDateTime = LocalDateTime.now().format(timeFormatter);
	boolean todoStatus = false;

	public String getId() {
		return id;
	}

	public String getTodo() {
		return todo;
	}

	public boolean getStatus() {
		// TODO Auto-generated method stub
		return todoStatus;
	}
	
	public String getTimeStampDateTime() {
		return timeStampDateTime;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public void setTodoStatus(boolean todoStatus) {
		this.todoStatus = todoStatus;
	}
	
	public void printString() {
		System.out.printf("|%-10s|%-10s|%-10b|\n", id, todo, todoStatus);
	}
}
