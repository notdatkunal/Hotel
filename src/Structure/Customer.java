package Structure;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer implements Serializable{
	static Scanner sc = Hotel.sc;
	/**
	 * This String will store the name of the Customer type object
	 * */
	private String name;
	/**
	 * This is a token Given to a Customer at Waiting Line
	 * */
	  int token;
	 
	 
	 public Customer(int token) {
		 this.token = token;
		System.out.println("enter name");
		this.name = sc.nextLine();
	}
	 @Override
	public String toString() {
		// TODO Auto-generated method stub
		return " "+" \t"+name.toString();
	}
}
