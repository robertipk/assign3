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
		int numLeftToSell= Integer.parseInt(number);
		int original = numLeftToSell;
		//Boolean completed = false; //flag set to true if there is enough inventory in the link to finish the sale
		//if (promotion>0) { //there is a promotion active
				while(numLeftToSell>0 && !isEmpty()){
					if (accessLastLink() != null){
						numLeftToSell = accessLastLink().decreaseQuantity(numLeftToSell);
						if(accessLastLink().getQuantity()==0)
							removeLast();

					}
				}
	
				if(isEmpty()&&numLeftToSell>0)
					System.out.println("Remainder of " + numLeftToSell + " widgets not availabe.");
				else
					System.out.println(original + " widgets sold!");
					
		//}
		
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
	
	public Link accessLastLink(){
		Link x = this.firstLink;
		while (x.next != null)
			x = x.next;
		return x;
	}
	
	public int numItems(){
		return this.firstLink.getQuantity();
	}
	
	public void removeFirst(){
		if(!isEmpty()){
			this.firstLink = this.firstLink.next;
		}
		else{
			System.out.println("This linked list is empty");
		}
	}
	
	public void removeLast(){
		System.out.println("Removing node");
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
