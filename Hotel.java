

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;


public class Hotel
{
	private String name;
	private int capacity;
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
		this.name = name;
		this.capacity = capacity;
		this.price = price;
		
		this.reservations = new ArrayList<Reservation>();
		this.rooms = new ArrayList<Room>();
		
		if(name.charAt(1) == ' ')
			room = new Room(name.charAt(0) + "-01", this.price);
		else
			room = new Room(name.charAt(0) + name.charAt(1) + "-01", this.price);
		
		this.rooms.add(room);
		
		while(this.rooms.size() < capacity)
		{
			this.addRoom();
		}
	}
	
	// di pa to tapos
	public boolean addRoom()
	{
		int size = this.rooms.size();
		String roomName;
		int roomNumber;
		Room room;
		
		// if capacity is still not satisfied?? or what is capacity the limit or the amount of rooms currently
		// probably the latter, then if(capacity < 50) is better, then update this.capacity++;
		if(size < capacity)
		{
			// deleted rooms may not come back again, for only O(1)
			// assign name, get last?
			// create room instance
			// add to list
			
			// extract the last room name
			roomName = this.rooms.get(size-1).getName();
			
			// extract the room number
			roomName = roomName.substring(3);
			
			// convert to int
			roomNumber = Integer.parseInt(roomName);
			
			// add 1
			roomNumber ++;
			
			
			///////////////////////////////////////////    PRIVATE METHOD THAT GENERATES UNIQUE NAME, lmao wag na
			if(size < 10)
				roomName = this.name.charAt(0) + this.name.charAt(1) + "-0" + roomNumber;
			else
				roomName = this.name.charAt(0) + this.name.charAt(1) + "-" + roomNumber;
			// what if space yung second character
			// are room names unique throughout the whole HRS, or just the hotel rooms
			
			room = new Room(name, this.price);
			
			this.rooms.add(room);
			
			this.capacity++;
			return true;
			
			// make a substring, starting from index 3 to end
			// convert to int, add 1, convert to string
			
			// what if space yung second character
			
			// deleted rooms can come back, for O(n)
			// go over each room
			// if, according to the naming convetion, one room is skipped, then
			// thats the name of the new room to be added
			// haba kapag iimplement tho
			//
			// or...
			// make a String[] that keeps the name of deleted rooms, then just access the first element
		}
		
		return false;
		
	}
	
	public boolean removeRoom(String name)// what if room instance yung param
	{	
		Room room;
		
		// return false if hotel only has one room
		if(this.rooms.size() == 1)
			return false;
		
		room = findRoom(name);
		
		// return false if either not found or not room is not empty
		if(room.getName().equals(name) &&
		   room.getReserved().isEmpty())
			return false;
		
		
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