package org.example;

public class Sorts {
    public void CountSort(int[] numbers, int k) {
        int[] counter = new int[k];
        int[] sortedNumbers = new int[numbers.length];

        for (int i = 1; i < k; i ++) {
            counter[i] = 0;
        }

        for (int j=0; j< numbers.length; j++) {
            counter[numbers[j]] = counter[numbers[j]] + 1;
        }

        for (int i = 1; i < k; i++) {
            counter[i] = counter[i] + counter[i-1];
        }

        for (int j = numbers.length; j >= 0; j++) {
            sortedNumbers[counter[numbers[j]]] = numbers[j];
            counter[numbers[j]] = counter[numbers[j]] - 1;
        }

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sortedNumbers[i];
        }
    }
}
