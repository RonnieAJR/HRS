import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

public class V{
	private JFrame frame; // borderlayout
	private JPanel cards; // cardlayout
	private V_Card1 card1;
	private V_Card2 card2;
	private V_Card3 card3;
	private V_Card4 card4;
	
	//  card 1 main menu
	private JButton btnCreHtl, btnVieHtl, btnManHtl, btnSimBook;


	// card 2 create hotel
	private JTextField txtHtlName, txtPrice;
	private JComboBox<Integer> cmbxCap;
	private JButton btnCreHtlTry, btnMaiMenBck1;
	private JLabel fdbckCreHtl;
	
	// card 3 view hotel
	private JButton btnVieHtl2, btnVieDay, btnVieRoom, btnVieRsrv, btnVieHtlBck, btnMaiMenBck2;
	
	// card 3.1 view hotel
	private JTextField txtHotelName, txtNumRooms, txtEstimatedEarnings;

	// card 3.2 view day availability
	private String[] roomAvailable, roomReserved;
	private JComboBox<Integer> cmbxDay;
	private JComboBox<String> cmbxAvail, cmbxReserved;
	private JTextField txtTotalRoomAvail, txtTotalRoomReserved;

	// card 3.3 view room info
	private JComboBox<String> cmbxSlctRoom;
	private JTextField roomName, floor, pricePerNight;
	private JComboBox<Integer> cmbxDayAvail, cmbxDayReserved;

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
		frame.setSize(320, 370);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initAll();
		
		frame.setVisible(true);
	}
	
	/* public void initCard1(){
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
	} */
	
	/* public void initCard2(){
		JPanel card2 = new JPanel();
		
		this.txtHtlName = new JTextField(20);
		this.txtPrice = new JTextField(20);
		this.btnCreHtlTry = new JButton("Create Hotel");
		this.fdbckCreHtl = new JLabel();
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
		card2.add(this.fdbckCreHtl);
		card2.add(this.btnMaiMenBck1);
		
		this.cards.add(card2, "Create Hotel");
	} */
	/* 
	public void initCard3(){
		JPanel card3 = new JPanel();
		
		this.btnVieHtl2 = new JButton("View Hotel Info");
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
		
		this.cards.add(card3, "View Hotel");
	} */
