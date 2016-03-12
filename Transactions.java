package hwthree;

import java.io.*;


public class Transactions {
	public static int promotion = 0;
	public static double discount;
	
	public static void processLine(LinkedList list, String[]text ){
		//String type = text[0];
		System.out.println(text[0]);
		if (text[0].equals("R")){
			list.addInventory(text[1].replaceAll("\\s",""),text[2].replaceAll("\\s",""));
			System.out.println("Added " + text[1] + " widgets at a price of " + text[2]);
		}		
		else if (text[0].equals("S")){
			list.makeSale(text[1],promotion,discount);
			//System.out.println("Sold " + text[1] + " widgets!");
			promotion--;
			
		}
		else //if promotion
		{
			System.out.println("Promotion for " + text[1].replace("%", ""));
			promotion = 2;
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
			      String thisLine, type;
			      String [] text;
				  while ((thisLine = reader.readLine()) != null) {
					 text = thisLine.split("\t");
					 processLine(inventory,text);
					 
				  }
		}
		catch(IOException e){
			   System.out.println("Error, could not open the file!");
		   }
		inventory.displayList();
		
	}

}
