import javax.swing.*;
import java.awt.event.ActionListener;

public class V_Card4_6 {
    private JPanel cards;

    private JTextField txtRsrvId, txtCnfrm;
    private JButton btnRmovRsrv, btnMngHtlBck;
    private JLabel txtFdbck;

    public V_Card4_6(JPanel cards){
        this.cards = cards;
        JPanel card4_6 = new JPanel();

        this.txtRsrvId = new JTextField(10);
        this.txtCnfrm = new JTextField();

        this.btnRmovRsrv = new JButton("Remove");
        this.btnMngHtlBck = new JButton("Back to Manage Hotel");

        this.txtFdbck = new JLabel();


        card4_6.add(new JLabel("Input Reservation ID:"));
        card4_6.add(this.txtRsrvId);

        card4_6.add(this.btnRmovRsrv);
        card4_6.add(this.btnMngHtlBck);
        card4_6.add(this.txtCnfrm);
        card4_6.add(this.txtFdbck);

        this.cards.add(card4_6, "Remove Reservation");
    }
    public String getTxtRsrvId(){return this.txtRsrvId.getText().toString();}

    public void resetRmovRsrv(){
        this.txtRsrvId.setText("");
        this.txtCnfrm.setText("");
        this.txtFdbck.setText("");
    }

    public void setTxtConfirm(String confirm){this.txtCnfrm.setText(confirm);}

    public void setTxtFdbck(String feedback){this.txtFdbck.setText(feedback);}

    public void setBtnRmovRsrvListener(ActionListener al){
        if(this.btnRmovRsrv.getActionListeners().length == 0)
            this.btnRmovRsrv.addActionListener(al);
    }

    public void setBtnMngHtlBckListener(ActionListener al){
        if(this.btnMngHtlBck.getActionListeners().length == 0)
            this.btnMngHtlBck.addActionListener(al);
    }
}
