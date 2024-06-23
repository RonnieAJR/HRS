

import java.util.ArrayList;

public class Room
{
	private String name;
	private double price;
	private ArrayList<Integer> reserved; // reserved, cuz for availability you add more numbers
	
	
	public Room(String name, double price)
	{
		this.name = name;
		this.price = price;
		this.reserved = new ArrayList<Integer>();
	}
	
	public void addReserved(int checkIn, int checkOut)
	{
		while(checkIn < checkOut)
		{
			this.reserved.add(checkIn);
			checkIn++;
		}
		// sort only when needed, for displaying?
	}
	
	public void removeReserved(int checkIn, int checkOut)
	{
		int i;
		
		for(i=0; i<this.reserved.size(); i++)
		{
			if(checkIn <= this.reserved.get(i) && 
						  this.reserved.get(i) < checkOut)
			   this.reserved.remove(i--);
		}
	}
	
	// focus muna sa feature implementations
	/* public String toString()
	{
		String str1 = new String("|");
		String str2 = new String("|");
		String str3 = new String("|");
		String div = new String("|");
		String res;
		
		// name, price per month, availability
		int size = this.reserved.size();
		int width;
		
		if(size > 15)
			width = size;
		else
			width = 31 - size;
		
		width = width * 4 + 20;
	} */
	
	public void displayInfo()
	{
		System.out.println("PLACEHOLDER");
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public double getPrice()
	{
		return this.price;
	}
	
	public ArrayList<Integer> getReserved()
	{
		return this.reserved;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
}