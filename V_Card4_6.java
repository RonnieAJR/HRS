import javax.swing.*;
import java.awt.event.ActionListener;

public class V_Card4_6 {
    private JPanel cards;

    private JTextField txtRsrvId, txtCnfrm;
    private JButton btnSbmt, btnMngHtlBck;
    private JLabel txtFdbck;

    public V_Card4_6(){
        this.cards = cards;
        JPanel card4_6 = new JPanel();

        this.txtRsrvId = new JTextField(10);
        this.txtCnfrm = new JTextField();

        this.btnSbmt = new JButton("Submit");
        this.btnMngHtlBck = new JButton("Back to Manage Hotel");

        this.txtFdbck = new JLabel();


        card4_6.add(new JLabel("Input Reservation ID:"));
        card4_6.add(this.txtRsrvId);

        card4_6.add(this.btnSbmt);
        card4_6.add(this.btnMngHtlBck);
        card4_6.add(this.txtCnfrm);
        card4_6.add(this.txtFdbck);

        this.cards.add(card4_6, "Remove Reservation");
    }
    public String getTxtRsrvId(){return this.txtRsrvId.getText().toString();}

    public void resetTxtRsrvId(){this.txtRsrvId.setText("");}

    public void resetTxtConfirm(){this.txtCnfrm.setText("");}

    public void resetTxtFdbck(){this.txtFdbck.setText("");}

    public void setTxtConfirm(String confirm){this.txtCnfrm.setText(confirm);}

    public void setTxtFdbck(String feedback){this.txtFdbck.setText(feedback);}

    public void setBtnSbmtListener(ActionListener al){this.btnSbmt.addActionListener(al);}

    public void setBtnMngHtlBckListener(ActionListener al){this.btnMngHtlBck.addActionListener(al);}
}
