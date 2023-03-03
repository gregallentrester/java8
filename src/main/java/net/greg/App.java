package net.greg;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

/**
 * count occurence of each letter
 * frequencyMap
 */

public class App {

	private static final String model = "abcabacc";

	public static void main(String[] any) {
		App app = new App();

		// app.letterCounter();
		// app.forEach();
		// app.min();
		// app.reduceToOneElement();
		// app.toArray();
		// app.filter();
		// app.functionIdentity();
		app.fibber(9);
		// System.err.println(app.fib(9));
	}


	/*
	 * https://bit.ly/3sYbs0T
	 * https://mkyong.com/java8/java-8-stream-iterate-examples/
   * https://mkyong.com/java/java-fibonacci-examples/
	 */
	 private void fibber(int limit) {

		 Stream.iterate(						// three args
				new int[] {0,1}, 				// seed
				t -> new int[] {t[1], 	// Predicate hasNext
				t[0] + t[1]})					  // unaryOperator next
    .limit(limit)
  		.map(t -> t[0])
  			.forEach(t -> System.err.println(t));
	}


	private int fib(int any) {

		if (any <= 1) return any;

    return fib(any-1) + fib(any-2);
	}

	private void functionIdentity() {

    Function<Integer, Integer> identityFunction = Function.identity();
    System.err.println(identityFunction.apply(10));

    List<String> names =
			Arrays.asList("Peter", "Martin", "John");

    names.stream().
		  map(Function.identity()).
			  forEach(System.out::println);
  }


	private void letterCounter() {
		Map<Character, Integer> frequencyMap = new HashMap();

		for (char key : model.toCharArray()) {

			frequencyMap.
				merge(key, 1, Integer::sum);
		}

		System.err.println("\nfrequencyMap\n" + frequencyMap);
	}

	private void forEach() {

		List<String> array = new ArrayList();

		array.add("one");
		array.add("two");
		array.add("three");

		array.forEach(o -> System.out.print(o + ", "));
	}


	private void min() {

		List<String> array = new ArrayList();

		array.add("abc");
		array.add("def");

		Optional<String> min =
			array.stream().min((val1, val2) -> {
			 return val1.compareTo(val2);
		  });

		String minString = min.get();

		System.out.println(minString);
	}


	private void reduceToOneElement() {

		List<String> array = new ArrayList();

		array.add("One nest");
		array.add("To bird");
		array.add("To tree");

		Optional<String> reduced =
			array.stream().
				reduce((s, x) -> {
    			return s + " + " + x;
		});

		System.err.println(reduced.get());
	}


	private void toArray() {

		List<String> array = new ArrayList();

		array.add("One nest");
		array.add("To bird");
		array.add("To tree");

		Object[] items =
			array.stream().toArray();

    Arrays.asList(items).
			stream().
				forEach(x -> System.err.println(x));
	}


	private void filter() {

		List<String> array = new ArrayList();

		array.add("One nest");
		array.add("To bird");
		array.add("To tree");

		Stream<String> result =
			array.stream().filter(x -> x.length() > 7);

		result.forEach(y -> System.err.print(y + ", " + y.length()));
	}

}
