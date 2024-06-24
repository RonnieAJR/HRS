

import java.util.ArrayList;
import java.util.Comparator;

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
		// sort reserved
		// create list for availability
		// name floor price availability reserved
		
		int i, reservedLength, availableLength;
		int length = this.reserved.size();
		ArrayList<Integer> available = new ArrayList<Integer>();
		
		// adds all the daylengths to available
		for(i=1; i<=31; i++)
			available.add(i);
		
		// sort reserved
		this.reserved.sort(Comparator.naturalOrder());
		
		// remove days from available that are reserved
		available.removeAll(this.reserved);
		
		
		if(this.reserved.size() < available.size())
			length = available.size();
		else
			length = this.reserved.size();
		
		length = length * 4;
		reservedLength = 4 * this.reserved.size() - 2;
		availableLength = 4 * available.size() - 2;
		
		for(i=0; i < length + 20; i++)
			System.out.print("-");
		System.out.print("\n");
		
		System.out.print("| Room name       |");
		for(i=0; i < length - 5; i++)
			System.out.print(" ");
		System.out.printf("%s |\n", this.name);
		
		System.out.print("|-----------------|");
		for(i=0; i < length; i++)
			System.out.print("-");
		System.out.print("|\n");
		
		System.out.print("| Floor           |");
		for(i=0; i < length - 2; i++)
			System.out.print(" ");
		System.out.printf("%c |\n", this.name.charAt(1));
		
		System.out.print("|-----------------|");
		for(i=0; i < length; i++)
			System.out.print("-");
		System.out.print("|\n");
		
		System.out.print("| Price per night |");
		for(i=0; i < length - 9; i++)
			System.out.print(" ");
		System.out.printf("%,5.2f |\n", this.price);
		
		System.out.print("|-----------------|");
		for(i=0; i < length; i++)
			System.out.print("-");
		System.out.print("|\n");
		
		System.out.print("| Days available  |");
		for(i=0; i < length - availableLength - 1; i++)
			System.out.print(" ");
		for(i=0; i < available.size(); i++)
			if(i != available.size() - 1)
				System.out.printf("%2d, ", available.get(i));
			else
				System.out.printf("%2d |\n", available.get(i));
			
		System.out.print("|-----------------|");
		for(i=0; i < length; i++)
			System.out.print("-");
		System.out.print("|\n");
		
		System.out.print("| Days reserved   |");
		for(i=0; i < length - reservedLength - 1; i++)
			System.out.print(" ");
		for(i=0; i < this.reserved.size(); i++)
			if(i != this.reserved.size() - 1)
				System.out.printf("%2d, ", this.reserved.get(i));
			else
				System.out.printf("%2d |\n", this.reserved.get(i));
		
		for(i=0; i < length + 20; i++)
			System.out.print("-");
		System.out.print("\n");
		
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public double getPrice()
	{
		return this.price;
	}

	public int getRoomNumber()
	{
		int roomNumber;
		roomNumber = Integer.parseInt(this.name.substring(1));
		return roomNumber;
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