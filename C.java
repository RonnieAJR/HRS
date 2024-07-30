import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;

public class C{
	private HRS m;
	private V v;
	
	public C(V v, HRS m)
	{
		this.m = m;
		this.v = v;
		V_Card1 card = v.getCard1();
		
		card.setBtnCreHtlListener(goCard("Create Hotel"));
		
		card.setBtnVieHtlListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// if(e.getSource() == card.getBtnVieHtl()){
					if(m.getHotels().isEmpty())
						card.setTxtFdbck("Hotels not found");
					else{
						initCard3();
						v.setCard("View Hotel");
					}
				// }
			}
		});
		
		card.setBtnManHtlListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// if(e.getSource() == card.getBtnManHtl()){
					if(m.getHotels().isEmpty())
						card.setTxtFdbck("Hotels not found");
					else{
						initCard4();
						v.setCard("Manage Hotel");
					}
				// }
			}
		});
		
		card.setBtnSimBookListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(m.getHotels().isEmpty())
					card.setTxtFdbck("Hotels not found");
				else{
					initCard5();
					v.setCard("Simulate Booking");
				}
			}
		});
		
		this.initCard2();
	}
	
	public void initCard2(){
		V_Card2 card = this.v.getCard2();
		
		card.setBtnCreHtlTryListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// if(e.getSource() == card.getBtnCreHtlTry()){
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
						v.getCard4().addCmbxHtlsItem(name);
						v.getCard5().addCmbxHtlsItem(name);
					}
					else{
						System.out.println("Hotel already exists\n");
						card.setFdbckCreHtl("Hotel already exists");
					}
					
					card.resetCreHtl();
				// }
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
		V_Card3 card3 = this.v.getCard3();
		
		// reset cmbx
		
		card3.setBtnVieHtlListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// if(e.getSource() == card3.getBtnVieHtl()){
					initCard3_1(card3);
					v.setCard("View Hotel Info");
				// }
			}
		});
		
		card3.setBtnVieDayListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// if(e.getSource() == card3.getBtnVieDay()){
					initCard3_2(card3);
					v.setCard("View Day Availability");
				// }
			}
		});
		
		card3.setBtnVieRoomListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// if(e.getSource() == card3.getBtnVieRoom()){
					initCard3_3(card3);
					v.setCard("View Room");
				// }
			}
		});
		
		card3.setBtnVieRsrvListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// if(e.getSource() == card3.getBtnVieRsrv()){
					System.out.println("2==" + e.paramString());
					Hotel hotel = m.findHotel(card3.getCmbxHtlsItem());
					if(hotel.getReservations().isEmpty())
						card3.setTxtFdbck("Reservations not found");
					else{
						initCard3_4(card3);
						v.setCard("View Reservation");
					}
				// }
			}
		});
		
		card3.setBtnMaiMenBckListener(goCard("Main Menu"));
		// reset hotel? on back to main menu only, then add e.getSource == button
	}
	
	public void initCard3_1(V_Card3 card3){
		Hotel hotel = m.findHotel(card3.getCmbxHtlsItem());
		
		V_Card3_1 card3_1 = card3.getCard3_1();
		
		card3_1.setTxtHtlName(hotel.getName());
		card3_1.setTxtNumRooms(hotel.getCapacity());
		card3_1.setTxtEstimatedEarnings(hotel.getEarnings());
		card3_1.setBtnVieHtlBckListener(goCard("View Hotel"));
	}
	
	public void initCard3_2(V_Card3 card3){
		Hotel hotel = m.findHotel(card3.getCmbxHtlsItem());
		
		V_Card3_2 card3_2 = card3.getCard3_2();
		
		int day = card3_2.getCmbxDayItem();
		
		String[] available = hotel.getAvailableNames(day).toArray(new String[hotel.getAvailableNames(day).size()]);
		String[] reserved = hotel.getReservedNames(day).toArray(new String[hotel.getReservedNames(day).size()]);
		
		card3_2.setRoomAvailable(available);
		card3_2.setTxtTotalRoomAvail(available.length);
		card3_2.setRoomReserved(reserved);
		card3_2.setTxtTotalRoomReserved(reserved.length);
		
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
	
	public void initCard3_3(V_Card3 card3){
		V_Card3_3 card3_3 = card3.getCard3_3();
		
		Hotel hotel = m.findHotel(card3.getCmbxHtlsItem());
		
		String[] roomNames = hotel.getRoomNames().toArray(new String[hotel.getRooms().size()]);
		card3_3.setCmbxSlctRoom(roomNames);
		
		Room room = hotel.findRoom(card3_3.getCmbxRoomItem());
		
		Integer[] availableDays = room.getAvailable().toArray(new Integer[room.getAvailable().size()]);
		Integer[] reservedDays = room.getReserved().toArray(new Integer[room.getReserved().size()]);
		
		card3_3.setRoomName(room.getName()); // add room type?
		card3_3.setRoomFloor(room.getName().charAt(1));
		card3_3.setPricePerNight(room.getPrice());
		card3_3.setCmbxDayAvail(availableDays);
		card3_3.setCmbxDayReserved(reservedDays);

		
		card3_3.setCmbxRoomListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){
				System.out.println("1==" + e.paramString());
				if(e.getStateChange() == ItemEvent.SELECTED){
					Room room = hotel.findRoom(card3_3.getCmbxRoomItem());
					
					Integer[] availableDays = room.getAvailable().toArray(new Integer[room.getAvailable().size()]);
					Integer[] reservedDays = room.getReserved().toArray(new Integer[room.getReserved().size()]);
					
					card3_3.setRoomName(room.getName()); // add room type?
					card3_3.setRoomFloor(room.getName().charAt(1));
					card3_3.setPricePerNight(room.getPrice());
					card3_3.setCmbxDayAvail(availableDays);
					card3_3.setCmbxDayReserved(reservedDays);

				}
			}
		});
		
		card3_3.setBtnVieHtlBckListener(goCard("View Hotel"));
	}
	
	public void initCard3_4(V_Card3 card3){
		V_Card3_4 card3_4 = card3.getCard3_4();
		
		Hotel hotel = m.findHotel(card3.getCmbxHtlsItem());
		
		Integer[] reservationIds = hotel.getReservationIds().toArray(new Integer[hotel.getReservations().size()]);
		card3_4.setCmbxRsrvLst(reservationIds);
		
		Reservation reservation = hotel.findReservation(card3_4.getCmbxRsrvItem());
		Integer[] days = new Integer[reservationIds.length];
		int checkIn = reservation.getCheckIn();
		int checkOut = reservation.getCheckOut();
		int i, day;
		
		card3_4.setTxtResId(reservation.getId());
		card3_4.setTxtGstNam(reservation.getGuestName());
		card3_4.setTxtRmNam(reservation.getRoom().getName());
		card3_4.setTxtChkIn(checkIn);
		card3_4.setTxtChkOut(checkOut);
		card3_4.setTxtTtlPrc(reservation.getTotalPrice());
		
		card3_4.setCmbxRsrvListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){
				if(e.getStateChange() == ItemEvent.SELECTED){
					Reservation reservation = hotel.findReservation(card3_4.getCmbxRsrvItem());
					int checkIn = reservation.getCheckIn();
					int checkOut = reservation.getCheckOut();
					
					card3_4.setTxtResId(reservation.getId());
					card3_4.setTxtGstNam(reservation.getGuestName());
					card3_4.setTxtRmNam(reservation.getRoom().getName());
					card3_4.setTxtChkIn(checkIn);
					card3_4.setTxtChkOut(checkOut);
					card3_4.setTxtTtlPrc(reservation.getTotalPrice());		
				}
			}
		});
		
		day = checkIn;
		i=0;
		while(i < days.length){
			days[i++] = day++;
		}
		
		card3_4.setCmbxDayPrcPerNyt(days);

		Room room = reservation.getRoom();
		HashMap<Integer, Double> dayPriceMod = room.getDayPriceMod();
		Integer daySelected = Integer.valueOf(card3_4.getCmbxDayItem());
		double mod = 100;
		
		if(dayPriceMod.containsKey(daySelected))
			mod = dayPriceMod.get(daySelected);
		
		card3_4.setTxtPrcPrNght(room.getPrice() * (mod / 100));
				
		card3_4.setCmbxDayPrcPerNytListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){
				if(e.getStateChange() == ItemEvent.SELECTED){
					Room room = reservation.getRoom();
					HashMap<Integer, Double> dayPriceMod = room.getDayPriceMod();
					Integer daySelected = Integer.valueOf(card3_4.getCmbxDayItem());
					double mod = 100;
					
					if(dayPriceMod.containsKey(daySelected))
						mod = dayPriceMod.get(daySelected);
					
					card3_4.setTxtPrcPrNght(room.getPrice() * (mod / 100));
				}
			}
		});
		
		card3_4.setBtnVieHtlBckListener(goCard("View Hotel"));
	}
		
	public void initCard4(){
		V_Card4 card4 = this.v.getCard4();
		
		card4.resetManHtl();
		
		card4.setBtnRnmHtlListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				initCard4_1(card4);
				v.setCard("Rename Hotel");
			}
		});
		
		card4.setBtnAddRoomListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				initCard4_2(card4);
				v.setCard("Add Room");
			}
		});
		
		card4.setBtnRmvRoomListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				initCard4_3(card4);
				v.setCard("Remove Room");
			}
		});
		
		card4.setBtnModPriceListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				initCard4_4(card4);
				v.setCard("Modify Day Price");
			}
		});
		
		card4.setBtnUpdPriceListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				initCard4_5(card4);
				v.setCard("Update Price");
			}
		});
		
		card4.setBtnRmvRsrvListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Hotel hotel = m.findHotel(card4.getCmbxHtlsItem());
				
				if(hotel.getReservations().isEmpty())
					card4.setTxtFdbck("Reservations not found");
				else{
					initCard4_6(card4);
					v.setCard("Remove Reservation");
				}
			}
		});
		
		card4.setBtnRmvHtlListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String hotelName = card4.getCmbxHtlsItem();
				
				int confirmation = JOptionPane.showConfirmDialog(v.getFrame(), "Are you sure you want to remove hotel " +
				hotelName + " ?", "Confirmation", JOptionPane.YES_NO_OPTION);
				///////////////////////////////////////////////////// current listeners must be removed before adding new listener
				System.out.println(confirmation + " == " + JOptionPane.YES_OPTION);
				if(confirmation == JOptionPane.YES_OPTION){
					m.removeHotel(hotelName);
					v.getCard3().removeCmbxHtlsItem(hotelName);
					card4.removeCmbxHtlsItem(hotelName);
					v.getCard5().removeCmbxHtlsItem(hotelName);
					v.getCard1().setTxtFdbck("Hotel " + hotelName + " removed");
					v.setCard("Main Menu");
					// remove hotel from cmbx
				}
			}
		});
		
		card4.setBtnMaiMenBckListener(goCard("Main Menu"));
		// reset fdbck
	}
	
	public void initCard4_1(V_Card4 card4){
		V_Card4_1 card4_1 = card4.getCard4_1();
		
		Hotel hotel = this.m.findHotel(card4.getCmbxHtlsItem());
		
		card4_1.setFdbckRnmHtl("");
		
		card4_1.setBtnRnmListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String newName = card4_1.getTxtNewHtlNm();
				String oldName = hotel.getName();
				
				if(m.renameHotel(oldName, newName)){
					v.getCard3().removeCmbxHtlsItem(oldName);
					v.getCard3().addCmbxHtlsItem(newName);
					card4.removeCmbxHtlsItem(oldName);
					card4.addCmbxHtlsItem(newName);
					v.getCard5().removeCmbxHtlsItem(oldName);
					v.getCard5().addCmbxHtlsItem(newName);
					card4_1.setFdbckRnmHtl("Hotel renamed");
				}
				else
					card4_1.setFdbckRnmHtl("Hotel already exists");
				
				card4_1.resetRnmHtl();
			}
		});
		
		card4_1.setBtnMngHtlBckListener(goCard("Manage Hotel"));
	}
	
	public void initCard4_2(V_Card4 card4){
		V_Card4_2 card4_2 = card4.getCard4_2();
		
		Hotel hotel = this.m.findHotel(card4.getCmbxHtlsItem());
		
		card4_2.setTxtFdbck("");
		
		card4_2.setBtnAddRmListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String roomType = card4_2.getCmbxRmTypItem();
				int target = card4_2.getTxtAddRm();
				int actual = 0;
				int confirmation;
				
				if(target + hotel.getCapacity() > 50)
					card4_2.setTxtFdbck("Amount of rooms exceed the maximum capacity");
				else{
					confirmation = JOptionPane.showConfirmDialog(v.getFrame(), "Are you sure you want to add " +
					target + " rooms?", "Confirmation", JOptionPane.YES_NO_OPTION);
					
					if(confirmation == JOptionPane.YES_OPTION){
						while(actual < target){
							hotel.addRoom(roomType);
							actual++;
						}
						card4_2.setTxtFdbck("" + actual + " rooms added");
					}
					else
						card4_2.setTxtFdbck("Aborting room additions");
					
					card4_2.resetAddRm();
				}
			}
		});
		
		card4_2.setBtnMngHtlBckListener(goCard("Manage Hotel"));
	}
	
	public void initCard4_3(V_Card4 card4){
		V_Card4_3 card4_3 = card4.getCard4_3();
		
		Hotel hotel = this.m.findHotel(card4.getCmbxHtlsItem());
		
		String[] roomNames = hotel.getRoomNames().toArray(new String[hotel.getRooms().size()]);
		card4_3.setCmbxRmtRmov(roomNames);
		
		card4_3.setTxtFdbck("");
		
		card4_3.setBtnRmovRmListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String roomName = card4_3.getCmbxRmtRmov();
				int confirmation;
				
				if(hotel.getRooms().size() == 1){
					card4_3.setTxtFdbck("Cannot remove last room");
				}
				else{
					confirmation = JOptionPane.showConfirmDialog(v.getFrame(), "Are you sure you want to remove room " +
					roomName + " ?", "Confirmation", JOptionPane.YES_NO_OPTION);
					
					if(confirmation == JOptionPane.YES_OPTION){
						if(hotel.removeRoom(roomName)){
							//////////////////////////////// remove in selection
							card4_3.setTxtFdbck("Room removed");
						}
						else
							card4_3.setTxtFdbck("Cannot remove a room with reservations");
					}
					else
						card4_3.setTxtFdbck("Aborting room removal");
				}
				card4_3.resetRmovRoom();
			}
		});
		
		card4_3.setBtnMngHtlBckListener(goCard("Manage Hotel"));
	}
	
	public void initCard4_4(V_Card4 card4){
		V_Card4_4 card4_4 = card4.getCard4_4();
		
		Hotel hotel = this.m.findHotel(card4.getCmbxHtlsItem());
		
		card4_4.setTxtFdbck("");
		
		card4_4.setBtnMdfyPrcListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				int day = card4_4.getCmbxDayItem();
				double mod = card4_4.getTxtPrcMod();
				
				if(50 <= mod && mod <= 150){
					if(hotel.modDayPrice(day, mod))
						card4_4.setTxtFdbck("Day price modified");
					else
						card4_4.setTxtFdbck("Cannot modify day with reservation");
				}
				else
					card4_4.setTxtFdbck("Price modification can only be 50% to 150% of the base price");
				
				card4_4.resetMdfyPrc();
			}
		});
		
		card4_4.setBtnMngHtlBckListener(goCard("Manage Hotel"));
	}
	
	public void initCard4_5(V_Card4 card4){
		V_Card4_5 card4_5 = card4.getCard4_5();
		
		Hotel hotel = this.m.findHotel(card4.getCmbxHtlsItem());
		
		card4_5.setTxtFdbck("");
		
		card4_5.setBtnUpdtListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				double newPrice = card4_5.getTxtUpdtNew();
				
				if(100 <= newPrice){
					if(hotel.updatePrice(newPrice))
						card4_5.setTxtFdbck("Price updated");
					else
						card4_5.setTxtFdbck("Cannot update the price of a hotel with reservations");
				}
				else
					card4_5.setTxtFdbck("Price cannot be less than 100");
				
				card4_5.resetUpdtHtlPrc();
			}
		});
		
		card4_5.setBtnMngHtlBckListener(goCard("Manage Hotel"));
	}
	
	public void initCard4_6(V_Card4 card4){
		V_Card4_6 card4_6 = card4.getCard4_6();
		
		Hotel hotel = this.m.findHotel(card4.getCmbxHtlsItem());
		
		card4_6.setTxtFdbck("");
		
		Integer[] reservationIds = hotel.getReservationIds().toArray(new Integer[hotel.getReservationIds().size()]);
		card4_6.setCmbxRsrvId(reservationIds);
		
		card4_6.setBtnRmovRsrvListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				int reservationId = card4_6.getCmbxRsrvId();
				
				hotel.removeReservation(reservationId);
				
				card4_6.removeCmbxItem(reservationId);
				
				if(hotel.getReservations().isEmpty()){
					v.setCard("Manage Hotel");
					v.getCard4().setTxtFdbck("Reservation removed");
				}
				else{
				card4_6.setTxtFdbck("Reservation removed");
					card4_6.resetRmovRsrv();
				}
			}
		});
		
		card4_6.setBtnMngHtlBckListener(goCard("Manage Hotel"));
	}
	
	public void initCard5(){
		V_Card5 card5 = this.v.getCard5();
		
		card5.setTxtFdbck("");
		
		card5.setBtnBook(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Hotel hotel = m.findHotel(card5.getCmbxHtls());
				String guestName = card5.getTxtGstNme();
				String discountCode = card5.getTxtDscntCde();
				String roomType = card5.getCmbxRmItem();
				int checkIn = card5.getCmbxChkInItem();
				int checkOut = card5.getCmbxChkOutItem();
				
				if(checkIn < checkOut){
					if(hotel.createReservation(guestName, checkIn, checkOut, roomType, discountCode))
						card5.setTxtFdbck("Reservation created");
					else
						card5.setTxtFdbck("No room available");
				}
				else
					card5.setTxtFdbck("Invalid days");
				
				card5.resetSim();
			}
		});
		
		card5.setBtnMaiMenBck(goCard("Main Menu"));
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
	
	public static void main(String[] args){
		new C(new V(), new HRS());
	}
}