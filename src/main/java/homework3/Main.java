// אור גלבוע 324188754
// ורברה גריניוב 338055866

package homework3;

import java.util.Random;

import static homework3.Sorts.RadixSortForEndPoints;
import static homework3.Sorts.RadixSortForStartPoints;

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
        int startPointsIndex = 1;
        int endPointsIndex = 0;

        int currentLinesNum = 1; // because startPointsIndex is already at first point
        int kIndex = 0;
        int maxLinesNum = 1; // because startPointsIndex is already at first point

        // iterates both arrays to find k.
        // O(2n) = O(n) worst case complexity.
        while (startPointsIndex < sortedByStart.length){
            Point currentStartPoint = sortedByStart[startPointsIndex].getP1();
            Point currentEndPoint = sortedByEnd[endPointsIndex].getP2();

            // any end point cant be placed before the first start point
            if(currentEndPoint.getX() < currentStartPoint.getX()) {
                endPointsIndex++;
                currentLinesNum--;
            } else {
                currentLinesNum++;

                if(currentLinesNum >= maxLinesNum){
                    maxLinesNum = currentLinesNum;
                    kIndex = startPointsIndex;
                }

                startPointsIndex++;
            }
        }

        double maxLinesK  = sortedByStart[kIndex].getP1().getX();
        int currLineIndex = kIndex;

        System.out.println("k = " + maxLinesK );
        System.out.println("maxLinesNum = " + maxLinesNum );


        while (maxLinesNum > 0 && currLineIndex >= 0) {

            if(sortedByStart[currLineIndex].getP2().getX() >= maxLinesK ){
                System.out.println(sortedByStart[currLineIndex].toString());
                maxLinesNum--;
            }

            currLineIndex--;
        }
    }

   }
