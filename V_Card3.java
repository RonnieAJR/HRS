import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

public class V_Card3{
	private JPanel cards;
	private JComboBox<String> cmbxHtls;
	private ArrayList<String> htlNames;
	private V_Card3_1 card3_1;
	private V_Card3_2 card3_2;
	private V_Card3_3 card3_3;
	private V_Card3_4 card3_4;
	
	// card 3 view hotel
	private JButton btnVieHtl, btnVieDay, btnVieRoom, btnVieRsrv, btnMaiMenBck;

	public V_Card3(JPanel cards){
		this.cards = cards;
		
		JPanel card3 = new JPanel();
		
		this.cmbxHtls = new JComboBox<>();
		
		this.btnVieHtl = new JButton("View Hotel Info");
		this.btnVieDay = new JButton("View Day Availability");
		this.btnVieRoom = new JButton("View Room");
		this.btnVieRsrv = new JButton("View Reservation");
		this.btnMaiMenBck = new JButton("Back to Main Menu");
		
		// cmbx
		card3.add(this.btnVieHtl);
		card3.add(this.btnVieDay);
		card3.add(this.btnVieRoom);
		card3.add(this.btnVieRsrv);
		card3.add(this.btnMaiMenBck);
		
		this.card3_1 = new V_Card3_1(cards);
		this.card3_2 = new V_Card3_2(cards);
		this.card3_3 = new V_Card3_3(cards);
		this.card3_4 = new V_Card3_4(cards);
		
		this.cards.add(card3, "View Hotel");
	}
	
	public V_Card3_1 getCard3_1(){
		return this.card3_1;
	}
	public V_Card3_2 getCard3_2(){
		return this.card3_2;
	}
	public V_Card3_3 getCard3_3(){
		return this.card3_3;
	}
	public V_Card3_4 getCard3_4(){
		return this.card3_4;
	}
	
	public JButton getBtnVieRoom(){
		return this.btnVieRoom;
	}
	
	public JButton getBtnVieRsrv(){
		return this.btnVieRsrv;
	}
	
	public String getCmbxHtlsItem(){
		return (String) this.cmbxHtls.getSelectedItem();
	}
	
	public void addCmbxHtlsItem(String hotelName){
		this.cmbxHtls.addItem(hotelName);
	}
	
	public void removeCmbxHtlsItem(String hotelName){
		this.cmbxHtls.removeItem(hotelName);
	}
		
	public void setBtnVieHtlListener(ActionListener al){
		if(this.btnVieHtl.getActionListeners().length == 0)
			this.btnVieHtl.addActionListener(al);
	}
	
	public void setBtnVieDayListener(ActionListener al){
		if(this.btnVieDay.getActionListeners().length == 0)
			this.btnVieDay.addActionListener(al);
	}
	
	public void setBtnVieRoomListener(ActionListener al){
		if(this.btnVieRoom.getActionListeners().length == 0)
			this.btnVieRoom.addActionListener(al);
	}
	
	public void setBtnVieRsrvListener(ActionListener al){
		if(this.btnVieRsrv.getActionListeners().length == 0)
			this.btnVieRsrv.addActionListener(al);
	}
	
	public void setBtnMaiMenBckListener(ActionListener al){
		if(this.btnMaiMenBck.getActionListeners().length == 0)
			this.btnMaiMenBck.addActionListener(al);
	}
}