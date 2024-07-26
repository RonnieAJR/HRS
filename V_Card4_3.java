import javax.swing.*;
import java.awt.event.ActionListener;

public class V_Card4_3 {
    private JPanel cards;

    private JTextField txtRmtRmov, txtCnfrm;
    private JButton btnRmovRm, btnMngHtlBck;
    private JLabel txtFdbck;

    public V_Card4_3(JPanel cards){
        this.cards = cards;
        JPanel card4_3 = new JPanel();

        this.txtRmtRmov = new JTextField(20);
        this.txtCnfrm = new JTextField(10);

        this.btnRmovRm = new JButton("Remove");
        this.btnMngHtlBck = new JButton("Back to Manage Hotel");

        this.txtFdbck = new JLabel();

        card4_3.add(new JLabel("Enter room name to remove"));
        card4_3.add(this.txtRmtRmov);

        card4_3.add(this.btnRmovRm);
        card4_3.add(this.btnMngHtlBck);
        card4_3.add(this.txtCnfrm);
        card4_3.add(this.txtFdbck);

        this.cards.add(card4_3, "Remove Room");
    }

    public String getTxtRmtRmov(){return txtRmtRmov.getName().toString();}

    public String getTxtCnfrm(){return this.txtCnfrm.getText().toString();}

    public void resetRmovRoom(){
        this.txtRmtRmov.setText("");
        this.txtCnfrm.setText("");
        this.txtFdbck.setText("");
    }

    public void setTxtConfirm(String confirm){this.txtCnfrm.setText(confirm);}

    public void setTxtFdbck(String feedback){this.txtFdbck.setText(feedback);}

    public void setBtnRmovRmListener(ActionListener al){
        if(this.btnRmovRm.getActionListeners().length == 0)
            this.btnRmovRm.addActionListener(al);
    }

    public void setBtnMngHtlBckListener(ActionListener al){
        if(this.btnMngHtlBck.getActionListeners().length == 0)
            this.btnMngHtlBck.addActionListener(al);
    }
}
