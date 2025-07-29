package com.edvin.projects.bookstore.util;

public class UtilClass {
	
	public int add(int a, int b, int c) {
		return a + b + c;
	}
	
	public int add(int a, int b) {
		return a + b;
	}
	
	public int calculateSum(int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
	
	public int calculateFactorial(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("Number must be non-negative");
		}
		if (number == 0 || number == 1) {
			return 1;
		}
		int result = 1;
		for (int i = 2; i <= number; i++) {
			result *= i;
		}
		return result;
	}

}
