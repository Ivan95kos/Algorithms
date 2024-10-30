package _13_Remove_All_Adjacent_Duplicates_in_String_II;

import java.util.stream.Collectors;

public class RemoveAllAdjacentDuplicatesInStringII {

  public static String removeDuplicates(String s, int k) {
    var chars = s.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.toList());

    var count = 0;
    char lastChar = chars.getFirst();

    for (int i = 0; i < chars.size(); i++) {

      if (lastChar == chars.get(i)) {
        count++;
      } else {
        lastChar = chars.get(i);
        count = 1;
      }

      if (count == k) {
        chars.subList(++i - k, i).clear();
        count = 1;
        lastChar = chars.getFirst();
        i = 0;
      }
    }

    return chars.stream()
        .map(String::valueOf)
        .collect(Collectors.joining());
  }

  public static void main(String[] args) {
    var a = "deeedbbcccbdaa";

    System.out.println(removeDuplicates(a, 3));
  }

}
