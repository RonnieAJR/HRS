import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class V_Card1{
	private JPanel cards;
	
	//  card 1 main menu
	private JButton btnCreHtl, btnVieHtl, btnManHtl, btnSimBook;
	
	public V_Card1(JPanel cards){
		this.cards = cards;
		
		JPanel card1 = new JPanel();
		
		// Main Menu Card
		this.btnCreHtl = new JButton("Create Hotel");
		this.btnVieHtl = new JButton("View Hotel");
		this.btnManHtl = new JButton("Manage Hotel");
		this.btnSimBook = new JButton("Simulate Booking");
		
		card1.add(this.btnCreHtl);
		card1.add(this.btnVieHtl);
		card1.add(this.btnManHtl);
		card1.add(this.btnSimBook);
		
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