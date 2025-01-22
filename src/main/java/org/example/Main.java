// אור גלבוע 324188754
// ורברה גריניוב 338055866

package org.example;

import java.util.Objects;
import java.util.Random;

import static org.example.Sorts.RadixSortForEndPoints;
import static org.example.Sorts.RadixSortForStartPoints;

public class Main {

    private static Random random = new Random();

    public static void main(String[] args) {
        Line[] lines = generateLines(100);
        Line[] sortedByStartPoint = RadixSortForStartPoints(lines);
        Line[] sortedByEndPoint = RadixSortForEndPoints(lines);
        findMaxLines(sortedByStartPoint, sortedByEndPoint);
    }

    public static double generateSevenDigitDouble() {
        double num = random.nextDouble();
        num = (num * (9999.999 - 1000)) + 1000;
        num = Math.round(num*1000.000)/1000.000;
        return num;
    }

   public static Line generateLine(){
      double x1 = generateSevenDigitDouble();
      //so that x2 will have an option to be bigger and to avoid a possible stuck overflow in the next while
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

    public static Line[] generateLines(int linesNum){
        Line[] lines = new Line[linesNum];
        for (int i = 0; i< lines.length; i++) {
            lines[i] = generateLine();
        }
        return lines;
    }

    public static void findMaxLines(Line[] sortedByStart, Line[] sortedByEnd) {
        SortedLine[] allLines = new SortedLine[sortedByStart.length * 2];

        int p = 0;
        int q = 0;

        for (int i = 0; i< sortedByStart.length * 2; i++) {
            if (sortedByStart[p].getP1().getX() <= sortedByEnd[q].getP2().getX()) {
                allLines[i] = new SortedLine(sortedByStart[p], "start");

                if (p + 1 < sortedByStart.length) {
                    p++;
                }
            } else {
                allLines[i] = new SortedLine(sortedByEnd[q], "end");
                if (q + 1 < sortedByEnd.length) {
                    q++;
                }
            }
        }

        int currentLinesNum = 1; // because startPointsIndex is already at first point
        int kIndex = 0;
        int maxLinesNum = 1; // because startPointsIndex is already at first point

        // iterates both all lines twice to find k.
        // O(2n) = O(n) worst case complexity.
        for(int j=0; j<allLines.length; j++) {
            if(Objects.equals(allLines[j].getType(), "start")) {
                currentLinesNum++;

                if(currentLinesNum > maxLinesNum){
                    maxLinesNum = currentLinesNum;
                    kIndex = j;
                }
            } else {
                currentLinesNum --;
            }
        }

        double maxLinesK  = allLines[kIndex].getP1().getX();
        int currLineIndex = kIndex;

        System.out.println("k = " + maxLinesK );
        System.out.println("maxLinesNum = " + maxLinesNum );


        while (maxLinesNum > 0 && currLineIndex >= 0) {
            SortedLine currLine = allLines[currLineIndex];
            if(Objects.equals(currLine.getType(), "start") && currLine.getP2().getX() > maxLinesK ){
                System.out.println(allLines[currLineIndex].toString());
                maxLinesNum--;
            }

            currLineIndex--;
        }
    }

   }
