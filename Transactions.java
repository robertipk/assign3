package hwthree;

import java.io.*;

public class Transactions {
	public static int promotion = 0; //if promotion is greater than 0, apply discount
	public static double discount;
	
	public static void processLine(LinkedList list, String[]text ){
		if (text[0].equals("R")){
			list.addInventory(text[1].replaceAll("\\s",""),text[2].replaceAll("\\s",""));
			System.out.println("Received " + text[1] + " widgets at a price of $" + text[2] + " each");
		}		
		else if (text[0].equals("S")){
			list.makeSale(text[1],promotion,discount);
			promotion--;
		} 
		else //if promotion occurs
		{
			promotion = 2; //promotion is active for the next two customers 
			discount = Double.parseDouble(text[1].replace("%", ""))/100;
			System.out.println(discount);
		}
	}
	
	public static void main(String[] args){
		LinkedList inventory = new LinkedList();
		try{
			BufferedReader reader;
			FileReader file = new FileReader("C:\\Users\\admin\\Desktop\\widgets.txt");
			reader = new BufferedReader(file);			
			      String thisLine;
			      String [] text;
				  while ((thisLine = reader.readLine()) != null) {
					 text = thisLine.split("\t");
					 processLine(inventory,text);				 
				  }
		  }
		catch(IOException e){
			   System.out.println("Error, could not open the file!");
		   }
		inventory.displayRemaining();
		
	}
}