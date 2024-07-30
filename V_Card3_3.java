import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class V_Card3_3 {
    private JPanel cards;

    private JComboBox<String> cmbxSlctRoom;
    private JTextField roomName, floor, pricePerNight;
    private JComboBox<Integer> cmbxDayAvail, cmbxDayReserved;
	private JButton btnVieHtlBck;

    public V_Card3_3(JPanel cards){
        this.cards = cards;

        JPanel card3_3 = new JPanel(new BorderLayout());

        JLabel header = new JLabel("Room Info", JLabel.CENTER);
		header.setFont(new Font("Default", Font.PLAIN, 20));
		card3_3.add(header, BorderLayout.NORTH);

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


        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1.0;


        //Room Selector
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Select Room:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(this.cmbxSlctRoom, gbc);

        //Room Name
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Room Name:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.roomName.setPreferredSize(new Dimension(300, 20));
        centerPanel.add(this.roomName, gbc);

        //Room Floor
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Room Floor:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.roomName.setPreferredSize(new Dimension(300, 20));
        centerPanel.add(this.floor, gbc);

        //Room Price Per Night
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Room Price Per Night:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.roomName.setPreferredSize(new Dimension(300, 20));
        centerPanel.add(this.pricePerNight, gbc);

        //Day Avail Selector
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Days Available:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(this.cmbxDayAvail, gbc);

        //Day Reserv Selector
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Days Reserved:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(this.cmbxDayReserved, gbc);

        card3_3.add(centerPanel, BorderLayout.CENTER);

		//Panel for Button
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));

        this.btnVieHtlBck.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonsPanel.add(Box.createVerticalStrut(5));
        buttonsPanel.add(this.btnVieHtlBck);
		card3_3.add(buttonsPanel, BorderLayout.PAGE_END);

        this.cards.add(card3_3, "View Room");
    }

    //card 3_3 setters
	
	public String getCmbxRoomItem(){
		return this.cmbxSlctRoom.getSelectedItem().toString();
	}
		
    public void setCmbxSlctRoom(String[] roomNames){
		this.cmbxSlctRoom.removeAllItems();
		// int i=0;
        for(String roomName: roomNames){
			this.cmbxSlctRoom.addItem(roomName);
			// i++;
		}
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
	
	public void setCmbxRoomListener(ItemListener il){
		// buggy
		if(this.cmbxSlctRoom.getItemListeners().length != 0)
			for(ItemListener i : this.cmbxSlctRoom.getItemListeners())
				this.cmbxSlctRoom.removeItemListener(i);
		this.cmbxSlctRoom.addItemListener(il);
	}

	public void setBtnVieHtlBckListener(ActionListener al){
		if(this.btnVieHtlBck.getActionListeners().length == 0)
			this.btnVieHtlBck.addActionListener(al);
	}
}
