import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci numero da convertire: ");
        String num = scanner.nextLine();

        System.out.println("Il valore decimale e': " + parseBin(num));
    }

    private static String parseBin(String binNum) {
        return String.valueOf(Long.parseLong(binNum, 2));
    }
}