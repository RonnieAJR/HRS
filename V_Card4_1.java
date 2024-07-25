import javax.swing.*;
import java.awt.event.ActionListener;

public class V_Card4_1 {
    private JPanel cards;

    private JTextField txtnewHtlNm;
    private JButton btnSbmt, btnMngHtlBck;
    private JLabel fdbckRnmHtl;

    public V_Card4_1(JPanel cards){
        this.cards = cards;
        JPanel card4_1 = new JPanel();

        this.txtnewHtlNm = new JTextField(20);

        this.fdbckRnmHtl = new JLabel();

        this.btnSbmt = new JButton("Submit");
        this.btnMngHtlBck = new JButton("Back to Manage Hotel");

        card4_1.add(new JLabel("Enter new Hotel Name:"));
        card4_1.add(this.txtnewHtlNm);

        card4_1.add(this.btnSbmt);
        card4_1.add(this.fdbckRnmHtl);
        card4_1.add(this.btnMngHtlBck);

        this.cards.add(card4_1, "Rename Hotel");
    }

    public String getTxtnewHtlNm(){return this.txtnewHtlNm.getText().toString();}

    public void resetRnmHtl(){this.txtnewHtlNm.setText("");}

    public void clearFdbck(){this.fdbckRnmHtl.setText("");}

    public void setFdbckRnmHtl(String fdbck){this.fdbckRnmHtl.setText(fdbck);}

    public void setBtnSbmtListener(ActionListener al){this.btnSbmt.addActionListener(al);}

    public void setBtnMngHtlBckListener(ActionListener al){this.btnMngHtlBck.addActionListener(al);}

}
