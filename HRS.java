import java.util.ArrayList;
import java.util.Scanner;

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
	 * Displays all hotels
	 */
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
	
	/**
	 * Returns the array list of hotels in the hotel reservation system.
	 * @return array list of hotels
	 */
	public ArrayList<Hotel> getHotels()
	{
		return this.hotels;
	}
	
	/**
	 * Creates combines all the class and methods to create a hotel reservation system that a user can interact with.
	 *
	 * @param args
	 */
	public static void main(String[] args)
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
		String confirmation = new String();
		int choice, innerchoice, capacity, checkIn, checkOut, day, reservationId, tempCap = 0;
		double price;
				
		do
		{
			System.out.println("\nHOTEL RESERVATION SYSTEM\n");
			System.out.println("1 - Create Hotel");
			System.out.println("2 - View Hotel");
			System.out.println("3 - Manage Hotel");
			System.out.println("4 - Simulate Booking");
			System.out.println("0 - Exit\n");
			
			System.out.print("Enter choice: ");
			choice = scan.nextInt();
			scan.nextLine();
			System.out.print("\n");
			
			if(choice == 1)
			{	
				System.out.print("Enter hotel name: ");
				hotelName = scan.nextLine();

				System.out.print("Enter hotel capacity: ");
				capacity = scan.nextInt();
				scan.nextLine();
				
				System.out.print("Enter room price: ");
				price = scan.nextDouble();
				scan.nextLine();
				System.out.print("\n");

				if(price < 100)
					System.out.println("Invalid price input\n");
				else if(capacity < 1 || capacity > 50)
					System.out.println("Invalid capacity input\n");
				else if(hrs.createHotel(hotelName, capacity, price))
					System.out.println("Hotel created\n");
				else
					System.out.println("Hotel already exists\n");
				
			}
			
			else if(hrs.getHotels().isEmpty())
				System.out.println("Hotels not found");
			
			else if(choice == 2)
			{
				hrs.displayHotels();
				
				System.out.print("Enter hotel: ");
				hotelName = scan.nextLine();
				System.out.print("\n");
				
				hotel = hrs.findHotel(hotelName);
				
				if(!hotel.getName().equals(hotelName))
					System.out.println("Hotel not found");
				else
				{
					do
					{
						System.out.println("\nView Hotel");
						System.out.println("1 - View hotel");
						System.out.println("2 - View day availability");
						System.out.println("3 - View room info");
						System.out.println("4 - View reservation info");
						System.out.println("0 - Exit\n");

						System.out.print("Enter choice: ");
						innerchoice = scan.nextInt();
						scan.nextLine();
						System.out.print("\n");

						if(innerchoice == 1)
							hotel.displayInfo();
						else if(innerchoice == 2)
						{
							System.out.print("Enter day: ");
							day = scan.nextInt();
							System.out.print("\n");

							if(1 <= day && day <= 31)
								hotel.displayDayInfo(day);
							else
								System.out.println("Invalid day");
						}
						else if(innerchoice == 3)
						{
							hotel.displayRooms();

							System.out.print("Enter room: ");
							roomName = scan.nextLine();
							System.out.print("\n");

							room = hotel.findRoom(roomName);

							if(!room.getName().equals(roomName))
								System.out.println("Room not found");
							else
								room.displayInfo();
						}

						else if(innerchoice == 4)
						{
							hotel.displayReservations();

							if(!hotel.getReservations().isEmpty())
							{
								System.out.print("Enter reservation: ");
								reservationId = scan.nextInt();
								System.out.print("\n");

								reservation = hotel.findReservation(reservationId);

								if(reservation.getId() != reservationId)
									System.out.println("Reservation not found");
								else
									reservation.displayInfo();
							}
						}

						else if(innerchoice != 0)
							System.out.println("Invalid choice");
					} while (innerchoice != 0);

				}
			}
			
			else if(choice == 3)
			{
				hrs.displayHotels();
				
				System.out.print("Enter hotel: ");
				hotelName = scan.nextLine();
				System.out.print("\n");
				
				hotel = hrs.findHotel(hotelName);
				
				if(!hotel.getName().equals(hotelName))
					System.out.println("Hotel not found");
				else
				{
					do
					{
						System.out.println("\nManage Hotel\n");
						System.out.println("1 - Rename hotel");
						System.out.println("2 - Add room");
						System.out.println("3 - Remove room");
						System.out.println("4 - Update price");
						System.out.println("5 - Remove reservation");
						System.out.println("6 - Remove hotel");
						System.out.println("0 - Exit\n");
						
						System.out.print("Enter choice: ");
						innerchoice = scan.nextInt();
						scan.nextLine();
						System.out.print("\n");
						
						if(innerchoice == 1)
						{
							System.out.print("Enter new Hotel name: ");
							newName = scan.nextLine();
							System.out.print("\n");
							
							if(hrs.renameHotel(hotelName, newName))
							{
								System.out.println("Hotel renamed");
								hotelName = newName;
							}
								
							else
								System.out.println("Hotel already exists");
						}
						
						else if(innerchoice == 2)
						{
							System.out.print("Enter amount of rooms to add: ");
							capacity = scan.nextInt();
							scan.nextLine();
							System.out.print("\n");

							if((capacity + hotel.getCapacity()) > 50)
								System.out.println("Amount of rooms exceed the capacity of the hotel");
							else
							{
								System.out.print("Are you sure you want to add rooms? (y/n): ");
								confirmation = scan.nextLine();
								System.out.print("\n");
								
								if(confirmation.equalsIgnoreCase("y"))
								{
									while(tempCap < capacity)
									{
										hotel.addRoom();
										tempCap++;
									}
									System.out.printf("%d Rooms added\n", tempCap);
									tempCap = 0;
								}

								else if(confirmation.equalsIgnoreCase("n"))
									System.out.println("Aborting add Rooms ");
							}
						}
						
						else if(innerchoice == 3)
						{
							hotel.displayRooms();
							
							do
							{
								System.out.print("Select room: ");
								roomName = scan.nextLine();
								System.out.print("\n");
								
								room = hotel.findRoom(roomName);
									
								if(!room.getName().equals(roomName))
									System.out.println("Room not found");
								
								else
								{
									System.out.printf("Are you sure you want to remove room %s (y/n): ", roomName);
									confirmation = scan.nextLine();
									System.out.println();
									
									if(confirmation.equalsIgnoreCase("y"))
									{
										if(hotel.getRooms().size() == 1)
											System.out.println("Cannot remove last room\n");
										
										else if(hotel.removeRoom(roomName))
											System.out.println("Room removed\n");
										else
											System.out.println("Cannot remove room with a reservation\n");
									}
									else if(confirmation.equalsIgnoreCase("n"))
										System.out.printf("\nAborting removal of room %s\n", roomName);
								}
								
								System.out.print("\nRemove another room (y/n): ");
								
							}while(scan.nextLine().equalsIgnoreCase("y"));
						}
						
						else if(innerchoice == 4)
						{
							System.out.print("Enter price: ");
							price = scan.nextDouble();
							scan.nextLine();
							System.out.print("\n");
							
							if(price < 100)
								System.out.println("Price cannot be less than 100");
							else
							{
								if(hotel.updatePrice(price))
									System.out.println("Price updated\n");
								else
									System.out.println("Cannot update the price of a hotel with a reservation");
							}
						}
						
						else if(innerchoice == 5)
						{
							hotel.displayReservations();
							
							if(!hotel.getReservations().isEmpty())
							{
								System.out.print("Enter reservation: ");
								reservationId = scan.nextInt();
								scan.nextLine();
								System.out.print("\n");
								
								reservation = hotel.findReservation(reservationId);
								
								if(reservation.getId() != reservationId)
									System.out.println("Reservation not found");
								else
									hotel.removeReservation(reservationId);
							}
						}
						
						else if(innerchoice == 6)
						{
							System.out.printf("Are you sure you want to remove hotel %s (y/n): ", hotelName);
							confirmation = scan.nextLine();	
							System.out.print("\n");
							
							if(confirmation.equalsIgnoreCase("y"))
							{
								hrs.removeHotel(hotel.getName());
								hrs.displayHotels();
							}
								
							else
								System.out.printf("Aborting removal of hotel %s\n", hotelName);
						}
						
						else if(innerchoice != 0)
							System.out.println("Invalid choice");
					} while(innerchoice != 0 && innerchoice != 6);
					
				}
			}
			
			else if(choice == 4)
			{
				hrs.displayHotels();
				
				System.out.print("Enter hotel: ");
				hotelName = scan.nextLine();
				System.out.print("\n");
				
				hotel = hrs.findHotel(hotelName);
				
				if(!hotel.getName().equals(hotelName))
					System.out.println("Hotel not found");
				else
				{
					System.out.print("Enter guest name: ");
					guestName = scan.nextLine();
					
					System.out.print("Enter day of check in: ");
					checkIn = scan.nextInt();
					scan.nextLine();
					
					System.out.print("Enter day of check out: ");
					checkOut = scan.nextInt();
					scan.nextLine();
					System.out.print("\n");
					
					if(checkIn < 1 || checkOut  > 31 || checkIn >= checkOut)
						System.out.println("Invalid days");
					else
					{
						if(hotel.createReservation(guestName, checkIn, checkOut))
							System.out.println("Reservation created");
						else
							System.out.println("No room available");
					}
				}
			}
			
			else if(choice != 0)
				System.out.println("Invalid choice");
			
		}while(choice != 0);
		
		scan.close();
		System.out.println("Terminating program...");
	}
}

