import javax.swing.*;
import java.awt.event.ActionListener;

public class V_Card4_5 {
    private JPanel cards;
    
    private JTextField txtPrcMod, txtCnfrm;
    private JButton btnSbmt, btnMngHtlBck;
    private JLabel txtFdbck;

    public V_Card4_5(JPanel cards){
        this.cards = cards;
        JPanel card4_5 = new JPanel();
        
        this.txtPrcMod = new JTextField(10);
        this.txtCnfrm = new JTextField();

        this.btnSbmt = new JButton("Submit");
        this.btnMngHtlBck = new JButton("Back to Manage Hotel");

        this.txtFdbck = new JLabel();


        card4_5.add(new JLabel("Input new price"));
        card4_5.add(this.txtPrcMod);

        card4_5.add(this.btnSbmt);
        card4_5.add(this.btnMngHtlBck);
        card4_5.add(this.txtCnfrm);
        card4_5.add(this.txtFdbck);

        this.cards.add(card4_5, "Update Hotel Price");
    }

    public double getTxtPrcMod(){return Double.parseDouble(txtPrcMod.getText());}

    public void resetTxtPrcMod(){this.txtPrcMod.setText("");}

    public void resetTxtConfirm(){this.txtCnfrm.setText("");}

    public void resetTxtFdbck(){this.txtFdbck.setText("");}

    public void setTxtConfirm(String confirm){this.txtCnfrm.setText(confirm);}

    public void setTxtFdbck(String feedback){this.txtFdbck.setText(feedback);}

    public void setBtnSbmtListener(ActionListener al){this.btnSbmt.addActionListener(al);}

    public void setBtnMngHtlBckListener(ActionListener al){this.btnMngHtlBck.addActionListener(al);}
}
