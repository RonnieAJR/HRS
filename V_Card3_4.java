import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class V_Card3_4 {
    private JPanel cards;

    private JTextField txtResId, txtGstNam, txtRmNam, txtChkIn, txtChkOut, txtPrcPrNght, txtTtlPrc;
    private JComboBox<Integer> cmbxRsrvLst, cmbxDayPrcPerNyt;
	private JButton btnVieHtlBck;

    public V_Card3_4(JPanel cards){
        this.cards = cards;

        JPanel card3_4 = new JPanel(new BorderLayout());

        JLabel header = new JLabel("Reservation Info", JLabel.CENTER);
		header.setFont(new Font("Default", Font.PLAIN, 20));
		card3_4.add(header, BorderLayout.NORTH);

        this.txtResId = new JTextField();
        this.txtResId.setEditable(false);

        this.txtGstNam = new JTextField();
        this.txtGstNam.setEditable(false);

        this.txtRmNam = new JTextField();
        this.txtRmNam.setEditable(false);

        this.txtChkIn = new JTextField();
        this.txtChkIn.setEditable(false);

        this.txtChkOut = new JTextField();
        this.txtChkOut.setEditable(false);

        this.txtPrcPrNght = new JTextField();
        this.txtPrcPrNght.setEditable(false);

        this.txtTtlPrc = new JTextField();
        this.txtTtlPrc.setEditable(false);

        this.cmbxRsrvLst = new JComboBox<>();
        this.cmbxDayPrcPerNyt = new JComboBox<>();

		this.btnVieHtlBck = new JButton("Back to View Hotel");

        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1.0;


        //Room Selector
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Select Reservation"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(this.cmbxRsrvLst, gbc);

        //Reservation ID
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Reservation ID:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.txtResId.setPreferredSize(new Dimension(300, 20));
        centerPanel.add(this.txtResId, gbc);


        //Guest Name
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Guest Name:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.txtGstNam.setPreferredSize(new Dimension(300, 20));
        centerPanel.add(this.txtGstNam, gbc);

        //Room Name
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Room Name:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.txtRmNam.setPreferredSize(new Dimension(300, 20));
        centerPanel.add(this.txtRmNam, gbc);

        //Check in Day
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Check In Day"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.txtChkIn.setPreferredSize(new Dimension(300, 20));
        centerPanel.add(this.txtChkIn, gbc);


        //Check Out Day
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Check Out Day"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.txtChkOut.setPreferredSize(new Dimension(300, 20));
        centerPanel.add(this.txtChkOut, gbc);

        //Day Price per night
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Choose Day to check price per night"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(this.cmbxDayPrcPerNyt, gbc);

        //Price Per Night
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Price per night"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.txtPrcPrNght.setPreferredSize(new Dimension(300, 20));
        centerPanel.add(this.txtPrcPrNght, gbc);


        //Total Price
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Total Price"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.txtTtlPrc.setPreferredSize(new Dimension(300, 20));
        centerPanel.add(this.txtTtlPrc, gbc);


        card3_4.add(centerPanel, BorderLayout.CENTER);
		
		//Panel for Button
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));

        this.btnVieHtlBck.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonsPanel.add(Box.createVerticalStrut(5));
        buttonsPanel.add(this.btnVieHtlBck);    
		card3_4.add(buttonsPanel, BorderLayout.PAGE_END);

        this.cards.add(card3_4, "View Reservation");
    }

    //card3_4 setters
	
	public int getCmbxRsrvItem(){
		return (int) this.cmbxRsrvLst.getSelectedItem();
	}

    public int getCmbxDayItem(){
        return (int) this.cmbxDayPrcPerNyt.getSelectedItem();
    }

    public void setCmbxDayPrcPerNyt(Integer[] days){
        this.cmbxDayPrcPerNyt.removeAllItems();
        for(Integer day : days)
            this.cmbxDayPrcPerNyt.addItem(day);
    }
	
    public void setCmbxRsrvLst(Integer[] reservationIDs){
		this.cmbxRsrvLst.removeAllItems();
        for(Integer Reservation : reservationIDs)
            this.cmbxRsrvLst.addItem(Reservation);
    }
	
	public void resetVieRsrv(){
		this.cmbxRsrvLst.setSelectedIndex(0);
	}

    public void setTxtResId(int reservationID){
        this.txtResId.setText("" + reservationID);
    }

    public void setTxtGstNam(String gstNam){
        this.txtGstNam.setText(gstNam);
    }

    public void setTxtRmNam(String roomNam){
        this.txtRmNam.setText(roomNam);
    }

    public void setTxtChkIn(int chkIn){
        this.txtChkIn.setText("" + chkIn);
    }

    public void setTxtChkOut(int chkOut){
        this.txtChkOut.setText("" + chkOut);
    }

    public void setTxtPrcPrNght(double prcPrNght){
        this.txtPrcPrNght.setText("" + prcPrNght);
    }

    public void setTxtTtlPrc(double totalPrice){
        this.txtTtlPrc.setText("" + totalPrice);
    }
	
	public void setCmbxDayPrcPerNytListener(ItemListener il){
		if(this.cmbxDayPrcPerNyt.getItemListeners().length != 0)
			for(ItemListener i : this.cmbxDayPrcPerNyt.getItemListeners())
				this.cmbxDayPrcPerNyt.removeItemListener(i);
		this.cmbxDayPrcPerNyt.addItemListener(il);
	}
	
	public void setCmbxRsrvListener(ItemListener il){
		if(this.cmbxRsrvLst.getItemListeners().length == 0)
			this.cmbxRsrvLst.addItemListener(il);
	}

	public void setBtnVieHtlBckListener(ActionListener al){
		if(this.btnVieHtlBck.getActionListeners().length == 0)
			this.btnVieHtlBck.addActionListener(al);
	}
}
