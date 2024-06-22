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
