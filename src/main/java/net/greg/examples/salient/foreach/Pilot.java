package net.greg.examples.salient.foreach;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;


/**
  https://bit.ly/3tB1xjl | POM MODS-11
 */
public class Pilot {

  private static final Map<String, Integer> map = new HashMap();

  private static final List<String> list = new ArrayList();

  private static final List<String> list2;


  static {

    map.put(null, 10);
    map.put("B", 20);
    map.put("C", null);
    map.put("D", 40);
    map.put("E", 50);

    list.add("A");
    list.add(null);
    list.add("C");

    String[] any =
      new String[] { "1", "2", "3" };

    list2 = Arrays.asList("1", "2", "3");
  }


  public static void main(String ... args) {

    Pilot pilot = new Pilot();

    /// pilot.loopMap();
    /// pilot.loopList();
    pilot.loopListViaConsumer();
  }


  private final void loopMap() {

    System.err.println("\n\nloopMap()\n");

    // lambda
    map.forEach(
      (k, v) -> {

        if (null != k && null != v) {

          System.err.println(
            "Key: " + k + ", Val: " + v);
        }
      }
    );
  }


  private final void loopList() {

    System.err.println("\n\nloopList()\n");

    // lambda
    list.forEach(x -> System.err.println(x));

    // emthod reference
    list.forEach(System.err::println);


    // filter null value
    list.stream().
      filter(Objects::nonNull).
        forEach(System.err::println);
  }


  private final void loopListViaConsumer() {

    Consumer<String> method =
      (n) -> { System.out.println(n); };

    list.forEach(method);
  }

  public static final String RED = "\033[1;91m";
  public static final String GRN = "\033[1;92m";
  public static final String YLW = "\033[1;93m";
  public static final String NC = "\u001B[0m";
}
