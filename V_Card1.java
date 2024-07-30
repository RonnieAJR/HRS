import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * V_Card1 class is the card of the view which contains the main menu.
 */
public class V_Card1{
	private JPanel cards;
	private JButton btnCreHtl, btnVieHtl, btnManHtl, btnSimBook;
    private JLabel txtFdbck;
	
	/**
	 * Initializes all the components of the card.
	 */
	public V_Card1(JPanel cards) {
        this.cards = cards;

        JPanel card1 = new JPanel(new BorderLayout());

        // Main Menu Header
        JLabel header = new JLabel("Main Menu", JLabel.CENTER);
        header.setFont(new Font("Default", Font.PLAIN, 20));
        card1.add(header, BorderLayout.NORTH);

        //fdback label
        this.txtFdbck = new JLabel();

        // Buttons Panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));

        this.btnCreHtl = new JButton("Create Hotel");
        this.btnVieHtl = new JButton("View Hotel");
        this.btnManHtl = new JButton("Manage Hotel");
        this.btnSimBook = new JButton("Simulate Booking");

        Dimension buttonSize = new Dimension(150, 30); // Adjust the size as needed

        this.btnCreHtl.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.btnVieHtl.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.btnManHtl.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.btnSimBook.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.btnCreHtl.setMaximumSize(buttonSize);
        this.btnVieHtl.setMaximumSize(buttonSize);
        this.btnManHtl.setMaximumSize(buttonSize);
        this.btnSimBook.setMaximumSize(buttonSize);

        // Add buttons to the panel
        buttonsPanel.add(Box.createVerticalStrut(10)); // Add space before the first button
        buttonsPanel.add(this.btnCreHtl);
        buttonsPanel.add(Box.createVerticalStrut(10)); // Add space between buttons
        buttonsPanel.add(this.btnVieHtl);
        buttonsPanel.add(Box.createVerticalStrut(10)); // Add space between buttons
        buttonsPanel.add(this.btnManHtl);
        buttonsPanel.add(Box.createVerticalStrut(10)); // Add space between buttons
        buttonsPanel.add(this.btnSimBook);
        buttonsPanel.add(Box.createVerticalStrut(10)); // Add space after the last button

        //feedback panel
        JPanel feedbackPanel = new JPanel(new BorderLayout());
        this.txtFdbck.setHorizontalAlignment(JLabel.CENTER);
        feedbackPanel.add(this.txtFdbck, BorderLayout.CENTER);
        buttonsPanel.add(feedbackPanel, BorderLayout.CENTER);

        card1.add(buttonsPanel, BorderLayout.CENTER);

        this.cards.add(card1, "Main Menu");
    }
	
	/**
	 * Returns the create hotel button.
	 * @return the create hotel button
	 */
	public JButton getBtnCretl(){
		return this.btnCreHtl;
	}
	
	public JButton getBtnVieHtl(){
		return this.btnVieHtl;
	}
	
	public JButton getBtnManHtl(){
		return this.btnManHtl;
	}
	
	public JButton getBtnSimBook(){
		return this.btnSimBook;
	}

	/**
	 * Sets the feedback text.
	 * @param feedback the feedback string
	 */
    public void setTxtFdbck(String feedback){
        this.txtFdbck.setText(feedback);
    }
	
	/**
	 * Sets the action listener for the create hotel button.
	 * @param al the action listener
	 */
	public void setBtnCreHtlListener(ActionListener al){
        if(this.btnCreHtl.getActionListeners().length == 0)
		    this.btnCreHtl.addActionListener(al);
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
	 * Sets the action listener for the manage hotel button.
	 * @param al the action listener
	 */
	public void setBtnManHtlListener(ActionListener al){
		if(this.btnManHtl.getActionListeners().length == 0)
            this.btnManHtl.addActionListener(al);
	}
	
	/**
	 * Sets the action listener for the simulate booking button.
	 * @param al the action listener
	 */
	public void setBtnSimBookListener(ActionListener al){
        if(this.btnSimBook.getActionListeners().length == 0)
		    this.btnSimBook.addActionListener(al);
	}
}