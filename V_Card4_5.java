import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class V_Card4_5 {
    private JPanel cards;
    
    private JTextField txtUpdtNew;
    private JButton btnUpdt, btnMngHtlBck;
    private JLabel txtFdbck;

    public V_Card4_5(JPanel cards){
        this.cards = cards;
        JPanel card4_5 = new JPanel(new BorderLayout());

        //header
		JLabel header = new JLabel("Remove Room", JLabel.CENTER);
		header.setFont(new Font("Default", Font.PLAIN, 20));
		card4_5.add(header, BorderLayout.NORTH);

        this.txtUpdtNew = new JTextField(10);

        this.btnUpdt = new JButton("Update");
        this.btnMngHtlBck = new JButton("Back to Manage Hotel");

        this.txtFdbck = new JLabel();

        // Central panel for labels and text fields
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Dimension textFieldSize = new Dimension(300, 20);
        
        //Update Price
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(new JLabel("Input new price"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.txtUpdtNew = new JTextField(20);
        this.txtUpdtNew.setPreferredSize(textFieldSize);
        centerPanel.add(this.txtUpdtNew, gbc);

        card4_5.add(centerPanel, BorderLayout.CENTER);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(this.btnUpdt);
        buttonPanel.add(this.btnMngHtlBck);

        // Panel for feedback label and buttons
        JPanel feedbackPanel = new JPanel(new BorderLayout());
        this.txtFdbck.setHorizontalAlignment(JLabel.CENTER);
        feedbackPanel.add(buttonPanel, BorderLayout.SOUTH);
        feedbackPanel.add(this.txtFdbck, BorderLayout.CENTER);

        card4_5.add(feedbackPanel, BorderLayout.SOUTH);

        this.cards.add(card4_5, "Update Price");
    }

    public double getTxtUpdtNew(){return Double.parseDouble(txtUpdtNew.getText());}

    public void resetUpdtHtlPrc(){
        this.txtUpdtNew.setText("");
    }

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
