package _1_Validate_Parentheses;

import java.util.Map;
import java.util.Stack;

// https://neetcode.io/problems/validate-parentheses

public class ValidateParentheses {

    public static boolean isValid(String s) {
        var bracketMap = Map.of(
                ')', '(',
                '}', '{',
                ']', '['
        );
        var bracketStack = new Stack<Character>();
        for (Character c : s.toCharArray()) {

            if ('(' == c || '{' == c || '[' == c) {
                bracketStack.push(c);
                continue;
            }

            if (bracketStack.isEmpty() || !bracketStack.pop().equals(bracketMap.get(c))) {
                return false;
            }
        }

        return bracketStack.isEmpty();
    }

    public static void main(String[] args) {
        var brackets = "([{}])";
        System.out.println(isValid(brackets));
    }
}
