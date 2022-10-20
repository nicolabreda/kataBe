package kata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Day16 {


    public static final Map<String, String> decoder = new HashMap<>();
    public static final int[] powerOf2 = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 5012, 1024, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152};

    public static final List<Packet> packets = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        fillDecoder();

        String full = "E20D7880532D4E551A5791BD7B8C964C1548CB3EC1FCA41CC00C6D50024400C202A65C00C20257C008AF70024C00810039C00C3002D400A300258040F200D6040093002CC0084003FA52DB8134DE620EC01DECC4C8A5B55E204B6610189F87BDD3B30052C01493E2DC9F1724B3C1F8DC801E249E8D66C564715589BCCF08B23CA1A00039D35FD6AC5727801500260B8801F253D467BFF99C40182004223B4458D2600E42C82D07CC01D83F0521C180273D5C8EE802B29F7C9DA1DCACD1D802469FF57558D6A65372113005E4DB25CF8C0209B329D0D996C92605009A637D299AEF06622CE4F1D7560141A52BC6D91C73CD732153BF862F39BA49E6BA8C438C010E009AA6B75EF7EE53BBAC244933A48600B025AD7C074FEB901599A49808008398142013426BD06FA00D540010C87F0CA29880370E21D42294A6E3BCF0A080324A006824E3FCBE4A782E7F356A5006A587A56D3699CF2F4FD6DF60862600BF802F25B4E96BDD26049802333EB7DDB401795FC36BD26A860094E176006A0200FC4B8790B4001098A50A61748D2DEDDF4C6200F4B6FE1F1665BED44015ACC055802B23BD87C8EF61E600B4D6BAD5800AA4E5C8672E4E401D0CC89F802D298F6A317894C7B518BE4772013C2803710004261EC318B800084C7288509E56FD6430052482340128FB37286F9194EE3D31FA43BACAF2802B12A7B83E4017E4E755E801A2942A9FCE757093005A6D1F803561007A17C3B8EE0008442085D1E8C0109E3BC00CDE4BFED737A90DC97FDAE6F521B97B4619BE17CC01D94489E1C9623000F924A7C8C77EA61E6679F7398159DE7D84C015A0040670765D5A52D060200C92801CA8A531194E98DA3CCF8C8C017C00416703665A2141008CF34EF8019A080390962841C1007217C5587E60164F81C9A5CE0E4AA549223002E32BDCEA36B2E100A160008747D8B705C001098DB13A388803F1AE304600";
        String primo = "D2FE28";  //110100101111111000101000
        String secondo = "38006F45291200";
        String terzo = "C200B40A82";
        String quarto = "04005AC33890";
        String quinto = "880086C3E88112";
        String sesto = "CE00C43D881120";
        String settimo = "9C0141080250320F1802104A08";
        String ottavo = "EE00D40C823060";
        String nono = "8A004A801A8002F478";
        String decimo = "620080001611562C8802118E34";
        String undicesimo = "C0015000016115A2E0802F182340";
        String dodicesimo = "A0016C880162017C3686B18A3D4780";

        String prove = "EE008E0066C600F41A845058401E8D508A234AE23CAF63D99C";
        String prove1 ="304";    //1 2
        String prove2 ="9227";  // 4    23
        String prove3 ="D25130";  //6    534
        String prove4 ="F31FE66F790C"; //7  2412345123
        String prove5 ="52D084A5BA6E69";//2   412353252153
        String prove6 ="725C8E3F8BCF319FB68";//3     12412354345123512

        String operazione = full;


        //File file = new File("/Users/nbreda/Progetti/sfidaUnicredit2021/data/day16");

        //BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedReader reader = new BufferedReader(new StringReader(operazione));

        String line = null;
        String decoded = null;

        long time = System.currentTimeMillis();
        while ((line = reader.readLine()) != null) {
            //System.out.println(line);
            decoded = decode(line);
            System.out.println(decoded);
        }

        for (int i = 0; i < decoded.length(); ) {
            //System.out.println("SONO IN " + i);
            //System.out.println(decoded.substring(i));
            if ((decoded.length() - i) < 10) {
                break;
            }
            int version = (int) stringBinToNum(decoded.substring(i, i + 3));
            int type = (int) stringBinToNum(decoded.substring(i + 3, i + 6));
            i = i + 6;
            System.out.println("version " + version);
            System.out.println("type " + type);
            Packet packet;
            if (type == 4) {
                packet = new NumberPacket(version, type, true);
            } else {
                int index = (int) stringBinToNum(decoded.substring(i, i + 1));
                //System.out.println("INDEX = " + index);
                i = i + 1;
                if (index == 0) {
                    packet = new VariableSubPacket(version, type);
                } else {
                    packet = new FixedSubPacket(version, type);
                }
            }
            i = packet.decode(decoded, i);
            packets.add(packet);
        }


        int sum = 0;

        for (Packet p : packets) {
            sum += p.sumVersion();
        }

        System.out.println("SIZE = " + packets.size());

        System.out.println("VALUE = " + packets.get(0).calculate());

        System.out.printf("sum= %d%n", sum);

        System.out.println("TIME : " + (System.currentTimeMillis() - time));

    }

    public static void fillDecoder() {
        decoder.put("0", "0000");
        decoder.put("1", "0001");
        decoder.put("2", "0010");
        decoder.put("3", "0011");
        decoder.put("4", "0100");
        decoder.put("5", "0101");
        decoder.put("6", "0110");
        decoder.put("7", "0111");
        decoder.put("8", "1000");
        decoder.put("9", "1001");
        decoder.put("A", "1010");
        decoder.put("B", "1011");
        decoder.put("C", "1100");
        decoder.put("D", "1101");
        decoder.put("E", "1110");
        decoder.put("F", "1111");


        decoder.put("0000", "0");
        decoder.put("0001", "1");
        decoder.put("0010", "2");
        decoder.put("0011", "3");
        decoder.put("0100", "4");
        decoder.put("0101", "5");
        decoder.put("0110", "6");
        decoder.put("0111", "7");
        decoder.put("1000", "8");
        decoder.put("1001", "9");
        decoder.put("1010", "A");
        decoder.put("1011", "B");
        decoder.put("1100", "C");
        decoder.put("1101", "D");
        decoder.put("1110", "E");
        decoder.put("1111", "F");
    }


    private static String decode(String line) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            builder.append(decoder.get(line.substring(i, i + 1)));
        }

        return builder.toString();
    }


    public static long stringBinToNum(String line) {
        //System.out.println("->" + line);
        long val = 0;
        int pos = line.length() - 1;
        for (int i : line.chars().toArray()) {
            int n = ((char) i) - '0';
            val += n * (long) Math.pow(2, pos--);
            //powerOf2[pos--];
        }

        return val;
    }

    public static String stringNumToBin(long num) {
        if(num==0){
            return "0";
        }
        //System.out.println("->" + line);
        StringBuilder ret = new StringBuilder("");
        while (num > 0) {
            ret.insert(0, num % 2 == 0 ? "0" : "1");
            num /= 2;
        }

        return ret.toString();
    }
}


