import java.util.*;

public class Step3 {
    
    static HashMap<String, String> map = fillMap();
   
    public static void main(String[] args) {
    
        String packet = "100010100000000001001010100000000001101010000000000000101111010001111000";

        Packet mainPacket = new Packet(packet);

        return;


/*
        if(mainPacket.getType().equals("4")) {
            if(id.equals("0")) {
                int packetNum = Integer.parseInt(packet.substring(7, 22), 2);

                String subPacket = packet.substring(22);

                String val = "";
                StringBuilder sb = new StringBuilder();

                System.out.println(sb.toString());
                
            }
            else if(id.equals("1")) {
                int packetNum = Integer.parseInt(packet.substring(7, 18), 2);

            }
            */
        }
    


    static HashMap<String, String> fillMap() {

        HashMap<String, String> map = new HashMap<>();

        map.put("0000", "0");
        map.put("0001", "1");
        map.put("0010", "2");
        map.put("0011", "3");
        map.put("0100", "4");
        map.put("0101", "5");
        map.put("0110", "6");
        map.put("0111", "7");
        map.put("1000", "8");
        map.put("1001", "9");
        map.put("1010", "A");
        map.put("1011", "B");
        map.put("1100", "C");
        map.put("1101", "D");
        map.put("1110", "E");
        map.put("1111", "F");

        return map;
    }
}