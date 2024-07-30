
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
