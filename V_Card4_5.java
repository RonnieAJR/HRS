import javax.swing.*;
import java.awt.event.ActionListener;

public class V_Card4_5 {
    private JPanel cards;
    
    private JTextField txtUpdtNew, txtCnfrm;
    private JButton btnUpdt, btnMngHtlBck;
    private JLabel txtFdbck;

    public V_Card4_5(JPanel cards){
        this.cards = cards;
        JPanel card4_5 = new JPanel();
        
        this.txtUpdtNew = new JTextField(10);
        this.txtCnfrm = new JTextField();

        this.btnUpdt = new JButton("Update");
        this.btnMngHtlBck = new JButton("Back to Manage Hotel");

        this.txtFdbck = new JLabel();


        card4_5.add(new JLabel("Input new price"));
        card4_5.add(this.txtUpdtNew);

        card4_5.add(this.btnUpdt);
        card4_5.add(this.btnMngHtlBck);
        card4_5.add(this.txtCnfrm);
        card4_5.add(this.txtFdbck);

        this.cards.add(card4_5, "Update Hotel Price");
    }

    public double getTxtUpdtNew(){return Double.parseDouble(txtUpdtNew.getText());}

    public void resetUpdtHtlPrc(){
        this.txtUpdtNew.setText("");
        this.txtCnfrm.setText("");
        this.txtFdbck.setText("");
    }

    public void setTxtConfirm(String confirm){this.txtCnfrm.setText(confirm);}

    public void setTxtFdbck(String feedback){this.txtFdbck.setText(feedback);}

    public void setBtnUpdtListener(ActionListener al){
        if(this.btnUpdt.getActionListeners().length == 0)
            this.btnUpdt.addActionListener(al);
    }

    public void setBtnMngHtlBckListener(ActionListener al){
        if(this.btnMngHtlBck.getActionListeners().length == 0)
            this.btnMngHtlBck.addActionListener(al);
    }
}
