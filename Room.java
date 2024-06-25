
import java.util.ArrayList;
import java.util.Comparator;

/**
 * The Room class mimics an actual room in a hotel having a name, price, reservation
 */
public class Room
{
	private String name;
	private double price;
	private ArrayList<Integer> reserved; // reserved, cuz for availability you add more numbers
	
	/**
	 * constructor for Room class
	 * @param name : name of room
	 * @param price : price of room
	 */
	public Room(String name, double price)
	{
		this.name = name;
		this.price = price;
		this.reserved = new ArrayList<Integer>();
	}
	
	/**
	 * this method reserves a room using the checkin and checkout dates of a reservation
	 * @param checkIn : date of a check in
	 * @param checkOut : date of a check out
	 */
	public void addReserved(int checkIn, int checkOut)
	{
			while(checkIn < checkOut)
			{
				this.reserved.add(checkIn);
				checkIn++;
			}
	}

	/**
	 * this method removes a reservation on the room using the check in and check out parameters
	 * @param checkIn : date of a check in
	 * @param checkOut : date of a check out
	 */
	
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
	
	/**
	 * this method displays every available dates for a room to be reserved as well as its
	 * info such as name, floor, price, days reserved, and available days to be reserved
	 */
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
		for(i=0; i < length - 13; i++)
			System.out.print(" ");
		System.out.printf("%,12.2f |\n", this.price);
		
		System.out.print("|-----------------|");
		for(i=0; i < length; i++)
			System.out.print("-");
		System.out.print("|\n");
		
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
			
		System.out.print("|-----------------|");
		for(i=0; i < length; i++)
			System.out.print("-");
		System.out.print("|\n");
		
		System.out.print("| Days reserved   |");
		for(i=0; i < length - reservedLength - 2; i++)
			System.out.print(" ");
		
		if(this.reserved.isEmpty())
			System.out.print("|\n");
		
		for(i=0; i < this.reserved.size(); i++)
			if(i != this.reserved.size() - 1)
				System.out.printf("%2d, ", this.reserved.get(i));
			else
				System.out.printf("%2d |\n", this.reserved.get(i));
		
		for(i=0; i < length + 20; i++)
			System.out.print("-");
		System.out.print("\n\n");
		
	}
	
	/**
	 * this method gets the name of the room
	 * @return String name of the room
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * this method gets the price per room
	 * @return double price of a room
	 */
	
	public double getPrice()
	{
		return this.price;
	}

	/**
	 * this method gets the room's number as well as its floor using a specific naming convention
	 * @return integer of a room's number
	 */
	public int getRoomNumber()
	{
		int roomNumber;
		roomNumber = Integer.parseInt(this.name.substring(1));
		return roomNumber;
	}

	/**
	 * this method gets a room's reservations
	 * @return ArrayList of integers of reservations
	 */

	public ArrayList<Integer> getReserved()
	{
		return this.reserved;
	}
	
	/**
	 * this method allows a system to manipulate the price of a room
	 * @param price : to be used as basis for new price of a room
	 */
	public void setPrice(double price)
	{
		this.price = price;
	}
}