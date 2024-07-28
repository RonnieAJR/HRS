import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class V_Card5 {
    private JPanel cards;

    private JTextField txtGstNme, txtDscntCde;
    private JComboBox<Integer> cmbxChkIn, cmbxChkOut;
    private JComboBox<String> cmbxRmTyp, cmbxHtls;
    private JButton btnApplDisc, btnBook, btnMaiMenBck;
    private JLabel txtFdbck;

    public V_Card5(JPanel cards){
        this.cards = cards;
        JPanel card5 = new JPanel(new BorderLayout());

        //header
		JLabel header = new JLabel("Simulate Booking", JLabel.CENTER);
		header.setFont(new Font("Default", Font.PLAIN, 20));
		card5.add(header, BorderLayout.NORTH);

        this.txtGstNme = new JTextField(20);
        this.txtDscntCde = new JTextField(15);

        int i;
        this.cmbxChkIn = new JComboBox<>();
        this.cmbxChkOut = new JComboBox<>();
        for(i = 1; i <= 31; i++) {
            if(i != 31)
                cmbxChkIn.addItem(i);
            if(i != 1)
                cmbxChkOut.addItem(i);
        }

        this.cmbxHtls = new JComboBox<>();
        this.cmbxRmTyp = new JComboBox<>();
        this.cmbxRmTyp.addItem("Standard");
        this.cmbxRmTyp.addItem("Deluxe");
        this.cmbxRmTyp.addItem("Executive");

        this.btnBook = new JButton("Book");
        this.btnMaiMenBck = new JButton("Back to Main Menu");

        this.txtFdbck = new JLabel();

        // Central panel for labels and text fields
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Dimension textFieldSize = new Dimension(300, 20);

        //Choose Hotel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Choose hotel to book"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(this.cmbxHtls, gbc);


        //Guest Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(new JLabel("Enter Guest Name:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.txtGstNme = new JTextField(20);
        this.txtGstNme.setPreferredSize(textFieldSize);
        centerPanel.add(this.txtGstNme, gbc);


        //Room Type Selector
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Choose Room Type"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(this.cmbxRmTyp, gbc);


        //Check in Day Selector
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Choose Check in Day"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(this.cmbxChkIn, gbc);

        //Check in Day Selector
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        centerPanel.add(new JLabel("Choose Check out Day"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(this.cmbxChkOut, gbc);

        //Guest Name
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(new JLabel("Enter Discount Code (optional):"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.txtDscntCde = new JTextField(20);
        this.txtDscntCde.setPreferredSize(textFieldSize);
        centerPanel.add(this.txtDscntCde, gbc);

        card5.add(centerPanel, BorderLayout.CENTER);
        
        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(this.btnBook);
        buttonPanel.add(this.btnMaiMenBck);

        // Panel for feedback label and buttons
        JPanel feedbackPanel = new JPanel(new BorderLayout());
        this.txtFdbck.setHorizontalAlignment(JLabel.CENTER);
        feedbackPanel.add(buttonPanel, BorderLayout.SOUTH);
        feedbackPanel.add(this.txtFdbck, BorderLayout.CENTER);

        card5.add(feedbackPanel, BorderLayout.SOUTH);

        this.cards.add(card5, "Simulate Booking");
    }

    public String getCmbxHtls(){return this.cmbxHtls.getSelectedItem().toString();}

    public String getTxtGstNme(){return this.txtGstNme.getText().toString();}

    public String getTxtDscntCde(){return this.txtDscntCde.getText().toString();}

    public int getCmbxChkInItem(){return (int) this.cmbxChkIn.getSelectedItem();}

    public int getCmbxChkOutItem(){return (int) this.cmbxChkOut.getSelectedItem();}

    public String getCmbxRmItem(){return this.cmbxRmTyp.getSelectedItem().toString();}

    public void resetSim(){
        this.txtGstNme.setText("");
        this.txtDscntCde.setText("");
        this.txtFdbck.setText("");
		this.cmbxChkIn.setSelectedIndex(0);
		this.cmbxChkOut.setSelectedIndex(0);
        this.cmbxRmTyp.setSelectedIndex(0);
        this.cmbxHtls.setSelectedIndex(0);

    }

    public void setCmbxHtls(String[] hotels){
        this.cmbxHtls.removeAllItems();
        for(String hotel : hotels){
            this.cmbxHtls.addItem(hotel);
        }
    }

    public void setTxtFdbck(String Fdbck){
        this.txtFdbck.setText(Fdbck);
    }

    public void setBtnApplDisc(ActionListener al){
        if(this.btnApplDisc.getActionListeners().length == 0)
            this.btnApplDisc.addActionListener(al);
    }

    public void setBtnBook(ActionListener al){
        if(this.btnBook.getActionListeners().length == 0)
            this.btnBook.addActionListener(al);
    }

    public void setBtnMaiMenBck(ActionListener al){
        if(this.btnMaiMenBck.getActionListeners().length == 0)
            this.btnMaiMenBck.addActionListener(al);
    }
}
