package hwthree;
import java.text.NumberFormat;

public class LinkedList {
	
	class Total{	
		private double totalSales = 0;
		
		public void increase(double amt){
			this.totalSales += amt;
		}
		
		public Total(double amt){
			this.totalSales = amt;
		}
		
		public double getAmt(){
			return this.totalSales;
		}	
	}
	
	public Link firstLink;
	
	LinkedList(){
		firstLink = null;
	}
	
	public boolean isEmpty(){
		return(firstLink == null);
	}
	
	public void insertFirstLink(int number, double cost){
		Link newLink = new Link(number, cost);
		newLink.next = firstLink;
		firstLink = newLink;
	}
	
	public void makeSale(String number,int promotion, double discount){
		double discountVal;
		if(promotion>0){
			discountVal = 1-discount;
			System.out.println("Promotion is in effect----------------------");
		}
		else
			discountVal = 1;
		
		Total amtSales = new Total(0.00);
		NumberFormat fmt1 = NumberFormat.getCurrencyInstance();
		int numLeftToSell= Integer.parseInt(number);
		int remaining;
		int original = numLeftToSell;		
			while(numLeftToSell>0 && !isEmpty()){
					remaining = accessLastLink().decreaseQuantity(numLeftToSell, amtSales,discountVal);
					numLeftToSell = remaining;
					if(accessLastLink().getQuantity()==0){
						System.out.println("Zero left in this inventory");
						removeLast();
					}
				}
			if(isEmpty()&&numLeftToSell>0)
				System.out.println("Remainder of " + numLeftToSell + " widgets not availabe.");
			else
				System.out.println(original + " total widgets sold!");
		System.out.println("The total sold was: " + fmt1.format(amtSales.getAmt()) + "\n");
	}
	
	public void addInventory(String number, String cost){
		int num = Integer.parseInt(number);
		double itemCost = Double.parseDouble(cost);
		Link newLink = new Link(num,itemCost);
		newLink.next = firstLink;
		firstLink = newLink;
	}
	
	public Link accessLastLink(){
		Link x = this.firstLink;
		while (x.next != null)
			x = x.next;
		return x;
	}
	
	public void removeLast(){
		Link last = this.firstLink.next;
		Link nextToLast = this.firstLink;
		if (this.firstLink.next ==null)
			this.firstLink = null;
		else{
			while(last.next!=null){
				last = last.next;
				nextToLast = nextToLast.next;
			}
			nextToLast.next = null;	
		}
		
}
	
	public void displayRemaining(){
		System.out.println("\n-----------Remaining Stock---------");
		Link theLink = firstLink;
		while(theLink != null){
			System.out.println(theLink.toString());
			theLink = theLink.next;
			System.out.println();			
		}
	}
}
