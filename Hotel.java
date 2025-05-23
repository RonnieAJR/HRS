

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;


/**
  * The Hotel class mimics an actual hotel having a name, rooms, price, and reservations.
  */
public class Hotel
{
	private String name;
	private int capacity;	
	private ArrayList<Room> rooms;
	private double price;
	private ArrayList<Reservation> reservations;
	private HashMap<Integer, Double> dayPriceMod;
	
	/**
	  * Constructs a new hotel with the given parameters.
	  * The list of rooms is filled according to the capacity set.
	  */
	public Hotel(String name, int capacity, double price)
	{
		Room room;
		char firstLetter = name.charAt(0);
		this.name = name;
		this.capacity = 0;
		this.price = price;
		
		this.reservations = new ArrayList<Reservation>();
		this.rooms = new ArrayList<Room>();
		this.dayPriceMod = new HashMap<Integer, Double>();

		// instantiates the first room
		room = new Room((firstLetter + Integer.toString(101)), this.price, this.dayPriceMod);

		this.rooms.add(room);
		this.capacity++;

		// adds the rest of the rooms
		while(this.rooms.size() < capacity)
		{
			this.addRoom("Standard");
		}
	}

	/**
	 * Creates a room and adds it to the list of rooms if the list is not yet full.
	 * also automatically detects room type by using the parameters as an indicator
	 *
	 */
	public void addRoom(String roomType)
	{
		int size = this.capacity; 
		String roomName;
		Room room;
		
		// cannot add room if max capacity is reached
		if(50 <= size)
			return;
		
		roomName = generateRoomName(roomType);
		
		if(roomType.equals("Deluxe"))
			room = new DeluxeRoom(roomName, this.price, this.dayPriceMod);
		else if(roomType.equals("Executive"))
			room = new ExecutiveRoom(roomName, this.price, this.dayPriceMod);
		else
			room = new Room(roomName, this.price, this.dayPriceMod);

		this.rooms.add(room);
		this.capacity++;
		
		// sorts room according to room number
		insertionSortRoom();
	}

	/**
	 * method that generates a room's name depending on their room type
	 * @param roomType - Indicates what room type to generate new room name
	 * @return String room name
	 */
	public String generateRoomName(String roomType)
	{
		int roomNumber = findGapRoom();
		String roomName = this.getName().charAt(0) + Integer.toString(roomNumber);
		
		if(roomType.equals("Deluxe"))
			return roomName + "-DEL";
		else if(roomType.equals("Executive"))
			return roomName + "-EXE";
		else
			return roomName;
	}

	/**
	  * Returns the number of first room that is missing in
	  * the expected consecutive room numbers, or -1 if all expected rooms exists.
	  *
	  * @return the room number if found, otherwise -1
	  */
	public int findGapRoom()
	{
		int i = 0, floor = 100, room = 1, roomNumber;

		// checks if room number exists within capacity and five floors
		while (i < 50 && floor < 600)
		{
			roomNumber = floor + room;
			
			// if a room is missing, return the missing room's number
			if (i >= this.rooms.size() || this.rooms.get(i).getRoomNumber() != roomNumber)
				return roomNumber;

			// room increments
			room++;

			// if room is 11th in the floor, move to the next floor
			if (room == 11)
			{
				floor += 100;
				room = 1;
			}
			
			i++;
		}

		// return -1 if all rooms until the 5th floor are found
		return -1;
	}

	/**
	 * Insertion sorts array list of rooms according to their room name.
	 */
	public void insertionSortRoom()
	{

		int i, n, j;
		Room key;
		n = this.rooms.size();

		for (i = 1; i < n; ++i)
		{
			key = this.rooms.get(i);
			j = i - 1;

			// move elements of this.rooms[0..i-1], that are greater than key,
			// to one position ahead of their current position
			while (j >= 0 && this.rooms.get(j).getRoomNumber() > key.getRoomNumber())
			{
				this.rooms.set(j + 1, this.rooms.get(j));
				j = j - 1;
			}
			this.rooms.set(j + 1, key);
		}
	}
	
	/**
	  * Removes the room from the list of rooms if it is not the last in the list.
	  * 
	  * @param name name of the room to remove
	  * @return true if the room is successfully removed
	  */
	public boolean removeRoom(String name)
	{	
		Room room;
		
		room = findRoom(name);
		
		// return false if room is reserved
		if(!room.getReserved().isEmpty())
			return false;
		
		// removes room
		this.capacity--;
		
		return this.rooms.remove(room);
	}

