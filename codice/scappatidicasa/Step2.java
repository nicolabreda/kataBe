import java.util.HashMap;

public class Step2 {

    public static void main(String[] args) {
    
        String[] values = {
            "304",
            "9227",
            "D25130",
            "F31FE66F790C",
            "52D084A5BA6E69",
            "725C8E3F8BCF319FB68"
        };

        for(String val : values) {

            String bin = hexToBin(val);

            int version = Integer.parseInt(bin.substring(0, 3), 2);
            int type = Integer.parseInt(bin.substring(3, 6), 2);
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

            System.out.println("------------------------------");
            System.out.println("Version: " + version);
            System.out.println("Type: " + type);
            System.out.println("Value: " + Long.parseLong(value, 2));
        }
    }

    private static String hexToBin(String hex) {

        String val = "";

        HashMap<String, String> map = new HashMap<>();

        map.put("0", "0000");
        map.put("1", "0001");
        map.put("2", "0010");
        map.put("3", "0011");
        map.put("4", "0100");
        map.put("5", "0101");
        map.put("6", "0110");
        map.put("7", "0111");
        map.put("8", "1000");
        map.put("9", "1001");
        map.put("A", "1010");
        map.put("B", "1011");
        map.put("C", "1100");
        map.put("D", "1101");
        map.put("E", "1110");
        map.put("F", "1111");

        for(int i=0; i<hex.length(); i++) {
            String car = map.get(String.valueOf(hex.charAt(i)));
            val += car;
        }

        return val;
    }
}
