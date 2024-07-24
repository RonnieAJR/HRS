
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class C{
	// private M m;
	private V v;
	
	public C(V v)
	{
		// this.m = m;
		this.v = v;
		
		ActionListener goMainMenu = goCard("Main Menu");
		ActionListener goViewHotel = goCard("View Hotel");
		ActionListener goManageHotel = goCard("Manage Hotel");
		
		v.setBtnCreHtlListener(goCard("Create Hotel"));
		
		v.setBtnVieHtlListener(goViewHotel);
		
		v.setBtnManHtlListener(goManageHotel);
		
		// sim booking btn MISSING
		
		v.setBtnMaiMenBck1Listener(goMainMenu);
		v.setBtnMaiMenBck2Listener(goMainMenu);
		v.setBtnMaiMenBck3Listener(goMainMenu);
		// v.setBtnMaiMenBck4Listener(goMainMenu);
		
		
		v.setBtnCreHtlTryListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String name = v.getTxtHtlName();
				int capacity = v.getCmbxCapItem();
				double price = v.getTxtPrice();
				
				if(price < 100)
				{
					System.out.println("Invalid price input\n");
					v.setFdbckCreHtl("Invalid price input");
				}
				// else if(hrs.createHotel(name, capacity, price)) // m.createHotel(name, capacity, price)
					// System.out.println("Hotel created\n");
				else
				{
					// System.out.println("Hotel already exists\n");
					System.out.println("Hotel Created");
					v.setFdbckCreHtl("Hotel Created");
				}
				
				// setSelectedIndex(0);
				v.resetCreHtl();
			}
		});
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