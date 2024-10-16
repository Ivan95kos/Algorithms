package _8_Removing_Stars_From_a_String;

// https://leetcode.com/problems/removing-stars-from-a-string/description/

public class RemovingStarsFromString {

  public String removeStars(String s) {
    var newString = new StringBuilder();
    var countStars = 0;

    for (int i = s.toCharArray().length - 1; i >= 0; i--) {
      if (s.charAt(i) == '*') {
        countStars++;
      } else if (countStars == 0) {
        newString.append(s.charAt(i));
      } else {
        countStars--;
      }
    }

    return newString.reverse().toString();
  }
}
