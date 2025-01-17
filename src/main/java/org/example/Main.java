package org.example;

import java.util.Random;

public class Main {

    private static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("a");

      for (int i = 0; i<10; i++) {
            System.out.println(generateSevenDigitDouble());
        }
        //System.out.println(generateSevenDigitDouble());
    }

    //input
   /* public Line[] generateLines(int linesNum){
        Line[] lines = new Line[linesNum];
        for (int i = 0; i< lines.length; i++) {
            Point point1 = new Point()
        }
    }*/

/*    public static Line generateLine(){
      double x1 = generateSevenDigitDouble();

      while ()
      Point point1 = new Point()
      Line line = new Line()
    }

    public static Point generateLine(){

    }*/

    public static double generateSevenDigitDouble() {
        double num = random.nextDouble();
        num = (num * (9999.999 - 1000)) + 1000;
        num = Math.round(num*1000.000)/1000.000;
        return num;
    }

    // miyun

    // algo

   }
