import javax.swing.*;
import java.awt.event.ActionListener;

public class V_Card3_4 {
    private JPanel cards;

    private JTextField txtResId, txtGstNam, txtRmNam, txtChkIn, txtChkOut, txtPrcPrNght, txtTtlPrc;
    private JComboBox<Integer> cmbxRsrvLst;
	private JButton btnVieHtlBck;

    public V_Card3_4(JPanel cards){
        this.cards = cards;

        JPanel card3_4 = new JPanel();

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

		this.btnVieHtlBck = new JButton("Back to View Hotel");

        card3_4.add(new JLabel("Reservation Info"));

        card3_4.add(new JLabel("Select Reservation"));
        card3_4.add(this.cmbxRsrvLst);

        card3_4.add(new JLabel("Reservation ID:"));
        card3_4.add(this.txtResId);

        card3_4.add(new JLabel("Guest Name:"));
        card3_4.add(this.txtGstNam);

        card3_4.add(new JLabel("Room Name:"));
        card3_4.add(this.txtRmNam);

        card3_4.add(new JLabel("Check In Day:"));
        card3_4.add(this.txtChkIn);

        card3_4.add(new JLabel("Check Out Day:"));
        card3_4.add(this.txtChkOut);

        card3_4.add(new JLabel("Price per night:"));
        card3_4.add(this.txtPrcPrNght);

        card3_4.add(new JLabel("Total Price:"));
        card3_4.add(this.txtTtlPrc);
		
		card3_4.add(this.btnVieHtlBck);

        this.cards.add(card3_4, "View Reservation");
    }

    //card3_4 setters
	public int getCmbxRsrvItem(){
		return (int) this.cmbxRsrvLst.getSelectedItem();
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
	
	public void setCmbxRsrvListener(ActionListener al){
		this.cmbxRsrvLst.addActionListener(al);
	}

	public void setBtnVieHtlBckListener(ActionListener al){
		this.btnVieHtlBck.addActionListener(al);
	}
}
