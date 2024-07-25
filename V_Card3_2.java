import javax.swing.*;
import java.awt.event.ActionListener;

public class V_Card3_2 {
    private JPanel cards;

    private String[] roomAvailable, roomReserved;
    private JComboBox<Integer> cmbxDay;
    private JComboBox<String> cmbxAvail, cmbxReserved;
    private JTextField txtTotalRoomAvail, txtTotalRoomReserved;
	private JButton btnVieHtlBck;

    public V_Card3_2(JPanel cards){
        this.cards = cards;

        int i;
        JPanel card3_2 = new JPanel();

        this.cmbxDay = new JComboBox<>();
        for(i = 1; i<=31; i++)
            cmbxDay.addItem(i);

        this.cmbxAvail = new JComboBox<>();
        this.cmbxAvail = new JComboBox<>(this.roomAvailable);
        this.cmbxReserved = new JComboBox<>(this.roomAvailable);

        this.txtTotalRoomAvail = new JTextField();
        this.txtTotalRoomAvail.setText("" + this.roomAvailable.length);
        this.txtTotalRoomAvail.setEditable(false);

        this.txtTotalRoomReserved = new JTextField();
        this.txtTotalRoomAvail.setText("" + this.roomReserved.length);
        this.txtTotalRoomAvail.setEditable(false);
		
		this.btnVieHtlBck = new JButton("Back to View Hotel");

        card3_2.add(new JLabel("Day Availability Info"));

        card3_2.add(new JLabel("Select Day:"));
        card3_2.add(this.cmbxDay);

        card3_2.add(new JLabel("Rooms available:"));
        card3_2.add(this.cmbxAvail);

        card3_2.add(new JLabel("Total rooms available:"));
        card3_2.add(this.txtTotalRoomAvail);

        card3_2.add(new JLabel("Rooms reserved:"));
        card3_2.add(this.cmbxReserved);

        card3_2.add(new JLabel("Total reserved:"));
        card3_2.add(this.txtTotalRoomReserved);
		
		card3_2.add(this.btnVieHtlBck);

        this.cards.add(card3_2, "View Day Availability");
    }

    //card 3_2 setters
	
	public int getCmbDayItem(){
		return (int) this.cmbxDay.getSelectedItem();
	}
	
    public void setRoomAvailable(String[] roomsAvailable){
        for(String roomAvail: roomsAvailable)
            this.cmbxAvail.addItem(roomAvail);
    }

    public void setRoomReserved(String[] roomsReserved){
        for(String roomRes: roomsReserved)
            this.cmbxReserved.addItem(roomRes);
    }
	
	public void resetVieDay(){
		this.cmbxDay.setSelectedIndex(0);
	}

	public void setBtnVieHtlBckListener(ActionListener al){
		this.btnVieHtlBck.addActionListener(al);
	}
}
