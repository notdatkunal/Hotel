package Structure;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Counter {
		static Hotel h ;
		static boolean p = true;
		static{
			File f = new File("MyHotel");
			f = new File(f,"register.ser");

			try {
					
						FileInputStream fIn = new FileInputStream(f.getAbsoluteFile());
						ObjectInputStream in = new ObjectInputStream(fIn);
						
					h = (Hotel) in.readObject();
					in.close();
					fIn.close();
					System.out.println("welcome to existing hotel");
				
					
				
				} catch ( ClassNotFoundException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					System.err.println("file not found");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			if((!f.exists())||h==null) {
				h =  new Hotel();
				System.out.println("new hotel");
				
			}
			
		}
		static Scanner sc = new Scanner(System.in);
		public static void main(String[] args) {
		for(;;) {
			try {
			//this error message mimics 
			//the close button in real UI
			System.err.println("-1. exit");
			System.out.println("0. save");
			System.out.println("1. add customer \n2.show tables \n3.show waiting line \n4.show orders \n5.print bill");
			System.out.println("9.empty all tables");
			int choose = Integer.parseInt(sc.nextLine());
			switch(choose) {
			case 1: p =h.addCustomer();break;
			case 2:h.showCustomers();break;
			case 3:h.showWaiting();break;
			case 4:h.showOrders();break;
			case 5:p=h.printBill();break;
			case 0:	p =sleep(); break;
			case -1:exitApp();
			case 9: p = newHotel();break;
			default : System.out.println("choose proper option");
			}}catch(NumberFormatException a) {
				System.out.println("number format exception");
			}
			
//			catch(NullPointerException e) {System.out.println("null pointer exception");}
			
		}
	}
		static void exitApp() {
			if(!p) {
				System.out.println("press 1 to save");
				System.out.println("press any other key to exit");
				
				int choose = Integer.parseInt(sc.nextLine());
				if(choose==1) {
					sleep();
				}
			}
			System.exit(9);
			
		}
		static boolean newHotel() {
			h = new Hotel();
			return false;
		}
		static boolean sleep() {
			File f = new File("MyHotel");
			f.mkdir();
			f = new File(f,"register.ser");
			try {
				f.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				FileOutputStream fileOut = new FileOutputStream(f.getAbsolutePath());
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					out.writeObject(h);
					out.close();
				fileOut.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return true;
		}

}
