import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class V_Card4_3 {
    private JPanel cards;

    private JTextField txtRmtRmov;
    private JButton btnRmovRm, btnMngHtlBck;
    private JLabel txtFdbck;

    public V_Card4_3(JPanel cards){
        this.cards = cards;
        JPanel card4_3 = new JPanel(new BorderLayout());

        //header
		JLabel header = new JLabel("Remove Room", JLabel.CENTER);
		header.setFont(new Font("Default", Font.PLAIN, 20));
		card4_3.add(header, BorderLayout.NORTH);

        this.txtRmtRmov = new JTextField(20);

        this.btnRmovRm = new JButton("Remove");
        this.btnMngHtlBck = new JButton("Back to Manage Hotel");

        this.txtFdbck = new JLabel();

        // Central panel for labels and text fields
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Dimension textFieldSize = new Dimension(300, 20);

        //Room to remove
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(new JLabel("Enter room to remove"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.txtRmtRmov = new JTextField(20);
        this.txtRmtRmov.setPreferredSize(textFieldSize);
        centerPanel.add(this.txtRmtRmov, gbc);

        card4_3.add(centerPanel, BorderLayout.CENTER);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(this.btnRmovRm);
        buttonPanel.add(this.btnMngHtlBck);

        // Panel for feedback label and buttons
        JPanel feedbackPanel = new JPanel(new BorderLayout());
        this.txtFdbck.setHorizontalAlignment(JLabel.CENTER);
        feedbackPanel.add(buttonPanel, BorderLayout.SOUTH);
        feedbackPanel.add(this.txtFdbck, BorderLayout.CENTER);

        card4_3.add(feedbackPanel, BorderLayout.SOUTH);

        this.cards.add(card4_3, "Remove Room");
    }

    public String getTxtRmtRmov(){return txtRmtRmov.getName().toString();}

    public void resetRmovRoom(){
        this.txtRmtRmov.setText("");
        this.txtFdbck.setText("");
    }

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
