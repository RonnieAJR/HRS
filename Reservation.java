




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

    public double getTotalPrice()
    {
		return this.room.getPrice() * (checkOut - checkIn);
    }

    public String getName(){return this.name;}

    public Room getRoom(){return this.room;}

    int getCheckIn()
    {
        return this.checkIn;
    }

    int getCheckOut()
    {
        return this.checkOut;
    }

    int getId(){return this.reservationId;}





}
