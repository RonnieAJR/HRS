import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * V_Card4_2 class is the card of the view which contains the add room menu.
 */
public class V_Card4_3 {
    private JPanel cards;

    private JComboBox<String> cmbxRmtRmov;
    private JButton btnRmovRm, btnMngHtlBck;
    private JLabel txtFdbck;

	/**
	 * Initializes all the components of the card.
	 */
    public V_Card4_3(JPanel cards){
        this.cards = cards;
        JPanel card4_3 = new JPanel(new BorderLayout());

        //header
		JLabel header = new JLabel("Remove Room", JLabel.CENTER);
		header.setFont(new Font("Default", Font.PLAIN, 20));
		card4_3.add(header, BorderLayout.NORTH);

        this.cmbxRmtRmov = new JComboBox<>();

        this.btnRmovRm = new JButton("Remove");
        this.btnMngHtlBck = new JButton("Back to Manage Hotel");

        this.txtFdbck = new JLabel();

        // Central panel for labels and text fields
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //Room to remove
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(new JLabel("Choose room to remove"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(this.cmbxRmtRmov, gbc);

        card4_3.add(centerPanel, BorderLayout.CENTER);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(this.btnRmovRm);
        buttonPanel.add(this.btnMngHtlBck);

        // Panel for feedback label and buttons
        JPanel feedbackPanel = new JPanel(new BorderLayout());
        this.txtFdbck.setHorizontalAlignment(JLabel.CENTER);
        feedbackPanel.add(buttonPanel, BorderLayout.SOUTH);
        feedbackPanel.add(this.txtFdbck, BorderLayout.CENTER);

        card4_3.add(feedbackPanel, BorderLayout.SOUTH);

        this.cards.add(card4_3, "Remove Room");
    }

	/**
	 * Returns the selected room.
	 * @return the selected room
	 */
    public String getCmbxRmtRmov(){return this.cmbxRmtRmov.getSelectedItem().toString();}

	/**
	 * Resets the input made to the default values.
	 */
    public void resetRmovRoom(){
        this.cmbxRmtRmov.setSelectedIndex(0);
    }

	/**
	 * Removes a room name from the selection.
	 * @param room the roomName
	 */
    public void removeItem(String room){
        this.cmbxRmtRmov.removeItem(room);
    }

	/**
	 * Sets the room name selection.
	 * @param room[] the array of room names
	 */
    public void setCmbxRmtRmov(String[] rooms){
        this.cmbxRmtRmov.removeAllItems();
        for(String room : rooms)
            this.cmbxRmtRmov.addItem(room);
    }

	/**
	 * Sets the feedback text.
	 * @param feedback the feedback string
	 */
    public void setTxtFdbck(String feedback){this.txtFdbck.setText(feedback);}

	/**
	 * Sets the action listener for the remove room button.
	 * @param al the action listener
	 */
    public void setBtnRmovRmListener(ActionListener al){
        if(this.btnRmovRm.getActionListeners().length == 0)
            this.btnRmovRm.addActionListener(al);
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
