package com.first;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Task {

  public static boolean checkBrackets(String string) {
    Stack<Character> checkingStack = new Stack<Character>();
    List<Character> openBrackets = Arrays.asList('{', '[', '(');
    List<Character> closeBrackets = Arrays.asList('}', ']', ')');

    for (int i = 0; i < string.length(); i++) {
      Character ch = string.charAt(i);
      if (openBrackets.contains(ch)) {
        checkingStack.push(ch);
        continue;
      }

      if (closeBrackets.contains(ch)) {
        if (checkingStack.isEmpty()) {
          return false;
        }
        Character openBracket = checkingStack.pop();
        int indexOfBracket = openBrackets.indexOf(openBracket);
        Character closeBracket = closeBrackets.get(indexOfBracket);
        if (!ch.equals(closeBracket)) {
          return false;
        }
      }
    }
    return checkingStack.isEmpty();
  }

}
