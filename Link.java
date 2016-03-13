package hwthree;

public class Link {
	
	public double price;
	public int quantity;
	public double purchasePrice;
	public Link next;
	
	public Link(int number, double cost){
		this.price = cost * 1.3; //30% mark-up
		this.quantity = number;
		this.purchasePrice = cost;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public int decreaseQuantity(int num) {
		if(this.quantity >= num){
			this.quantity = this.quantity - num;
			System.out.println(num + " at $" + this.price + " each    Sales:$" + num*this.price);
			System.out.println(this.quantity + " remaining");
			return 0;
		}
		else{
			int numLeft = num-this.quantity;
			System.out.println(this.quantity + " at $" + this.price + " each    Sales:$" + this.quantity*this.price);
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
		return "Purchase price=$" + purchasePrice + ", quantity=" + quantity;
	}
}