package _7_Evaluate_Reverse_Polish_Notation;

import java.util.ArrayDeque;

// https://neetcode.io/problems/evaluate-reverse-polish-notation

public class EvaluateReversePolishNotation {

  public static int evalRPN(String[] tokens) {
    var numbers = new ArrayDeque<Integer>();

    for (String token : tokens) {
      switch (token) {
        case "+" -> numbers.push(numbers.pop() + numbers.pop());
        case "-" -> {
            var secondNum = numbers.pop();
            var firstNum = numbers.pop();
            numbers.push(firstNum - secondNum);
        }
        case "*" -> numbers.push(numbers.pop() * numbers.pop());
        case "/" -> {
          var secondNum = numbers.pop();
          var firstNum = numbers.pop();
          numbers.push(firstNum / secondNum);
        }
        default -> numbers.push(Integer.parseInt(token));
      }
    }

    return numbers.pop();
  }

  public static void main(String[] args) {
    var tokens = new String[]{ "1","2","+","3","*","4","-"};
    System.out.println(evalRPN(tokens));
  }
}
