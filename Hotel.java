

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;


public class Hotel
{
	private String name;
	private int capacity; // = 50?
	private ArrayList<Room> rooms;
	private double price;
	private ArrayList<Reservation> reservations;
	
	public Hotel(String name)
	{
		this(name, 1, 1299.0);
	}
	
	public Hotel(String name, int capacity)
	{
		this(name, capacity, 1299.0);
	}
	
	public Hotel(String name, int capacity, double price)
	{
		Room room;
		char firstLetter = name.charAt(0);
		this.name = name;
		this.capacity = capacity;
		this.price = price;
		
		this.reservations = new ArrayList<Reservation>();
		this.rooms = new ArrayList<Room>();

		room = new Room((firstLetter + Integer.toString(101)), this.price);

		this.rooms.add(room);

		while(this.rooms.size() < capacity)
		{
			this.addRoom();
		}
	}

	public boolean addRoom()
	{
		int noRoom; // placeholder for finding floor with no room
		int size = this.capacity; // placeholder for capacity of hotel
		char firstLetter = this.getName().charAt(0); // first letter of hotel's name
		String roomName; //placeholder for new unique room name
		Room room;// placeholder for room

		if(size < 50) //if size is less than 50, can add room
		{
			noRoom = findGapRoom(); //noRoom is assigned a room that does not exist in the floors

			if(noRoom != -1) // if noRoom is not equal to the false equivalent of isRoom exist, execute add room
			{
				//name of room is first letter of hotel + room number
				roomName = firstLetter + Integer.toString(noRoom);
				room = new Room(roomName, this.price); //instantiate new room
				this.rooms.add(room); // adds new room to the list of hotel rooms
				insertionSortRoom(); // sorts room according to room number
				return true;
			}
		}
		return false;
	}

	public int findGapRoom()
	{
		int i = 0, floor = 100, room = 1, roomNumber;

		while (i < this.capacity && floor < 600)
		{ // Check if room number exists within capacity and five floors
			roomNumber = floor + room;
			if (i >= this.rooms.size() || this.rooms.get(i).getRoomNumber() != roomNumber)
			{ // If room doesn't exist, return room number where room doesn't exist
				return roomNumber;
			}

			// Room increments
			room++;

			// If room is 11, move to the next floor
			if (room == 11)
			{
				floor += 100;
				room = 1;
			}

			// Increment index
			i++;
		}

		// Return -1 if all rooms until the 5th floor are found
		return -1;
	}

