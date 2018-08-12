import java.io.IOException;

public class Bat {

	public static void main(String[] args) {
		try {
			Runtime.
			   getRuntime().
			   exec("cmd /c start \"\"  d:\\test.bat");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
