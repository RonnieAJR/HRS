public class ExecutiveRoom extends Room
{
    public ExecutiveRoom(String name, double price)
    {
        super(name, price);
        double priceBump = super.getPrice() * 0.35;
        super.setPrice(super.getPrice() + priceBump);
    }
}
