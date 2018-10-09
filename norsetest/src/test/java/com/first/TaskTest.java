package com.first;

import static com.first.Task.checkBrackets;
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
            {"g{fsdfg}s", true},
            {"g{f(sd)fg}s", true},
            {"{g{fsdfg}s", false},
            {"{{[cc(c)ggg]}ssss}", true},
            {"{{[cc(c)ggg]}ssss}{", false}
        }
    );
  }

  @Parameter(0)
  public String string;

  @Parameter(1)
  public boolean expectedResult;

  @Test
  public void shouldCheckBrackets() {
    boolean actualResult = checkBrackets(string);
    assertThat(actualResult, is(expectedResult));
  }
}
