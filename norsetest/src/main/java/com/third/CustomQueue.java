package com.third;

import java.util.Stack;

public class CustomQueue<E> {

  private Stack<E> leftStack;
  private Stack<E> rightStack;

  public CustomQueue() {
    this.leftStack = new Stack<E>();
    this.rightStack = new Stack<E>();
  }

  public boolean isEmpty() {
    return leftStack.isEmpty() && rightStack.isEmpty();
  }

  public boolean add(E e) {
    return leftStack.add(e);
  }

  public E poll() {
    if (isEmpty()) {
      return null;
    }
    checkRightStack();
    return rightStack.pop();
  }

  public E peek() {
    if (isEmpty()) {
      return null;
    }
    checkRightStack();
    return rightStack.peek();
  }

  private void checkRightStack() {
    if (rightStack.isEmpty()) {
      while (!leftStack.isEmpty()) {
        rightStack.push(leftStack.pop());
      }
    }
  }
}
