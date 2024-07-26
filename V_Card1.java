import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class V_Card1{
	private JPanel cards;
	
	//  card 1 main menu
	private JButton btnCreHtl, btnVieHtl, btnManHtl, btnSimBook;
	
	public V_Card1(JPanel cards) {
        this.cards = cards;

        JPanel card1 = new JPanel(new BorderLayout());

        // Main Menu Header
        JLabel header = new JLabel("Main Menu", JLabel.CENTER);
        card1.add(header, BorderLayout.NORTH);

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

        card1.add(buttonsPanel, BorderLayout.CENTER);

        this.cards.add(card1, "Main Menu");
    }
	
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
	
	public void setBtnCreHtlListener(ActionListener al){
		this.btnCreHtl.addActionListener(al);
	}
	
	public void setBtnVieHtlListener(ActionListener al){
		this.btnVieHtl.addActionListener(al);
	}
	
	public void setBtnManHtlListener(ActionListener al){
		this.btnManHtl.addActionListener(al);
	}
	
	public void setBtnSimBookListener(ActionListener al){
		this.btnSimBook.addActionListener(al);
	}
}