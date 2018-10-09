package com.third;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CustomQueueTest {

  private CustomQueue<String> queue;
  private final static String TEST1 = "test1";
  private final static String TEST2 = "test2";

  @Before
  public void init() {
    queue = new CustomQueue<String>();
  }

  @Test
  public void isEmpty() {
    assertTrue(queue.isEmpty());
  }

  @Test
  public void add() {
    assertTrue(queue.isEmpty());
    assertTrue(queue.add(TEST1));
    assertFalse(queue.isEmpty());
  }

  @Test
  public void poll() {
    queue.add(TEST1);
    queue.add(TEST2);
    assertThat(queue.poll(), is(TEST1));
    assertFalse(queue.isEmpty());
    assertThat(queue.poll(), is(TEST2));
    assertTrue(queue.isEmpty());
    assertNull(queue.poll());
  }

  @Test
  public void peek() {
    queue.add(TEST1);
    assertThat(queue.peek(), is(TEST1));
    assertFalse(queue.isEmpty());
    queue.add(TEST2);
    assertThat(queue.peek(), is(TEST1));
  }
}
