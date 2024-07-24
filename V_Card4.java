import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class V_Card4{
	private JPanel cards;
	
	private JButton btnRnmHtl, btnAddRoom, btnRmvRoom, btnModPrice, btnUpdPrice, btnRmvRsrv, btnRmvHtl, btnManHtlBck, btnMaiMenBck;
	private JTextField txtPriceMod;
	private JComboBox<String> cmbxHtls;
	
	// card 4.1 rename hotel
	// card 4.2 add room
	// card 4.3 remove room
	// card 4.4 modify day price
	// card 4.5 update price
	// card 4.6 remove reservation
	// card 4.7 remove hotel
	
	private JTextField txtHtlName;
	
	
	public V_Card4(JPanel cards){
		this.cards = cards;
		
		JPanel card4 = new JPanel();
		
		String[] hotels = {"Hotel1", "Hotel2", "Hotel3"}; // placeholder
		this.cmbxHtls = new JComboBox<String>(hotels);
		this.cmbxHtls.setEditable(false);
		
		this.btnRnmHtl = new JButton("Rename Hotel");
		this.btnAddRoom = new JButton("Add Room");
		this.btnRmvRoom = new JButton("Remove Room");
		this.btnModPrice = new JButton("Modify Day Price");
		this.btnUpdPrice = new JButton("Update Price");
		this.btnRmvRsrv = new JButton("Remove Reservation");
		this.btnRmvHtl = new JButton("Remove Hotel");
		this.btnMaiMenBck = new JButton("Back to Main Menu");
		
		card4.add(this.cmbxHtls);
		card4.add(this.btnRnmHtl);
		card4.add(this.btnAddRoom);
		card4.add(this.btnRmvRoom);
		card4.add(this.btnModPrice);
		card4.add(this.btnUpdPrice);
		card4.add(this.btnRmvRsrv);
		card4.add(this.btnRmvHtl);
		card4.add(this.btnMaiMenBck);
		
		// init cards 4.1, 4.2, 4.3, 4.4, 4.5, 4.6, 4.7 here or in new methods and call here
		
		this.cards.add(card4, "Manage Hotel");
	}
	
	// card 4
	public void resetManHtl(){
		this.cmbxHtls.setSelectedIndex(0);
	}
	
	public void setBtnRnmHtlListener(ActionListener al){
		this.btnRnmHtl.addActionListener(al);
	}
	
	public void setBtnAddRoomListener(ActionListener al){
		this.btnAddRoom.addActionListener(al);
	}
	
	public void setBtnRmvRoomListener(ActionListener al){
		this.btnRmvRoom.addActionListener(al);
	}
	
	public void setBtnModPriceListener(ActionListener al){
		this.btnModPrice.addActionListener(al);
	}
	
	public void setBtnUpdPriceListener(ActionListener al){
		this.btnUpdPrice.addActionListener(al);
	}
	
	public void setBtnRmvRsrvListener(ActionListener al){
		this.btnRmvRsrv.addActionListener(al);
	}
	
	public void setBtnRmvHtl(ActionListener al){
		this.btnRmvHtl.addActionListener(al);
	}
	
	public void setBtnMaiMenBckListener(ActionListener al){
		this.btnMaiMenBck.addActionListener(al);
	}
}