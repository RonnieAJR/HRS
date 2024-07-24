
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