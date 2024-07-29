import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class V_Card4_1 {
    private JPanel cards;

    private JTextField txtnewHtlNm;
    private JButton btnRnm, btnMngHtlBck;
    private JLabel fdbckRnmHtl;

    public V_Card4_1(JPanel cards){
        this.cards = cards;
        JPanel card4_1 = new JPanel(new BorderLayout());

        //header
		JLabel header = new JLabel("Rename Hotel", JLabel.CENTER);
		header.setFont(new Font("Default", Font.PLAIN, 20));
		card4_1.add(header, BorderLayout.NORTH);

        this.txtnewHtlNm = new JTextField(20);

        this.fdbckRnmHtl = new JLabel();

        this.btnRnm = new JButton("Rename");
        this.btnMngHtlBck = new JButton("Back to Manage Hotel");

        // Central panel for labels and text fields
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Dimension textFieldSize = new Dimension(300, 20);

        // Hotel Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(new JLabel("Enter New Hotel Name:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.txtnewHtlNm = new JTextField(20);
        this.txtnewHtlNm.setPreferredSize(textFieldSize);
        centerPanel.add(this.txtnewHtlNm, gbc);

        card4_1.add(centerPanel, BorderLayout.CENTER);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(this.btnRnm);
        buttonPanel.add(this.btnMngHtlBck);

        // Panel for feedback label and buttons
        JPanel feedbackPanel = new JPanel(new BorderLayout());
        this.fdbckRnmHtl.setHorizontalAlignment(JLabel.CENTER);
        feedbackPanel.add(buttonPanel, BorderLayout.SOUTH);
        feedbackPanel.add(this.fdbckRnmHtl, BorderLayout.CENTER);

        card4_1.add(feedbackPanel, BorderLayout.SOUTH);

        this.cards.add(card4_1, "Rename Hotel");
    }

    public String getTxtNewHtlNm(){return this.txtnewHtlNm.getText().toString();}

    public void resetRnmHtl(){
        this.txtnewHtlNm.setText("");
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
