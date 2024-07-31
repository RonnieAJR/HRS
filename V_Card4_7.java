//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
//public class V_Card4_7 {
//    private JPanel cards;
//
//    private JButton btnYes, btnNo, btnMainBck;
//    private JLabel txtFdbck;
//
//
//    public V_Card4_7(JPanel cards) {
//        this.cards = cards;
//        JPanel card4_7 = new JPanel(new BorderLayout());
//
//        // Header
//        JLabel header = new JLabel("Remove Hotel", JLabel.CENTER);
//        header.setFont(new Font("Default", Font.PLAIN, 20));
//        card4_7.add(header, BorderLayout.NORTH);
//
//        this.btnYes = new JButton("Yes");
//        this.btnNo = new JButton("No");
//        this.btnMainBck = new JButton("Back to Main Menu");
//        this.txtFdbck = new JLabel("L GUI");
//
//        // Central panel for labels and buttons
//        JPanel centerPanel = new JPanel(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets = new Insets(5, 5, 5, 5);
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.anchor = GridBagConstraints.CENTER;
//        centerPanel.add(new JLabel("          Remove Hotel?"), gbc);
//
//        gbc.gridy = 1;
//        JPanel yesNoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//        yesNoPanel.add(this.btnYes);
//        yesNoPanel.add(this.btnNo);
//        centerPanel.add(yesNoPanel, gbc);
//
//        gbc.gridy = 2;
//        centerPanel.add(this.btnMainBck, gbc);
//
//        card4_7.add(centerPanel, BorderLayout.CENTER);
//
//        // Panel for feedback label and buttons
//        JPanel feedbackPanel = new JPanel(new BorderLayout());
//        this.txtFdbck.setHorizontalAlignment(JLabel.CENTER);
//
//        feedbackPanel.add(this.txtFdbck, BorderLayout.CENTER);
//
//        card4_7.add(feedbackPanel, BorderLayout.SOUTH);
//
//        this.cards.add(card4_7, "Remove Hotel");
//    }
//
//    public void resetTxt(){
//        this.txtFdbck.setText("");
//    }
//
//    public void setTxtFdbck(String feedback){this.txtFdbck.setText(feedback);}
//
//    public void setBtnYesListener(ActionListener al){
//        if(this.btnYes.getActionListeners().length == 0)
//            this.btnYes.addActionListener(al);
//    }
//
//    public void setBtnNoListener(ActionListener al){
//        if(this.btnNo.getActionListeners().length == 0)
//            this.btnNo.addActionListener(al);
//    }
//
//    public void setBtnMainBckListener(ActionListener al){
//        if(this.btnMainBck.getActionListeners().length == 0)
//            this.btnMainBck.addActionListener(al);
//    }
//}
