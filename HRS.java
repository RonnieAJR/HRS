

import java.util.ArrayList;
import java.util.Scanner;

public class HRS
{
	private ArrayList<Hotel> hotels;
	
	public HRS()
	{
		this.hotels = new ArrayList<Hotel>();
	}
	
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
	
	public void displayHotels()
	{
		int i, k;
		int length=11;
		
		if(!this.hotels.isEmpty())
		{
			// finds the longest hotel name
			for(i=0; i < this.hotels.size(); i++)
				if(length < this.hotels.get(i).getName().length())
					length = this.hotels.get(i).getName().length();
			
			length += 2;
			
			for(i=0; i < length + 2; i++)
				System.out.print("-");
			System.out.print("\n");
			
			System.out.print("| Hotel Names");
			for(i=0; i < length - 12; i++)
				System.out.print(" ");
			System.out.print("|\n");
			
			for(k=0; k < this.hotels.size(); k++)
			{
				System.out.print("|");
				for(i=0; i < length; i++)
					System.out.print("-");
				System.out.print("|\n");
				
				System.out.print("|");
				for(i=0; i < length - this.hotels.get(k).getName().length() - 1; i++)
					System.out.print(" ");
				System.out.printf("%s |\n", this.hotels.get(k).getName());
			}
			
			for(i=0; i < length + 2; i++)
				System.out.print("-");
			System.out.print("\n\n");
			
			
			
			
		}
	}
	
	public ArrayList<Hotel> getHotels()
	{
		return this.hotels;
	}
	
	// insert main here
	
