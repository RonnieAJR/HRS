import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class V_Card3{
	private JPanel cards;
	
	// card 3 view hotel
	private JButton btnVieHtl, btnVieDay, btnVieRoom, btnVieRsrv, btnMaiMenBck;

	public V_Card3(JPanel cards){
		this.cards = cards;
		
		JPanel card3 = new JPanel();
		
		this.btnVieHtl = new JButton("View Hotel Info");
		this.btnVieDay = new JButton("View Day Availability");
		this.btnVieRoom = new JButton("View Room");
		this.btnVieRsrv = new JButton("View Reservation");
		this.btnMaiMenBck = new JButton("Back to Main Menu");
		
		card3.add(this.btnVieHtl);
		card3.add(this.btnVieDay);
		card3.add(this.btnVieRoom);
		card3.add(this.btnVieRsrv);
		card3.add(this.btnMaiMenBck);
		
		// init cards 3.1, 3.2, 3.3, 3.4, here or in new methods and call here
		this.cards.add(card3, "View Hotel");
	}
	
	// card 3 listeners
	public void setBtnVieHtlListener(ActionListener al){
		this.btnVieHtl.addActionListener(al);
	}
	
	public void setBtnVieDayListener(ActionListener al){
		this.btnVieDay.addActionListener(al);
	}
	
	public void setBtnVieRoomListener(ActionListener al){
		this.btnVieRoom.addActionListener(al);
	}
	
	public void setBtnVieRsrvListener(ActionListener al){
		this.btnVieRsrv.addActionListener(al);
	}
	
	public void setBtnMaiMenBckListener(ActionListener al){
		this.btnMaiMenBck.addActionListener(al);
	}
}