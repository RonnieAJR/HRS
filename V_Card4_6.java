import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class V_Card4_6 {
    private JPanel cards;

    private JComboBox<Integer> cmbxRsrvId;
    private JButton btnRmovRsrv, btnMngHtlBck;
    private JLabel txtFdbck;

    public V_Card4_6(JPanel cards){
        this.cards = cards;
        JPanel card4_6 = new JPanel(new BorderLayout());

        //header
		JLabel header = new JLabel("Remove Reservation", JLabel.CENTER);
		header.setFont(new Font("Default", Font.PLAIN, 20));
		card4_6.add(header, BorderLayout.NORTH);

        this.cmbxRsrvId = new JComboBox<>();

        this.btnRmovRsrv = new JButton("Remove");
        this.btnMngHtlBck = new JButton("Back to Manage Hotel");

        this.txtFdbck = new JLabel();

        // Central panel for labels and text fields
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(new JLabel("Choose Reservation ID"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(this.cmbxRsrvId, gbc);

        card4_6.add(centerPanel, BorderLayout.CENTER);
        
        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(this.btnRmovRsrv);
        buttonPanel.add(this.btnMngHtlBck);

        // Panel for feedback label and buttons
        JPanel feedbackPanel = new JPanel(new BorderLayout());
        this.txtFdbck.setHorizontalAlignment(JLabel.CENTER);
        feedbackPanel.add(buttonPanel, BorderLayout.SOUTH);
        feedbackPanel.add(this.txtFdbck, BorderLayout.CENTER);

        card4_6.add(feedbackPanel, BorderLayout.SOUTH);

        this.cards.add(card4_6, "Remove Reservation");
    }
    public int getCmbxRsrvId(){return (int)this.cmbxRsrvId.getSelectedItem();}

    public void setCmbxRsrvId(Integer[] ids){
        for(Integer id : ids)
            this.cmbxRsrvId.addItem(id);
    }

    public void resetRmovRsrv(){
        this.cmbxRsrvId.setSelectedIndex(0);
        this.txtFdbck.setText("");
    }

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
