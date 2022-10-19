import java.util.Arrays;
import java.util.List;

public class Step1 {

	public static void main(String[] args) {
		List<String> binary = Arrays.asList("11", "100101100011", "100101001001001100011", "100101001001001010010010001000001000100010100011");
		binary.stream().forEach(s -> System.out.println(Long.parseLong(s,2) + " "));
	}
}