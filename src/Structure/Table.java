package Structure;

import java.util.Arrays;

public class Table {
	
	Customer[] members;

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String arr =""+members[0].token;
		for (Customer customer : members) {
			arr+=customer+"\n";
		}
		return arr;
	}
	
	public static Table singleCustomer(int token) {
		// getter for single person
		Customer c = new Customer(token);
		
		return new Table(c,token);
	}
	
	
	public static Table coupleCustomer(int token) {
		// getter for couples
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
