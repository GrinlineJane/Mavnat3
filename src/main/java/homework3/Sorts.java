// אור גלבוע 324188754
// ורברה גריניוב 338055866

package homework3;

public class Sorts {
    static int RADIX_SORT_BASE = 10;
    static int DIGITS = 7;
    static int ROUNDING_FACTOR = 1000;


    // .intValue() is used for type-casting,
    // although it has no meaning since the value is already multiplied by the rounding factor,
    // so it is a whole number.
    private static int GetValueAtDigit(Point point, int digit) {
        return (point.getX().intValue()/((int)Math.pow(10 , digit))) % 10;
    }

    public static Line[] RadixSortForStartPoints(Line[] lines) {
        Line[] sortedLines = new Line[lines.length];

        for (int i = 0; i < sortedLines.length; i ++) {
            sortedLines[i] = lines[i];

            sortedLines[i].getP1().setX(
                    lines[i].getP1().getX() * ROUNDING_FACTOR
            );
        }

        //preform counting sort
        for (int digit = 0; digit < DIGITS; digit++) {
            int[] counter = new int[RADIX_SORT_BASE];
            Line[] newSortedLines = new Line[sortedLines.length];

            for (int i = 0; i < RADIX_SORT_BASE; i ++) {
                counter[i] = 0;
            }

            for (int j = 0; j < sortedLines.length; j++) {
                counter[GetValueAtDigit(sortedLines[j].getP1(), digit)]++;
            }

            // indexes start from 0 while the count represent an amount,
            // example: 9 at count[0] would mean the final index of zeroes is 8.
            counter[0]--;

            for (int i = 1; i < RADIX_SORT_BASE; i++) {
                counter[i] += counter[i-1];
            }

            for (int j = sortedLines.length - 1; j >= 0; j--) {
                int valueAtDigit = GetValueAtDigit(sortedLines[j].getP1(), digit);
                newSortedLines[counter[valueAtDigit]] = sortedLines[j];
                counter[valueAtDigit] = counter[valueAtDigit] - 1;
            }

            for (int i = 0; i < sortedLines.length; i++) {
                sortedLines[i] = newSortedLines[i];
            }
        }

        for (int i = 0; i < sortedLines.length; i ++) {
            sortedLines[i].getP1().setX(
                    sortedLines[i].getP1().getX() / ROUNDING_FACTOR
            );
        }

        return sortedLines;
    }

    public static Line[] RadixSortForEndPoints(Line[] lines) {
        Line[] sortedLines = new Line[lines.length];

        for (int i = 0; i < sortedLines.length; i ++) {
            sortedLines[i] = lines[i];

            sortedLines[i].getP2().setX(
                    lines[i].getP2().getX() * ROUNDING_FACTOR
            );
        }

        //preform counting sort
        for (int digit = 0; digit < DIGITS; digit++) {
            int[] counter = new int[RADIX_SORT_BASE];
            Line[] newSortedLines = new Line[sortedLines.length];

            for (int i = 0; i < RADIX_SORT_BASE; i ++) {
                counter[i] = 0;
            }

            for (int j = 0; j < sortedLines.length; j++) {
                counter[GetValueAtDigit(sortedLines[j].getP2(), digit)]++;
            }

            // indexes start from 0 while the count represent an amount,
            // example: 9 at count[0] would mean the final index of zeroes is 8.
            counter[0]--;

            for (int i = 1; i < RADIX_SORT_BASE; i++) {
                counter[i] += counter[i-1];
            }

            for (int j = sortedLines.length - 1; j >= 0; j--) {
                int valueAtDigit = GetValueAtDigit(sortedLines[j].getP2(), digit);
                newSortedLines[counter[valueAtDigit]] = sortedLines[j];
                counter[valueAtDigit] = counter[valueAtDigit] - 1;
            }

            for (int i = 0; i < sortedLines.length; i++) {
                sortedLines[i] = newSortedLines[i];
            }
        }

        for (int i = 0; i < sortedLines.length; i ++) {
            sortedLines[i].getP2().setX(
                    sortedLines[i].getP2().getX() / ROUNDING_FACTOR
            );
        }

        return sortedLines;
    }
}
