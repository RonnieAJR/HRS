import javax.swing.*;

public class V_Card3_1 {
    private JPanel cards;
    private JTextField txtHotelName, txtNumRooms, txtEstimatedEarnings;

    public V_Card3_1(JPanel cards){
        this.cards = cards;

        JPanel card3_1 = new JPanel();

        this.txtHotelName = new JTextField();
        this.txtHotelName.setEditable(false);

        this.txtNumRooms = new JTextField();
        this.txtNumRooms.setEditable(false);

        this.txtEstimatedEarnings = new JTextField();
        this.txtEstimatedEarnings.setEditable(false);

        card3_1.add(new JLabel("Hotel Info"));

        card3_1.add(new JLabel("Hotel Name: "));
        card3_1.add(this.txtHotelName);

        card3_1.add(new JLabel("Number of Rooms: "));
        card3_1.add(this.txtNumRooms);

        card3_1.add(new JLabel("Estimated earnings: "));
        card3_1.add(this.txtEstimatedEarnings);

        this.cards.add(card3_1, "View Hotel Info");
    }

    //card3_1 setters
    public void setTxtHotelName(String hotelName){
        this.txtHotelName.setText(hotelName);
    }

    public void setTxtNumRooms(int numRooms){
        this.txtNumRooms.setText("" + numRooms);
    }

    public void setTxtEstimatedEarnings(double earnings){
        this.txtEstimatedEarnings.setText("" + earnings);
    }

}
