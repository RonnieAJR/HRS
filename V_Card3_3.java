import javax.swing.*;

public class V_Card3_3 {
    private JPanel cards;

    private JComboBox<String> cmbxSlctRoom;
    private JTextField roomName, floor, pricePerNight;
    private JComboBox<Integer> cmbxDayAvail, cmbxDayReserved;

    public V_Card3_3(JPanel cards){
        this.cards = cards;

        JPanel card3_3 = new JPanel();

        this.cmbxSlctRoom = new JComboBox<>();

        this.roomName = new JTextField();
        this.roomName.setEditable(false);

        this.floor = new JTextField();
        this.floor.setEditable(false);

        this.pricePerNight = new JTextField();
        this.pricePerNight.setEditable(false);

        this.cmbxDayAvail = new JComboBox<>();
        this.cmbxDayReserved = new JComboBox<>();

        card3_3.add(new JLabel("Room Info"));

        card3_3.add(new JLabel("Select Room"));
        card3_3.add(this.cmbxSlctRoom);

        card3_3.add(new JLabel("Room Name:"));
        card3_3.add(this.roomName);

        card3_3.add(new JLabel("Room Floor:"));
        card3_3.add(this.floor);

        card3_3.add(new JLabel("Room Price Per Night:"));
        card3_3.add(this.pricePerNight);

        card3_3.add(new JLabel("Days Available:"));
        card3_3.add(this.cmbxDayAvail);

        card3_3.add(new JLabel("Days Reserved"));
        card3_3.add(this.cmbxDayReserved);

        this.cards.add(card3_3, "View Room");
    }

    //card 3_3 setters
    public void setCmbxSlctRoom(String[] roomNames){
        for(String roomName: roomNames)
            this.cmbxSlctRoom.addItem(roomName);
    }

    public void setRoomName(String roomName){
        this.roomName.setText(roomName);
    }

    public void setRoomFloor(char floor){
        this.floor.setText("" + floor);
    }

    public void setPricePerNight(double price){
        this.pricePerNight.setText("" + price);
    }

    public void setCmbxDayAvail(Integer[] dayAvail){
        for(Integer day: dayAvail)
            this.cmbxDayAvail.addItem(day);
    }

    public void setCmbxDayReserved(Integer[] dayReserved){
        for(Integer day: dayReserved)
            this.cmbxDayReserved.addItem(day);
    }
}
