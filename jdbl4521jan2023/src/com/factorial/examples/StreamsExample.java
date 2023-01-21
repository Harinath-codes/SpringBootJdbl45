package com.factorial.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamsExample {

	public static void main(String[] args) {
		//// q2 find the sum of square of even in list?
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		int ans = numbers.stream().filter(new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {

				return t % 2 == 0;
			}
		}).map(new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer t) {

				return t * t;
			}
		}).reduce(0, new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				return t + u;
			}

		});

		System.out.println("Value is " + ans);

		int val2 = numbers.stream()
				          .filter((i) -> i % 2 == 0)
				          .map((x) -> x * x)
				          .reduce(0, (i1, i2) -> i1 + i2);
		
		
		
		System.out.println("value 2 is " + val2);

	}

}