	/**
	  * Returns the room in the list with the provided name, or the room at index 0 
	  *
	  * @param name name of the room to find
	  * @return the room with the provided name if found, otherwise the room in index 0
	  */
	public Room findRoom(String name)
	{
		// sets the default value
		Room room = this.rooms.get(0);
		
		// finds the room containing the name provided
		for(Room r : this.rooms)
			if(r.getName().equals(name))
			{
				room = r;
				break;
			}
		
		// return the room asked if found or the default room if not found
		return room;
	}

	/**
	 * method for modifying the percentage of the price for each day
	 * @param day - param day
	 * @param mod - percentage of the modified price
	 * @return - boolean if successfully done or not
	 */
	
	public boolean modDayPrice(int day, double mod)
	{
		boolean reserved = false;
		
		// checks if the modification is still normal price
		if(mod == 100)
		{
			this.dayPriceMod.remove(day);
			return true;
		}
		
		// checks if the day is reserved
		for(Room r : this.rooms)
			if(r.getReserved().contains(day))
			{
				reserved = true;
				break;
			}
		
		if(reserved)
			return false;
		
		// maps the price modification to the day
		this.dayPriceMod.put(day, mod);
		
		return true;
	}
	
	/**
	  * Updates the price of all the rooms if no reservations are present
	  *
	  * @param price new price of the rooms
	  * @return true if successfully updated
	  */
	public boolean updatePrice(double price)
	{
		// checks if there are no reservations
		if(this.reservations.isEmpty())
		{
			this.price = price;
			
			// updates the price in each room
			this.rooms.forEach(room ->
			{
				room.setPrice(price);
			});
			
			return true;
		}
		return false;
	}

	/**
	 * method for returning the index of the discount found in the list of strings
	 * @param discountCode - input discount code
	 * @return index of the discount code in the array or -1 (to indicate a fail)
	 */
	public int findDiscount(String discountCode)
	{
		String[] list = {"I_WORK_HERE", "STAY4_GET1", "PAYDAY"};
		int i, index = -1;

		for(i = 0; i < list.length; i++)
			if(discountCode.equals(list[i]))
				index = i;

		//return -1 if discount is not found
		return index;
	}
	
	/**
	  * Creates a reservation for the guest.
	  * Rooms are checked if the guest can be accomodated for the whole stay.
	  * A room is already available the day of a check out.
	  *
	  * @param guestName name of the guest
	  * @param checkIn day of check in
	  * @param checkOut day of check out
	  * @param DiscountInput input of discount
	  * @return true if reservation is successfully created
	  */
	public boolean createReservation(String guestName, int checkIn, int checkOut, String roomType, String DiscountInput)
	{
		ArrayList<Integer> targetDays = new ArrayList<Integer>();
		HashSet<Integer> combinedDays = new HashSet<Integer>();
		String roomExe = roomType.substring(0, 3).toUpperCase();
		int discountCode = findDiscount(DiscountInput);
		int size = this.reservations.size();
		Room room = this.rooms.get(0);
		boolean available = false;
		boolean roomMatch = false;
		int day = checkIn;
		int sizeSum;
		int id;
		// convert the target days to be reserved into a list
		while(day < checkOut)
			targetDays.add(day++);
		
		// checks each room
		for(Room r : this.rooms)
		{
			// check if the roomtype entered and roomtype of current room matches before doing all this
			roomMatch = false;
			
			if(r.getName().length() == 4)
			{
				if(roomExe.equals("STA"))
					roomMatch = true;
			}
			else if(r.getName().substring(5).equals(roomExe)) // is this correct or am i high
				roomMatch = true;
				
			if(roomMatch)
			{
				// gets the combined size of target days and days reserved
				sizeSum = targetDays.size() + r.getReserved().size();
				
				// adds the days reserved and the target days into a hashset
				combinedDays.addAll(r.getReserved());
				combinedDays.addAll(targetDays);
				
				// if the size is as expected, all target days are newly added into the hashset...
				// ...meaning, it is not present in the days reserved
				if(sizeSum == combinedDays.size())
				{
					room = r;
					available = true;
					break;
				}
				
				// resets the hash set
				combinedDays.clear();
			}
		}
		
		if(!available)
			return false;
		
		if(discountCode == 1 && targetDays.size() < 5)
			discountCode = -1;
		
		// generates reservation id
		if(size == 0)
			id = 1;
		else
			id = this.reservations.get(size-1).getId() + 1;
		
		// creates the reservation and adds it to the list
		Reservation reservation = new Reservation(guestName, room, checkIn, checkOut, id, discountCode);
		
		room.addReserved(checkIn, checkOut);
		
		return this.reservations.add(reservation);
	}


	
	/**
	  * Removes the reservation from the list with the provided id.
	  * The room with the reservation removes the days reserved for the reservation.
	  *
	  * @param reservationId id of the reservation
	  */
	public void removeReservation(int reservationId)
	{
		int checkIn;
		int checkOut;
		Reservation reservation;
		
		// checks if there are no reservations
		if(this.reservations.isEmpty())
			return;
		
		// finds the reservation
		reservation = findReservation(reservationId);
		
		// returns false if reservation is not found
		if(reservation.getId() != reservationId)
			return;
		
		// gets the checkin and checkout days
		checkIn = reservation.getCheckIn();
		checkOut = reservation.getCheckOut();
		
		// removes the reserved days in the room covered by the reservation
		reservation.getRoom().removeReserved(checkIn, checkOut);
		
		// removes the reservation from the list
		this.reservations.remove(reservation);

	}
	
