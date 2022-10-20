package kata;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day16Writer {


    public static final int[] powerOf2 = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 5012, 1024, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152};

    public static final List<Packet> packets = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        Day16.fillDecoder();

        String full = "E20D7880532D4E551A5791BD7B8C964C1548CB3EC1FCA41CC00C6D50024400C202A65C00C20257C008AF70024C00810039C00C3002D400A300258040F200D6040093002CC0084003FA52DB8134DE620EC01DECC4C8A5B55E204B6610189F87BDD3B30052C01493E2DC9F1724B3C1F8DC801E249E8D66C564715589BCCF08B23CA1A00039D35FD6AC5727801500260B8801F253D467BFF99C40182004223B4458D2600E42C82D07CC01D83F0521C180273D5C8EE802B29F7C9DA1DCACD1D802469FF57558D6A65372113005E4DB25CF8C0209B329D0D996C92605009A637D299AEF06622CE4F1D7560141A52BC6D91C73CD732153BF862F39BA49E6BA8C438C010E009AA6B75EF7EE53BBAC244933A48600B025AD7C074FEB901599A49808008398142013426BD06FA00D540010C87F0CA29880370E21D42294A6E3BCF0A080324A006824E3FCBE4A782E7F356A5006A587A56D3699CF2F4FD6DF60862600BF802F25B4E96BDD26049802333EB7DDB401795FC36BD26A860094E176006A0200FC4B8790B4001098A50A61748D2DEDDF4C6200F4B6FE1F1665BED44015ACC055802B23BD87C8EF61E600B4D6BAD5800AA4E5C8672E4E401D0CC89F802D298F6A317894C7B518BE4772013C2803710004261EC318B800084C7288509E56FD6430052482340128FB37286F9194EE3D31FA43BACAF2802B12A7B83E4017E4E755E801A2942A9FCE757093005A6D1F803561007A17C3B8EE0008442085D1E8C0109E3BC00CDE4BFED737A90DC97FDAE6F521B97B4619BE17CC01D94489E1C9623000F924A7C8C77EA61E6679F7398159DE7D84C015A0040670765D5A52D060200C92801CA8A531194E98DA3CCF8C8C017C00416703665A2141008CF34EF8019A080390962841C1007217C5587E60164F81C9A5CE0E4AA549223002E32BDCEA36B2E100A160008747D8B705C001098DB13A388803F1AE304600";
        String primo = "D2FE28";
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

        System.out.println("0->" + stringNumToBin(0L));
        System.out.println("1->" + stringNumToBin(1L));
        System.out.println("2->" + stringNumToBin(2L));
        System.out.println("3->" + stringNumToBin(3L));
        System.out.println("4->" + stringNumToBin(4L));
        System.out.println("5->" + stringNumToBin(5L));
        System.out.println("65->" + stringNumToBin(65L));

        NumberPacket number = new NumberPacket(6, 4, true);
        number.val = 378432986423L;

        NumberPacket number1 = new NumberPacket(6, 4, true);
        number1.val = 3;
        NumberPacket number2 = new NumberPacket(2, 4, true);
        number2.val = 4;
        NumberPacket number3 = new NumberPacket(2, 4, true);
        number3.val = 2;
        FixedSubPacket fsp = new FixedSubPacket(6,1);
        fsp.packets.add(number1);
        fsp.packets.add(number2);
        fsp.packets.add(number3);

        NumberPacket number11 = new NumberPacket(6, 4, true);
        number11.val = 13;
        NumberPacket number21 = new NumberPacket(2, 4, true);
        number21.val = 4;
        NumberPacket number31 = new NumberPacket(2, 4, true);
        number31.val = 8;
        FixedSubPacket fsp1 = new FixedSubPacket(6,0);
        fsp1.packets.add(number11);
        fsp1.packets.add(number21);
        fsp1.packets.add(number31);

        VariableSubPacket vsp1 = new VariableSubPacket(1,6);
        vsp1.packets.add(fsp);
        vsp1.packets.add(fsp1);

        NumberPacket numberv1 = new NumberPacket(6, 4, true);
        numberv1.val = 10;
        NumberPacket numberv2 = new NumberPacket(2, 4, true);
        numberv2.val = 20;
        VariableSubPacket vsp = new VariableSubPacket(1,6);
        vsp.packets.add(numberv1);
        vsp.packets.add(numberv2);

        FixedSubPacket fsp11 = new FixedSubPacket(7,3);
        fsp11.packets.add(vsp1);
        fsp11.packets.add(number);



        System.out.println(fsp11.write());


        NumberPacket n1 = new NumberPacket(1, 4, true);
        n1.val=2;
        NumberPacket n2 = new NumberPacket(4, 4, true);
        n2.val=23;
        NumberPacket n3 = new NumberPacket(6, 4, true);
        n3.val=534;
        NumberPacket n4 = new NumberPacket(7, 4, true);
        n4.val=2412345123L;
        NumberPacket n5 = new NumberPacket(2, 4, true);
        n5.val=412353252153L;
        NumberPacket n6 = new NumberPacket(3, 4, true);
        n6.val=12412354345123512L;
        System.out.println(n1.write());
        System.out.println(n2.write());
        System.out.println(n3.write());
        System.out.println(n4.write());
        System.out.println(n5.write());
        System.out.println(n6.write());


        System.out.println(Day16.stringBinToNum("11"));
        System.out.println(Day16.stringBinToNum("100101100011"));
        System.out.println(Day16.stringBinToNum("100101001001001100011"));
        System.out.println(Day16.stringBinToNum("100101001001001010010010001000001000100010100011"));

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
        //System.out.println("->" + line);
        StringBuilder ret = new StringBuilder("");
        while (num > 0) {
            ret.insert(0, num % 2 == 0 ? "0" : "1");
            num /= 2;
        }

        return ret.toString();
    }
}


