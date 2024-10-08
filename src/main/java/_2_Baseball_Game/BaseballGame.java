package _2_Baseball_Game;

// https://leetcode.com/problems/baseball-game/description/

import java.util.*;

public class BaseballGame {

    public static int calPointsV1(String[] operations) {

        var numbers = new ArrayList<>(Arrays.asList(operations));

        for (int i = 0; i < numbers.size(); ) {
            if ("+".equals(numbers.get(i))) {
                var firstNumber = numbers.get(i - 1);
                var secondNumber = numbers.get(i - 2);
                numbers.set(i, String.valueOf(Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber)));
                i++;
            } else if ("D".equals(numbers.get(i))) {
                var firstNumber = numbers.get(i - 1);
                numbers.set(i, String.valueOf(Integer.parseInt(firstNumber) * 2));
                i++;
            } else if ("C".equals(numbers.get(i))) {
                numbers.remove(i);
                numbers.remove(i - 1);
                i--;
            } else {
                i++;
            }
        }

        return numbers.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }

    public static int calPointsV2(String[] operations) {
        var numbers = new ArrayDeque<Integer>();
        for (String operation : operations) {
            switch (operation) {
                case "+" -> {
                    var top = numbers.pop();
                    var previous = numbers.peek();
                    numbers.push(top);
                    numbers.push(previous + top);
                }
                case "D" -> numbers.push(numbers.peek() * 2);
                case "C" -> numbers.pop();
                default -> numbers.push(Integer.parseInt(operation));
            }
        }

        return numbers.stream().reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        var operations = new String[]{"5", "2", "C", "D", "+"};

        System.out.println("FirstV1" + calPointsV1(operations));
        System.out.println("SecondV2" + calPointsV2(operations));
    }
}
