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
	
	public void addInventory(String number, String cost){
		int num = Integer.parseInt(number);
		double itemCost = Double.parseDouble(cost);
		Link newLink = new Link(num,itemCost);
		newLink.next = firstLink;
		firstLink = newLink;
	}
	
	public Link removeFirst(){
		Link linkReference = firstLink;
		if(!isEmpty()){
			firstLink = firstLink.next;
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
