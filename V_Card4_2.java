import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * V_Card4_2 class is the card of the view which contains the manage hotel menu.
 */
public class V_Card4_2 {
    private JPanel cards;

    private JTextField txtAddRm;
    private JComboBox<String> cmbxRmTyp;
    private JButton btnAddRm, btnMngHtlBck;
    private JLabel txtFdbck;

	/**
	 * Initializes all the components of the card.
	 */
    public V_Card4_2(JPanel cards){
        this.cards = cards;
        JPanel card4_2 = new JPanel(new BorderLayout());

        //header
		JLabel header = new JLabel("Add Room", JLabel.CENTER);
		header.setFont(new Font("Default", Font.PLAIN, 20));
		card4_2.add(header, BorderLayout.NORTH);

        this.txtAddRm = new JTextField(20);

        this.cmbxRmTyp = new JComboBox<>();
        this.cmbxRmTyp.addItem("Standard");
        this.cmbxRmTyp.addItem("Deluxe");
        this.cmbxRmTyp.addItem("Executive");

        this.txtFdbck = new JLabel();

        this.btnAddRm = new JButton("Add");
        this.btnMngHtlBck = new JButton("Back to Manage Hotel");

        // Central panel for labels and text fields
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Dimension textFieldSize = new Dimension(300, 20);

        //Room Number
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(new JLabel("Enter number of Rooms"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.txtAddRm = new JTextField(20);
        this.txtAddRm.setPreferredSize(textFieldSize);
        centerPanel.add(this.txtAddRm, gbc);


        //Room Type Selector
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Choose Room Type"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(this.cmbxRmTyp, gbc);

        card4_2.add(centerPanel, BorderLayout.CENTER);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(this.btnAddRm);
        buttonPanel.add(this.btnMngHtlBck);

        // Panel for feedback label and buttons
        JPanel feedbackPanel = new JPanel(new BorderLayout());
        this.txtFdbck.setHorizontalAlignment(JLabel.CENTER);
        feedbackPanel.add(buttonPanel, BorderLayout.SOUTH);
        feedbackPanel.add(this.txtFdbck, BorderLayout.CENTER);

        card4_2.add(feedbackPanel, BorderLayout.SOUTH);

        this.cards.add(card4_2, "Add Room");
    }

	/**
	 * Returns the amount of room to add.
	 * @return the amoount of room to add
	 */
    public int getTxtAddRm(){return Integer.parseInt(txtAddRm.getText());}

	/**
	 * Returns the selected room type.
	 * @return the selected room type
	 */
    public String getCmbxRmTypItem(){return this.cmbxRmTyp.getSelectedItem().toString();}

	/**
	 * Resets the input made to the default values.
	 */
    public void resetAddRm(){
		this.cmbxRmTyp.setSelectedItem(0);
        this.txtAddRm.setText("");
    }

	/**
	 * Sets the feedback text.
	 * @param feedback the feedback string
	 */
    public void setTxtFdbck(String feedback){this.txtFdbck.setText(feedback);}

	/**
	 * Sets the action listener for the add room button.
	 * @param al the action listener
	 */
    public void setBtnAddRmListener(ActionListener al){
        if(this.btnAddRm.getActionListeners().length == 0)
            this.btnAddRm.addActionListener(al);
    }

	/**
	 * Sets the action listener for the manage hotel button.
	 * @param al the action listener
	 */
    public void setBtnMngHtlBckListener(ActionListener al){
        if(this.btnMngHtlBck.getActionListeners().length == 0)
            this.btnMngHtlBck.addActionListener(al);
    }
}