	/**
	  * Returns the reservation from the list with the provided id, or the reservation at index 0
	  *
	  * @param id id of the reservation to find
	  * @return the reservation with the provided id if found, otherwise the reservation at index 0
	  */
	public Reservation findReservation(int id)
	{
		// sets the default value
		Reservation reservation = this.reservations.get(0);
		
		// finds the reservation with the id provided
		for(Reservation r : this.reservations)
			if(r.getId() == id)
			{
				reservation = r;
				break;
			}
			
		// returns the reservation asked if found or the default reservation if not found
		return reservation;
	}

	/**
	 * method to return room names of the hotel
	 * @return arraylist of room names
	 */
	public ArrayList<String> getRoomNames()
	{
		ArrayList<String> rooms = new ArrayList<>();
		
		for(Room room : this.rooms)
		{
			rooms.add(room.getName());
		}
		return rooms;
	}

	/**
	 * method to return the reservation ids of a hotel
	 * @return arraylist of reservation ids
	 */
	public ArrayList<Integer> getReservationIds()
	{
		ArrayList<Integer> reservationIds = new ArrayList<>();
		
		for(Reservation r: this.reservations)
		{
			reservationIds.add(r.getId());
		}
		return reservationIds;
	}

	/**
	 * method for getting the room names of the reserved rooms in a specified day
	 * @param day - day param to supply rooms reserved in specified day
	 * @return arraylist of room names reserved in a specified day
	 */
	public ArrayList<String> getReservedNames(int day)
	{
		ArrayList<String> reserved = new ArrayList<>();
		
		for(Room room : this.rooms)
		{
			if(room.getReserved().contains(Integer.valueOf(day)))
				reserved.add(room.getName());
		}
		return reserved;
	}

	/**
	 * method to get the room names of available rooms in a specified day
	 * @param day - day param to supply the available rooms
	 * @return - arrray list of available room (names) in a specified day
	 */
	public ArrayList<String> getAvailableNames(int day)
	{
		ArrayList<String> available = new ArrayList<>();
		ArrayList<String> reserved = getReservedNames(day);
		
		for(Room room : this.rooms)
		{
			if(!reserved.contains(room.getName()))
				available.add(room.getName());
		}
		return available;
	}

	/**
	 * method to get the total amount of money earned from reservations
	 * @return - total amount of money earned
	 */
	public double getEarnings()
	{
		int i;
		double earnings = 0;
		
		for(i=0; i < this.reservations.size(); i++)
			earnings += this.reservations.get(i).getTotalPrice();
		
		return earnings;
	}
	
	/**
	  * Returns the name of the hotel.
	  *
	  * @return the name of the hotel
	  */
	public String getName()
	{
		return this.name;
	}
	
	/**
	  * Returns the number of rooms in the hotel.
	  *
	  * @return the number of rooms in the hotel
	  */
	public int getCapacity()
	{
		return this.capacity;
	}
	
	/**
	  * Returns the list of rooms in the hotel.
	  *
	  * @return the list of rooms in the hotel
	  */
	public ArrayList<Room> getRooms()
	{
		return this.rooms;
	}


	/**
	 * method to get the price of the hotel
	 * @return double price
	 */
	public double getPrice()
	{
		return this.price;
	}
	
	/**
	  * Returns the list of reservations in the hotel.
	  *
	  * @return the list of reservations in the hotel
	  */
	public ArrayList<Reservation> getReservations()
	{
		return this.reservations;
	}

	/**
	 * getter to return dayPriceMod HashMap attribute
	 * @return HashMap of day price modification
	 */
	public HashMap<Integer, Double> getDayPriceMod()
	{
		return this.dayPriceMod;
	}
	
	/**
	  * Changes the name of the hotel.
	  *
	  * @param name new hotel name
	  */
	public void setName(String name)
	{
		this.name = name;
	}
}

