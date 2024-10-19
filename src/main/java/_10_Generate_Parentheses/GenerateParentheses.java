package _10_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

// https://neetcode.io/problems/generate-parentheses

public class GenerateParentheses {

  public List<String> generateParenthesis(int n) {
    var parenthesis = new ArrayList<String>();
    backtrack(parenthesis, "", 0, 0, n);

    return parenthesis;
  }

  private void backtrack(List<String> parenthesis, String str, int open, int close, int n) {
    if (open == n && close == n) {
      parenthesis.add(str);
      return;
    }

    if (open < n) {
      backtrack(parenthesis, str + "(", open + 1, close, n);
    }

    if (close < open) {
      backtrack(parenthesis, str + ")", open, close + 1, n);
    }
  }
}
