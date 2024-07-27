import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class V_Card4_2 {
    private JPanel cards;

    private JTextField txtAddRm, txtCnfrm;
    private JComboBox<String> cmbxRmTyp;
    private JButton btnAddRm, btnMngHtlBck;
    private JLabel txtFdbck;

    public V_Card4_2(JPanel cards){
        this.cards = cards;
        JPanel card4_2 = new JPanel();


        this.txtAddRm = new JTextField(20);
        this.txtCnfrm = new JTextField(10);

        this.cmbxRmTyp = new JComboBox<>();
        this.cmbxRmTyp.addItem("Standard");
        this.cmbxRmTyp.addItem("Deluxe");
        this.cmbxRmTyp.addItem("Executive");

        this.txtFdbck = new JLabel();



        this.btnAddRm = new JButton("Add");
        this.btnMngHtlBck = new JButton("Back to Manage Hotel");

        card4_2.add(new JLabel("Add Room"));

        card4_2.add(new JLabel("Enter number of Rooms:"));
        card4_2.add(this.txtAddRm);

        card4_2.add(new JLabel("Choose Room Type"));
        card4_2.add(this.cmbxRmTyp);

        card4_2.add(this.btnAddRm);
        card4_2.add(this.btnMngHtlBck);

        card4_2.add(this.txtCnfrm);
        card4_2.add(this.txtFdbck);

        this.cards.add(card4_2, "Add Room");
    }

    public int getTxtAddRm(){return Integer.parseInt(txtAddRm.getText());}

    public String getCmbxRmTypItem(){return this.cmbxRmTyp.getSelectedItem().toString();}

    public String getTxtCnfrm(){return this.txtCnfrm.getName().toString();}

    public void resetAddRm(){
        this.txtAddRm.setText("");
        this.txtCnfrm.setText("");
        this.txtFdbck.setText("");
    }
    
    public void setTxtConfirm(String confirm){this.txtCnfrm.setText(confirm);}

    public void setTxtFdbck(String feedback){this.txtFdbck.setText(feedback);}

    public void setBtnAddRmListener(ActionListener al){
        if(this.btnAddRm.getActionListeners().length == 0)
            this.btnAddRm.addActionListener(al);
    }

    public void setBtnMngHtlBckListener(ActionListener al){
        if(this.btnMngHtlBck.getActionListeners().length == 0)
            this.btnMngHtlBck.addActionListener(al);
    }

}
