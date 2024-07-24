import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

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
	private JButton btnRnmHtl, btnAddRoom, btnRmvRoom, btnModPrice, btnUpdPrice, btnRmvRsrv, btnRmvHtl
	private JTextField txtPriceMod;
	
	// card 4.1 rename hotel
	// card 4.2 add room
	// card 4.3 remove room
	// card 4.4 modify day price
	// card 4.5 update price
	// card 4.6 remove reservation
	// card 4.7 remove hotel
	
	private JComboBox cmbxHtls, cmbxDays, cmbxRooms, cmbxRsrvs;
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
		new JPanel(new CardLayout());
	}
}