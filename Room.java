

import java.util.ArrayList;
import java.util.Comparator;


/**
 * The Room class mimics an actual room in a hotel having a name, price, and reservation.
 */
public class Room
{
	private String name;
	private double price;
	private ArrayList<Integer> reserved;
	
	/**
	 * Constructs a new room with the given parameters.
	 * @param name name of the room
	 * @param price price of the room
	 */
	public Room(String name, double price)
	{
		this.name = name;
		this.price = price;
		this.reserved = new ArrayList<Integer>();
	}
	
	/**
	 * Adds days to the list of reserved days.
	 * The days between check in, inclusive, and check out, exclusive, are added.
	 * @param checkIn day of check in
	 * @param checkOut day of check out
	 */
	public void addReserved(int checkIn, int checkOut)
	{
		// adds the days between checkIn and checkOut...
		// ...checkIn inclusive and checkOut exclusive
		while(checkIn < checkOut)
		{
			this.reserved.add(checkIn);
			checkIn++;
		}
	}

	/**
	 * Removes days from the list of reserved days.
	 * The days between check in, inclusive, and check out, exclusive, are remove.
	 * @param checkIn day of check in
	 * @param checkOut day of check out
	 */
	
	public void removeReserved(int checkIn, int checkOut)
	{
		int i;
		
		// removes the days between checkIn and checkOut...
		// ...checkIn inclusive and checkOut exclusive
		for(i=0; i<this.reserved.size(); i++)
		{
			if(checkIn <= this.reserved.get(i) && 
						  this.reserved.get(i) < checkOut)
			   this.reserved.remove(i--);
		}
	}
	
	/**
	 * Displays the room information on the standard output stream in a tabular format.
	 * Info such as name, floor, price, days reserved, and available days.
	 */
	public void displayInfo()
	{
		int i, reservedLength, availableLength;
		int length = this.reserved.size();
		ArrayList<Integer> available = new ArrayList<Integer>();
		
		// adds all the days to available
		for(i=1; i<=31; i++)
			available.add(i);
		
		// sort reserved
		this.reserved.sort(Comparator.naturalOrder());
		
		// remove days from available that are reserved
		available.removeAll(this.reserved);
		
		// determines which list as more days
		if(this.reserved.size() < available.size())
			length = available.size();
		else
			length = this.reserved.size();
		
		// sets the length of the table's second column
		length = length * 4;
		reservedLength = 4 * this.reserved.size() - 2;
		availableLength = 4 * available.size() - 2;
		
		// top of the table
		for(i=0; i < length + 20; i++)
			System.out.print("-");
		System.out.print("\n");
		
		// room name
		System.out.print("| Room name       |");
		for(i=0; i < length - 5; i++)
			System.out.print(" ");
		System.out.printf("%s |\n", this.name);
		
		// row and column divider
		System.out.print("|-----------------|");
		for(i=0; i < length; i++)
			System.out.print("-");
		System.out.print("|\n");
		
		// floor number
		System.out.print("| Floor           |");
		for(i=0; i < length - 2; i++)
			System.out.print(" ");
		System.out.printf("%c |\n", this.name.charAt(1));
		
		// row and column divider
		System.out.print("|-----------------|");
		for(i=0; i < length; i++)
			System.out.print("-");
		System.out.print("|\n");
		
		// price per night
		System.out.print("| Price per night |");
		for(i=0; i < length - 13; i++)
			System.out.print(" ");
		System.out.printf("%,12.2f |\n", this.price);
		
		// row and column divider
		System.out.print("|-----------------|");
		for(i=0; i < length; i++)
			System.out.print("-");
		System.out.print("|\n");
		
		// days available
		System.out.print("| Days available  |");
		for(i=0; i < length - availableLength - 1; i++)
			System.out.print(" ");
		
		if(available.isEmpty())
			System.out.print("|\n");
		
		for(i=0; i < available.size(); i++)
			if(i != available.size() - 1)
				System.out.printf("%2d, ", available.get(i));
			else
				System.out.printf("%2d |\n", available.get(i));
		
		// row and column divider
		System.out.print("|-----------------|");
		for(i=0; i < length; i++)
			System.out.print("-");
		System.out.print("|\n");
		
		// days reserved
		System.out.print("| Days reserved   |");
		for(i=0; i < length - reservedLength - 1; i++)
			System.out.print(" ");
		
		if(this.reserved.isEmpty())
			System.out.print("|\n");
		
		for(i=0; i < this.reserved.size(); i++)
			if(i != this.reserved.size() - 1)
				System.out.printf("%2d, ", this.reserved.get(i));
			else
				System.out.printf("%2d |\n", this.reserved.get(i));
		
		// bottom of the table
		for(i=0; i < length + 20; i++)
			System.out.print("-");
		System.out.print("\n\n");
		
	}
	
	/**
	 * Returns the name of the room.
	 * @return the name of the room
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * Returns the price of the room per night.
	 * @return the price of the room per night
	 */
	
	public double getPrice()
	{
		return this.price;
	}

	/**
	 * Returns the name of the room without the first letter as an integer.
	 * @return the name of the room without the first letter as an integer
	 */
	public int getRoomNumber()
	{
		int roomNumber;
		roomNumber = Integer.parseInt(this.name.substring(1));
		return roomNumber;
	}

	public void changeFirstLetter(char newLetter)
	{
		this.name = newLetter + Integer.toString(getRoomNumber());
	}

	/**
	 * Returns the list of days reserved.
	 * @return the list of days reserved
	 */
	public ArrayList<Integer> getReserved()
	{
		return this.reserved;
	}
	
	/**
	 * Changes the price of the room.
	 * @param price new price
	 */
	public void setPrice(double price)
	{
		this.price = price;
	}

}