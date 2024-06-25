

import java.util.ArrayList;
import java.util.HashSet;


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

		// instantiates the first room
		room = new Room((firstLetter + Integer.toString(101)), this.price);

		this.rooms.add(room);
		this.capacity++;

		// adds the rest of the rooms
		while(this.rooms.size() < capacity)
		{
			this.addRoom();
		}
	}

	/**
	 * Creates a room and adds it to the list of rooms if the list is not yet full.
	 *
	 * @return true if the room is created and added successfully
	 */
	public boolean addRoom()
	{
		int roomNumber;
		int size = this.capacity; 
		char firstLetter = this.getName().charAt(0);
		String roomName;
		Room room;
		
		// cannot add room if max capacity is reached
		if(50 <= size)
			return false;
		
		//roomNumber is assigned a room that does not exist in the floors
		roomNumber = findGapRoom(); 

		//name of room is first letter of hotel + room number
		roomName = firstLetter + Integer.toString(roomNumber);
		
		// creates the room and adds it to the list
		room = new Room(roomName, this.price); 
		this.rooms.add(room);
		this.capacity++;
		
		// sorts room according to room number
		insertionSortRoom();
		return true;
		
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
	 * insertion sorts array list of rooms according to their room name
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
	  * Creates a reservation for the guest.
	  * Rooms are checked if the guest can be accomodated for the whole stay.
	  * A room is already available the day of a check out.
	  *
	  * @param guestName name of the guest
	  * @param checkIn day of check in
	  * @param checkOut day of check out
	  * @return true if reservation is successfully created
	  */
	public boolean createReservation(String guestName, int checkIn, int checkOut)
	{
		int id;
		int sizeSum;
		int day = checkIn;
		int size = this.reservations.size();
		boolean available = false;
		Room room = this.rooms.get(0);
		ArrayList<Integer> targetDays = new ArrayList<Integer>();
		HashSet<Integer> combinedDays = new HashSet<Integer>();
		
		// convert the target days to be reserved into a list
		while(day < checkOut)
			targetDays.add(day++);
		
		// checks each room
		for(Room r : this.rooms)
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
		
		if(!available)
			return false;
		
		// generates reservation id
		if(size == 0)
			id = 1;
		else
			id = this.reservations.get(size-1).getId() + 1;
		
		// creates the reservation and adds it to the list
		Reservation reservation = new Reservation(guestName, room, checkIn, checkOut, id);
		
		room.addReserved(checkIn, checkOut);
		
		return this.reservations.add(reservation);
	}
	
	/**
	  * Removes the reservation from the list with the provided id.
	  * The room with the reservation removes the days reserved for the reservation.
	  *
	  * @param reservationId id of the reservation
	  * @return true if successfully removed
	  */
	public boolean removeReservation(int reservationId)
	{
		int checkIn;
		int checkOut;
		Reservation reservation;
		
		// checks if there are no reservations
		if(this.reservations.isEmpty())
			return false;
		
		// finds the reservation
		reservation = findReservation(reservationId);
		
		// returns false if reservation is not found
		if(reservation.getId() != reservationId)
			return false;
		
		// gets the checkin and checkout days
		checkIn = reservation.getCheckIn();
		checkOut = reservation.getCheckOut();
		
		// removes the reserved days in the room covered by the reservation
		reservation.getRoom().removeReserved(checkIn, checkOut);
		
		// removes the reservation from the list
		this.reservations.remove(reservation);
		
		return true;
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
	  * Displays the hotel information on the standard output stream in a tabular format.
	  *
	  */
	public void displayInfo()
	{
		int i;
		int length = this.name.length() + 2;
		double earnings=0;

		// sets the minimum length
		if(length < 14)
			length = 14;

		// computes the estimated earnings
		for(i=0; i < this.reservations.size(); i++)
			earnings += this.reservations.get(i).getTotalPrice();
		
		// top of the table
		for(i=0; i < length + 23; i++)
			System.out.print("-");
		System.out.print("\n");
		
		// hotel name
		System.out.print("| Hotel name         |");
		for(i=0; i < length - this.name.length() - 1; i++)
			System.out.print(" ");
		System.out.printf("%s |\n", this.name);
		
		// row and column divider
		System.out.print("|--------------------|");
		for(i=0; i < length; i++)
			System.out.print("-");
		System.out.print("|\n");
		
		// number of rooms
		System.out.print("| Number of rooms    |");
		for(i=0; i < length - 3; i++)
			System.out.print(" ");
		System.out.printf("%2d |\n", this.capacity);
		
		// row and column divider
		System.out.print("|--------------------|");
		for(i=0; i < length; i++)
			System.out.print("-");
		System.out.print("|\n");
		
		// estimated earnings
		System.out.print("| Estimated earnings |");
		for(i=0; i < length - 13; i++)
			System.out.print(" ");
		System.out.printf("%,12.2f |\n", earnings);
		
		// bottom of the table
		for(i=0; i < length + 23; i++)
			System.out.print("-");
		System.out.print("\n");
	}
	
	/**
	  * Displays the room available and reserved in the provided day on the standard output stream in a tabular format.
	  *
	  * @param day day to check
	  */
	public void displayDayInfo(int day)
	{	
		int i, size, length;
		HashSet<Integer> daysReserved = new HashSet<Integer>();
		ArrayList<Room> reserved = new ArrayList<Room>();
		ArrayList<Room> available = new ArrayList<Room>();
		
		reserved.addAll(this.rooms);
		
		// separates the rooms available and reserved
		for(i=0; i < reserved.size(); i++)
		{
			// adds the days reserved and target day to the hashset	
			daysReserved.addAll(reserved.get(i).getReserved());
			size = daysReserved.size();
			daysReserved.add(day);
			
			// if the target day is added to the hashset...
			// ...the target day is available
			if(size != daysReserved.size())
			{
				available.add(reserved.remove(i));
				i--;
			}
					
			// clear the hashset
			daysReserved.clear();
		}
		
		// determines the maximum length
		if(available.size() > reserved.size())
			length = available.size();
		else
			length = reserved.size();
		
		// top of the table
		for(i=0; i < 36; i++)
			System.out.print("-");
		System.out.print("\n");
		
		// table header
		System.out.printf("|        Day %2d Availability       |\n", day);
		
		// row and column divider
		System.out.print("|");
		for(i=0; i < 34; i++)
			System.out.print("-");
		System.out.print("|\n");
		
		// room label
		System.out.print("| Rooms available | Rooms reserved |\n");
		
		for(i=0; i < length; i++)// wrong condition
		{
			// row and column divider
			System.out.print("|-----------------|----------------|\n");
			
			// room available
			if(i < available.size())
				System.out.printf("| %15s |", available.get(i).getName());
			else
				System.out.printf("| %15s |", " ");
			
			// room reserved
			if(i < reserved.size())
				System.out.printf(" %14s |\n", reserved.get(i).getName());
			else
				System.out.printf(" %14s |\n", " ");
		}
		
		// row and column divider
		System.out.print("|");
		for(i=0; i < 34; i++)
			System.out.print("-");
		System.out.print("|\n");
		
		// total label
		System.out.print("|               Total              |\n");
		
		// row and column divider
		System.out.print("|");
		for(i=0; i < 34; i++)
			System.out.print("-");
		System.out.print("|\n");
		
		// total rooms
		System.out.printf("| %15d | %14d |\n", available.size(), reserved.size()); 
		
		// bottom of the table
		for(i=0; i < 36; i++)
			System.out.print("-");
		System.out.print("\n\n");
	}
	
	/**
	  * Displays the list of room names on the standard output stream in a tabular format
	  *
	  */
	public void displayRooms()
	{
		int i;
		
		// top of the table
		System.out.print("-------------\n");
		System.out.print("| Room Name |\n");
		
		for(i=0; i < this.rooms.size(); i++)
		{
			// row and column divider
			System.out.print("|-----------|\n");
			
			// room name
			System.out.printf("| %9s |\n", this.rooms.get(i).getName());
		}
		
		// bottom of the table
		System.out.print("-------------\n\n");
	}
	
	/**
	  * Displays the list of reservation ids on the standard output stream in a tabular format.
	  *
	  */
	public void displayReservations()
	{
		int i;
		
		// checks if reservations is empty
		if(this.reservations.isEmpty())
			System.out.println("Reservations not found\n");
		else
		{
			// top of the table
			System.out.print("------------------\n");
			System.out.print("| Reservation ID |\n");
			
			for(i=0; i < this.reservations.size(); i++)
			{
				// row and column divider
				System.out.print("|----------------|\n");
				
				// reservation id
				System.out.printf("| %14d |\n", this.reservations.get(i).getId());
			}
			System.out.print("------------------\n\n");
		}
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
	  * Changes the name of the hotel.
	  *
	  * @param name new hotel name
	  */
	public void setName(String name)
	{
		this.name = name;
	}
}

