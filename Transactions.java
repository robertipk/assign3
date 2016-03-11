package hwthree;

import java.io.*;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;




public class Transactions {
	
	
	public static void processLine(LinkedList list, String[]text ){
		System.out.println(1 + " " + text[0] + " " + text[1]);
		if (text[0].equals("R")){
			System.out.println("This was a restock");
			list.addInventory(text[1],text[2]);
		}		
		else if (text[0].equals("S")){
			System.out.println("This was a SALE");
			
		}
		else //if promotion{
			System.out.println("This was a PROMOTION");
			;
	}
	
	public static void main(String[] args){
		LinkedList inventory = new LinkedList();
		Link one = new Link(34,56.7);
		Link two = new Link(45,23.3);
		Link three = new Link(12,34.7);
		inventory.insertFirstLink(29, 45.3);
		inventory.insertFirstLink(23, 45.9);
		inventory.insertFirstLink(15, 45.9);
		inventory.insertFirstLink(11, 65.9);
		inventory.displayList();
		
		try{
			BufferedReader reader;
			FileReader file = new FileReader("C:\\Users\\admin\\Desktop\\widgets.txt");
			reader = new BufferedReader(file);			
			      String thisLine, type;
			      String [] text;
				  thisLine = reader.readLine();	
				  while ((thisLine = reader.readLine()) != null) {
					 processLine(inventory,thisLine.split(" "));
					 
				  }
		}
		catch(IOException e){
			   System.out.println("Error, could not open the file!");
		   }				
	}

}
