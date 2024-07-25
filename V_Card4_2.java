import javax.swing.*;
//import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class V_Card4_2 {
    private JPanel cards;

    private JTextField txtAddRm, txtCnfrm;
    private JComboBox<String> cmbxRmTyp;
    private JButton btnSbmt, btnMngHtlBck;
    private JLabel txtFdbck;

    public V_Card4_2(JPanel cards){
        this.cards = cards;
        JPanel card4_2 = new JPanel();


        this.txtAddRm = new JTextField(20);
        this.txtCnfrm = new JTextField(10);

        this.cmbxRmTyp = new JComboBox<>();

        this.txtFdbck = new JLabel();

        this.cmbxRmTyp.addItem("Standard");
        this.cmbxRmTyp.addItem("Deluxe");
        this.cmbxRmTyp.addItem("Executive");

        this.btnSbmt = new JButton("Submit");
        this.btnMngHtlBck = new JButton("Back to Manage Hotel");

        card4_2.add(new JLabel("Add Room"));

        card4_2.add(new JLabel("Enter number of Rooms:"));
        card4_2.add(this.txtAddRm);

        card4_2.add(new JLabel("Choose Room Type"));
        card4_2.add(this.cmbxRmTyp);

        card4_2.add(this.btnSbmt);
        card4_2.add(this.btnMngHtlBck);

        card4_2.add(this.txtCnfrm);
        card4_2.add(this.txtFdbck);

        this.cards.add(card4_2, "Add Room");
    }

    public int getTxtAddRm(){return Integer.parseInt(txtAddRm.getText());}

    public String getTxtCnfrm(){return this.txtCnfrm.getName().toString();}

    public void resetTxtAddRm(){this.txtAddRm.setText("");}

    public void resetTxtConfirm(){this.txtCnfrm.setText("");}

    public void resetTxtFdbck(){this.txtFdbck.setText("");}

    public void setTxtConfirm(String confirm){this.txtCnfrm.setText(confirm);}

    public void setTxtFdbck(String feedback){this.txtFdbck.setText(feedback);}

    public void setBtnSbmtListener(ActionListener al){this.btnSbmt.addActionListener(al);}

    public void setBtnMngHtlBckListener(ActionListener al){this.btnMngHtlBck.addActionListener(al);}

}
