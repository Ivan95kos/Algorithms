package _9_Validate_Stack_Sequences;

// https://leetcode.com/problems/validate-stack-sequences/

import java.util.Stack;

public class ValidateStackSequences {

  public static boolean validateStackSequences(int[] pushed, int[] popped) {
    var stack = new Stack<Integer>();
    for (int i = 0, j = 0; i < pushed.length; i++) {
      stack.push(pushed[i]);
      while (!stack.isEmpty() && j < popped.length) {
        if (stack.peek() == popped[j]) {
          stack.pop();
          j++;
        } else {
          break;
        }
      }
    }

    return stack.isEmpty();
  }

  public static void main(String[] args) {
    var pushed = new int[] {1, 2, 3, 4, 5};
    var popped = new int[] {4, 5, 3, 2, 1};
    System.out.println(validateStackSequences(pushed, popped));
  }
}
