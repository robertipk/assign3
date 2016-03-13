package hwthree;
import hwthree.LinkedList.Total;
import java.text.NumberFormat;


public class Link {
	
	public double price;
	public int quantity;
	public double purchasePrice;
	public Link next;
	public static double total = 0.00 ;
	
	public Link(int number, double cost){
		this.price = cost * 1.3; //30% mark-up
		this.quantity = number;
		this.purchasePrice = cost;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public int decreaseQuantity(int num, Total amtSales, double discount) {
		NumberFormat fmt1 = NumberFormat.getCurrencyInstance();
		if(this.quantity >= num){
			this.quantity = this.quantity - num;
			System.out.println(num + " at " + fmt1.format(this.price) + " each    Sales:" + fmt1.format(num*this.price*discount));
			amtSales.increase(num*this.price*discount);
			return 0;
		}
		else{
			int numLeft = num-this.quantity;
			System.out.println(this.quantity + " at " + fmt1.format(this.price) + " each    Sales:" + fmt1.format(this.quantity*this.price*discount));
			amtSales.increase(this.quantity*this.price*discount);
			this.quantity = 0;
			return numLeft;
		}
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
		NumberFormat fmt1 = NumberFormat.getCurrencyInstance();
		return "Purchase price=" + fmt1.format(purchasePrice) + ", quantity=" + quantity;
	}
}