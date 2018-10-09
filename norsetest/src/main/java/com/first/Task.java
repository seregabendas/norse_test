package com.first;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Task {

  private static final List<Character> OPEN_BRACKETS = Arrays.asList('{', '[', '(');
  private static final List<Character> CLOSE_BRACKETS = Arrays.asList('}', ']', ')');

  public static boolean checkBrackets(String string) {
    Stack<Character> checkingStack = new Stack<Character>();

    for (int i = 0; i < string.length(); i++) {
      Character ch = string.charAt(i);
      if (OPEN_BRACKETS.contains(ch)) {
        checkingStack.push(ch);
        continue;
      }

      if (CLOSE_BRACKETS.contains(ch)) {
        if (checkingStack.isEmpty()) {
          return false;
        }
        Character openBracket = checkingStack.pop();
        int indexOfBracket = OPEN_BRACKETS.indexOf(openBracket);
        Character closeBracket = CLOSE_BRACKETS.get(indexOfBracket);
        if (!ch.equals(closeBracket)) {
          return false;
        }
      }
    }
    return checkingStack.isEmpty();
  }

}
