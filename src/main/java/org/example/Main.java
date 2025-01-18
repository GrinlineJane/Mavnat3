package org.example;

import java.util.Random;

public class Main {

    private static Random random = new Random();

    public static double generateSevenDigitDouble() {
        double num = random.nextDouble();
        num = (num * (9999.999 - 1000)) + 1000;
        num = Math.round(num*1000.000)/1000.000;
        return num;
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

    //input
    public static Line[] generateLines(int linesNum){
        Line[] lines = new Line[linesNum];
        for (int i = 0; i< lines.length; i++) {
            lines[i] = generateLine();
        }
        return lines;
    }

    // miyun

    // algo

    public static void findMaxLines(Line[] sortedByStart, Line[] sortedByEnd) {
        double furthestPoint = sortedByStart[0].getP1().getX();

        int startPointsIndex = 1;
        int endPointsIndex = 0;

        int currentLinesNum = 1; // because k is already at first point
        int kIndex = 0;
        int maxLinesNum = 0;

        // iterates both arrays to find k.
        // O(2n) = O(n) worst case complexity.
        while (startPointsIndex < sortedByStart.length){

            if(sortedByStart[startPointsIndex].getP1().getX() <=
                    sortedByEnd[endPointsIndex].getP2().getX()) {
                if(sortedByStart[startPointsIndex].getP1().getX() > furthestPoint){
                    furthestPoint = sortedByStart[startPointsIndex].getP1().getX();
                    startPointsIndex++;
                    currentLinesNum++;
                }
            } else {
                if(sortedByEnd[endPointsIndex].getP2().getX() > furthestPoint){
                    furthestPoint = sortedByEnd[endPointsIndex].getP2().getX();
                    endPointsIndex++;
                    currentLinesNum--;
                }
            }

            if(currentLinesNum > maxLinesNum){
                maxLinesNum = currentLinesNum;
                kIndex = startPointsIndex;
            }
        }

        double maxLinesK  = sortedByStart[kIndex].getP1().getX();
        int currLineIndex = kIndex;

        System.out.println("k = " + maxLinesK );

        while (maxLinesNum > 0) {

            if(sortedByStart[currLineIndex].getP2().getX() > maxLinesK ){
                System.out.println(sortedByStart[kIndex].toString());
                maxLinesNum--;
            }

            currLineIndex--;
        }
    }

    public static void main(String[] args) {
        System.out.println("a");

        for (int i = 0; i<10; i++) {
            System.out.println(generateSevenDigitDouble());
        }
        Line[] lines = generateLines(100);
    }
   }
