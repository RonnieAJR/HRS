import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * V_Card4_4 class is the card of the view which contains the modify day price menu.
 */
public class V_Card4_4 {
    private JPanel cards;

    private JComboBox<Integer> cmbxDay;
    private JTextField txtPrcMod;
    private JButton btnMdfyPrc, btnMngHtlBck;
    private JLabel txtFdbck;

	/**
	 * Initializes all the components of the card.
	 */
    public V_Card4_4(JPanel cards){
        this.cards = cards;
        JPanel card4_4 = new JPanel(new BorderLayout());

        //header
		JLabel header = new JLabel("Modify Day Price", JLabel.CENTER);
		header.setFont(new Font("Default", Font.PLAIN, 20));
		card4_4.add(header, BorderLayout.NORTH);

        int i;

        this.cmbxDay = new JComboBox<>();
        for(i = 1; i <= 31; i++)
            this.cmbxDay.addItem(i);

        this.txtPrcMod = new JTextField(10);

        this.btnMdfyPrc = new JButton("Modify");
        this.btnMngHtlBck = new JButton("Back to Manage Hotel");

        this.txtFdbck = new JLabel();

        // Central panel for labels and text fields
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Dimension textFieldSize = new Dimension(300, 20);

        //Day Selector
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Choose Day to Modify"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(this.cmbxDay, gbc);


        //Modify Price
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(new JLabel("Input percentage to modify price"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.txtPrcMod = new JTextField(20);
        this.txtPrcMod.setPreferredSize(textFieldSize);
        centerPanel.add(this.txtPrcMod, gbc);

        card4_4.add(centerPanel, BorderLayout.CENTER);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(this.btnMdfyPrc);
        buttonPanel.add(this.btnMngHtlBck);

        // Panel for feedback label and buttons
        JPanel feedbackPanel = new JPanel(new BorderLayout());
        this.txtFdbck.setHorizontalAlignment(JLabel.CENTER);
        feedbackPanel.add(buttonPanel, BorderLayout.SOUTH);
        feedbackPanel.add(this.txtFdbck, BorderLayout.CENTER);

        card4_4.add(feedbackPanel, BorderLayout.SOUTH);
        this.cards.add(card4_4, "Modify Day Price");
    }

	/**
	 * Returns the price modification.
	 * @return the price modification
	 */
    public double getTxtPrcMod(){return Double.parseDouble(txtPrcMod.getText());}

	/**
	 * Returns the selected day.
	 * @return the selected day
	 */
    public int getCmbxDayItem(){return (int) this.cmbxDay.getSelectedItem();}

	/**
	 * Resets the input made to the default value.
	 */
    public void resetMdfyPrc(){
		this.cmbxDay.setSelectedItem(0);
        this.txtPrcMod.setText("");
    }

	/**
	 * Sets the feedback text.
	 * @param feedback the feedback string
	 */
    public void setTxtFdbck(String feedback){this.txtFdbck.setText(feedback);}

	/**
	 * Sets the action listener for the modify price button.
	 * @param al the action listener
	 */
    public void setBtnMdfyPrcListener(ActionListener al){
        if(this.btnMdfyPrc.getActionListeners().length == 0)
            this.btnMdfyPrc.addActionListener(al);
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
