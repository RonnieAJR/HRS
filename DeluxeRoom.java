import java.util.HashMap;

public class DeluxeRoom extends Room
{
    public DeluxeRoom(String name, double price, HashMap<Integer, Double> dayPriceMod)
    {
        super(name, price, dayPriceMod);
        double priceBump = super.getPrice() * 0.20;
        super.setPrice(super.getPrice() + priceBump);
    }
}
