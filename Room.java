

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;


/**
 * The Room class mimics an actual room in a hotel having a name, price, and reservation.
 */
public class Room
{
	private String name;
	private double price;
	private ArrayList<Integer> reserved;
	private HashMap<Integer, Double> dayPriceMod;
	
	/**
	 * Constructs a new room with the given parameters.
	 * @param name name of the room
	 * @param price price of the room
	 */
	public Room(String name, double price, HashMap<Integer, Double> dayPriceMod)
	{
		this.name = name;
		this.price = price;
		this.reserved = new ArrayList<Integer>();
		this.dayPriceMod = dayPriceMod;
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

	/**
	 * Changes the first letter of the room name.
	 * @param newLetter character to replace the first index of the room name
	 */
	public void changeFirstLetter(char newLetter)
	{
		this.name = newLetter + Integer.toString(getRoomNumber());
	}
	
	public ArrayList<Integer> getAvailable()
	{
		ArrayList<Integer> available = new ArrayList<>();
		int i;
		Integer day;
		for(i=1; i<=31; i++)
		{
			day = Integer.valueOf(i);
			if(!this.reserved.contains(day))
				available.add(day);
		}
		
		return available;
	}

	/**
	 * Returns the list of days reserved.
	 * @return the list of days reserved
	 */
	public ArrayList<Integer> getReserved()
	{
		return this.reserved;
	}
	
	public HashMap<Integer, Double> getDayPriceMod()
	{
		return this.dayPriceMod;
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