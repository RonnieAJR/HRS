




public class Reservation
{
    private String name;
    private Room room;
    private int checkin;
    private int checkout;
    private int reservationid;


    public Reservation(String name, Room room, int checkin, int checkout)
    {

    }

    String getBreakdown()
    {

    }

    double getTotalPrice()
    {

    }

    String getName(){return this.name;}

    String getRoom(){return this.room.getName();}

    int getCheckin()
    {
        return this.checkin;
    }

    int getCheckout()
    {
        return this.checkout;
    }

    int getid(){return this.reservationid;}





}
