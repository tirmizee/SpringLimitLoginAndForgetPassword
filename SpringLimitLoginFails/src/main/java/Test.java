import java.util.Random;

public class Test {

	public static void main(String[] args) {
		for (int i = 0; i < 6; i++) {
			System.out.print(new Random().nextInt(21) + ",");
		}
	}

}
