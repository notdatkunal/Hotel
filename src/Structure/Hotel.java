package Structure;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
* @author Kunal
* @version 1.0
*
* */
public class Hotel implements Serializable{
	static Scanner sc = new Scanner(System.in);
	 Table[] tables = new Table[12];
	 /**
	  * This Linked List will save all the Customers that are waiting for the tables
	  * */
	LinkedList<Table> table_waiting = new LinkedList<Table>();
	/**
	 * this token will allocate the value to a customer type Object
	 * */
	int token = 0;
	private  void resetToken() {
		
//		
		if(token>=12) {
			token = 0;
		}
		for(int i = 0;i<tables.length;i++) {
			 Table t=tables[i];
			if(t==null) {
				token = i;
				break;
			}
		}
	}
	private boolean isEmpty() {
		// return true if array of tables is empty
		
		for(Table i:tables) {
				if(i ==null) {return true;}
		}
		return false;
	}
	public void showOrders() {
//		if(tables[0]==null) {
//			System.err.println("all tables are empty");
//			return;
//		}
		System.out.println("press 0 to exit");
		System.out.println("token \tname ");
		int i;
		for( i = 0;i<tables.length;i++) {
			if(tables[i]==null) {continue;}
			System.out.println((i+1)+"\t"+tables[i]);
			
		}
		
		int choose = Integer.parseInt(sc.nextLine());
		if(choose==0) {return;}
		System.out.println(tables[choose-1].order);
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
	}
	public  void showWaiting() {
		
		if(table_waiting.size()==0) {
			System.err.println("no one is waiting");
			return ;
		}
		System.out.println("token \tname ");
		for (Table table : table_waiting) {
			if(table==null) {break;}
			System.out.print(table);
		}
		System.out.println();
		
	}
	public  boolean addCustomer() {
		
		resetToken();
		
//		if(isWaiting()) {
//		addWaiting();
//		}
		
		if(isEmpty()) {
			System.err.printf("table number %d is empty %n",(token+1));
			Table a = createCustomer();
			tables[token]= a;
			if(a.order==null) {
				a.createOrder();
			}
			
		}else {
			
			
				System.err.printf("sorry you have to wait for table number %d",(token+1));
				Table a=createCustomer();
				System.out.println("do you want to choose your order right now");
				System.out.println("1.yes \n2.no");
				int f = Integer.parseInt(sc.nextLine());
				if(f==1) {
					a.createOrder();
				}
				table_waiting.add(a);
				
			
			
		}
		
		
		if(tables[token]!=null) {
			
			token++;
		}
		return false;
	}
	private boolean isWaiting() {
		// returns true if waiting list is empty
		
		return !(table_waiting.size()==0);
		
	}
	private void addWaiting() {
		//recursive method that keeps adding waiting people
		// until tables are full
		if(!isEmpty()) {return;}
		
		System.out.println("adding waiting customers");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			
			Table t= table_waiting.removeFirst();
			
			if(t.order==null) {
				t.createOrder();
			}
			int f =getEmptyIndex(); 
			tables[f]=t;
			for(Customer h:t.members) {
				h.token = f;
			}
			
		}catch(NoSuchElementException e) {
			System.err.println("waiting list is empty");
			return;
		}
		addWaiting();
	}
	private int getEmptyIndex() {
		int i;
		for( i = 0;i<tables.length;i++) {
			
			if(tables[i]==null) 
			{
				break;
			}
		}
		return i;
	}
	private  Table createCustomer() {
	
		System.out.println("choose type of table setting");
		System.out.println("1.single person \n2.two persons");
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
	public boolean printBill() {
		//removes customers from the hotel
		System.out.println("choose table");
		if(isEmpty()) {
			System.out.println("all tables are empty");
		}
		System.out.println("press 0 to exit");
		System.out.println("token \tname ");
		int i;
		for( i = 0;i<tables.length;i++) {
			if(tables[i]==null) {continue;}
			System.out.println((i+1)+"\t"+tables[i]);
			
		}
		
		int choose = Integer.parseInt(sc.nextLine());
		if(choose==0) {return true;}
		int total = tables[choose-1].getTotal();
		System.out.printf("your total is %d \n",total);
		System.out.println("please enter your payment");
		int amount = Integer.parseInt(sc.nextLine());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(amount==total) {System.out.println("thank you please come again");}
		if(amount<total) {System.err.println("kitchen is towards the corner"); return true;}
		if(amount>total) {System.out.println("thanks for the tip broo :)");}
		tables[choose-1]=null;
		addWaiting();
		return false;
	}
	
	
}
