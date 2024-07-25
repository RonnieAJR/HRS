import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class V_Card2{
	private JPanel cards;
	
	private JTextField txtHtlName, txtPrice;
	private JComboBox<Integer> cmbxCap;
	private JButton btnCreHtlTry, btnMaiMenBck;
	private JLabel fdbckCreHtl;
	
	public V_Card2(JPanel cards){
		this.cards = cards;
		
		JPanel card2 = new JPanel();
		
		this.txtHtlName = new JTextField(20);
		this.txtPrice = new JTextField(20);
		this.btnCreHtlTry = new JButton("Create Hotel");
		this.fdbckCreHtl = new JLabel();
		this.btnMaiMenBck = new JButton("Back to Main Menu");
		
		this.cmbxCap = new JComboBox<>();
		for(int i = 1; i <= 50; i++){
			this.cmbxCap.addItem(i);
		}	
		
		card2.add(new JLabel("Enter Hotel Name"));
		card2.add(this.txtHtlName);
		
		card2.add(new JLabel("Enter Hotel Capacity"));
		card2.add(this.cmbxCap);
		
		card2.add(new JLabel("Enter Price per Night"));
		card2.add(this.txtPrice);
		
		card2.add(this.btnCreHtlTry);
		card2.add(this.fdbckCreHtl);
		card2.add(this.btnMaiMenBck);
		
		this.cards.add(card2, "Create Hotel");
	}
	
	// card 2 listeners and getters and setters
	public String getTxtHtlName(){
		return this.txtHtlName.getText().toString();
	}
	
	public int getCmbxCapItem(){
		return (int) this.cmbxCap.getSelectedItem();
	}
	
	public double getTxtPrice(){
		return Double.parseDouble(this.txtPrice.getText());
	}
	
	public void setFdbckCreHtl(String fdbck){
		this.fdbckCreHtl.setText(fdbck);
	}
	
	public void resetCreHtl(){
		this.txtHtlName.setText("");
		this.txtPrice.setText("");
		this.cmbxCap.setSelectedIndex(0);
	}
	
	public void clearFdbck(){
		this.fdbckCreHtl.setText("");
	}
	
	public void setBtnCreHtlTryListener(ActionListener al){
		this.btnCreHtlTry.addActionListener(al);
	}
	
	public void setBtnMaiMenBckListener(ActionListener al){
		this.btnMaiMenBck.addActionListener(al);
	}
	
}