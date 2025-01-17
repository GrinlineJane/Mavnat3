package org.example;

import java.util.Random;

public class Main {

    private static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("a");

      for (int i = 0; i<10; i++) {
            System.out.println(generateSevenDigitDouble());
        }
        Line[] lines = generateLines(100);
    }

    //input
    public static Line[] generateLines(int linesNum){
        Line[] lines = new Line[linesNum];
        for (int i = 0; i< lines.length; i++) {
            lines[i] = generateLine();
        }
        return lines;
    }

   public static Line generateLine(){
      double x1 = generateSevenDigitDouble();
      while (x1 == 9999.999){
          x1 = generateSevenDigitDouble();
      }
      double x2 = generateSevenDigitDouble();

      while (x2 <= x1){
          x2 = generateSevenDigitDouble();
      }

      Point startPoint = new Point(x1, generateSevenDigitDouble());
      Point endPoint = new Point(x2, generateSevenDigitDouble());
      return new Line(startPoint, endPoint);
    }

    public static double generateSevenDigitDouble() {
        double num = random.nextDouble();
        num = (num * (9999.999 - 1000)) + 1000;
        num = Math.round(num*1000.000)/1000.000;
        return num;
    }

    // miyun

    // algo

    public static void findMaxLines(Line[] sortedByStart, Line[] sortedByFinish) {
        int startIndex = 0;
        int endIndex = 0;
        double k = sortedByStart[0].getP1().getX();
        int maxLinesIndex= 0;
        int linesNum = 1; // because k is already at first point
        int maxLinesNum = 0;
        while (startIndex < sortedByStart.length){
            if(sortedByStart[startIndex].getP1().getX() <= sortedByFinish[endIndex].getP2().getX()){
                if(sortedByStart[startIndex].getP1().getX() > k){
                    k = sortedByStart[0].getP1().getX();
                    startIndex++;
                    linesNum++;
                }
            }else {
                if(sortedByFinish[endIndex].getP2().getX() > k){
                    k = sortedByFinish[0].getP1().getX();
                    endIndex++;
                    linesNum--;
                }
            }

            if(linesNum > maxLinesNum){
                maxLinesNum = linesNum;
                maxLinesIndex = startIndex;
            }
        }

        while (maxLinesNum > 0) {
            if(sortedByStart[maxLinesIndex].getP2().getX() > k){
                System.out.println(sortedByStart[maxLinesIndex].toString());
                maxLinesNum--;
            }
            maxLinesIndex--;
        }
    }
   }
