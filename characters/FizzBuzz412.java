package com.leetcode.characters;

import java.util.ArrayList;
import java.util.List;

/*
* 3의 배수 fizz
* 5의 배수 buzz
* */
public class FizzBuzz412 {
	public List<String> fizzBuzz(int n) {
		List<String> res = new ArrayList<>();

		for(int i = 1; i <= n; i++) {
			if(i % 3 == 0 && i % 5 == 0) {
				res.add("FizzBuzz");
				continue;
			}
			if(i % 3 == 0 ) res.add("Fizz");
			else if(i % 5 == 0 ) res.add("Buzz");
			else res.add(Integer.toString(i));
		}

		return res;
	}
}
