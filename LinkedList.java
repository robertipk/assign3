package hwthree;

public class LinkedList {
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
		int num = Integer.parseInt(number);
		Boolean completed = false; //flag set to true if there is enough inventory in the link to finish the sale
		if (promotion>0) { //there is a promotion active
	
		}
		if (num <= numItems()){
			System.out.println("There is enough");
			accessFirstLink().decreaseQuantity(num);
			System.out.println(num + " widgets sold for " + num*accessFirstLink().getPrice());	
		}
		else{
			System.out.println("There is not enough to make this sale");
		}
	}
	public void addInventory(String number, String cost){
		int num = Integer.parseInt(number);
		double itemCost = Double.parseDouble(cost);
		Link newLink = new Link(num,itemCost);
		newLink.next = firstLink;
		firstLink = newLink;
	}
	
	public Link accessFirstLink(){
		return this.firstLink;
	}
	
	public int numItems(){
		return this.firstLink.getQuantity();
	}
	
	public Link removeFirst(){
		Link linkReference = this.firstLink;
		if(!isEmpty()){
			this.firstLink = this.firstLink.next;
		}
		else{
			System.out.println("This linked list is empty");
		}
		return linkReference;
	}
	
	public void displayList(){
		Link theLink = firstLink;
		while(theLink != null){
			System.out.println(theLink.toString());
			//System.out.println("Next link " + theLink.next);
			theLink = theLink.next;
			System.out.println();
			
		}
	}
}
