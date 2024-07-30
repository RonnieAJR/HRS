import java.util.ArrayList;

public class HRS
{
	private ArrayList<Hotel> hotels;
	
	/**
	 * Constructor for the hotel reservation system
	 */
	public HRS()
	{
		this.hotels = new ArrayList<Hotel>();
	}
	
	/**
	 * Creates a hotel instance to be used by the hotel reservation system
	 * @param name name of the hotel
	 * @param capacity capacity of the hotel
	 * @param price price per night of a room of the hotel
	 * @return true if hotel is successfully created
	 * 		   false if otherwise
	 */
	public boolean createHotel(String name, int capacity, double price)
	{
		Hotel hotel;
		if(!this.hotels.isEmpty())
		{
			hotel = findHotel(name);
			if(hotel.getName().equals(name))
				return false;
		}
		
		hotel = new Hotel(name, capacity, price);
		this.hotels.add(hotel);
		
		return true;
	}

	/**
	 * Renames existing hotel in the array list of hotels
	 * @param oldName old name of the hotel
	 * @param newName new name to be renamed to the hotel
	 * @return true if successfully renamed
	 * 		   false if otherwise
	 */
	public boolean renameHotel(String oldName, String newName)
	{
		Hotel hotel = findHotel(newName);
		
		if(hotel.getName().equals(newName))
			return false;
		
		hotel = findHotel(oldName);
		hotel.setName(newName);

		for(Room r : hotel.getRooms())
		{
			r.changeFirstLetter(newName.charAt(0));
		}
		
		return true;
	}
	
	/**
	 * Finds hotel instance inside the array list of hotel using its name.
	 * @param name name of the hotel
	 * @return hotel with the name parameter
	 * 		   first hotel in the array list otherwise.
	 */
	public Hotel findHotel(String name)
	{
		Hotel hotel = this.hotels.get(0);
		
		for(Hotel h : this.hotels)
			if(h.getName().equals(name))
			{
				hotel = h;
				break;
			}
		return hotel;
	}
	
	/**
	 * Removes hotel from the array list of hotels.
	 * @param name name of the hotel to be removed
	 */
	public void removeHotel(String name)
	{
		Hotel hotel = findHotel(name);
		
		this.hotels.remove(hotel);
	}

	/**
	 * Returns the array list of hotels in the hotel reservation system.
	 * @return array list of hotels
	 */
	public ArrayList<Hotel> getHotels()
	{
		return this.hotels;
	}

}

