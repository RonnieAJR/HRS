import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class V_Card3{
	private JPanel cards;
	private JComboBox<String> cmbxHtls;
	private V_Card3_1 card3_1;
	private V_Card3_2 card3_2;
	private V_Card3_3 card3_3;
	private V_Card3_4 card3_4;
	
	// card 3 view hotel
	private JButton btnVieHtl, btnVieDay, btnVieRoom, btnVieRsrv, btnMaiMenBck;

	public V_Card3(JPanel cards) {
		this.cards = cards;
	
		JPanel card3 = new JPanel(new BorderLayout());
	
		// Main Menu Header
		JLabel header = new JLabel("View Hotel", JLabel.CENTER);
		header.setFont(new Font("Default", Font.PLAIN, 20));
		card3.add(header, BorderLayout.NORTH);
	
		// Panel for hotel selector and buttons
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
	
		// Top Panel for Hotel Selector with BoxLayout
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS)); // Horizontal BoxLayout
	
		// Hotel Selector
		JLabel hotelLabel = new JLabel("Select Hotel:   ");
		topPanel.add(hotelLabel);
		
		this.cmbxHtls = new JComboBox<>();
		this.cmbxHtls.setMaximumSize(new Dimension(100, 20));
		topPanel.add(this.cmbxHtls);
		mainPanel.add(Box.createVerticalStrut(10));
		mainPanel.add(topPanel);
	
		// Buttons Panel
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
	
		this.btnVieHtl = new JButton("View Hotel Info");
		this.btnVieDay = new JButton("View Day Availability");
		this.btnVieRoom = new JButton("View Room");
		this.btnVieRsrv = new JButton("View Reservation");
		this.btnMaiMenBck = new JButton("Back to Main Menu");
		
		Dimension buttonSize = new Dimension(150, 30);
		this.btnVieHtl.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.btnVieDay.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.btnVieRoom.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.btnVieRsrv.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.btnMaiMenBck.setAlignmentX(Component.CENTER_ALIGNMENT);
	
		this.btnVieHtl.setMaximumSize(buttonSize);
		this.btnVieDay.setMaximumSize(buttonSize);
		this.btnVieRoom.setMaximumSize(buttonSize);
		this.btnVieRsrv.setMaximumSize(buttonSize);
		this.btnMaiMenBck.setMaximumSize(buttonSize);
	
		buttonsPanel.add(Box.createVerticalStrut(2));
		buttonsPanel.add(this.btnVieHtl);
		buttonsPanel.add(Box.createVerticalStrut(2)); // Reduced vertical strut
		buttonsPanel.add(this.btnVieDay);
		buttonsPanel.add(Box.createVerticalStrut(2)); // Reduced vertical strut
		buttonsPanel.add(this.btnVieRoom);
		buttonsPanel.add(Box.createVerticalStrut(2)); // Reduced vertical strut
		buttonsPanel.add(this.btnVieRsrv);
		buttonsPanel.add(Box.createVerticalStrut(2)); // Reduced vertical strut
		buttonsPanel.add(this.btnMaiMenBck);
	
		mainPanel.add(buttonsPanel);
	
		card3.add(mainPanel, BorderLayout.CENTER); // Add mainPanel to the center of card3
	
		this.card3_1 = new V_Card3_1(cards);
		this.card3_2 = new V_Card3_2(cards);
		this.card3_3 = new V_Card3_3(cards);
		this.card3_4 = new V_Card3_4(cards);
	
		this.cards.add(card3, "View Hotel");
	}
	
	public V_Card3_1 getCard3_1(){
		return this.card3_1;
	}
	public V_Card3_2 getCard3_2(){
		return this.card3_2;
	}
	public V_Card3_3 getCard3_3(){
		return this.card3_3;
	}
	public V_Card3_4 getCard3_4(){
		return this.card3_4;
	}
	
	public JButton getBtnVieHtl(){
		return this.btnVieHtl;
	}
	
	public JButton getBtnVieDay(){
		return this.btnVieDay;
	}
	
	public JButton getBtnVieRoom(){
		return this.btnVieRoom;
	}
	
	public JButton getBtnVieRsrv(){
		return this.btnVieRsrv;
	}
	
	public String getCmbxHtlsItem(){
		return (String) this.cmbxHtls.getSelectedItem();
	}
	
	public void addCmbxHtlsItem(String hotelName){
		this.cmbxHtls.addItem(hotelName);
	}
	
	public void removeCmbxHtlsItem(String hotelName){
		this.cmbxHtls.removeItem(hotelName);
	}
		
	public void setBtnVieHtlListener(ActionListener al){
		if(this.btnVieHtl.getActionListeners().length == 0)
			this.btnVieHtl.addActionListener(al);
	}
	
	public void setBtnVieDayListener(ActionListener al){
		if(this.btnVieDay.getActionListeners().length == 0)
			this.btnVieDay.addActionListener(al);
	}
	
	public void setBtnVieRoomListener(ActionListener al){
		if(this.btnVieRoom.getActionListeners().length == 0)
			this.btnVieRoom.addActionListener(al);
	}
	
	public void setBtnVieRsrvListener(ActionListener al){
		if(this.btnVieRsrv.getActionListeners().length == 0)
			this.btnVieRsrv.addActionListener(al);
	}
	
	public void setBtnMaiMenBckListener(ActionListener al){
		if(this.btnMaiMenBck.getActionListeners().length == 0)
			this.btnMaiMenBck.addActionListener(al);
	}
}