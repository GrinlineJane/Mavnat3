package org.example;

public class Sorts {
    static int RADIX_SORT_BASE = 10;
    static int DIGITS = 7;
    static int MULTIPLYING_FACTOR = 1000;


    // .intValue() is used for type-casting,
    // although it has no meaning since the value is already multiplied by the rounding factor.
    private static int GetValueAtDigit(Point point, int digit) {
        return (point.getX().intValue()/((int)Math.pow(10 , digit))) % 10;
    }

    public static Line[] RadixSortForStartPoints(Line[] lines) {
        Line[] sortedLines = new Line[lines.length];

        for (int i = 0; i < sortedLines.length; i ++) {
            sortedLines[i] = lines[i];

            sortedLines[i].getP1().setX(
                    lines[i].getP1().getX() * MULTIPLYING_FACTOR
            );
        }

        for (int digit = 0; digit < DIGITS; digit++) {
            int[] counter = new int[RADIX_SORT_BASE];
            Line[] newSortedLines = new Line[sortedLines.length];

            for (int i = 0; i < RADIX_SORT_BASE; i ++) {
                counter[i] = 0;
            }

            for (int j = 0; j < sortedLines.length; j++) {
                counter[GetValueAtDigit(sortedLines[j].getP1(), digit)]++;
            }

            if(digit != DIGITS - 1) {
                counter[0]--;
            } else {
                counter[1]--;
            }

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
                    sortedLines[i].getP1().getX() / MULTIPLYING_FACTOR
            );
        }

        return sortedLines;
    }

    public static Line[] RadixSortForEndPoints(Line[] lines) {
        Line[] sortedLines = new Line[lines.length];

        for (int i = 0; i < sortedLines.length; i ++) {
            sortedLines[i] = lines[i];

            sortedLines[i].getP2().setX(
                    lines[i].getP2().getX() * MULTIPLYING_FACTOR
            );
        }

        for (int digit = 0; digit < DIGITS; digit++) {
            int[] counter = new int[RADIX_SORT_BASE];
            Line[] newSortedLines = new Line[sortedLines.length];

            for (int i = 0; i < RADIX_SORT_BASE; i ++) {
                counter[i] = 0;
            }

            for (int j = 0; j < sortedLines.length; j++) {
                counter[GetValueAtDigit(sortedLines[j].getP2(), digit)]++;
            }

            if(digit != DIGITS - 1) {
                counter[0]--;
            } else {
                counter[1]--;
            }

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
                    sortedLines[i].getP2().getX() / MULTIPLYING_FACTOR
            );
        }

        return sortedLines;
    }
}
