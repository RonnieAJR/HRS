




public class Reservation
{
    private String name;
    private Room room;
    private int checkIn;
    private int checkOut;
    private int reservationId;


    public Reservation(String name, Room room, int checkIn, int checkOut, int reservationId)
    {
		this.name = name;
		this.room = room;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.reservationId = reservationId;
    }

    public String getBreakdown()
    {
		return "PLACEHOLDER";
    }

    public double getTotalPrice() //getter for total price of the room being reserved
    {
		return this.room.getPrice() * (checkOut - checkIn);
    }

    public String getName(){return this.name;} //getter for name of reservation

    public Room getRoom(){return this.room;} // getter for the room

    int getCheckIn()
    {
        return this.checkIn;
    } // getter for check in date

    int getCheckOut()
    {
        return this.checkOut;
    }// getter for check out date

    int getId(){return this.reservationId;} // getter for the id of reservation





}
