/**
 * this class allows a system to be able to reserve a room
 */

public class Reservation
{
    private String guestName;
    private Room room;
    private int checkIn;
    private int checkOut;
    private int reservationId;


    /**
     * constructor for the reservation class
     * @param guestName : guestName of the customer who reserved
     * @param room : room parameter to identify what room to be reserved
     * @param checkIn : checkin date
     * @param checkOut : checkout date
     * @param reservationId : id reservation
     */
    public Reservation(String guestName, Room room, int checkIn, int checkOut, int reservationId)
    {
		this.guestName = guestName;
		this.room = room;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.reservationId = reservationId;
    }
	
	public void displayInfo()
	{
		
		int i;
		int length = this.guestName.length() + 2;
		
		if(length < 14)
			length = 14;
		
		for(i=0; i < length + 20; i++)
			System.out.print("-");
		System.out.print("\n");
		
		System.out.print("| Reservation ID  |");
		for(i=0; i < length - 5; i++)
			System.out.print(" ");
		System.out.printf("%4d |\n", this.reservationId);
		
		System.out.print("|-----------------|");
		for(i=0; i < length; i++)
			System.out.print("-");
		System.out.print("|\n");
		
		System.out.print("| Guest name      |");
		for(i=0; i < length - this.guestName.length() - 1; i++)
			System.out.print(" ");
		System.out.printf("%s |\n", this.guestName);
		
		System.out.print("|-----------------|");
		for(i=0; i < length; i++)
			System.out.print("-");
		System.out.print("|\n");
		
		System.out.print("| Room            |");
		for(i=0; i < length - 5; i++)
			System.out.print(" ");
		System.out.print(this.room.getName() + " |\n");
		
		System.out.print("|-----------------|");
		for(i=0; i < length; i++)
			System.out.print("-");
		System.out.print("|\n");
		
		System.out.print("| Check in day    |");
		for(i=0; i < length - 4; i++)
			System.out.print(" ");
		System.out.printf("%3d |\n", this.checkIn);
		
		System.out.print("|-----------------|");
		for(i=0; i < length; i++)
			System.out.print("-");
		System.out.print("|\n");
		
		System.out.print("| Check out day   |");
		for(i=0; i < length - 4; i++)
			System.out.print(" ");
		System.out.printf("%3d |\n", this.checkOut);
		
		System.out.print("|-----------------|");
		for(i=0; i < length; i++)
			System.out.print("-");
		System.out.print("|\n");
		
		System.out.print("| Price per night |");
		for(i=0; i < length - 13; i++)
			System.out.print(" ");
		System.out.printf("%,12.2f |\n", this.room.getPrice());
		
		System.out.print("|-----------------|");
		for(i=0; i < length; i++)
			System.out.print("-");
		System.out.print("|\n");
		
		System.out.print("| Total price     |");
		for(i=0; i < length - 13; i++)
			System.out.print(" ");
		System.out.printf("%,12.2f |\n", this.getTotalPrice());
		//
		for(i=0; i < length + 20; i++)
			System.out.print("-");
		System.out.print("\n\n");
	}
	
    /**
     * getter for total price for the duration of a room being reserved
     * @return : double total price
     */
    public double getTotalPrice()
    {
		return this.room.getPrice() * (checkOut - checkIn);
    }

    /**
     * getter for name of the guest
     * @return : string guestName of the customer
     */
    public String getGuestName()
    {
        return this.guestName;
    }

    /**
     * getter for the room
     * @return : room object
     */
    public Room getRoom()
    {
        return this.room;
    }

    /**
     * // getter for the check in date
     * @return : integer of a checkin date
     */
    public int getCheckIn()
    {
        return this.checkIn;
    }

    /**
     * getter for the check out date
     * @return : integer of a checkout date
     */
    public int getCheckOut()
    {
        return this.checkOut;
    }

    /**
     * getter for the id of reservation
     * @return : integer for a reservation id
     */
    public int getId()
    {
        return this.reservationId;
    }





}
