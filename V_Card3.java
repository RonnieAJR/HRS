import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * V_Card3 class is the card of the view which contains the view hotel menu.
 */
public class V_Card3{
	private JPanel cards;
	private JComboBox<String> cmbxHtls;
	private JLabel txtFdbck;
	private V_Card3_1 card3_1;
	private V_Card3_2 card3_2;
	private V_Card3_3 card3_3;
	private V_Card3_4 card3_4;
	
	private JButton btnVieHtl, btnVieDay, btnVieRoom, btnVieRsrv, btnMaiMenBck;

	/**
	 * Initializes all the components of the card.
	 */
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
		this.cmbxHtls.setMaximumSize(new Dimension(100, 25));
		topPanel.add(this.cmbxHtls);
		mainPanel.add(Box.createVerticalStrut(15));
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
		buttonsPanel.add(Box.createVerticalStrut(10));

		JPanel feedbackPanel = new JPanel(new BorderLayout());
		this.txtFdbck = new JLabel();
		this.txtFdbck.setHorizontalAlignment(JLabel.CENTER);
		feedbackPanel.add(this.txtFdbck, BorderLayout.CENTER);
		buttonsPanel.add(feedbackPanel, BorderLayout.CENTER);
	
		mainPanel.add(buttonsPanel);
	
		card3.add(mainPanel, BorderLayout.CENTER); // Add mainPanel to the center of card3
	
		this.card3_1 = new V_Card3_1(cards);
		this.card3_2 = new V_Card3_2(cards);
		this.card3_3 = new V_Card3_3(cards);
		this.card3_4 = new V_Card3_4(cards);
	
		this.cards.add(card3, "View Hotel");
	}
	
	/**
	 * Returns card3_1.
	 * @return card3_1
	 */
	public V_Card3_1 getCard3_1(){
		return this.card3_1;
	}
	
	/**
	 * Returns card3_2.
	 * @return card3_2
	 */
	public V_Card3_2 getCard3_2(){
		return this.card3_2;
	}
	
	/**
	 * Returns card3_3.
	 * @return card3_3
	 */
	public V_Card3_3 getCard3_3(){
		return this.card3_3;
	}
	
	/**
	 * Returns card3_4.
	 * @return card3_4
	 */
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

	/**
	 * Resets rhe input made to default value.
	 */
	public void resetViewHtl(){
		this.cmbxHtls.setSelectedIndex(0);
	}
	
	/**
	 * Returns the selected hotel name.
	 * @return the selected hotel name
	 */
	public String getCmbxHtlsItem(){
		return (String) this.cmbxHtls.getSelectedItem();
	}
	
	/**
	 * Adds a hotel to the selection
	 * @param hotelName the name of the hotel
	 */
	public void addCmbxHtlsItem(String hotelName){
		this.cmbxHtls.addItem(hotelName);
	}
	
	/**
	 * Removes a hotel to the selection.
	 * @param hotelName the name of the hotel
	 */
	public void removeCmbxHtlsItem(String hotelName){
		this.cmbxHtls.removeItem(hotelName);
	}

	/**
	 * Sets the feedback text.
	 * @param feedback the feedback string
	 */
	public void setTxtFdbck(String feedback){
		this.txtFdbck.setText(feedback);
	}
	
	/**
	 * Sets the action listener for the view hotel button.
	 * @param al the action listener
	 */
	public void setBtnVieHtlListener(ActionListener al){
		if(this.btnVieHtl.getActionListeners().length == 0)
			this.btnVieHtl.addActionListener(al);
	}
	
	/**
	 * Sets the action listener for view day availability button.
	 * @param al the action listener
	 */
	public void setBtnVieDayListener(ActionListener al){
		if(this.btnVieDay.getActionListeners().length == 0)
			this.btnVieDay.addActionListener(al);
	}
	
	/**
	 * Sets the action listener for the view room button.
	 * @param al the action listener
	 */
	public void setBtnVieRoomListener(ActionListener al){
		if(this.btnVieRoom.getActionListeners().length == 0)
			this.btnVieRoom.addActionListener(al);
	}
	
	/**
	 * Sets the action listener for the view reservation button.
	 * @param al the action listener
	 */
	public void setBtnVieRsrvListener(ActionListener al){
		if(this.btnVieRsrv.getActionListeners().length == 0)
			this.btnVieRsrv.addActionListener(al);
	}
	
	/**
	 * Sets the action listener for the main menu button.
	 * @param al the action listener
	 */
	public void setBtnMaiMenBckListener(ActionListener al){
		if(this.btnMaiMenBck.getActionListeners().length == 0)
			this.btnMaiMenBck.addActionListener(al);
	}

}