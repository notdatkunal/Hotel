package Structure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer implements Serializable{
	static Scanner sc = Hotel.sc;
	private String name;
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
