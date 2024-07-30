import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * V_Card4_1 class is the card of the view which contains the add room menu.
 */
public class V_Card4_1 {
    private JPanel cards;

    private JTextField txtnewHtlNm;
    private JButton btnRnm, btnMngHtlBck;
    private JLabel fdbckRnmHtl;

	/**
	 * Initializes all the components of the card.
	 */
    public V_Card4_1(JPanel cards){
        this.cards = cards;
        JPanel card4_1 = new JPanel(new BorderLayout());

        //header
		JLabel header = new JLabel("Rename Hotel", JLabel.CENTER);
		header.setFont(new Font("Default", Font.PLAIN, 20));
		card4_1.add(header, BorderLayout.NORTH);

        this.txtnewHtlNm = new JTextField(20);

        this.fdbckRnmHtl = new JLabel();

        this.btnRnm = new JButton("Rename");
        this.btnMngHtlBck = new JButton("Back to Manage Hotel");

        // Central panel for labels and text fields
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Dimension textFieldSize = new Dimension(300, 20);

        // Hotel Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(new JLabel("Enter New Hotel Name:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.txtnewHtlNm = new JTextField(20);
        this.txtnewHtlNm.setPreferredSize(textFieldSize);
        centerPanel.add(this.txtnewHtlNm, gbc);

        card4_1.add(centerPanel, BorderLayout.CENTER);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(this.btnRnm);
        buttonPanel.add(this.btnMngHtlBck);

        // Panel for feedback label and buttons
        JPanel feedbackPanel = new JPanel(new BorderLayout());
        this.fdbckRnmHtl.setHorizontalAlignment(JLabel.CENTER);
        feedbackPanel.add(buttonPanel, BorderLayout.SOUTH);
        feedbackPanel.add(this.fdbckRnmHtl, BorderLayout.CENTER);

        card4_1.add(feedbackPanel, BorderLayout.SOUTH);

        this.cards.add(card4_1, "Rename Hotel");
    }

	/**
	 * Returns the new hotel name.
	 * @return the new hotel name
	 */
    public String getTxtNewHtlNm(){return this.txtnewHtlNm.getText().toString();}

	/**
	 * Resets the input made to the default value.
	 */
    public void resetRnmHtl(){
        this.txtnewHtlNm.setText("");
    }

	/**
	 * Sets the feedback text.
	 * @param fdbck the feedback string
	 */
    public void setFdbckRnmHtl(String fdbck){this.fdbckRnmHtl.setText(fdbck);}

	/**
	 * Sets the action listener for the rename hotel button.
	 * @param al the action listener
	 */
    public void setBtnRnmListener(ActionListener al){
        if(this.btnRnm.getActionListeners().length == 0)
            this.btnRnm.addActionListener(al);
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
