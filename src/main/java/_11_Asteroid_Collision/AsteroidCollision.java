package _11_Asteroid_Collision;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

// https://leetcode.com/problems/asteroid-collision/description/

public class AsteroidCollision {

  public static int[] asteroidCollision(int[] asteroids) {
    var stack = new ArrayDeque<Integer>();
    stack.add(asteroids[0]);

    for (int i = 1; i < asteroids.length; i++) {

      if (asteroids[i] > 0) {
        stack.push(asteroids[i]);
      } else if (stack.isEmpty() || stack.peek() < 0) {
        stack.push(asteroids[i]);
      } else {
        while (!stack.isEmpty()) {
          if (stack.peek() < 0) {
            stack.push(asteroids[i]);
            break;
          } else if (stack.peek() < Math.abs(asteroids[i])) {
            stack.pop();
          } else {
            break;
          }
        }

        if (!stack.isEmpty() && stack.peek() == Math.abs(asteroids[i])) {
          stack.pop();
        } else if (stack.isEmpty()) {
          stack.push(asteroids[i]);
        }
      }
    }

    var list = new ArrayList<>(stack);
    Collections.reverse(list);
    return list.stream()
        .mapToInt(Integer::intValue)
        .toArray();
  }

  public static void main(String[] args) {

    var numbers = new int[] {1,-2,-2,-2};

    asteroidCollision(numbers);
  }
}
