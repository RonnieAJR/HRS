
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class C{
	// private M m;
	private V v;
	
	public C(V v)
	{
		// this.m = m;
		this.v = v;
		V_Card1 card = v.getCard1();
		
		ActionListener goMainMenu = goCard("Main Menu");
		ActionListener goViewHotel = goCard("View Hotel");
		ActionListener goManageHotel = goCard("Manage Hotel");
		
		card.setBtnCreHtlListener(goCard("Create Hotel"));
		card.setBtnVieHtlListener(goViewHotel);
		card.setBtnManHtlListener(goManageHotel);
		// sim booking btn MISSING
		
		// v.setBtnMaiMenBck4Listener(goMainMenu);
		
		this.initCard2Listener();
		this.initCard3Listener();
		this.initCard4Listener();
	}
	
	public void initCard2Listener(){
		V_Card2 card = this.v.getCard2();
		card.setBtnCreHtlTryListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String name = card.getTxtHtlName();
				int capacity = card.getCmbxCapItem();
				double price = card.getTxtPrice();
				
				if(price < 100)
				{
					System.out.println("Invalid price input\n");
					card.setFdbckCreHtl("Invalid price input");
				}
				// else if(hrs.createHotel(name, capacity, price)) // m.createHotel(name, capacity, price)
					// System.out.println("Hotel created\n");
				else
				{
					// System.out.println("Hotel already exists\n");
					System.out.println("Hotel Created");
					card.setFdbckCreHtl("Hotel Created");
				}
				
				// setSelectedIndex(0);
				card.resetCreHtl();
			}
		});
		
		card.setBtnMaiMenBckListener(goCard("Main Menu")); // clear fdbck upon exit
	}
	
	public void initCard3Listener(){
		V_Card3 card = this.v.getCard3();
		card.setBtnMaiMenBckListener(goCard("Main Menu"));
		
	}
		
	public void initCard4Listener(){
		V_Card4 card = this.v.getCard4();
		card.setBtnMaiMenBckListener(goCard("Main Menu"));
		
	}
	
	public ActionListener goCard(String cardName){
		ActionListener al = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				v.setCard(cardName);
			}
		};
		return al;
	}
	
	public static void main(String args[]){
		new C(new V());
	}
}