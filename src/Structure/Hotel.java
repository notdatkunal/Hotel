package Structure;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Hotel {
	static Scanner sc = new Scanner(System.in);
	 Table[] tables = new Table[12];
	LinkedList<Table> table_waiting = new LinkedList<Table>();
	int token = 0;
	private  void resetToken() {
		
		if(token>=12) {
			token = 0;
		}
	}
	private boolean isEmpty() {
		// this method will check if the array is empty or not
		
		for(Table i:tables) {
				if(i ==null) {return true;}
		}
		return false;
	}
	public  void showCustomers() {
		
		if(tables[0]==null) {
			System.err.println("all tables are empty");
			return;
		}
		System.out.println("token \tname ");
		for (Table table : tables) {
			if(table==null) {break;}
			System.out.print(table);
		}
		System.out.println();
	}
	public  void showWaiting() {
		
		if(table_waiting.size()==0) {
			System.err.println("no one is waiting");
			return;
		}
		System.out.println("token \tname ");
		for (Table table : table_waiting) {
			if(table==null) {break;}
			System.out.print(table);
		}
		System.out.println();
		
	}
	public  void addCustomer() {
		
		resetToken();
		
		
		if(isEmpty()) {
			System.err.printf("table number %d is empty %n",(token+1));
			tables[token]= createCustomer();
			
			
		}else {
			System.out.printf("you have to wait for table number %d",(token+1));
			table_waiting.add(createCustomer());
		}
		
		
		if(tables[token]!=null) {
			
			token++;
		}
	}
	private  Table createCustomer() {
	
		System.out.println("choose type of table setting");
		System.out.println("1.single person \n2.couple");
		try {
		int choice = Integer.parseInt(sc.nextLine());
		if(choice==1) {return Table.singleCustomer(token+1);}
		if(choice==2) {return Table.coupleCustomer(token+1);}}
		catch(NumberFormatException e) {
			System.err.println("string not allowed");
		}
		System.out.println("choose correct option");
		return null;
		
	}
	
	
}
