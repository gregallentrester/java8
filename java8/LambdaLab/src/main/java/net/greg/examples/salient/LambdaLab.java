package net.greg.examples.salient;

import java.awt.*;
import java.awt.event.*;

// https://blog.jooq.org/2015/11/10/beware-of-functional-programming-in-java/
public class LambdaLab {

  private static final Frame frame =
    new Frame("ActionListener Before Java8");

  private static final Button button =
    new Button("Click Here");

  static {
    button.setBounds(50,100,80,50);
  }


  public static void main(String[] args) {

    LambdaLab app =
      new LambdaLab();

    app.buttonListenerOldWay4LinesNoLeak(button);
    app.buttonListenerNewWay3LinesCanLeak(button);

    frame.add(button);
  }

  void buttonListenerOldWay4LinesNoLeak(Button b) {

    b.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) { System.out.println("Hello World!"); }});
  }

  void buttonListenerNewWay3LinesCanLeak(Button b) {

    b.addActionListener(e -> System.out.println("Hello World!"));
  }
}
