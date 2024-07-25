import javax.swing.*;
import java.awt.event.ActionListener;

public class V_Card3_3 {
    private JPanel cards;

    private JComboBox<String> cmbxSlctRoom;
    private JTextField roomName, floor, pricePerNight;
    private JComboBox<Integer> cmbxDayAvail, cmbxDayReserved;
	private JButton btnVieHtlBck;

    public V_Card3_3(JPanel cards){
        this.cards = cards;

        JPanel card3_3 = new JPanel();

        this.cmbxSlctRoom = new JComboBox<>();

        this.roomName = new JTextField();
        this.roomName.setEditable(false);

        this.floor = new JTextField();
        this.floor.setEditable(false);

        this.pricePerNight = new JTextField();
        this.pricePerNight.setEditable(false);

        this.cmbxDayAvail = new JComboBox<>();
        this.cmbxDayReserved = new JComboBox<>();
		
		this.btnVieHtlBck = new JButton("Back to View Hotel");

        card3_3.add(new JLabel("Room Info"));

        card3_3.add(new JLabel("Select Room"));
        card3_3.add(this.cmbxSlctRoom);

        card3_3.add(new JLabel("Room Name:"));
        card3_3.add(this.roomName);

        card3_3.add(new JLabel("Room Floor:"));
        card3_3.add(this.floor);

        card3_3.add(new JLabel("Room Price Per Night:"));
        card3_3.add(this.pricePerNight);

        card3_3.add(new JLabel("Days Available:"));
        card3_3.add(this.cmbxDayAvail);

        card3_3.add(new JLabel("Days Reserved"));
        card3_3.add(this.cmbxDayReserved);
		
		card3_3.add(this.btnVieHtlBck);

        this.cards.add(card3_3, "View Room");
    }

    //card 3_3 setters
	public String getCmbxRoomItem(){
		return this.cmbxSlctRoom.getSelectedItem().toString();
	}
		
    public void setCmbxSlctRoom(String[] roomNames){
		this.cmbxSlctRoom.removeAllItems();
		int i=0;
        for(String roomName: roomNames){
			this.cmbxSlctRoom.addItem(roomName);
			i++;
		}
		System.out.println("initialized" + i);
    }
	
	public void resetVieRoom(){
		this.cmbxSlctRoom.setSelectedIndex(0);
	}

    public void setRoomName(String roomName){
        this.roomName.setText(roomName);
    }

    public void setRoomFloor(char floor){
        this.floor.setText("" + floor);
    }

    public void setPricePerNight(double price){
        this.pricePerNight.setText("" + price);
    }

    public void setCmbxDayAvail(Integer[] dayAvail){
		this.cmbxDayAvail.removeAllItems();
        for(Integer day: dayAvail)
            this.cmbxDayAvail.addItem(day);
    }

    public void setCmbxDayReserved(Integer[] dayReserved){
		this.cmbxDayReserved.removeAllItems();
        for(Integer day: dayReserved)
            this.cmbxDayReserved.addItem(day);
    }
	
	public void setCmbxRoomListener(ActionListener al){
		this.cmbxSlctRoom.addActionListener(al);
	}

	public void setBtnVieHtlBckListener(ActionListener al){
		this.btnVieHtlBck.addActionListener(al);
	}
}
