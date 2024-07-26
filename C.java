
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class C{
	private HRS m;
	private V v;
	
	public C(V v, HRS m)
	{
		this.m = m;
		this.v = v;
		V_Card1 card = v.getCard1();
		
		ActionListener goMainMenu = goCard("Main Menu");
		ActionListener goManageHotel = goCard("Manage Hotel");
		
		card.setBtnCreHtlListener(goCard("Create Hotel"));
		card.setBtnVieHtlListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == card.getBtnVieHtl()){
					if(m.getHotels().isEmpty())
						System.out.println("Hotels not found"); // set fdbck on gui
					else{
						initCard3();
						v.setCard("View Hotel");
					}
				}
			}
		});
		
		card.setBtnManHtlListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(m.getHotels().isEmpty())
					System.out.println("Hotels not found");
				else{
					initCard4();
					v.setCard("Manage Hotel");
				}
			}
		});
		
		// sim booking btn MISSING
		
		// v.setBtnMaiMenBck4Listener(goMainMenu);
		
		this.initCard2();
	}
	
	public void initCard2(){
		V_Card2 card = this.v.getCard2();
		card.setBtnCreHtlTryListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == card.getBtnCreHtlTry()){
					String name = card.getTxtHtlName();
					int capacity = card.getCmbxCapItem();
					double price = card.getTxtPrice();
					
					if(price < 100){
						System.out.println("Invalid price input\n");
						card.setFdbckCreHtl("Invalid price input");
					}
					else if(m.createHotel(name, capacity, price)){
						System.out.println("Hotel created\n");
						card.setFdbckCreHtl("Hotel created");
						v.getCard3().addCmbxHtlsItem(name);
					}
					else{
						System.out.println("Hotel already exists\n");
						card.setFdbckCreHtl("Hotel already exists");
					}
					
					card.resetCreHtl();
				}
			}
		});
		
		card.setBtnMaiMenBckListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				card.resetCreHtl();
				card.setFdbckCreHtl("");
				v.setCard("Main Menu");
			}
		});
	}
	
	public void initCard3(){
		V_Card3 card = this.v.getCard3();
		
		card.setBtnVieHtlListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				initCard3_1();
				v.setCard("View Hotel Info");
			}
		});
		
		card.setBtnVieDayListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				initCard3_2();
				v.setCard("View Day Availability");
			}
		});
		
		card.setBtnVieRoomListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == card.getBtnVieRoom()){
					initCard3_3();
					v.setCard("View Room");
				}
			}
		});
		
		card.setBtnVieRsrvListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// if(e.getSource() == card.getBtnVieRsrv()){
					Hotel hotel = m.findHotel(card.getCmbxHtlsItem());
					if(hotel.getReservations().isEmpty())
						System.out.println("Reservations not found");
					else{
						initCard3_4();
						v.setCard("View Reservation");
					}
				// }
			}
		});
		
		card.setBtnMaiMenBckListener(goCard("Main Menu"));
		// reset hotel? on back to main menu only, then add e.getSource == button
	}
	
	public void initCard3_1(){
		V_Card3 card3 = this.v.getCard3();
		
		Hotel hotel = m.findHotel(card3.getCmbxHtlsItem());
		
		// card3_1
		V_Card3_1 card3_1 = card3.getCard3_1();
		
		// card3_1.resetVieHtl();
		card3_1.setTxtHtlName(hotel.getName());
		card3_1.setTxtNumRooms(hotel.getCapacity());
		card3_1.setTxtEstimatedEarnings(hotel.getEarnings());
		card3_1.setBtnVieHtlBckListener(goCard("View Hotel"));
	}
	
	public void initCard3_2(){
		V_Card3 card3 = this.v.getCard3();
		
		Hotel hotel = m.findHotel(card3.getCmbxHtlsItem());
		
		// card3_2
		V_Card3_2 card3_2 = card3.getCard3_2();
		card3_2.resetVieDay();
		
		card3_2.setCmbxDayListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){
				if(e.getStateChange() == ItemEvent.SELECTED){
					int day = card3_2.getCmbxDayItem();
					
					String[] available = hotel.getAvailableNames(day).toArray(new String[hotel.getAvailableNames(day).size()]);
					String[] reserved = hotel.getReservedNames(day).toArray(new String[hotel.getReservedNames(day).size()]);
					
					card3_2.setRoomAvailable(available);
					card3_2.setTxtTotalRoomAvail(available.length);
					card3_2.setRoomReserved(reserved);
					card3_2.setTxtTotalRoomReserved(reserved.length);
				}
			}
		});
				
		card3_2.setBtnVieHtlBckListener(goCard("View Hotel"));
	}
	
	public void initCard3_3(){
		V_Card3 card3 = this.v.getCard3();
		
		// card 3_3
		V_Card3_3 card3_3 = card3.getCard3_3();
		
		Hotel hotel = m.findHotel(card3.getCmbxHtlsItem());
		
		String[] roomNames = hotel.getRoomNames().toArray(new String[hotel.getRooms().size()]);
		card3_3.setCmbxSlctRoom(roomNames);
		// card3_3.resetVieRoom();
		
		card3_3.setCmbxRoomListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){
				if(e.getStateChange() == ItemEvent.SELECTED){
				
					Room room = hotel.findRoom(card3_3.getCmbxRoomItem());
					
					Integer[] availableDays = room.getAvailable().toArray(new Integer[room.getAvailable().size()]);
					Integer[] reservedDays = room.getReserved().toArray(new Integer[room.getReserved().size()]);
					
					card3_3.setRoomName(room.getName()); // add room type
					card3_3.setRoomFloor(room.getName().charAt(1));
					card3_3.setPricePerNight(room.getPrice());
					card3_3.setCmbxDayAvail(availableDays);
					card3_3.setCmbxDayReserved(reservedDays);
				}
			}
		});
		
		card3_3.setBtnVieHtlBckListener(goCard("View Hotel"));
	}
	
	public void initCard3_4(){
		V_Card3 card3 = this.v.getCard3();
		
		Hotel hotel = m.findHotel(card3.getCmbxHtlsItem());
		
		// card 3_4
		V_Card3_4 card3_4 = card3.getCard3_4();
		
		Integer[] reservationIds = hotel.getReservationIds().toArray(new Integer[hotel.getReservations().size()]);
		card3_4.setCmbxRsrvLst(reservationIds);
		// card3_4.resetVieRsrv();
		
		card3_4.setCmbxRsrvListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){
				if(e.getStateChange() == ItemEvent.SELECTED){
					Reservation reservation = hotel.findReservation(card3_4.getCmbxRsrvItem());
					
					card3_4.setTxtResId(reservation.getId());
					card3_4.setTxtGstNam(reservation.getGuestName());
					card3_4.setTxtRmNam(reservation.getRoom().getName());
					card3_4.setTxtChkIn(reservation.getCheckIn());
					card3_4.setTxtChkOut(reservation.getCheckOut());
					card3_4.setTxtPrcPrNght(reservation.getRoom().getPrice());
					card3_4.setTxtTtlPrc(reservation.getTotalPrice());
				}
			}
		});
		
		card3_4.setBtnVieHtlBckListener(goCard("View Hotel"));
	}
		
	public void initCard4(){
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
		new C(new V(), new HRS());
	}
}