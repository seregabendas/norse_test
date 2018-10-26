package com.task1;

import java.util.ArrayList;
import java.util.Arrays;

public class Task {

    public static void main(String[] args) {
        printPairsSumTen(new Integer[]{1, 2, 3, 2, 6, 4, 3, 5, 6, 7, -6, 16});
    }

    public static void printPairsSumTen(Integer[] array) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
        while (!list.isEmpty()) {
            Integer removed = list.remove(0);
            if (list.remove(Integer.valueOf(10 - removed))) {
                System.out.println("pair of integers {" + removed + "; " + (10 - removed) + "}");
            }
        }
    }
}
