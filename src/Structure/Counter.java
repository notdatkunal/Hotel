package Structure;

import java.util.Scanner;

public class Counter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Hotel h = new Hotel();
		for(;;) {
		
			System.out.println("1. add customer \n2.show tables \n3.show waiting line");
			int choose = Integer.parseInt(sc.nextLine());
			switch(choose) {
			case 1: h.addCustomer();break;
			case 2:h.showCustomers();break;
			case 3:h.showWaiting();break;
			default : System.out.println("choose proper option");
			}
			
		}
	}

}
