import java.util.HashMap;

public class ExecutiveRoom extends Room
{
    public ExecutiveRoom(String name, double price, HashMap<Integer, Double> dayPriceMod)
    {
        super(name, price, dayPriceMod);
        double priceBump = super.getPrice() * 0.35;
        super.setPrice(super.getPrice() + priceBump);
    }
}
