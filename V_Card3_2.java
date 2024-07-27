import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        JPanel card3_2 = new JPanel(new BorderLayout());

        JLabel header = new JLabel("Day Availability Info", JLabel.CENTER);
		header.setFont(new Font("Default", Font.PLAIN, 20));
		card3_2.add(header, BorderLayout.NORTH);

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

        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Day Selector
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Select Day:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(this.cmbxDay, gbc);

        //Room Selector
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Rooms Available:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(this.cmbxAvail, gbc);

        //Total rooms available
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Total rooms available:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.txtTotalRoomAvail.setPreferredSize(new Dimension(300, 20));
        centerPanel.add(this.txtTotalRoomAvail, gbc);

        //Room Selector
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Rooms Reserved:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(this.cmbxReserved, gbc);

        //Total rooms Reserved
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Total rooms Reserved:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.txtTotalRoomAvail.setPreferredSize(new Dimension(300, 20));
        centerPanel.add(this.txtTotalRoomReserved, gbc);
        
        card3_2.add(centerPanel, BorderLayout.CENTER);
		
		//Panel for Button
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));

        this.btnVieHtlBck.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonsPanel.add(Box.createVerticalStrut(5));
        buttonsPanel.add(this.btnVieHtlBck);
		card3_2.add(buttonsPanel, BorderLayout.PAGE_END);
		
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
