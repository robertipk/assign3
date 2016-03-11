package hwthree;

public class Link {
	
	public double price;
	public int quantity;
	public Link next;
	
	public Link(int number, double cost){
		price = cost * 1.3; //30% mark-up
		quantity = number;
	}
	
	public int getQuantity() {
		return quantity;
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
