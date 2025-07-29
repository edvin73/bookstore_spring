package com.edvin.projects.bookstore.util;

import org.springframework.stereotype.Service;

@Service
public class CalculateService {
	
		
	public int getSum(int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
	
	public int getFactorial(int number) {
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
