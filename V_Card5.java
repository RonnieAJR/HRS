import javax.swing.*;
import java.awt.event.ActionListener;

public class V_Card5 {
    private JPanel cards;

    private JTextField txtGstNme, txtDscntCde;
    private JComboBox<Integer> cmbxChkIn, cmbxChkOut;
    private JComboBox<String> cmbxRmTyp;
    private JButton btnApplDisc, btnBook, btnMaiMenBck;
    private JLabel txtFdbck;

    public V_Card5(JPanel cards){
        this.cards = cards;
        JPanel card5 = new JPanel();

        this.txtGstNme = new JTextField(20);
        this.txtDscntCde = new JTextField(15);

        int i;
        this.cmbxChkIn = new JComboBox<>();
        this.cmbxChkOut = new JComboBox<>();
        for(i = 1; i <= 31; i++) {
            if(i != 31)
                cmbxChkIn.addItem(i);
            if(i != 1)
                cmbxChkOut.addItem(i);
        }

        this.cmbxRmTyp = new JComboBox<>();
        this.cmbxRmTyp.addItem("Standard");
        this.cmbxRmTyp.addItem("Deluxe");
        this.cmbxRmTyp.addItem("Executive");

        this.btnBook = new JButton("Book");
        this.btnApplDisc = new JButton("Apply Discount");
        this.btnMaiMenBck = new JButton("Back to Main Menu");

        this.txtFdbck = new JLabel();

        card5.add(new JLabel("Enter Guest Name:"));
        card5.add(this.txtGstNme);

        card5.add(new JLabel("Choose Room Type"));
        card5.add(this.cmbxRmTyp);

        card5.add(new JLabel("Choose Check in day"));
        card5.add(this.cmbxChkIn);

        card5.add(new JLabel("Choose Check out day"));
        card5.add(this.cmbxChkOut);

        card5.add(new JLabel("Enter Discount Code (Optional)"));
        card5.add(this.txtDscntCde);
        card5.add(this.btnApplDisc);

        card5.add(this.btnBook);
        card5.add(this.btnMaiMenBck);

        this.cards.add(card5, "Simulate Booking");
    }

    public String getTxtGstNme(){return this.txtGstNme.getText().toString();}

    public String getTxtDscntCde(){return this.txtDscntCde.getText().toString();}

    public int getCmbxChkInItem(){return (int) this.cmbxChkIn.getSelectedItem();}

    public int getCmbxChkOutItem(){return (int) this.cmbxChkOut.getSelectedItem();}

    public String getCmbxRmItem(){return this.cmbxRmTyp.getSelectedItem().toString();}

    public void resetSim(){
        this.txtGstNme.setText("");
        this.txtDscntCde.setText("");
        this.txtFdbck.setText("");
        this.cmbxRmTyp.setSelectedIndex(0);

    }

    public void setTxtFdbck(String Fdbck){
        this.txtFdbck.setText(Fdbck);
    }

    public void setBtnApplDisc(ActionListener al){
        if(this.btnApplDisc.getActionListeners().length == 0)
            this.btnApplDisc.addActionListener(al);
    }

    public void setBtnBook(ActionListener al){
        if(this.btnBook.getActionListeners().length == 0)
            this.btnBook.addActionListener(al);
    }

    public void setBtnMaiMenBck(ActionListener al){
        if(this.btnMaiMenBck.getActionListeners().length == 0)
            this.btnMaiMenBck.addActionListener(al);
    }

}
