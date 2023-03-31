package Structure;

import java.io.Serializable;

public enum Items implements Serializable{
	//non-veg items
	BIRYANI(false,80),ANDA_BHURJI(false,40),
	// veg items
	PULAV(true,40),RICE_PLATE(true,60);
	
	 final int price ;
	 final boolean veg;
		
	Items(boolean veg,int price){
		this.veg = veg;
		this.price = price;
		}
	
	
	public static Items[] vegOnly() {
		//this method returns array of veg items
		Items[] products = Items.values();
		Items[] veg ;
		int j=0;
		
		//counting veg items
		for (int i = 0;i<products.length;i++) {
			if(products[i].veg) {j++;}
		}
		
		veg = new Items[j];
		// adding veg items
		for (int i = 0;i<products.length;i++) {
			if(products[i].veg) {
				veg[--j]=products[i];
			}
		}
		
		return veg;
	}
}
