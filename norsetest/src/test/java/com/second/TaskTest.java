package com.second;

import static com.second.Task.uniteTwoSortedArrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TaskTest {


  @Parameters
  public static Collection init() {
    return Arrays.asList(
        new Object[][]{
            {new int[]{1, 3, 6, 8, 9}, new int[]{1, 2, 4, 5}, new int[]{1, 1, 2, 3, 4, 5, 6, 8, 9}},
            {new int[0], new int[0], new int[0]},
            {new int[]{1, 2, 4, 5}, new int[]{1, 3, 6, 8, 9}, new int[]{1, 1, 2, 3, 4, 5, 6, 8, 9}},
            {new int[]{4, 5, 6}, new int[]{1, 2, 3}, new int[]{1, 2, 3, 4, 5, 6}}
        }
    );
  }

  @Parameter(0)
  public int[] array1;

  @Parameter(1)
  public int[] array2;

  @Parameter(2)
  public int[] expectedResult;

  @Test
  public void shouldUniteTwoSortedArrays() {
    int[] actualResult = uniteTwoSortedArrays(array1, array2);
    assertThat(actualResult, is(expectedResult));
  }
}
