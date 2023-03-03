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
public class HailLambdas {

  public static void main(String[] args) {
    new HailLambdas().
      // dates().
      // optional().
      // forEach().
      // map().
      // filter().
      // sort().
      // func();
      lambdas();
  }


  private HailLambdas lambdas() {

    // parenthesis optional
    GreetingService greetService = (message) ->
    System.out.println("Jesus " + message);

    greetService.sayMessage("Christ");

    return this;
  }

  interface GreetingService {
    void sayMessage(String message);
  }


  /**
   * java.util.Function interfaces are used in lambda expressions.
   *
   * Predicate <T> - the only method test(Object) returns boolean,
   * and says that an object is tested to be true or false.
   */
  private HailLambdas func() {

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

    return this;
  }

  public static void pushStackFrame(
      List<Integer> list, Predicate<Integer> p) {

    for (Integer n: list)
      if (p.test(n))
        System.err.println(n + " ");
 }


 private HailLambdas sort() {

    List<String> model =
      Arrays.asList("yz", "cd", "ef", "ab", "gh", "ef");

    model.stream().
    limit(4).sorted().
    forEach(System.err::println);

    return this;
 }


  private HailLambdas filter() {

    List<String> model =
      Arrays.asList("yz","", "cd", "yz", "", "ab", "ab" );

      long hasContentCount =
        model.stream().
        filter(any -> ! any.isEmpty()).count();

      System.err.println(hasContentCount);

    return this;
  }

  private HailLambdas forEach() {

    StringBuilder sb = new StringBuilder();

    String [] model = { "1","2","3","4","5","6","7","8","9","-END\n" };

    List list = Arrays.asList(model);

    for (int i=0; i < list.size(); i++) {
      sb.append(list.get(i));
    }

    list.forEach(sb::append);

    System.err.println(sb + "");

    return this;
  }


  private HailLambdas map() {

    List<Integer> model =
      Arrays.asList(3, 2, 2, 5);

    // list of unique squares
    List<Integer> squaresList =
      model.stream().
        map(any -> any*any).
        distinct().
        collect(Collectors.toList());

    squaresList.forEach(System.err::println);

    return this;
  }


  private HailLambdas optional() {

    Double balance = null;

    double scalar = Optional.ofNullable(balance).orElse(0.0);

    System.err.println("balance, scalar " + scalar);

    return this;
  }


  private HailLambdas dates() {

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

    return this;
  }
}
