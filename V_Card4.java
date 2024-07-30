import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * V_Card4 class is the card of the view which contains the manage hotel menu.
 */
public class V_Card4{
	private JPanel cards;
	
	private JButton btnRnmHtl, btnAddRoom, btnRmvRoom, btnModPrice, btnUpdPrice, btnRmvRsrv, btnRmvHtl, btnMaiMenBck;
	private JComboBox<String> cmbxHtls;
	private JLabel txtFdbck;
	private V_Card4_1 card4_1;
	private V_Card4_2 card4_2;
	private V_Card4_3 card4_3;
	private V_Card4_4 card4_4;
	private V_Card4_5 card4_5;
	private V_Card4_6 card4_6;
	private V_Card4_7 card4_7;	
	
	/**
	 * Initializes all the components of the card.
	 */
	public V_Card4(JPanel cards){
		this.cards = cards;
    
		JPanel card4 = new JPanel(new BorderLayout());

		// Header
		JLabel header = new JLabel("Manage Hotel", JLabel.CENTER);
		header.setFont(new Font("Default", Font.PLAIN, 20));
		card4.add(header, BorderLayout.NORTH);

		this.cmbxHtls = new JComboBox<>();
		this.cmbxHtls.setEditable(false);
		
		this.btnRnmHtl = new JButton("Rename Hotel");
		this.btnAddRoom = new JButton("Add Room");
		this.btnRmvRoom = new JButton("Remove Room");
		this.btnModPrice = new JButton("Modify Day Price");
		this.btnUpdPrice = new JButton("Update Price");
		this.btnRmvRsrv = new JButton("Remove Reservation");
		this.btnRmvHtl = new JButton("Remove Hotel");
		this.btnMaiMenBck = new JButton("Back to Main Menu");

		this.txtFdbck = new JLabel();

		// Central panel for hotel selector and buttons
		JPanel centerPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.weightx = 1.0;

		// Hotel Selector
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.NONE;
		centerPanel.add(new JLabel("Select Hotel To Manage"), gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		centerPanel.add(this.cmbxHtls, gbc);

		// Buttons Panel
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
		Dimension buttonSize = new Dimension(150, 30);

		JButton[] buttons = {
			this.btnRnmHtl, this.btnAddRoom, this.btnRmvRoom, 
			this.btnModPrice, this.btnUpdPrice, this.btnRmvRsrv, 
			this.btnRmvHtl, this.btnMaiMenBck
		};

		for (JButton button : buttons) {
			button.setAlignmentX(Component.CENTER_ALIGNMENT);
			button.setMaximumSize(buttonSize);
			buttonsPanel.add(Box.createVerticalStrut(5));
			buttonsPanel.add(button);
		}

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		buttonsPanel.add(Box.createVerticalStrut(10));

		JPanel feedbackPanel = new JPanel(new BorderLayout());
		this.txtFdbck.setHorizontalAlignment(JLabel.CENTER);
		feedbackPanel.add(this.txtFdbck, BorderLayout.CENTER);
		buttonsPanel.add(feedbackPanel, BorderLayout.CENTER);
		centerPanel.add(buttonsPanel, gbc);

		card4.add(centerPanel, BorderLayout.CENTER);
		
		this.card4_1 = new V_Card4_1(cards);
		this.card4_2 = new V_Card4_2(cards);
		this.card4_3 = new V_Card4_3(cards);
		this.card4_4 = new V_Card4_4(cards);
		this.card4_5 = new V_Card4_5(cards);
		this.card4_6 = new V_Card4_6(cards);
		this.card4_7 = new V_Card4_7(cards);

		
		this.cards.add(card4, "Manage Hotel");
	}

	/**
	 * Returns card4_1.
	 * @return card4_1
	 */
	public V_Card4_1 getCard4_1(){
		return this.card4_1;
	}

	/**
	 * Returns card4_2.
	 * @return card4_2
	 */
	public V_Card4_2 getCard4_2(){
		return this.card4_2;
	}

	/**
	 * Returns card4_3.
	 * @return card4_3
	 */
	public V_Card4_3 getCard4_3(){
		return this.card4_3;
	}

	/**
	 * Returns card4_4.
	 * @return card4_4
	 */
	public V_Card4_4 getCard4_4(){
		return this.card4_4;
	}

	/**
	 * Returns card4_5.
	 * @return card4_5
	 */
	public V_Card4_5 getCard4_5(){
		return this.card4_5;
	}

	/**
	 * Returns card4_6.
	 * @return card4_6
	 */
	public V_Card4_6 getCard4_6(){
		return this.card4_6;
	}

	public V_Card4_7 getCard4_7(){
		return this.card4_7;
	}
	
	/**
	 * Returns selected hotel.
	 * @return selected hotel
	 */
	public String getCmbxHtlsItem(){
		return this.cmbxHtls.getSelectedItem().toString();
	}

	/**
	 * Resets the input made to the default value.
	 */
	public void resetManHtl(){
		this.cmbxHtls.setSelectedIndex(0);
	}
	
	/**
	 * Adds hotel name to the selection.
	 * @param hotel the hotel name 
	 */
	public void addCmbxHtlsItem(String hotel){
		this.cmbxHtls.addItem(hotel);
	}

	/**
	 * Removes hotel name to the selection.
	 * @param hotel the hotel name 
	 */
	public void removeCmbxHtlsItem(String hotelName){
		this.cmbxHtls.removeItem(hotelName);
	}

	/**
	 * Sets feedback.
	 * @param feedback the feedback string
	 */
	public void setTxtFdbck(String feedback){
		this.txtFdbck.setText(feedback);
	}

	/**
	 * Sets the action listener for the rename hotel button.
	 * @param al the action listener
	 */
	public void setBtnRnmHtlListener(ActionListener al){
		if(this.btnRnmHtl.getActionListeners().length == 0)
			this.btnRnmHtl.addActionListener(al);
	}
	
	/**
	 * Sets the action listener for the add room button.
	 * @param al the action listener
	 */
	public void setBtnAddRoomListener(ActionListener al){
		if(this.btnAddRoom.getActionListeners().length == 0)
			this.btnAddRoom.addActionListener(al);
	}
	
	/**
	 * Sets the action listener for the remove room button.
	 * @param al the action listener
	 */
	public void setBtnRmvRoomListener(ActionListener al){
		if(this.btnRmvRoom.getActionListeners().length == 0)
			this.btnRmvRoom.addActionListener(al);
	}
	
	/**
	 * Sets the action listener for the modify day price button.
	 * @param al the action listener
	 */
	public void setBtnModPriceListener(ActionListener al){
		if(this.btnModPrice.getActionListeners().length == 0)
			this.btnModPrice.addActionListener(al);
	}
	
	/**
	 * Sets the action listener for the update price button.
	 * @param al the action listener
	 */
	public void setBtnUpdPriceListener(ActionListener al){
		if(this.btnUpdPrice.getActionListeners().length == 0)
			this.btnUpdPrice.addActionListener(al);
	}
	
	/**
	 * Sets the action listener for the remove reservation button.
	 * @param al the action listener
	 */
	public void setBtnRmvRsrvListener(ActionListener al){
		if(this.btnRmvRsrv.getActionListeners().length == 0)
			this.btnRmvRsrv.addActionListener(al);
	}
	
	/**
	 * Sets the action listener for the remove hotel button.
	 * @param al the action listener
	 */
	public void setBtnRmvHtlListener(ActionListener al){
		if(this.btnRmvHtl.getActionListeners().length == 0)
			this.btnRmvHtl.addActionListener(al);
	}
	
	/**
	 * Sets the action listener for the manage hotel button.
	 * @param al the action listener
	 */
	public void setBtnMaiMenBckListener(ActionListener al){
		if(this.btnMaiMenBck.getActionListeners().length == 0)
			this.btnMaiMenBck.addActionListener(al);
	}

}