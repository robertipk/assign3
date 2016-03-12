package hwthree;

public class Link {
	
	public double price;
	public int quantity;
	public Link next;
	
	public Link(int number, double cost){
		this.price = cost * 1.3; //30% mark-up
		this.quantity = number;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public int decreaseQuantity(int num) {
		if(this.quantity >= num){
			this.quantity -= num;
			System.out.println(num + " widgets sold at a price of " + this.price + " :SALE FINISHED");
			return 0;
		}
		else{
			int numLeft = num-this.quantity;
			System.out.println(this.quantity + " widgets sold at a price of " + this.price + " :SALE UNFINISHED");
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
		return "Link [price=" + price + ", quantity=" + quantity + "]";
	}





	public static void main(String[] args){
		
	}
	

}
