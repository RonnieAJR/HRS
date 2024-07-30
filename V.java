import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The HRSView class provides the view for the HRS
 */
public class V{
	private JFrame frame;
	private JPanel cards;
	private V_Card1 card1;
	private V_Card2 card2;
	private V_Card3 card3;
	private V_Card4 card4;
	private V_Card5 card5;
	
	/**
	 * Constructs the view, initializing all cards inside the view
	 */
	public V(){
		frame = new JFrame("Hotel Reservation System");
		frame.setLayout(new BorderLayout());
		frame.setSize(320, 420);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.cards = new JPanel(new CardLayout());
		this.card1 = new V_Card1(this.cards);
		this.card2 = new V_Card2(this.cards);
		this.card3 = new V_Card3(this.cards);
		this.card4 = new V_Card4(this.cards);
		this.card5 = new V_Card5(this.cards);
		this.frame.add(cards, BorderLayout.CENTER);
		
		frame.setVisible(true);
	}
	
	/**
	 * Returns the main frame.
	 * @return the main frame
	 */
	public JFrame getFrame(){
		return this.frame;
	}
	
	/**
	 * Returns the panel with the card layout.
	 * @return the panel with the card layout
	 */
	public JPanel getCards(){
		return this.cards;
	}
	
	/**
	 * Sets the card visible.
	 * @param cardName the name of the card to be made visible
	 */
	public void setCard(String cardName){
		CardLayout cl = (CardLayout) this.cards.getLayout();
		cl.show(this.cards, cardName);
	}

	/**
	 * Returns card1.
	 * @return card1
	 */
	public V_Card1 getCard1(){
		return this.card1;
	}

	/**
	 * Returns card2.
	 * @return card2
	 */
	public V_Card2 getCard2(){
		return this.card2;
	}

	/**
	 * Returns card3.
	 * @return card3
	 */
	public V_Card3 getCard3(){
		return this.card3;
	}

	/**
	 * Returns card4.
	 * @return card4
	 */
	public V_Card4 getCard4(){
		return this.card4;
	}

	/**
	 * Returns card5.
	 * @return card5
	 */
	public V_Card5 getCard5(){
		return this.card5;
	}
}