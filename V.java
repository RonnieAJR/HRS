import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

public class V{
	private JFrame frame; // borderlayout
	private JPanel cards; // cardlayout
	
	//  card 1 main menu
	private JButton btnCreHtl, btnVieHtl, btnManHtl, btnSimBook;


	// card 2 create hotel
	private JTextField txtHtlName, txtPrice;
	private JComboBox<Integer> cmbxCap;
	private JButton btnCreHtlTry, btnMaiMenBck1;
	
	// card 3 view hotel
	private JButton btnVieHtl2, btnVieDay, btnVieRoom, btnVieRsrv, btnVieHtlBck, btnMaiMenBck2;
	
	// card 3.1 view hotel
	// card 3.2 view day availability
	// card 3.3 view room info
	// card 3.4 view reservation info
	
	// card 4 manage hotel
	private JButton btnRnmHtl, btnAddRoom, btnRmvRoom, btnModPrice, btnUpdPrice, btnRmvRsrv, btnRmvHtl, btnManHtlBck, btnMaiMenBck3;
	private JTextField txtPriceMod;
	
	// card 4.1 rename hotel
	// card 4.2 add room
	// card 4.3 remove room
	// card 4.4 modify day price
	// card 4.5 update price
	// card 4.6 remove reservation
	// card 4.7 remove hotel
	
	// card 5 simulate booking
	private JTextField txtGstName;
	// hotel name, guest name, check in, check out, discount code, create booking
	
	private JComboBox<String> cmbxHtls, cmbxDays, cmbxRooms, cmbxRsrvs;
	private JLabel lblFeedback;
	
	
	public V(){
		frame = new JFrame("Hotel Reservation System");
		frame.setLayout(new BorderLayout());
		frame.setSize(420, 450);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initAll();
		frame.setVisible(true);
	}
	
	public void initCard1(){
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
	
	public void initCard2(){
		JPanel card2 = new JPanel();
		
		this.txtHtlName = new JTextField(20);
		this.txtPrice = new JTextField(20);
		this.btnCreHtlTry = new JButton("Create Hotel");
		this.btnMaiMenBck1 = new JButton("Back to Main Menu");
		
		this.cmbxCap = new JComboBox<>();
		for(int i = 1; i <= 50; i++)
		{
			this.cmbxCap.addItem(i);
		}	
		
		card2.add(new JLabel("Enter Hotel Name"));
		card2.add(this.txtHtlName);
		
		card2.add(new JLabel("Enter Hotel Capacity"));
		card2.add(this.cmbxCap);
		
		card2.add(new JLabel("Enter Price per Night"));
		card2.add(this.txtPrice);
		
		card2.add(this.btnCreHtlTry);
		card2.add(this.lblFeedback);
		card2.add(this.btnMaiMenBck1);
		
		this.cards.add(card2, "Create Hotel");
	}
	
	public void initCard3(){
		JPanel card3 = new JPanel();
		
		this.btnVieHtl2 = new JButton("View Hotel");
		this.btnVieDay = new JButton("View Day Availability");
		this.btnVieRoom = new JButton("View Room");
		this.btnVieRsrv = new JButton("View Reservation");
		this.btnVieHtlBck = new JButton("Back to View Hotel");
		this.btnMaiMenBck2 = new JButton("Back to Main Menu");
		
		card3.add(this.btnVieHtl2);
		card3.add(this.btnVieDay);
		card3.add(this.btnVieRoom);
		card3.add(this.btnVieRsrv);
		card3.add(this.btnMaiMenBck2);
		
		// init cards 3.1, 3.2, 3.3, 3.4, here or in new methods and call here
		
		this.cards.add(card3, "View Hotel");
	}
		
	
	public void initCard4(){
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
		this.btnManHtlBck = new JButton("Back to Manage Hotel");
		this.btnMaiMenBck3 = new JButton("Back to Main Menu");
		
		card4.add(cmbxHtls); // this.
		card4.add(btnRnmHtl);
		card4.add(btnAddRoom);
		card4.add(btnRmvRoom);
		card4.add(btnModPrice);
		card4.add(btnUpdPrice);
		card4.add(btnRmvRsrv);
		card4.add(btnRmvHtl);
		card4.add(btnMaiMenBck3);
		
		// init cards 4.1, 4.2, 4.3, 4.4, 4.5, 4.6, 4.7 here or in new methods and call here
		
		this.cards.add(card4, "Manage Hotel");
	}
	
	public void initAll(){
		this.cards = new JPanel(new CardLayout());
		this.lblFeedback = new JLabel();
		initCard1();
		initCard2();
		initCard3();
		initCard4();
		this.frame.add(cards, BorderLayout.CENTER);
	}
	
	public void setCard(String string){
		CardLayout cl = (CardLayout) this.cards.getLayout();
		cl.show(this.cards, string);
	}
	
	// card 1 listeners
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
	
	// card 2 listeners
	public void setBtnCreHtlTryListener(ActionListener al){
		this.btnCreHtlTry.addActionListener(al);
	}
	
	public void setBtnMaiMenBck1Listener(ActionListener al){
		this.btnMaiMenBck1.addActionListener(al);
	}
	// card 3 listeners
	public void setBtnVieHtl2Listener(ActionListener al){
		this.btnVieHtl2.addActionListener(al);
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
	
	public void setBtnVieHtl2BckListener(ActionListener al){
		this.btnVieHtlBck.addActionListener(al);
	}
	
	public void setBtnMaiMenBck2Listener(ActionListener al){
		this.btnMaiMenBck2.addActionListener(al);
	}
	// card 4
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
	
	public void setBtnManHtlBckListener(ActionListener al){
		this.btnManHtlBck.addActionListener(al);
	}
	
	public void setBtnMaiMenBck3Listener(ActionListener al){
		this.btnMaiMenBck3.addActionListener(al);
	}
	
	public static void main(String args[]){
		new V();
	}
}