	/**
	 * insertion sorts array list of roos
	 * di ko pa alam kung pano pero aralin ko nalang mamaya
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

			// Move elements of this.rooms[0..i-1], that are greater than key,
			// to one position ahead of their current position
			while (j >= 0 && this.rooms.get(j).getRoomNumber() > key.getRoomNumber())
			{
				this.rooms.set(j + 1, this.rooms.get(j));
				j = j - 1;
			}
			this.rooms.set(j + 1, key);
		}
	}
	
	public boolean removeRoom(String name)// what if room instance yung param
	{	
		Room room;
		
		// return false if hotel only has one room
		if(this.rooms.size() == 1)
			return false;
		
		room = findRoom(name);
		
		// return false if either not found or not room is not empty
//		if(room.getName().equals(name) &&
//		   room.getReserved().isEmpty())
//			return false;
		
		
		// remove if room is found and empty
		this.capacity--;
		
		return this.rooms.remove(room);
	}
	
	public boolean updatePrice(double price)
	{
		// condition for updating the price
		if(this.reservations.isEmpty() && price >= 100)
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
	
	// viewDayAvailability checks each reserved in each room, O(n^2),,,,, or
	// create new arraylist, add day, create hashset, add all day to hashset, convert to arraylist, check if size changed,,, O(n)?
	// this wont identify which rooms are free tho
	
	// reserve checks each reserved, for each room, for each day, O(n^3),,,,,,, or
	// copy a room's reserved days to an arraylist, add the days to be reserved in the arraylist, if size is less than expected,,,,
	// return false,,, do it for each room, O(n^2)
	public boolean createReservation(String guestName, int checkIn, int checkOut)// guest name and room name, instead of room instacne
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
			sizeSum = targetDays.size() + r.getReserved().size();
			
			// prevents duplicate days from being added into the list
			combinedDays.addAll(targetDays);
			combinedDays.addAll(r.getReserved());
			
			// checks if no days overlap in target days and reserved days
			// same size means no duplicate days were prevented
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
		
		Reservation reservation = new Reservation(guestName, room, checkIn, checkOut, id);
		
		return this.reservations.add(reservation);
	}
	
	
	public boolean removeReservation(int reservationId)
	{
		int checkIn;
		int checkOut;
		Reservation reservation;
		
		if(this.reservations.isEmpty())
			return false;
		
		reservation = findReservation(reservationId);
		
		if(reservation.getId() != reservationId)
			return false;
		
		checkIn = reservation.getCheckIn();
		checkOut = reservation.getCheckOut();
		
		reservation.getRoom().removeReserved(checkIn, checkOut);
		
		this.reservations.remove(reservation);
		
		return true;
	}
	
	public Room findRoom(String name)
	{
		Room room = this.rooms.get(0);
		
		for(Room r : this.rooms)
			if(r.getName().equals(name))
			{
				room = r;
				break;
			}
		return room;
	}
	
	// breaks if this.reservations is empty
	public Reservation findReservation(int id)
	{
		Reservation reservation = this.reservations.get(0);
		
		for(Reservation r : this.reservations)
			if(r.getId() == id)
			{
				reservation = r;
				break;
			}
		return reservation;
	}
	
	public void displayInfo()
	{
		int i;
		int length = this.name.length() + 2;

		for(i=0; i < length + 23; i++);
			System.out.print("-");
		System.out.print("\n");
		
		System.out.printf("| Hotel name         | %s |", this.name);
		
		System.out.print("|--------------------|");
		for(i=0; i < length; i++);
			System.out.print("-");
		System.out.print("|\n");
		
		System.out.print("| Number of rooms    |");
		for(i=0; i < length - 3; i++)
			System.out.print(" ");
		System.out.printf("%2d |\n", this.capacity);
		
		System.out.print("|--------------------|");
		for(i=0; i < length; i++);
			System.out.print("-");
		System.out.print("|\n");
		
		System.out.print("| Estimated earnings |");
		for(i=0; i < length - 13; i++)
			System.out.print(" ");
		System.out.printf("%,12.2f |\n", this.price);
		
		for(i=0; i < length + 23; i++);
			System.out.print("-");
		System.out.print("\n");
		
		
		
	}
	
	public void displayDayInfo(int day)
	{	
		int i, size;
		HashSet<Integer> daysReserved = new HashSet<Integer>();
		ArrayList<Room> reserved = new ArrayList<Room>();
		ArrayList<Room> available = new ArrayList<Room>();
		
		reserved.addAll(this.rooms);
		
		// separates the rooms available and reserved
		for(i=0; i < reserved.size(); i++)
		{
			daysReserved.addAll(reserved.get(i).getReserved());
			size = daysReserved.size();
			daysReserved.add(day);
			
			if(size != daysReserved.size())
			{
				available.add(reserved.remove(i));
				i--;
			}
			daysReserved.clear();
		}

		for(i=0; i < 36; i++)
			System.out.print("-");
		System.out.print("\n");
		
		System.out.printf("|        Day %2d Availability       |\n", day);
		
		for(i=0; i < 36; i++)
			System.out.print("-");
		System.out.print("\n");
		
		System.out.print("| Rooms available | Rooms reserved |\n");		
		
		for(i=0; i < this.capacity; i++)// wrong condition
		{
			System.out.print("|-----------------|----------------|\n");
			
			if(i < reserved.size())
				System.out.printf("| %15s |", reserved.get(i));
			else
				System.out.printf("| 15s |", " ");
			
			if(i < available.size())
				System.out.printf("| %14s |\n", available.get(i));
			else
				System.out.printf("| 14s |\n", " ");
		}
		
		for(i=0; i < 36; i++)
			System.out.print("-");
		System.out.print("\n\n");
	}
	
	public void displayRooms()
	{
		int i;
		
		System.out.print("-------------\n");
		System.out.print("| Room Name |\n");
		
		for(i=0; i < this.rooms.size(); i++)
		{
			System.out.print("|-----------|\n");
			System.out.printf("| %9s |\n", this.rooms.get(i).getName());
		}
		System.out.print("-------------\n\n");
	}
	
	public void displayReservations()
	{
		int i;
		
		if(this.reservations.size() == 0)
			System.out.println("Reservations not found\n");
		else
		{
			System.out.print("------------------\n");
			System.out.print("| Reservation ID |\n");
			
			for(i=0; i < this.reservations.size(); i++)
			{
				System.out.print("|----------------|\n");
				System.out.printf("| %14d |\n", this.reservations.get(i).getId());
			}
			System.out.print("------------------\n\n");
		}
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getCapacity()
	{
		return this.capacity;
	}
	
	public ArrayList<Room> getRooms()
	{
		return this.rooms;
	}
	
	public double getPrice()
	{
		return this.price;
	}
	
	public ArrayList<Reservation> getReservations()
	{
		return this.reservations;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	/*

	methods to add
	displayRooms
	displaySelectRoom (name)
	displayReservations
	displaySelectReservation (id)
	getEarnings()?
	
	
	on hrs
	displayHotels
	displaySelectHotel (name)
	
	*/
	
