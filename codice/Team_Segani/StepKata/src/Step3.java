package com.company;

import java.util.*;

public class Step3 {

    private static String lastBit = null;

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("620080001611562C8802118E34");
        Map<String, String> hexaToBinary = initializeMap();
        stringList.forEach(s -> {
            StringBuilder toMap = new StringBuilder();
            for(char x: s.toCharArray()){
                toMap.append(hexaToBinary.get(String.valueOf(x)));
            }
            List<CodifiedPacket> codifiedPacketList = new ArrayList<>();
            codifiedPacketList = versioningToMap(toMap.toString(), codifiedPacketList);
            Long totalVersion = 0L;
            for(CodifiedPacket c : codifiedPacketList){
                totalVersion = totalVersion + c.getVersion();
            }
            System.out.println("VERSIONE TOTALE: " + totalVersion);
        });
    }

    private static List<CodifiedPacket> versioningToMap(String toString, List<CodifiedPacket> codifiedPacketList) {
        System.out.println("String: " + toString);
        Long version = binaryToLong(toString.substring(0, 3));
        Long id = binaryToLong(toString.substring(3, 6));
        Long number = 0L;
        Integer lastBit;
        System.out.println("ID: " + id);
        System.out.println("VERSION: " + version);
        switch(String.valueOf(id)) {
            case "4":
                lastBit = decodeBinary(toString.substring(6), codifiedPacketList, version, id);
                break;
            default: lastBit = checkByte(toString.substring(6), codifiedPacketList);
        }
        codifiedPacketList.add(new CodifiedPacket(version, id, number, lastBit));
        return codifiedPacketList;
    }

    private static Integer checkByte(String substring, List<CodifiedPacket> codifiedPacketList) {
        System.out.println("STRING - ID - VERSION: " + substring);
        char bit = substring.charAt(0);
        if(bit == '0'){
            String size = substring.substring(1, 16);
            if(binaryToLong(size)<=0){
                System.out.println("ERRORE");
            }
            String nextPacket = substring.substring(16);
            System.out.println("PACCHETTO SUCCESSIVO: " + nextPacket);
            versioningToMap(nextPacket, codifiedPacketList);
        }else if(bit == '1'){
            String size = substring.substring(1, 12);
            //Ci prendiamo il numero di pacchetti
            if(binaryToLong(size)<=0){
                System.out.println("ERRORE");
            }
            String nextPacket = substring.substring(12);
            System.out.println("PACCHETTO SUCCESSIVO: " + nextPacket);
            versioningToMap(nextPacket, codifiedPacketList);
        }
        return null;
    }

    private static Integer decodeBinary(String number, List<CodifiedPacket> codifiedPacketList, Long version, Long id) {
        List<String> strings = new ArrayList<>();
        int index = 0;
        while (index < number.length()) {
            strings.add(number.substring(index, Math.min(index + 5,number.length())));
            index += 5;
        }
        StringBuilder binary = new StringBuilder();
        for(String x : strings){
            binary.append(x, 1, 5);
            if(x.charAt(0) == '0'){
                break;
            }
        }
        codifiedPacketList.add(new CodifiedPacket(version, id, binaryToLong(binary.toString()), null));
        return null;
    }

    public static Long binaryToLong(String arg){
        return Long.parseLong(arg,2);
    }

    private static Map<String, String> initializeMap() {
        Map<String, String> hexaToBinary = new HashMap<>();
        hexaToBinary.put("0", "0000");
        hexaToBinary.put("1", "0001");
        hexaToBinary.put("2", "0010");
        hexaToBinary.put("3", "0011");
        hexaToBinary.put("4", "0100");
        hexaToBinary.put("5", "0101");
        hexaToBinary.put("6", "0110");
        hexaToBinary.put("7", "0111");
        hexaToBinary.put("8", "1000");
        hexaToBinary.put("9", "1001");
        hexaToBinary.put("A", "1010");
        hexaToBinary.put("B", "1011");
        hexaToBinary.put("C", "1100");
        hexaToBinary.put("D", "1101");
        hexaToBinary.put("F", "1111");
        hexaToBinary.put("E", "1110");
        return hexaToBinary;
    }
}
