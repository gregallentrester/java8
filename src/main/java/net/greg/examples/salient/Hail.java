package net.greg.examples.salient;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;


/**
 * https://www.tutorialspoint.com/java8/index.htm
 * https://www.tutorialspoint.com/java8/java8_streams.htm
 * https://www.tutorialspoint.com/java8/java8_lambda_expressions.htm
 * https://www.tutorialspoint.com/java8/java8_functional_interfaces.htm
 */
public class Hail {

  public static void main(String[] args) {

      // new Hail().optional();
      // new Hail().forEach();
      // new Hail().map();
      //new Hail().flatmap();

       new Hail().filter();
      // new Hail().sort();
      // new Hail().lambdas()

      // new Hail().func();
      // new Hail().dates();
  }


  private void lambdas() {

    // parenthesis optional
    Service service = (x) ->
      System.err.println("Part 1 " + x);

    service.appendThis("Part 2");
  }

  private void sort() {

    List<String> model =
      Arrays.asList("yz", "cd", "ef", "ab", "gh", "ef");

    Collections.sort(model);

   // Let us print the sorted list
   System.err.println(
     "List after the use of " +
     " Collection.sort(): \n" +
     model);

    model.stream().
      limit(4).sorted().
        forEach(System.err::println);
  }


  private void filter() {

    List<String> model =
      Arrays.asList("yz","", "cd", "yz", "", "ab", "ab" );

    long hasContentCount =
      model.stream().
        filter(x -> ! x.isEmpty()).count();

    System.err.println(hasContentCount);
  }


  private void forEach() {

    String [] model =
      { "1","2","3","4","5","6","7","8","9","-END\n" };

    List list = Arrays.asList(model);

    list.forEach(System.err::println);
  }


  private void map() {

    List<Integer> model =
      Arrays.asList(3, 2, 2, 5);

    // list of unique squares
    List<Integer> squaresList =
      model.stream().
        map(x -> x*x).
          distinct().
            collect(Collectors.toList());

    squaresList.forEach(System.err::println);
  }


  private void flatmap() {

    List<Integer> primes = Arrays.asList(5, 7, 11,13);
    List<Integer> odds = Arrays.asList(1, 3, 5);
    List<Integer> evens = Arrays.asList(2, 4, 6, 8);

    List<List<Integer>> threeDimList =
      Arrays.asList(primes, odds, evens);

    System.err.println("\n\nflatmap(): \n\nthreeDimList \n" + threeDimList);

    List<Integer> flatlist  =
      threeDimList.
        stream().
          flatMap(list -> list.stream()).
            collect(Collectors.toList());

    System.err.println("\nflattened \n" + flatlist + "\n\n");

    StringBuilder sb = new StringBuilder();

    flatlist.stream().sorted().forEach(sb::append);
    System.err.println("\nflattened/sorted \n" + sb);
  }

  private void optional() {

    Double balance = null;

    double scalar = Optional.ofNullable(balance).orElse(0.0);

    System.err.println("\nOptional, balance, scalar (s.b. - 0.0) - actual " + scalar);
  }



  private void dates() {

    LocalDateTime currentTime = LocalDateTime.now();
    System.err.println("LocalDateTime | " + currentTime);

    LocalDate date = currentTime.toLocalDate();
    System.err.println("\nToday | " + date);


    System.err.println(
      "Month (as Month) | " + currentTime.getMonth() +
        "\n    Day (as int) | " + currentTime.getDayOfMonth());

    currentTime = currentTime.withDayOfMonth(10).withYear(2000);
    System.err.println("\ncurrentTime.withDayOfMonth(10).withYear(2022) | " + date);

    date = LocalDate.of(2012, Month.DECEMBER, 12);
    System.err.println("\nLocalDate.of(2012, Month.DECEMBER, 12) | " + date);

    LocalTime time = LocalTime.of(22, 15);
    System.err.println("\nLocalTime.of(22, 15) | " + time);

    time = LocalTime.parse("20:15:30");
    System.err.println("\n20:15:30 | " + time);
  }


  /**
   * java.util.Function interfaces are used in lambda expressions.
   *
   * Predicate <T> - the only method test(Object) returns boolean,
   * and says that an object is tested to be true or false.
   */
  private void func() {

    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

    // new Predicate<Integer> predicate
    System.err.println("All numbers:");
    pushStackFrame(list, z -> true);

    // new Predicate<Integer> predicate
    System.err.println("Even numbers:");
    pushStackFrame(list, z -> z % 2 == 0);

    // new Predicate<Integer> predicate
    System.err.println("Numbers > 3:");
    pushStackFrame(list, z -> z > 3);

  }

  public static void pushStackFrame(
      List<Integer> list, Predicate<Integer> p) {

    for (Integer n: list) {

      if (p.test(n)) {
        System.err.println(n + " ");
      }
    }
  }

}
