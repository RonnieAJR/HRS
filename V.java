import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

public class V{
	private JFrame frame; // borderlayout
	private JPanel cards; // cardlayout
	
	//  card 1 main menu
	private JButton btnCreHtl, btnVieHtl, btnManHtl, btnSimBook, btnMaiMenBck;
	
	// card 2 create hotel
	private JTextField txtHtlName, txtPrice;
	private JComboBox cmbxCap;
	
	// card 3 view hotel
	private JButton btnVieHtl2, btnVieDay, btnVieRoom, btnVieRsrv, btnVieHtl2Bck;
	
	// card 3.1 view hotel
	// card 3.2 view day availability
	// card 3.3 view room info
	// card 3.4 view reservation info
	
	// card 4 manage hotel
	private JButton btnRnmHtl, btnAddRoom, btnRmvRoom, btnModPrice, btnUpdPrice, btnRmvRsrv, btnRmvHtl;
	private JTextField txtPriceMod;
	
	// card 4.1 rename hotel
	// card 4.2 add room
	// card 4.3 remove room
	// card 4.4 modify day price
	// card 4.5 update price
	// card 4.6 remove reservation
	// card 4.7 remove hotel
	
	private JComboBox<String> cmbxHtls, cmbxDays, cmbxRooms, cmbxRsrvs;
	private JLabel lblFeedback;
	
	
	public V(){
		frame = new JFrame("Hotel Reservation System");
		frame.setLayout(new BorderLayout());
		frame.setSize(420, 450);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.init();
		frame.setVisible(true);
	}
	
	public void init(){
		this.cards = new JPanel(new CardLayout());
		
		// initialize gui here
		
		JPanel card4 = new JPanel(new GridLayout(8, 1, 0, 5));
		
		String[] hotels = {"Hotel1", "Hotel2", "Hotel3"};
		this.cmbxHtls = new JComboBox<String>(hotels); // this is local
		this.cmbxHtls.setEditable(false);
		
		this.btnRnmHtl = new JButton("Rename Hotel");
		this.btnAddRoom = new JButton("Add Room");
		this.btnRmvRoom = new JButton("Remove Room");
		this.btnModPrice = new JButton("Modify Day Price");
		this.btnUpdPrice = new JButton("Update Price");
		this.btnRmvRsrv = new JButton("Remove Reservation");
		this.btnRmvHtl = new JButton("Remove Hotel");
		
		card4.add(cmbxHtls);
		card4.add(btnRnmHtl);
		card4.add(btnAddRoom);
		card4.add(btnRmvRoom);
		card4.add(btnModPrice);
		card4.add(btnUpdPrice);
		card4.add(btnRmvRsrv);
		card4.add(btnRmvHtl);
		
		this.cards.add(card4);
		this.frame.add(cards, BorderLayout.CENTER);
	}
	
	public static void main(String args[]){
		new V();
	}
}