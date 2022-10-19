import java.util.*;

public class Packet {
    public String version;
    public String type;
    public String id;
    public String value;
    public List<Packet> subPackets = new ArrayList<Packet>();
    public String packet;

    public Packet(String packet) {
        this.version = String.valueOf(Integer.parseInt(packet.substring(0, 3), 2));
        this.type = String.valueOf(Integer.parseInt(packet.substring(3, 6), 2));
        this.id = String.valueOf(Integer.parseInt(packet.substring(7, 8), 2));
        this.value = packet.substring(8);

        if(!type.equals("4"))
            getSubPackets();
        else
            getPacket();
    }

    private void getSubPackets() {
        if(id.equals("0")) {
            Packet subPacket = new Packet(value.substring(0, 15));
            subPackets.add(subPacket);
        }
        else if(id.equals("1")) {
            Packet subPacket = new Packet(value.substring(0, 11));
            subPackets.add(subPacket);
        }
    }

    private void getPacket() {
        String value = "";
            int pos = 6;

            boolean last = false;

            while(last != true) {

                String string = bin.substring(pos+1, pos+5);
                String num = String.valueOf(Integer.parseInt(bin.substring(pos, pos+5)));

                value = value + string;
                pos += 5;

                if(num.length() < 5) {
                    last = true;
                }
            }
    }
}
