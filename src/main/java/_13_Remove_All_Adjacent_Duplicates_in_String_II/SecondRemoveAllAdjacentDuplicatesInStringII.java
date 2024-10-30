package _13_Remove_All_Adjacent_Duplicates_in_String_II;

import java.util.Stack;
import java.util.stream.Collectors;

public class SecondRemoveAllAdjacentDuplicatesInStringII {

  public static String removeDuplicates(String s, int k) {
    var characters = new Stack<Character>();
    var countCharacters = new Stack<Integer>();

    characters.push(s.charAt(0));
    countCharacters.push(1);

    for (int i = 1; i < s.length(); i++) {

      if (!characters.isEmpty() && characters.peek() == s.charAt(i)) {
        countCharacters.push(countCharacters.pop() + 1);
        characters.push(s.charAt(i));
      } else {
        characters.push(s.charAt(i));
        countCharacters.push(1);
      }

      if (countCharacters.peek() == k) {
        for (int j = 0; j < k; j++) {
          characters.pop();
        }
        countCharacters.pop();
      }
    }

    return characters.stream()
        .map(String::valueOf)
        .collect(Collectors.joining());
  }

  public static void main(String[] args) {
    var a = "deeedbbcccbdaa";

    System.out.println(removeDuplicates(a, 3));
  }
}
