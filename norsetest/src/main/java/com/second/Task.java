package com.second;


public class Task {

  public static int[] uniteTwoSortedArrays(int[] array1, int[] array2) {
    int[] resultArray = new int[array1.length + array2.length];
    int i = 0;
    int j = 0;
    while (i + j < resultArray.length) {
      if (i >= array1.length) {
        System.arraycopy(array2, j, resultArray, i + j, array2.length - j);
        break;
      }
      if (j >= array2.length) {
        System.arraycopy(array1, i, resultArray, i + j, array1.length - i);
        break;
      }
      if (array1[i] < array2[j]) {
        resultArray[i + j] = array1[i];
        i++;
      } else {
        resultArray[i + j] = array2[j];
        j++;
      }
    }
    return resultArray;
  }
}
