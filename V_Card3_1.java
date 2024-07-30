import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * V_Card3_1 class is the card of the view which contains the view hotel info view.
 */
public class V_Card3_1 {
    private JPanel cards;
    private JTextField txtHtlName, txtNumRooms, txtEstimatedEarnings;
	private JButton btnVieHtlBck;

	/**
	 * Initializes all the components of the card.
	 */
    public V_Card3_1(JPanel cards){
        this.cards = cards;

        JPanel card3_1 = new JPanel(new BorderLayout());

        JLabel header = new JLabel("View Hotel", JLabel.CENTER);
		header.setFont(new Font("Default", Font.PLAIN, 20));
		card3_1.add(header, BorderLayout.NORTH);

        this.txtHtlName = new JTextField(20);
        this.txtHtlName.setEditable(false);

        this.txtNumRooms = new JTextField(20);
        this.txtNumRooms.setEditable(false);

        this.txtEstimatedEarnings = new JTextField(20);
        this.txtEstimatedEarnings.setEditable(false);
		
		this.btnVieHtlBck = new JButton("Back to View Hotel");

        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        Dimension textFieldSize = new Dimension(300, 20);

        //Hotel Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(new JLabel("Hotel Name:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.txtHtlName.setPreferredSize(textFieldSize);
        centerPanel.add(this.txtHtlName, gbc);


        // Hotel Capacity
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Number of Rooms: "), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.txtNumRooms.setPreferredSize(textFieldSize);
        centerPanel.add(this.txtNumRooms, gbc);


        //Hotel Estimated Earnings
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Estimated earnings: "), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.txtEstimatedEarnings.setPreferredSize(textFieldSize);
        centerPanel.add(this.txtEstimatedEarnings, gbc);
        
        card3_1.add(centerPanel, BorderLayout.CENTER);

        //Panel for Button
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));

        this.btnVieHtlBck.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonsPanel.add(Box.createVerticalStrut(5));
        buttonsPanel.add(this.btnVieHtlBck);
		card3_1.add(buttonsPanel, BorderLayout.PAGE_END);
		
        this.cards.add(card3_1, "View Hotel Info");
    }

    
	/**
	 * Resets the input made to the default value.
	 */
	public void resetVieHtl(){
		this.txtHtlName.setText("");
		this.txtNumRooms.setText("");
		this.txtEstimatedEarnings.setText("");
	}
	
	/**
	 * Sets the hotel name.
	 * @param hotelName the hotel name
	 */
    public void setTxtHtlName(String hotelName){
        this.txtHtlName.setText(hotelName);
    }

	/**
	 * Sets the amount of rooms.
	 * @param numRooms the amount of rooms
	 */
    public void setTxtNumRooms(int numRooms){
        this.txtNumRooms.setText("" + numRooms);
    }

	/**
	 * Sets the estimated earnings
	 * @param earnings the estimated earnings
	 */
    public void setTxtEstimatedEarnings(double earnings){
        this.txtEstimatedEarnings.setText("" + earnings);
    }
	
	/**
	 * Sets the action listener for the view hotel button.
	 * @param al the action listener
	 */
	public void setBtnVieHtlBckListener(ActionListener al){
        if(this.btnVieHtlBck.getActionListeners().length == 0)
		    this.btnVieHtlBck.addActionListener(al);
	}
}
