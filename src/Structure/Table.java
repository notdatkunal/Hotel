package Structure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Table implements Serializable{
	/*
	 * this is a template for the table type object 
	 * where it gets decided how many members will sit at a time 
	 * on a table
	 * 
	 * */ 
	
	Customer[] members;
	
	 ArrayList	<Items>  order;
	 public int getTotal() {
		 //this method returns total of the order
		 int total=0;
		 for (Iterator iterator = order.iterator(); iterator.hasNext();) {
			Items items = (Items) iterator.next();
			total+=items.price;
		}
		 return total;
	 }
	 public void createOrder() {
		 if(order!=null) {
			 
			 System.out.println("you have already ordered");
		 }
		 this.order =  new ArrayList<Items>();
		 Scanner sc = new Scanner(System.in);
		 System.out.println("press 1 for veg only \npress any other number key to skip");
		 int choose = Integer.parseInt(sc.nextLine());
		 Items[] array;
		if(choose==1) {
			array = Items.vegOnly();
		} else {
			array= Items.values();
		}
		
//		int f=0;
		 try {
		 for( ;;) {
			 System.err.println("1.Add items  \n2.exit");
			 
			  choose = Integer.parseInt(sc.nextLine());
			  switch(choose) {
			  
			  case 1:{
				  			for(int i = 0;i<array.length;i++) {
				  				System.out.println((i+1)+"\t"+array[i]+"\t"+array[i].price);
					 			}
				  choose = Integer.parseInt(sc.nextLine());
			  			order.add(array[choose-1]); 
			  			break;}
			  case 2:throw new MyException();
			  default:System.err.println("please choose right option");
			  }
		 }}catch(MyException e) {
			 if(order.size()==0) {
				 
				 
				 System.out.println("order can't be negative");
				 createOrder();
			 }
			 return;
		 }
		 
		
	 }

	
	@Override
	public String toString() {
		// this method prints name of the people who are going to sit at a time on table
		String arr =""+members[0].token;
		for (Customer customer : members) {
			arr+=customer+"\n";
		}
		return arr;
	}
	
	public static Table singleCustomer(int token) {
		// Table type getter for single person
		Customer c = new Customer(token);
		
		return new Table(c,token);
	}
	
	
	public static Table coupleCustomer(int token) {
		// table type getter for two persons
		System.out.println("info of customer 1");
		Customer c1 = new Customer(token);
		System.out.println("info of customer 2");
		Customer c2 = new Customer(token);
		
		return new Table(c1,c2,token);
	}
	
	private Table(Customer c,int token) {
	// if only one customer comes	
		this.members = new Customer[] {c};
	}
	
	
	private Table(Customer c1,Customer c2,int token) {
		// if two customer comes	
		this.members = new Customer[]{c1,c2};
		}

}
