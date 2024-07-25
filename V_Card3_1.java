import javax.swing.*;
import java.awt.event.ActionListener;

public class V_Card3_1 {
    private JPanel cards;
    private JTextField txtHtlName, txtNumRooms, txtEstimatedEarnings;
	private JButton btnVieHtlBck;

    public V_Card3_1(JPanel cards){
        this.cards = cards;

        JPanel card3_1 = new JPanel();

        this.txtHtlName = new JTextField();
        this.txtHtlName.setEditable(false);

        this.txtNumRooms = new JTextField();
        this.txtNumRooms.setEditable(false);

        this.txtEstimatedEarnings = new JTextField();
        this.txtEstimatedEarnings.setEditable(false);
		
		this.btnVieHtlBck = new JButton("Back to View Hotel");

        card3_1.add(new JLabel("Hotel Info"));

        card3_1.add(new JLabel("Hotel Name: "));
        card3_1.add(this.txtHtlName);

        card3_1.add(new JLabel("Number of Rooms: "));
        card3_1.add(this.txtNumRooms);

        card3_1.add(new JLabel("Estimated earnings: "));
        card3_1.add(this.txtEstimatedEarnings);

		card3_1.add(this.btnVieHtlBck);
		
        this.cards.add(card3_1, "View Hotel Info");
    }

    //card3_1 setters
	public void resetVieHtl(){
		this.txtHtlName.setText("");
		this.txtNumRooms.setText("");
		this.txtEstimatedEarnings.setText("");
	}
	
    public void setTxtHtlName(String hotelName){
        this.txtHtlName.setText(hotelName);
    }

    public void setTxtNumRooms(int numRooms){
        this.txtNumRooms.setText("" + numRooms);
    }

    public void setTxtEstimatedEarnings(double earnings){
        this.txtEstimatedEarnings.setText("" + earnings);
    }
	
	public void setBtnVieHtlBckListener(ActionListener al){
		this.btnVieHtlBck.addActionListener(al);
	}
}
