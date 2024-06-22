

import java.util.ArrayList;

public class HRS
{
	private ArrayList<Hotel> hotels;
	
	public HRS()
	{
		this.hotels = new ArrayList<Hotel>();
	}
	
	public boolean createHotel(String name, int capacity)
	{
		Hotel hotel = findHotel(name);
		
		if(hotel.getName().equals(name))
			return false;
		
		hotel = new Hotel(name, capacity);
		this.hotels.add(hotel);
		
		return true;
	}
	
	public boolean renameHotel(String oldName, String newName)
	{
		Hotel hotel = findHotel(newName);
		
		if(hotel.getName().equals(newName))
			return false;
		
		hotel = findHotel(oldName);
		hotel.setName(newName);
		
		return true;
	}
	
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
	
	public void removeHotel(String name)
	{
		Hotel hotel = findHotel(name);
		
		this.hotels.remove(hotel);
	}
	
	// insert main here
}