/* 
	public void initCard3_1(){

		JPanel card3_1 = new JPanel();
		this.txtHotelName = new JTextField();
		this.txtHotelName.setEditable(false);

		this.txtNumRooms = new JTextField();
		this.txtNumRooms.setEditable(false);

		this.txtEstimatedEarnings = new JTextField();
		this.txtEstimatedEarnings.setEditable(false);

		card3_1.add(new JLabel("Hotel Info"));

		card3_1.add(new JLabel("Hotel Name: "));
		card3_1.add(this.txtHotelName);

		card3_1.add(new JLabel("Number of Rooms: "));
		card3_1.add(this.txtNumRooms);

		card3_1.add(new JLabel("Estimated earnings: "));
		card3_1.add(this.txtEstimatedEarnings);

		this.cards.add(card3_1, "View Hotel Info");
	}

	public void initCard3_2(){
		int i;
		JPanel card3_2 = new JPanel();

		this.cmbxDay = new JComboBox<>();
		for(i = 1; i<=31; i++)
			cmbxDay.addItem(i);

		this.cmbxAvail = new JComboBox<>();
		this.cmbxAvail = new JComboBox<>(this.roomAvailable);
		this.cmbxReserved = new JComboBox<>(this.roomAvailable);

		this.txtTotalRoomAvail = new JTextField();
		this.txtTotalRoomAvail.setText("" + this.roomAvailable.length);
		this.txtTotalRoomAvail.setEditable(false);

		this.txtTotalRoomReserved = new JTextField();
		this.txtTotalRoomAvail.setText("" + this.roomReserved.length);
		this.txtTotalRoomAvail.setEditable(false);

		card3_2.add(new JLabel("Day Availability Info"));

		card3_2.add(new JLabel("Select Day:"));
		card3_2.add(this.cmbxDay);

		card3_2.add(new JLabel("Rooms available:"));
		card3_2.add(this.cmbxAvail);

		card3_2.add(new JLabel("Total rooms available:"));
		card3_2.add(this.txtTotalRoomAvail);

		card3_2.add(new JLabel("Rooms reserved:"));
		card3_2.add(this.cmbxReserved);

		card3_2.add(new JLabel("Total reserved:"));
		card3_2.add(this.txtTotalRoomReserved);

		this.cards.add(card3_2, "View Day Availability");

	}

	public void initCard3_3(){
		JPanel card3_3 = new JPanel();

		this.cmbxSlctRoom = new JComboBox<>();
		this.roomName = new JTextField();
		this.floor = new JTextField();
		this.pricePerNight = new JTextField();
		this.cmbxDayAvail = new JComboBox<>();
		this.cmbxDayReserved = new JComboBox<>();

		card3_3.add(new JLabel("Room Info"));

		card3_3.add(new JLabel("Select Room"));
		card3_3.add(this.cmbxSlctRoom);

		card3_3.add(new JLabel("Room Name:"));
		card3_3.add(this.roomName);

		card3_3.add(new JLabel("Room Floor:"));
		card3_3.add(this.floor);

		card3_3.add(new JLabel("Room Price Per Night:"));
		card3_3.add(this.pricePerNight);

		card3_3.add(new JLabel("Days Available:"));
		card3_3.add(this.cmbxDayAvail);

		card3_3.add(new JLabel("Days Reserved"));
		card3_3.add(this.cmbxDayReserved);

		this.cards.add(card3_3, "View Room");
	} */
		
	/* 
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
		
		card4.add(this.cmbxHtls); // this.
		card4.add(this.btnRnmHtl);
		card4.add(this.btnAddRoom);
		card4.add(this.btnRmvRoom);
		card4.add(this.btnModPrice);
		card4.add(this.btnUpdPrice);
		card4.add(this.btnRmvRsrv);
		card4.add(this.btnRmvHtl);
		card4.add(this.btnMaiMenBck3);
		
		// init cards 4.1, 4.2, 4.3, 4.4, 4.5, 4.6, 4.7 here or in new methods and call here
		
		this.cards.add(card4, "Manage Hotel");
	} */
	
	public void initAll(){
		this.cards = new JPanel(new CardLayout());
		this.card1 = new V_Card1(this.cards);
		this.card2 = new V_Card2(this.cards);
		this.card3 = new V_Card3(this.cards);
		this.card4 = new V_Card4(this.cards);
		//this.card5 = new V_Card5(this.cards);
		this.frame.add(cards, BorderLayout.CENTER);
	}
	
	public JFrame getFrame(){
		return this.frame;
	}
	
	public JPanel getCards(){
		return this.cards;
	}
	
	public void setCard(String cardName){
		CardLayout cl = (CardLayout) this.cards.getLayout();
		cl.show(this.cards, cardName);
	}
	
	public V_Card1 getCard1(){
		return this.card1;
	}
	
	public V_Card2 getCard2(){
		return this.card2;
	}
	
	public V_Card3 getCard3(){
		return this.card3;
	}
	
	public V_Card4 getCard4(){
		return this.card4;
	}
	
	// public V_Card5 getCard5(){
		// return this.card5;
	// }
	
	
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
	
	// card 2 listeners and getters and setters
	public String getTxtHtlName(){
		return this.txtHtlName.getText().toString();
	}
	
	public int getCmbxCapItem(){
		return (int) this.cmbxCap.getSelectedItem();
	}
	
	public double getTxtPrice(){
		return Double.parseDouble(this.txtPrice.getText());
	}
	
	public void setFdbckCreHtl(String fdbck){
		this.fdbckCreHtl.setText(fdbck);
	}
	
	public void resetCreHtl(){
		this.txtHtlName.setText("");
		this.cmbxCap.setSelectedIndex(0);
		this.txtPrice.setText("");
		this.fdbckCreHtl.setText("");
	}
	
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

	//card 3_1 setters
	public void setTxtHotelName(String hotelName){
		this.txtHotelName.setText(hotelName);
	}

	public void setTxtNumRooms(int numRooms){
		this.txtNumRooms.setText("" + numRooms);
	}

	public void setTxtEstimatedEarnings(double earnings){
		this.txtEstimatedEarnings.setText("" + earnings);
	}

	//card 3_2 setters
	public void setRoomAvailable(String[] roomsAvailable){
		for(String roomAvail: roomsAvailable)
			this.cmbxAvail.addItem(roomAvail);
	}

	public void setRoomReserved(String[] roomsReserved){
		for(String roomRes: roomsReserved)
			this.cmbxReserved.addItem(roomRes);
	}

	//card 3_3 setters
	public void setCmbxSlctRoom(String[] roomNames){
		for(String roomName: roomNames)
			this.cmbxSlctRoom.addItem(roomName);
	}

	public void setRoomName(String roomName){
		this.roomName.setText(roomName);
	}

	public void setRoomFloor(char floor){
		this.floor.setText("" + floor);
	}

	public void setPricePerNight(double price){
		this.pricePerNight.setText("" + price);
	}

	public void setCmbxDayAvail(Integer[] dayAvail){
		for(Integer day: dayAvail)
			this.cmbxDayAvail.addItem(day);
	}

	public void setCmbxDayReserved(Integer[] dayReserved){
		for(Integer day: dayReserved)
			this.cmbxDayReserved.addItem(day);
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