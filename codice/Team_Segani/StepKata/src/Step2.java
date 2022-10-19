package com.company;

import java.util.*;

public class Step2 {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("304", "9227", "D25130", "F31FE66F790C", "52D084A5BA6E69", "725C8E3F8BCF319FB68");
        Map<String, String> hexaToBinary = initializeMap();
        stringList.forEach(s -> {
            StringBuilder toMap = new StringBuilder();
            for(char x: s.toCharArray()){
                toMap.append(hexaToBinary.get(String.valueOf(x)));
            }
            versioningToMap(toMap.toString());
        });
    }

    private static void versioningToMap(String toString) {
        Long version = binaryToLong(toString.substring(0, 3));
        System.out.println("Version:" + version);
        version = binaryToLong(toString.substring(3, 6));
        System.out.println("ID:" + version);
        decodeBinary(toString.substring(6));
    }

    private static void decodeBinary(String number) {
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

        System.out.println("Numero decodificato: " + binaryToLong(binary.toString()));
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
