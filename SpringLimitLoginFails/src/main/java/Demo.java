

import java.util.Random;

public class Demo {

	public static void main(String[] args) {
		String code[] = {
				"37ef0f00-f20d-466d-97f6-06e9d7259af6.png",
				"23f59b33-9377-42f3-9086-324837f438f7.jpg",
				"200da470-1376-490c-b052-05a4c38a5196.png",
				"f3ab0b0a-6f49-40e6-a8b2-34c69fe6e867.jpg",
				"e0d38d86-8342-4281-863c-1a2f21bc6de8.png",
				"8bd01590-afe0-443b-b651-94bc72fa2b45.png"
			};
		for (int i = 1; i <= 1000; i++) {
			
//			String update = "UPDATE Products SET ProductImage = '%s' WHERE ProductId = %s;";
//			System.out.println(String.format(update,code[new Random().nextInt(code.length)], i));
			
			String update = "UPDATE Products SET ProductPrice = %s WHERE ProductId = %s;";
			System.out.println(String.format(update,new Random().nextInt(10000), i));
		}
		
	}

}
