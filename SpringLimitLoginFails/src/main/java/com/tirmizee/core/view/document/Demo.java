package com.tirmizee.core.view.document;

public class Demo {

	public static void main(String[] args) {
		for (int i = 1; i <= 1000; i++) {
			String code = String.format("%06d", i);
			String update = "UPDATE Customers SET CustomerCode = '%s' WHERE CustomerId = %s;";
			System.out.println(String.format(update,code, i));
		}
		

	}

}
