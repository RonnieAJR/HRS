import javax.swing.*;
import java.awt.event.ActionListener;

public class V_Card4_1 {
    private JPanel cards;

    private JTextField txtnewHtlNm;
    private JButton btnRnm, btnMngHtlBck;
    private JLabel fdbckRnmHtl;

    public V_Card4_1(JPanel cards){
        this.cards = cards;
        JPanel card4_1 = new JPanel();

        this.txtnewHtlNm = new JTextField(20);

        this.fdbckRnmHtl = new JLabel();

        this.btnRnm = new JButton("Rename");
        this.btnMngHtlBck = new JButton("Back to Manage Hotel");

        card4_1.add(new JLabel("Enter new Hotel Name:"));
        card4_1.add(this.txtnewHtlNm);

        card4_1.add(this.btnRnm);
        card4_1.add(this.fdbckRnmHtl);
        card4_1.add(this.btnMngHtlBck);

        this.cards.add(card4_1, "Rename Hotel");
    }

    public String getTxtnewHtlNm(){return this.txtnewHtlNm.getText().toString();}

    public void resetRnmHtl(){
        this.txtnewHtlNm.setText("");
        this.fdbckRnmHtl.setText("");
    }

    public void setFdbckRnmHtl(String fdbck){this.fdbckRnmHtl.setText(fdbck);}

    public void setBtnRnmListener(ActionListener al){
        if(this.btnRnm.getActionListeners().length == 0)
            this.btnRnm.addActionListener(al);
    }

    public void setBtnMngHtlBckListener(ActionListener al){
        if(this.btnMngHtlBck.getActionListeners().length == 0)
            this.btnMngHtlBck.addActionListener(al);
    }

}
