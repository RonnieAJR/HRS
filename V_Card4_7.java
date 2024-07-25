import javax.swing.*;
import java.awt.event.ActionListener;

public class V_Card4_7 {
    private JPanel cards;

    private JTextField txtCnfrm;
    private JButton btnYes, btnNo, btnSbmt, btnMngHtlBck;
    private JLabel txtFdbck;

    public V_Card4_7(JPanel cards){
        this.cards = cards;
        JPanel card4_7 = new JPanel();

        this.txtCnfrm = new JTextField();

        this.btnYes = new JButton("Yes");
        this.btnNo = new JButton("No");

        this.btnSbmt = new JButton("Submit");
        this.btnMngHtlBck = new JButton("Back to Manage Hotel");

        this.txtFdbck = new JLabel();

        card4_7.add(new JLabel("Remove Hotel"));
        card4_7.add(this.btnNo);
        card4_7.add(this.btnYes);

        card4_7.add(this.btnSbmt);
        card4_7.add(this.btnMngHtlBck);
        card4_7.add(this.txtCnfrm);
        card4_7.add(this.txtFdbck);

        this.cards.add(card4_7, "Remove Hotel");
    }

    public void resetTxtConfirm(){this.txtCnfrm.setText("");}

    public void resetTxtFdbck(){this.txtFdbck.setText("");}

    public void setTxtConfirm(String confirm){this.txtCnfrm.setText(confirm);}

    public void setTxtFdbck(String feedback){this.txtFdbck.setText(feedback);}

    public void setBtnYesListener(ActionListener al){this.btnYes.addActionListener(al);}

    public void setBtnNoListener(ActionListener al){this.btnNo.addActionListener(al);}

    public void setBtnSbmtListener(ActionListener al){this.btnSbmt.addActionListener(al);}

    public void setBtnMngHtlBckListener(ActionListener al){this.btnMngHtlBck.addActionListener(al);}
}
