package _12_Decode_String;

import java.util.Stack;

// https://leetcode.com/problems/decode-string/

public class DecodeString {

  public static String decodeString(String s) {
    var temp = new StringBuilder();
    var tempValues = new Stack<StringBuilder>();
    var repeat = new Stack<Integer>();
    int count = 0;

    for (int i = 0; i < s.toCharArray().length; i++) {
      if (Character.isDigit(s.charAt(i))) {
        count = count * 10 + (s.charAt(i) - '0');
        continue;
      } else if (s.charAt(i) == '[') {
        repeat.push(count);
        count = 0;
        tempValues.push(temp);
        temp = new StringBuilder();
        continue;
      } else if (s.charAt(i) == ']') {
        temp = tempValues.pop().append(temp.toString().repeat(repeat.pop()));
        continue;
      }

      temp.append(s.charAt(i));
    }

    return temp.toString();
  }

  public static void main(String[] args) {
    var str = "100[leetcode]";

    System.out.println(decodeString(str));
  }

}
