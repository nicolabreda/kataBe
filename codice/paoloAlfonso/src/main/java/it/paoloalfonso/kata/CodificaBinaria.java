package it.paoloalfonso.kata;

import java.util.HashMap;
import java.util.Map;

public class CodificaBinaria {

    private static Map<Character, String> hexMap = new HashMap<>();

    static {
        hexMap.put('0', "0000");
        hexMap.put('1', "0001");
        hexMap.put('2', "0010");
        hexMap.put('3', "0011");
        hexMap.put('4', "0100");
        hexMap.put('5', "0101");
        hexMap.put('6', "0110");
        hexMap.put('7', "0111");
        hexMap.put('8', "1000");
        hexMap.put('9', "1001");
        hexMap.put('A', "1010");
        hexMap.put('B', "1011");
        hexMap.put('C', "1100");
        hexMap.put('D', "1101");
        hexMap.put('E', "1110");
        hexMap.put('F', "1111");
    }

    public static Long calculateDecimalFromBinary(String binaryNumber) {
        return Long.parseLong(binaryNumber, 2);
    }

    public static String convertHexToBinary(String hexString) {
        char[] hexChars = hexString.toCharArray();
        String binString = "";
        for(char hexChar : hexChars) {
            binString += hexMap.get(hexChar);
        }
        return binString;
    }

    public static Pacchetto convertBinaryStringToPackage(String binaryString) {
        String version = binaryString.substring(0, 3);
        String type = binaryString.substring(3, 6);
        String message = binaryString.substring(6);
        return new Pacchetto(binaryString, calculateDecimalFromBinary(version), calculateDecimalFromBinary(type), message);
    }

    public static Long convertMessageToBinary(String message) {
        Integer numberOfBlocks = message.length() / 5;
        String converted = "";
        if(message.length() % 5 > 0) numberOfBlocks++;
        for(int i = 0; message.length() % 5 > 0 ? i < numberOfBlocks - 1 : i < numberOfBlocks; i++) {
            String block = message.substring(i * 5, (i + 1) * 5);
            boolean hasNext = block.charAt(0) == '1';
            converted += block.substring(1, 5);
            if(!hasNext) break;
        }
        return Long.parseLong(converted,2);
    }

    public static Integer translateGenericPackage(String stringToConvert) {
        String binary = convertHexToBinary(stringToConvert);
        Pacchetto pacchetto = convertBinaryStringToPackage(binary);
        Long type = pacchetto.getType();
        Integer sumVersions = 0;
        if(type == 4) {

        } else {
            Integer idLength = Integer.parseInt(pacchetto.getBinaryPackage().substring(6, 7));
            String binaryPackage = pacchetto.getBinaryPackage();
            Integer lengthIndex = idLength == 0 ? 22 : 18;
            Long subPackageLength = calculateDecimalFromBinary(binaryPackage.substring(7, lengthIndex));
            Boolean isNumeric = false;
            while(!isNumeric) {
                String subPackage = binaryPackage.substring(22, subPackageLength.intValue() + 22);
                Long subPackageVersion = calculateDecimalFromBinary(subPackage.substring(0, 3));
                Long subPackageType = calculateDecimalFromBinary(subPackage.substring(3, 6));
                String subPackageMessage = subPackage.substring(6);
                sumVersions += subPackageVersion.intValue();
                isNumeric = subPackageType == 4;
                if(!isNumeric) {
                    translateGenericPackage(subPackageMessage);
                }
            }
        }
        return sumVersions;
    }

    public static Long calculateSubPackageLength(String messageLengthString) {
        return 0L;
    }

}