	/* public double getEarnings()
	{
		double earnings=0;
		Reservation reservation;
		
		for(reservation : this.reservations)
			earnings += reservation.getTotalPrice();
		
		return earnings;
	} */
	
	/* public String displayRoomInfo(String name)
	{
		Room r;
		Integer day;
		String availability = "";
		ArrayList<Integer> reserved;
		
		for(r : this.rooms)
			if(r.getName().equals(name))
				break;
		
		if(!r.getName().equals(name))
			return "Room doesn't exist.\n\n";
		
		reserved = r.getReserved();
		reserved.sort(Comparator.naturalOrder());
		
		for(day : reserved)
		{
			availability.concat(day.toString());
			availability.concat("  ");
		}
		return "Name: " + r.getName() + "\n" +
			   "Price: " + r.getPrice() + "\n" +
			   "Available days: " + availability + "\n\n";
	} */
	
	
	
}

/*

high level info

	display list of hotel first
	
	
	view hotel(hotel name)
	
	provide hotel name as param
	iterate through list of hotel to find instance
	
	name param
	getCapacity()
	for(r : hotel.getReservations())
	earnings = r.getTotalPrice(); // getReservations is useed


low level info

	display list of hotel
	
		viewDayAvailability(day)// getRooms is a must
			pick a day
			available = hotel.getCapacity();
			reserved = 0;
			rooms = hotel.getRooms();
			for(r : rooms)
			if(r.getReserved().contains(day)) 
				available--; reserved++;
		
		viewRoomInfo(room name) // getRooms is used
			display list of rooms
			pick a room
			str = doesnt exist;
			for(r : hotel.getRooms())
				if(r.getName().equals(room name))
					str = room info;
					break;
			return str;
		
		viewReservation(reservation id) // getReservation is used
			display list of reservation ids
			str = doesnt exist;
			for(r : hotel.getReservations())
				if(r.getId == reservation id)
					str = reservation info;
					break;
			return str;
	
	
	
	
	
	
	
	
	
	view hotel							main
		display list of hotel			method in hrs	hrs.displayHotels()
		enter hotel						main	
		
		(after entering hotel, its already located)		hrs.hotels.get(i).getName().equals(name)	
		(its method can now be called directly)			hotel = hrs.hotels.get(i)
		
			view hotel info				method			hotel.displayInfo()
			
			view day availability
				enter day				main
				display info			method			hotel.displayDayAvailability()
				
			view room info
				display rooms			method			hotel.displayRooms()
				enter room				main			hotel.getRooms().get(i).getName().equals(name)	room = hotel.getRooms().get(i)
				display info			method			room.displayInfo()
				
			view reservation info
				display reservations					hotel.displayReservations()
				enter reservation						hotel.getReservations().get(i).getId(id)	r = hotel.getReservations().get(i)
				display info							r.displayInfo()
				
*/