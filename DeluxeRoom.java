import java.util.HashMap;

/**
 * Class that extends room to represent the deluxe room
 */
public class DeluxeRoom extends Room
{
    /**
     * Constructs a deluxe room
     * @param name - name of the room
     * @param price - price of the room
     * @param dayPriceMod - price modification for the room's day
     */
    public DeluxeRoom(String name, double price, HashMap<Integer, Double> dayPriceMod)
    {
        super(name, price, dayPriceMod);
        double priceBump = super.getPrice() * 0.20;
        super.setPrice(super.getPrice() + priceBump);
    }
}
