public class DeluxeRoom extends Room
{
    public DeluxeRoom(String name, double price)
    {
        super(name, price);
        double priceBump = super.getPrice() * 0.20;
        super.setPrice(super.getPrice() + priceBump);
    }
}
