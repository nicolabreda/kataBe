package it.paoloalfonso.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {

    private static List<String> values = Arrays.asList("304", "9227", "D25130", "F31FE66F790C", "52D084A5BA6E69", "725C8E3F8BCF319FB68");

    public static void main(String[] args) {
        values.stream().forEach(v -> {
            String binary = CodificaBinaria.convertHexToBinary(v);
            Pacchetto pacchetto = CodificaBinaria.convertBinaryString(binary);
            Long numero = CodificaBinaria.convertMessageToBinary(pacchetto.getMessage());
            System.out.println(String.format("Binary %s;\n Pacchetto: %s\n, numero: %s", binary, pacchetto, numero));
        });
    }

}
