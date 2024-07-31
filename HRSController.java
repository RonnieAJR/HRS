import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;

/**
 * The HRSModelController class controls both HRSModelModel and HRSModelView, providing means for the two classes to communicate.
 */
public class HRSController{
	private HRSModel m;
	private HRSView v;
	
	/**
	 * Constructs the controller, assigning model and view parameters as its own attributes.
	 * @param v the view
	 * @param m the model
	 */
	public HRSController(HRSView v, HRSModel m){
		this.m = m;
		this.v = v;
		V_Card1 card = v.getCard1();
		
		// initialize create hotel menu
		card.setBtnCreHtlListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				initCard2();
				v.setCard("Create Hotel");
				card.setTxtFdbck("");
			}
		});
		
		// initialize view hotel menu
		card.setBtnVieHtlListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(m.getHotels().isEmpty())
					card.setTxtFdbck("Hotels not found");
				else{
					initCard3();
					v.setCard("View Hotel");
				}
				card.setTxtFdbck("");
			}
		});
		
		// initializes manage hotel menu
		card.setBtnManHtlListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(m.getHotels().isEmpty())
					card.setTxtFdbck("Hotels not found");
				else{
					initCard4();
					v.setCard("Manage Hotel");
				}
				card.setTxtFdbck("");
			}
		});
		
		// initialize simulate booking menu
		card.setBtnSimBookListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(m.getHotels().isEmpty())
					card.setTxtFdbck("Hotels not found");
				else{
					initCard5();
					v.setCard("Simulate Booking");
				}
				card.setTxtFdbck("");
			}
		});
	}
	
	/**
	 * Initializes the card2 of the view according to the model.
	 */
	public void initCard2(){
		V_Card2 card = this.v.getCard2();
		
		// initializes the button listener
		card.setBtnCreHtlTryListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// gets the info of the hotel
				String name = card.getTxtHtlName();
				int capacity = card.getCmbxCapItem();
				double price = card.getTxtPrice();
				
				// checks if the hotel is to be created
				if(name.isEmpty())
					card.setFdbckCreHtl("Invalid name input");

				else if(price < 100){
					System.out.println("Invalid price input\n");
					card.setFdbckCreHtl("Invalid price input");
				}

				else if(m.createHotel(name, capacity, price)){
					card.setFdbckCreHtl("Hotel created");
					// adds the hotel to the options in view, manage, and simulate booking
					v.getCard3().addCmbxHtlsItem(name);
					v.getCard4().addCmbxHtlsItem(name);
					v.getCard5().addCmbxHtlsItem(name);
				}
				else{
					System.out.println("Hotel already exists\n");
					card.setFdbckCreHtl("Hotel already exists");
				}
				card.resetCreHtl();
			}
		});
		
		// initializes back to main menu button
		card.setBtnMaiMenBckListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				card.resetCreHtl();
				card.setFdbckCreHtl("");
				v.setCard("Main Menu");
			}
		});
	}
	
	/**
	 * Initializes the card3 of the view according to the model.
	 */
	public void initCard3(){
		V_Card3 card3 = this.v.getCard3();
		
		card3.resetViewHtl();
		card3.setTxtFdbck("");
		
		// initializes view hotel window and button
		card3.setBtnVieHtlListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				card3.setTxtFdbck("");
				initCard3_1(card3);
				v.setCard("View Hotel Info");
			}
		});
		
		// initializes view day availability window and button
		card3.setBtnVieDayListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				card3.setTxtFdbck("");
				initCard3_2(card3);
				v.setCard("View Day Availability");
			}
		});
		
		// initializes view room window and button
		card3.setBtnVieRoomListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				card3.setTxtFdbck("");
				initCard3_3(card3);
				v.setCard("View Room");
			}
		});
		
		// initializes view reservation window and button
		card3.setBtnVieRsrvListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Hotel hotel = m.findHotel(card3.getCmbxHtlsItem());
				if(hotel.getReservations().isEmpty())
					card3.setTxtFdbck("Reservations not found");
				else{
					initCard3_4(card3);
					v.setCard("View Reservation");
				}
			}
		});
		
		// initializes back to main menu button
		card3.setBtnMaiMenBckListener(goCard("Main Menu"));
	}
	
	/**
	 * Initializes the card3_1 of the view according to the model.
	 */
	public void initCard3_1(V_Card3 card3){
		V_Card3_1 card3_1 = card3.getCard3_1();
		
		// gets the hotel selected
		Hotel hotel = m.findHotel(card3.getCmbxHtlsItem());
		
		// gets and displays the hotel info
		card3_1.setTxtHtlName(hotel.getName());
		card3_1.setTxtNumRooms(hotel.getCapacity());
		card3_1.setTxtEstimatedEarnings(hotel.getEarnings());
		
		// initializes back to view hotel menu
		card3_1.setBtnVieHtlBckListener(goCard("View Hotel"));
	}
	
	/**
	 * Initializes the card3_2 of the view according to the model.
	 */
	public void initCard3_2(V_Card3 card3){
		V_Card3_2 card3_2 = card3.getCard3_2();
		
		// gets the hotel selected
		Hotel hotel = m.findHotel(card3.getCmbxHtlsItem());
		
		// gets the first day
		int day = card3_2.getCmbxDayItem();
		
		// initializes rooms available and reserved arrays on the first day
		String[] available = hotel.getAvailableNames(day).toArray(new String[hotel.getAvailableNames(day).size()]);
		String[] reserved = hotel.getReservedNames(day).toArray(new String[hotel.getReservedNames(day).size()]);
		
		// displays info about the first day
		card3_2.setRoomAvailable(available);
		card3_2.setTxtTotalRoomAvail(available.length);
		card3_2.setRoomReserved(reserved);
		card3_2.setTxtTotalRoomReserved(reserved.length);
		
		// initializes selected day
		card3_2.setCmbxDayListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){
				if(e.getStateChange() == ItemEvent.SELECTED){
					// gets selected day
					int day = card3_2.getCmbxDayItem();
					
					// initializes room available and reserved arrays on the selected day
					String[] available = hotel.getAvailableNames(day).toArray(new String[hotel.getAvailableNames(day).size()]);
					String[] reserved = hotel.getReservedNames(day).toArray(new String[hotel.getReservedNames(day).size()]);
					
					// displays info about the selected day
					card3_2.setRoomAvailable(available);
					card3_2.setTxtTotalRoomAvail(available.length);
					card3_2.setRoomReserved(reserved);
					card3_2.setTxtTotalRoomReserved(reserved.length);
				}
			}
		});
		
		// initializes back to view hotel button
		card3_2.setBtnVieHtlBckListener(goCard("View Hotel"));
	}
	
	/**
	 * Initializes the card3_3 of the view according to the model.
	 */
	public void initCard3_3(V_Card3 card3){
		V_Card3_3 card3_3 = card3.getCard3_3();
		
		// gets the hotel selected
		Hotel hotel = m.findHotel(card3.getCmbxHtlsItem());
		
		// initializes room names
		String[] roomNames = hotel.getRoomNames().toArray(new String[hotel.getRooms().size()]);
		card3_3.setCmbxSlctRoom(roomNames);
		
		// gets the first room
		Room room = hotel.findRoom(card3_3.getCmbxRoomItem());
		
		// initializes days available and reserved on the first room
		Integer[] availableDays = room.getAvailable().toArray(new Integer[room.getAvailable().size()]);
		Integer[] reservedDays = room.getReserved().toArray(new Integer[room.getReserved().size()]);
		
		// displays info about the first room
		card3_3.setRoomName(room.getName());
		card3_3.setRoomFloor(room.getName().charAt(1));
		card3_3.setPricePerNight(room.getPrice());
		card3_3.setCmbxDayAvail(availableDays);
		card3_3.setCmbxDayReserved(reservedDays);

		// initializes selected room
		card3_3.setCmbxRoomListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){
				if(e.getStateChange() == ItemEvent.SELECTED){
					// gets selected room
					Room room = hotel.findRoom(card3_3.getCmbxRoomItem());
					
					// initializes days available and reserved on the selected room
					Integer[] availableDays = room.getAvailable().toArray(new Integer[room.getAvailable().size()]);
					Integer[] reservedDays = room.getReserved().toArray(new Integer[room.getReserved().size()]);
					
					// displays info about the selected room
					card3_3.setRoomName(room.getName());
					card3_3.setRoomFloor(room.getName().charAt(1));
					card3_3.setPricePerNight(room.getPrice());
					card3_3.setCmbxDayAvail(availableDays);
					card3_3.setCmbxDayReserved(reservedDays);

				}
			}
		});
		
		// initializes back to view hotel button
		card3_3.setBtnVieHtlBckListener(goCard("View Hotel"));
	}
	
	/**
	 * Initializes the card3_4 of the view according to the model.
	 */
	public void initCard3_4(V_Card3 card3){
		V_Card3_4 card3_4 = card3.getCard3_4();
		
		// gets the selected hotel
		Hotel hotel = m.findHotel(card3.getCmbxHtlsItem());
		
		// initializes the reservation ids
		Integer[] reservationIds = hotel.getReservationIds().toArray(new Integer[hotel.getReservations().size()]);
		card3_4.setCmbxRsrvLst(reservationIds);
		
		// gets the first reservation
		Reservation reservation = hotel.findReservation(card3_4.getCmbxRsrvItem());
		int checkIn = reservation.getCheckIn();
		int checkOut = reservation.getCheckOut();
		int i, day;
		Integer[] days = new Integer[checkOut - checkIn];
		
		// displays info about the first reservation
		card3_4.setTxtResId(reservation.getId());
		card3_4.setTxtGstNam(reservation.getGuestName());
		card3_4.setTxtRmNam(reservation.getRoom().getName());
		card3_4.setTxtChkIn(checkIn);
		card3_4.setTxtChkOut(checkOut);
		card3_4.setTxtTtlPrc(reservation.getTotalPrice());
		
		// initializes days of the first reservation
		day = checkIn;
		i=0;
		while(i < days.length){
			days[i++] = day++;
		}
		
		card3_4.setCmbxDayPrcPerNyt(days);
		
		// initializes prices on the first day
		Room room = reservation.getRoom();
		HashMap<Integer, Double> dayPriceMod = room.getDayPriceMod();
		Integer daySelected = Integer.valueOf(card3_4.getCmbxDayItem());
		double mod = 100;
		
		if(dayPriceMod.containsKey(daySelected))
			mod = dayPriceMod.get(daySelected);
		
		// displays the price on the first day
		card3_4.setTxtPrcPrNght(room.getPrice() * (mod / 100));
		
		// initializes the selected reservation
		card3_4.setCmbxRsrvListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){
				if(e.getStateChange() == ItemEvent.SELECTED){
					// gets the selected reservation
					Reservation reservation = hotel.findReservation(card3_4.getCmbxRsrvItem());
					int checkIn = reservation.getCheckIn();
					int checkOut = reservation.getCheckOut();
					
					// displays info about the selected reservation
					card3_4.setTxtResId(reservation.getId());
					card3_4.setTxtGstNam(reservation.getGuestName());
					card3_4.setTxtRmNam(reservation.getRoom().getName());
					card3_4.setTxtChkIn(checkIn);
					card3_4.setTxtChkOut(checkOut);
					card3_4.setTxtTtlPrc(reservation.getTotalPrice());
					
					// initializes the days of the selected reservation
					Integer[] days = new Integer[checkOut - checkIn];
					int i, day;
					
					day = checkIn;
					i=0;
					while(i < days.length){
						days[i++] = day++;
					}
					
					card3_4.setCmbxDayPrcPerNyt(days);
					
					// initializes the price on the first day
					Room room = reservation.getRoom();
					HashMap<Integer, Double> dayPriceMod = room.getDayPriceMod();
					Integer daySelected = Integer.valueOf(card3_4.getCmbxDayItem());
					double mod = 100;
					
					if(dayPriceMod.containsKey(daySelected))
						mod = dayPriceMod.get(daySelected);
					
					// displays the price on the first day
					card3_4.setTxtPrcPrNght(room.getPrice() * (mod / 100));
				}
			}
		});
		
		// initializes the price on the selected day
		card3_4.setCmbxDayPrcPerNytListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){
				if(e.getStateChange() == ItemEvent.SELECTED){
					// gets the selected day price
					Room room = reservation.getRoom();
					HashMap<Integer, Double> dayPriceMod = room.getDayPriceMod();
					Integer daySelected = Integer.valueOf(card3_4.getCmbxDayItem());
					double mod = 100;
					
					if(dayPriceMod.containsKey(daySelected))
						mod = dayPriceMod.get(daySelected);
					
					// displays the price on the selected day
					card3_4.setTxtPrcPrNght(room.getPrice() * (mod / 100));
				}
			}
		});
		
		// initializes the back to view hotel button
		card3_4.setBtnVieHtlBckListener(goCard("View Hotel"));
	}
	
	/**
	 * Initializes the card4 of the view according to the model.
	 */
	public void initCard4(){
		V_Card4 card4 = this.v.getCard4();
		
		card4.setTxtFdbck("");
		card4.resetManHtl();
		
		// initializes rename hotel menu and button
		card4.setBtnRnmHtlListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				card4.setTxtFdbck("");
				initCard4_1(card4);
				v.setCard("Rename Hotel");
			}
		});
		
		// initializes add room menu and button
		card4.setBtnAddRoomListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				card4.setTxtFdbck("");
				initCard4_2(card4);
				v.setCard("Add Room");
			}
		});
		
		// initializes remove room menu and button
		card4.setBtnRmvRoomListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				card4.setTxtFdbck("");
				initCard4_3(card4);
				v.setCard("Remove Room");
			}
		});
		
		// initializes modify day price menu and button
		card4.setBtnModPriceListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				card4.setTxtFdbck("");
				initCard4_4(card4);
				v.setCard("Modify Day Price");
			}
		});
		
		// initializes update price menu and button
		card4.setBtnUpdPriceListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				card4.setTxtFdbck("");
				initCard4_5(card4);
				v.setCard("Update Price");
			}
		});
		
		// initializes remove reservation menu and button
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
		
		// removes selected hotel
		card4.setBtnRmvHtlListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// gets selected hotel
				String hotelName = card4.getCmbxHtlsItem();
				
				// displays confirmation menu
				int confirmation = JOptionPane.showConfirmDialog(v.getFrame(), "Are you sure you want to remove hotel " +
				hotelName + " ?", "Confirmation", JOptionPane.YES_NO_OPTION);
				
				if(confirmation == JOptionPane.YES_OPTION){
					// removes selected hotel
					m.removeHotel(hotelName);
					v.getCard3().removeCmbxHtlsItem(hotelName);
					card4.removeCmbxHtlsItem(hotelName);
					v.getCard5().removeCmbxHtlsItem(hotelName);
					
					// displays outcome
					if(m.getHotels().isEmpty()){
						v.getCard1().setTxtFdbck("Hotel " + hotelName + " removed");
						v.setCard("Main Menu");
					}
					else
						card4.setTxtFdbck("Hotel " + hotelName + " removed");
				}
				else
					card4.setTxtFdbck("Aborting removal of hotel " + hotelName);
			}
		});
		
		// initializes back to main menu button
		card4.setBtnMaiMenBckListener(goCard("Main Menu"));
	}
	
	/**
	 * Initializes the card4_1 of the view according to the model.
	 */
	public void initCard4_1(V_Card4 card4){
		V_Card4_1 card4_1 = card4.getCard4_1();
		
		// gets selected hotel
		Hotel hotel = this.m.findHotel(card4.getCmbxHtlsItem());
		
		card4_1.setFdbckRnmHtl("");
		
		// initializes rename hotel button
		card4_1.setBtnRnmListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// gets the new name
				String newName = card4_1.getTxtNewHtlNm();
				String oldName = hotel.getName();
				
				// renames the hotel
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
		
		// initializes back to manage hotel button
		card4_1.setBtnMngHtlBckListener(goCard("Manage Hotel"));
	}
	
	/**
	 * Initializes the card4_2 of the view according to the model.
	 */
	public void initCard4_2(V_Card4 card4){
		V_Card4_2 card4_2 = card4.getCard4_2();
		
		// gets selected hotel
		Hotel hotel = this.m.findHotel(card4.getCmbxHtlsItem());
		
		card4_2.setTxtFdbck("");
		
		// initializes add room button
		card4_2.setBtnAddRmListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// gets room type and amount
				String roomType = card4_2.getCmbxRmTypItem();
				int target = card4_2.getTxtAddRm();
				int actual = 0;
				int confirmation;
				
				// checks if amount is valid
				if(target + hotel.getCapacity() > 50)
					card4_2.setTxtFdbck("Amount of rooms exceed the maximum capacity");
				else{
					// displays confirmation menu
					confirmation = JOptionPane.showConfirmDialog(v.getFrame(), "Are you sure you want to add " +
					target + " rooms?", "Confirmation", JOptionPane.YES_NO_OPTION);
					
					// adds rooms
					if(confirmation == JOptionPane.YES_OPTION){
						while(actual < target){
							hotel.addRoom(roomType);
							actual++;
						}
						card4_2.setTxtFdbck("" + actual + " rooms added");
					}
					else
						card4_2.setTxtFdbck("Aborting room additions");
				}
				card4_2.resetAddRm();
			}
		});
		
		// initializes back to manage hotel button
		card4_2.setBtnMngHtlBckListener(goCard("Manage Hotel"));
	}
	
	/**
	 * Initializes the card4_3 of the view according to the model.
	 */
	public void initCard4_3(V_Card4 card4){
		V_Card4_3 card4_3 = card4.getCard4_3();
		
		// gets selected hotel
		Hotel hotel = this.m.findHotel(card4.getCmbxHtlsItem());
		
		// initializes room names
		String[] roomNames = hotel.getRoomNames().toArray(new String[hotel.getRooms().size()]);
		card4_3.setCmbxRmtRmov(roomNames);
		
		card4_3.setTxtFdbck("");
		
		// initializes remove room button
		card4_3.setBtnRmovRmListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// gets the selected room
				String roomName = card4_3.getCmbxRmtRmov();
				int confirmation;
				
				// checks if the room is the last
				if(hotel.getRooms().size() == 1){
					card4_3.setTxtFdbck("Cannot remove last room");
				}
				else{
					// displays confirmation menu
					confirmation = JOptionPane.showConfirmDialog(v.getFrame(), "Are you sure you want to remove room " +
					roomName + " ?", "Confirmation", JOptionPane.YES_NO_OPTION);
					
					// removes room
					if(confirmation == JOptionPane.YES_OPTION){
						if(hotel.removeRoom(roomName)){
							card4_3.removeItem(roomName);
							card4_3.setTxtFdbck("Room removed");
						}
						else
							card4_3.setTxtFdbck("Cannot remove room with reservations");
					}
					else
						card4_3.setTxtFdbck("Aborting room removal");
				}
				card4_3.resetRmovRoom();
			}
		});
		
		// initializes back to manage hotel button
		card4_3.setBtnMngHtlBckListener(goCard("Manage Hotel"));
	}
	
	/**
	 * Initializes the card4_4 of the view according to the model.
	 */
	public void initCard4_4(V_Card4 card4){
		V_Card4_4 card4_4 = card4.getCard4_4();
		
		// gets selected hotel
		Hotel hotel = this.m.findHotel(card4.getCmbxHtlsItem());
		
		card4_4.setTxtFdbck("");
		
		// initializes modify day price button
		card4_4.setBtnMdfyPrcListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// gets day and modification
				int day = card4_4.getCmbxDayItem();
				double mod = card4_4.getTxtPrcMod();
				
				// validates day price modification
				if(50 <= mod && mod <= 150){
					// modifies the day price
					if(hotel.modDayPrice(day, mod))
						card4_4.setTxtFdbck("Day price modified");
					else
						card4_4.setTxtFdbck("Cannot modify day with reservations");
				}
				else
					card4_4.setTxtFdbck("Modification can only be 50%-150% of the base price");
				
				card4_4.resetMdfyPrc();
			}
		});
		
		// initializes back to manage hotel button
		card4_4.setBtnMngHtlBckListener(goCard("Manage Hotel"));
	}
	
	/**
	 * Initializes the card4_5 of the view according to the model.
	 */
	public void initCard4_5(V_Card4 card4){
		V_Card4_5 card4_5 = card4.getCard4_5();
		
		// gets selected hotel
		Hotel hotel = this.m.findHotel(card4.getCmbxHtlsItem());
		
		card4_5.setTxtFdbck("");
		
		// initializes update price button
		card4_5.setBtnUpdtListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// gets new price
				double newPrice = card4_5.getTxtUpdtNew();
				
				// validates the price update
				if(100 <= newPrice){
					// updates price
					if(hotel.updatePrice(newPrice))
						card4_5.setTxtFdbck("Price updated");
					else
						card4_5.setTxtFdbck("Cannot update the price of hotel with reservations");
				}
				else
					card4_5.setTxtFdbck("Price cannot be less than 100");
				
				card4_5.resetUpdtHtlPrc();
			}
		});
		
		// initializes back to manage hotel button
		card4_5.setBtnMngHtlBckListener(goCard("Manage Hotel"));
	}
	
	/**
	 * Initializes the card4_6 of the view according to the model.
	 */
	public void initCard4_6(V_Card4 card4){
		V_Card4_6 card4_6 = card4.getCard4_6();
		
		// gets selected hotel
		Hotel hotel = this.m.findHotel(card4.getCmbxHtlsItem());
		
		card4_6.setTxtFdbck("");
		
		// initializes reservation ids
		Integer[] reservationIds = hotel.getReservationIds().toArray(new Integer[hotel.getReservationIds().size()]);
		card4_6.setCmbxRsrvId(reservationIds);
		
		// initializes remove reservation button
		card4_6.setBtnRmovRsrvListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// gets selected reservation
				int reservationId = card4_6.getCmbxRsrvId();
				
				// removes reservation
				hotel.removeReservation(reservationId);
				
				card4_6.removeCmbxItem(reservationId);
				
				// displays outcome
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
		
		// initializes back to manage hotel button
		card4_6.setBtnMngHtlBckListener(goCard("Manage Hotel"));
	}
	
	/**
	 * Initializes the card5 of the view according to the model.
	 */
	public void initCard5(){
		V_Card5 card5 = this.v.getCard5();
		
		card5.setTxtFdbck("");
		
		// initializes book reservation button
		card5.setBtnBook(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// gets info
				Hotel hotel = m.findHotel(card5.getCmbxHtls());
				String guestName = card5.getTxtGstNme();
				String discountCode = card5.getTxtDscntCde();
				String roomType = card5.getCmbxRmItem();
				int checkIn = card5.getCmbxChkInItem();
				int checkOut = card5.getCmbxChkOutItem();
				
				// validates days
				if(checkIn < checkOut){
					// creates reservation
					if(guestName.isEmpty())
						card5.setTxtFdbck("Invalid Guest Name Input");
					else if(hotel.createReservation(guestName, checkIn, checkOut, roomType, discountCode))
						card5.setTxtFdbck("Reservation created");
					else
						card5.setTxtFdbck("No rooms available");
				}
				else
					card5.setTxtFdbck("Invalid days");
				
				card5.resetSim();
			}
		});
		
		// initializes back to main menu button
		card5.setBtnMaiMenBck(goCard("Main Menu"));
	}
	
	/**
	 * Returns an action listener that sets the card visible.
	 * @param cardName the name of the card to be made visible
	 * @return the action listener that sets the card visible
	 */
	public ActionListener goCard(String cardName){
		ActionListener al = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// changes windows
				v.setCard(cardName);
			}
		};
		return al;
	}
	
	/**
	 * Initializes the model, view, and the controller.
	 */
	public static void main(String[] args){
		// creates view and model
		new HRSController(new HRSView(), new HRSModel());
	}
}