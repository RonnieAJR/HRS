
import java.util.HashMap;

/**
 * The Reservation class mimics an actual reservation in a hotel having a guest name, room, check in, and check out, 
 */

public class Reservation
{
    private String guestName;
    private Room room;
    private int checkIn;
    private int checkOut;
    private int reservationId;
	private int discountCode;


    /**
     * Constructs a new reservation with the given parameters.
     * @param guestName name of the guest
     * @param room room that would accomodate the guest
     * @param checkIn day of check in
     * @param checkOut day of check out
     * @param reservationId id of the reservation
	 * @param discountCode code for identifying what code used for computing the total price
     */
    public Reservation(String guestName, Room room, int checkIn, int checkOut, int reservationId, int discountCode)
    {
		this.guestName = guestName;
		this.room = room;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.reservationId = reservationId;
		this.discountCode = discountCode;
    }

	/**
	 * Displays the reservation information on the standard output stream in a tabular format.
	 */
	public void displayInfo()
	{
		
		int i;
		int length = this.guestName.length() + 2;
		
		// sets the minimum length
		if(length < 14)
			length = 14;
		
		// top of the table
		for(i=0; i < length + 20; i++)
			System.out.print("-");
		System.out.print("\n");
		
		// reservation id
		System.out.print("| Reservation ID  |");
		for(i=0; i < length - 5; i++)
			System.out.print(" ");
		System.out.printf("%4d |\n", this.reservationId);
		
		// row and column divider
		System.out.print("|-----------------|");
		for(i=0; i < length; i++)
			System.out.print("-");
		System.out.print("|\n");
		
		// guest name
		System.out.print("| Guest name      |");
		for(i=0; i < length - this.guestName.length() - 1; i++)
			System.out.print(" ");
		System.out.printf("%s |\n", this.guestName);

		// row and column divider		
		System.out.print("|-----------------|");
		for(i=0; i < length; i++)
			System.out.print("-");
		System.out.print("|\n");
		
		// room name
		System.out.print("| Room            |");
		for(i=0; i < length - 5; i++)
			System.out.print(" ");
		System.out.print(this.room.getName() + " |\n");

		// row and column divider
		System.out.print("|-----------------|");
		for(i=0; i < length; i++)
			System.out.print("-");
		System.out.print("|\n");
		
		// check in day
		System.out.print("| Check in day    |");
		for(i=0; i < length - 4; i++)
			System.out.print(" ");
		System.out.printf("%3d |\n", this.checkIn);
		
		// row and column divider
		System.out.print("|-----------------|");
		for(i=0; i < length; i++)
			System.out.print("-");
		System.out.print("|\n");
		
		// check out day
		System.out.print("| Check out day   |");
		for(i=0; i < length - 4; i++)
			System.out.print(" ");
		System.out.printf("%3d |\n", this.checkOut);
		
		// row and column divider
		System.out.print("|-----------------|");
		for(i=0; i < length; i++)
			System.out.print("-");
		System.out.print("|\n");
		
		// price per night
		System.out.print("| Price per night |");
		for(i=0; i < length - 13; i++)
			System.out.print(" ");
		System.out.printf("%,12.2f |\n", this.room.getPrice());

		// row and column divider
		System.out.print("|-----------------|");
		for(i=0; i < length; i++)
			System.out.print("-");
		System.out.print("|\n");
		
		// total price
		System.out.print("| Total price     |");
		for(i=0; i < length - 13; i++)
			System.out.print(" ");
		System.out.printf("%,12.2f |\n", this.getTotalPrice());
		
		// row and column divider
		for(i=0; i < length + 20; i++)
			System.out.print("-");
		System.out.print("\n\n");
	}
	
    /**
     * Returns the total price of the reservation.
     * @return the total price of the reservation
     */
    public double getTotalPrice()
    {
		HashMap<Integer, Double> dayPriceMod = this.room.getDayPriceMod();
		double price = this.room.getPrice();
		int checkOut = this.checkOut;
		int checkIn = this.checkIn;
		Boolean payday = false;
		double total = 0;
		Integer day;
		
		if(this.discountCode == 1)
			checkIn++;
		
		while(checkIn < checkOut)
		{
			day = Integer.valueOf(checkIn);
			
			if(dayPriceMod.containsKey(day))
				total += price * (dayPriceMod.get(day) / 100);
			else
				total += price;
			
			if(checkIn == 15 || checkIn == 30)
				payday = true;
			
			checkIn++;
		}
		
		if(this.discountCode == 0)
			total *= .90;
		else if(this.discountCode == 2 && payday)
			total *= .93;
		
		return total;
    }

    /**
     * Returns the name of the guest.
     * @return the name of the guest
     */
    public String getGuestName()
    {
        return this.guestName;
    }

    /**
     * Returns the room that would accomodate the guest.
     * @return the room that would accomodate the guest
     */
    public Room getRoom()
    {
        return this.room;
    }

    /**
     * Returns the day of check in.
     * @return the day of check in
     */
    public int getCheckIn()
    {
        return this.checkIn;
    }

    /**
     * Returns the day of check out.
     * @return the day of check out
     */
    public int getCheckOut()
    {
        return this.checkOut;
    }

    /**
     * Returns the id of reservation.
     * @return the id of the reservation
     */
    public int getId()
    {
        return this.reservationId;
    }





}
