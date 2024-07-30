import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * V_Card2 class is the card of the view which contains the create hotel menu.
 */
public class V_Card2{
	private JPanel cards;
	
	private JTextField txtHtlName, txtPrice;
	private JComboBox<Integer> cmbxCap;
	private JButton btnCreHtlTry, btnMaiMenBck;
	private JLabel fdbckCreHtl;
	
	/**
	 * Initializes all the components of the card.
	 */
	public V_Card2(JPanel cards) {
        this.cards = cards;

        JPanel card2 = new JPanel(new BorderLayout());

        // Create Hotel Header
        JLabel header = new JLabel("Create Hotel", JLabel.CENTER);
        header.setFont(new Font("Default", Font.PLAIN, 20));
        card2.add(header, BorderLayout.NORTH);

        // Central panel for labels and text fields
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Dimension textFieldSize = new Dimension(300, 20); // Adjust the width as needed

        // Hotel Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(new JLabel("Enter Hotel Name:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.txtHtlName = new JTextField(20);
        this.txtHtlName.setPreferredSize(textFieldSize);
        centerPanel.add(this.txtHtlName, gbc);

        // Hotel Capacity
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Enter Hotel Capacity:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.cmbxCap = new JComboBox<>();
        for (int i = 1; i <= 50; i++) {
            this.cmbxCap.addItem(i);
        }
        centerPanel.add(this.cmbxCap, gbc);

        // Price per Night
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Enter Price per Night:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.txtPrice = new JTextField(20);
        this.txtPrice.setPreferredSize(textFieldSize);
        centerPanel.add(this.txtPrice, gbc);

        card2.add(centerPanel, BorderLayout.CENTER);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.btnCreHtlTry = new JButton("Create Hotel");
        this.btnMaiMenBck = new JButton("Back to Main Menu");
        buttonPanel.add(this.btnCreHtlTry);
        buttonPanel.add(this.btnMaiMenBck);

        // Panel for feedback label and buttons
        JPanel feedbackPanel = new JPanel(new BorderLayout());
        this.fdbckCreHtl = new JLabel("", JLabel.CENTER);
        feedbackPanel.add(buttonPanel, BorderLayout.SOUTH);
        feedbackPanel.add(this.fdbckCreHtl, BorderLayout.CENTER);

        card2.add(feedbackPanel, BorderLayout.SOUTH);

        this.cards.add(card2, "Create Hotel");
    }
	
	/**
	 * Returns the hotel name entered.
	 * @return the hotel name entered
	 */
	public String getTxtHtlName(){
		return this.txtHtlName.getText().toString();
	}
	
	/**
	 * Returns the capacity selected.
	 * @return the capacity selected
	 */
	public int getCmbxCapItem(){
		return (int) this.cmbxCap.getSelectedItem();
	}
	
	/**
	 * Returns the price entered.
	 * @return the price entered
	 */
	public double getTxtPrice(){
		return Double.parseDouble(this.txtPrice.getText());
	}
	
	public JButton getBtnCreHtlTry(){
		return this.btnCreHtlTry;
	}
	
	/**
	 * Sets the feedback text.
	 * @param fdbck the feedback string
	 */
	public void setFdbckCreHtl(String fdbck){
		this.fdbckCreHtl.setText(fdbck);
	}
	
	/**
	 * Resets the input made to default value.
	 */
	public void resetCreHtl(){
		this.txtHtlName.setText("");
		this.txtPrice.setText("1299.00");
		this.cmbxCap.setSelectedIndex(0);
	}
	
	public void clearFdbck(){
		this.fdbckCreHtl.setText("");
	}
	
	/**
	 * Sets the action listener for the create hotel button.
	 * @param al the action listener
	 */
	public void setBtnCreHtlTryListener(ActionListener al){
        if(this.btnCreHtlTry.getActionListeners().length == 0)
            this.btnCreHtlTry.addActionListener(al);
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