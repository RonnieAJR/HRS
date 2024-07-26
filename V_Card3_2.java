import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

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
        // this.cmbxAvail = new JComboBox<>(this.roomAvailable);
        this.cmbxReserved = new JComboBox<>();

        this.txtTotalRoomAvail = new JTextField();
        this.txtTotalRoomAvail.setEditable(false);

        this.txtTotalRoomReserved = new JTextField();
        this.txtTotalRoomReserved.setEditable(false);
		
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
	
	public int getCmbxDayItem(){
		return (int) this.cmbxDay.getSelectedItem();
	}
	
    public void setRoomAvailable(String[] roomsAvailable){
		this.cmbxAvail.removeAllItems();
        for(String roomAvail: roomsAvailable)
            this.cmbxAvail.addItem(roomAvail);
    }

    public void setRoomReserved(String[] roomsReserved){
		this.cmbxReserved.removeAllItems();
        for(String roomRes: roomsReserved)
            this.cmbxReserved.addItem(roomRes);
    }
	
	public void setTxtTotalRoomAvail(int num){
		this.txtTotalRoomAvail.setText("" + num);
	}
	
	public void setTxtTotalRoomReserved(int num){
		this.txtTotalRoomReserved.setText("" + num);
	}
	
	public void resetVieDay(){
		this.cmbxDay.setSelectedIndex(0);
	}
	
	public void setCmbxDayListener(ItemListener il){
		if(this.cmbxDay.getItemListeners().length != 0)
			for(ItemListener i : this.cmbxDay.getItemListeners())
				this.cmbxDay.removeItemListener(i);	
		this.cmbxDay.addItemListener(il);
	}

	public void setBtnVieHtlBckListener(ActionListener al){
		if(this.btnVieHtlBck.getActionListeners().length == 0)
			this.btnVieHtlBck.addActionListener(al);
	}
}
