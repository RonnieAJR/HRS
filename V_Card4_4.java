import javax.swing.*;
import java.awt.event.ActionListener;

public class V_Card4_4 {
    private JPanel cards;

    private JComboBox<Integer> cmbxDay;
    private JTextField txtPrcMod, txtCnfrm;
    private JButton btnMdfyPrc, btnMngHtlBck;
    private JLabel txtFdbck;

    public V_Card4_4(JPanel cards){
        this.cards = cards;
        JPanel card4_4 = new JPanel();

        int i;

        this.cmbxDay = new JComboBox<>();
        for(i = 1; i <= 31; i++)
            this.cmbxDay.addItem(i);

        this.txtPrcMod = new JTextField(10);
        this.txtCnfrm = new JTextField();

        this.btnMdfyPrc = new JButton("Modify");
        this.btnMngHtlBck = new JButton("Back to Manage Hotel");

        this.txtFdbck = new JLabel();

        card4_4.add(new JLabel("Choose Day to Modify:"));
        card4_4.add(this.cmbxDay);

        card4_4.add(new JLabel("Input percentage to modify price"));
        card4_4.add(this.txtPrcMod);

        card4_4.add(this.btnMdfyPrc);
        card4_4.add(this.btnMngHtlBck);
        card4_4.add(this.txtCnfrm);
        card4_4.add(this.txtFdbck);

        this.cards.add(card4_4, "Modify Day Price");
    }

    public double getTxtPrcMod(){return Double.parseDouble(txtPrcMod.getText());}

    public int getCmbxDayItem(){return (int) this.cmbxDay.getSelectedItem();}

    public void resetMdfyPrc(){
        this.txtPrcMod.setText("");
        this.txtCnfrm.setText("");
        this.txtFdbck.setText("");
    }

    public void setTxtConfirm(String confirm){this.txtCnfrm.setText(confirm);}

    public void setTxtFdbck(String feedback){this.txtFdbck.setText(feedback);}

    public void setBtnMdfyPrcListener(ActionListener al){
        if(this.btnMdfyPrc.getActionListeners().length == 0)
            this.btnMdfyPrc.addActionListener(al);
    }

    public void setBtnMngHtlBckListener(ActionListener al){
        if(this.btnMngHtlBck.getActionListeners().length == 0)
            this.btnMngHtlBck.addActionListener(al);
    }
}