	public static void main(String args[])
	{
		HRS hrs = new HRS();
		Hotel hotel;
		Room room;
		Reservation reservation;
		Scanner scan = new Scanner(System.in);
		String hotelName = new String();
		String newName = new String();
		String roomName = new String();
		String guestName = new String();
		int choice, capacity, checkIn, checkOut, day, reservationId;
		double price;
		
		/*
		
		display options
		
		create hotel
		view hotel
		manage hotel
		simulate booking
		
		*/
		
		do
		{
			System.out.println("Hotel Reservation System\n");
			System.out.println("1 - Create Hotel");
			System.out.println("2 - View Hotel");
			System.out.println("3 - Manage Hotel");
			System.out.println("4 - Simulate Booking");
			System.out.println("0 - Exit\n");
			
			System.out.print("Enter choice: ");
			choice = scan.nextInt();
			
			if(choice == 1)
			{
				scan.nextLine();
				System.out.print("Enter hotel name: ");
				hotelName = scan.nextLine();

				System.out.print("Enter hotel capacity: ");
				capacity = scan.nextInt();

				scan.nextLine();
				System.out.print("Enter room price: ");
				price = scan.nextDouble();

				scan.nextLine();
				if(hrs.createHotel(hotelName, capacity, price))
					System.out.println("Hotel created\n");
				else
					System.out.println("Hotel already exists\n");
			}
			
			else if(hrs.getHotels().isEmpty())
				System.out.println("Hotels not found\n");
			
			else if(choice == 2)
			{
				scan.nextLine();
				hrs.displayHotels();
				
				System.out.print("Enter hotel: ");
				hotelName = scan.nextLine();
				
				hotel = hrs.findHotel(hotelName);
				
				if(!hotel.getName().equals(hotelName))
					System.out.println("Hotel not found\n");
				else
				{
					System.out.println("View Hotel");
					System.out.println("1 - View hotel");
					System.out.println("2 - View day availability");
					System.out.println("3 - View room info");
					System.out.println("4 - View reservation info");
					System.out.println("0 - Exit\n");
					
					System.out.print("Enter choice: ");
					choice = scan.nextInt();
					scan.nextLine();
					
					if(choice == 1)
						hotel.displayInfo();
					else if(choice == 2)
					{
						System.out.print("Enter day: ");
						day = scan.nextInt();
						
						if(1 <= day && day <= 31)
							hotel.displayDayInfo(day);
						else
							System.out.println("Invalid day\n");
					}
					else if(choice == 3)
					{
						hotel.displayRooms();
						
						System.out.print("Enter room: ");
						roomName = scan.nextLine();
						
						room = hotel.findRoom(roomName);
						
						if(!room.getName().equals(roomName))
							System.out.println("Room not found\n");
						else
							room.displayInfo();
					}
					
					else if(choice == 4)
					{
						hotel.displayReservations();
						
						if(!hotel.getReservations().isEmpty())
						{
							System.out.print("Enter reservation: ");
							reservationId = scan.nextInt();
							
							reservation = hotel.findReservation(reservationId);
							
							if(reservation.getId() != reservationId)
								System.out.println("Reservation not found\n");
							else
								reservation.displayInfo();
						}
					}
					
					else if(choice != 0)
						System.out.println("Invalid choice\n");
				}
			}
			
			else if(choice == 3)
			{
				scan.nextLine();
				hrs.displayHotels();
				
				System.out.print("Enter hotel: ");
				hotelName = scan.nextLine();
				
				hotel = hrs.findHotel(hotelName);
				
				if(!hotel.getName().equals(hotelName))
					System.out.println("Hotel not found\n");
				else
				{
					System.out.println("Manage Hotel\n");
					System.out.println("1 - Rename hotel");
					System.out.println("2 - Add room");
					System.out.println("3 - Remove room");
					System.out.println("4 - Update price");
					System.out.println("5 - Remove reservation");
					System.out.println("6 - Remove hotel");
					System.out.println("0 - Exit\n");
					
					System.out.print("Enter choice: ");
					choice = scan.nextInt();
					
					if(choice == 1)
					{
						scan.nextLine();
						System.out.print("Enter new Hotel name: ");
						newName = scan.nextLine();
						
						if(hrs.renameHotel(hotelName, newName))
							System.out.println("Hotel renamed\n");
						else
							System.out.println("Hotel already exists\n");
					}
					
					else if(choice == 2)
					{
						scan.nextLine();
						if(hotel.addRoom())
							System.out.println("Room added\n");
						else
							System.out.println("Hotel is already full\n");
					}
					
					else if(choice == 3)
					{
						scan.nextLine();
						hotel.displayRooms();
						
						System.out.print("Select room: ");
						roomName = scan.nextLine();
						
						room = hotel.findRoom(roomName);
						
						if(!room.getName().equals(roomName))
							System.out.println("Room not found\n");
						else
						{
							if(hotel.removeRoom(roomName))
								System.out.println("Room removed\n");
							else
								System.out.println("Cannot remove room with a reservation\n");
						}
					}
					
					else if(choice == 4)
					{
						scan.nextLine();
						System.out.print("Enter price: ");
						price = scan.nextDouble();
						
						if(price < 100)
							System.out.println("Price cannot be less than 100\n");
						else
						{
							if(hotel.updatePrice(price))
								System.out.println("Price updated\n");
							else
								System.out.println("Cannot update the price of a hotel with a reservation");
						}
					}
					
					else if(choice == 5)
					{
						scan.nextLine();
						hotel.displayReservations();
						
						if(!hotel.getReservations().isEmpty())
						{
							System.out.print("Enter reservation: ");
							reservationId = scan.nextInt();
							
							reservation = hotel.findReservation(reservationId);
							
							if(reservation.getId() != reservationId)
								System.out.println("Reservation not found\n");
							else
								hotel.removeReservation(reservationId);
						}
					}
					
					else if(choice == 6)
					{
						hrs.removeHotel(hotel.getName());
						// hrs.getHotels().remove(hotel);
					}
					
					else if(choice != 0)
						System.out.println("Invalid choice\n");
				}
			}
			
			else if(choice == 4)
			{
				scan.nextLine();
				hrs.displayHotels();
				
				System.out.print("Enter hotel: ");
				hotelName = scan.nextLine();
				
				hotel = hrs.findHotel(hotelName);
				
				if(!hotel.getName().equals(hotelName))
					System.out.println("Hotel not found\n");
				else
				{
					System.out.print("Enter guest name: ");
					guestName = scan.nextLine();
					System.out.print("Enter day of check in: ");
					checkIn = scan.nextInt();
					System.out.print("Enter day of check out: ");
					checkOut = scan.nextInt();
					
					if(checkIn < 1 || checkIn >= checkOut)
						System.out.println("Invalid days");
					else
					{
						if(hotel.createReservation(guestName, checkIn, checkOut))
							System.out.println("Reservation created\n");
						else
							System.out.println("No room available");
					}
				}
			}
			
			else if(choice != 0)
				System.out.println("Invalid choice\n");
			
		}while(choice != 0);
		
		System.out.println("Terminating program...");
	}
}

