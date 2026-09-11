package string.class_problems;

import java.util.Scanner;

/**
 * Live Session Problem: Reverse a String
 * Demonstrates string reversal using:
 * 1. Two-pointer character array approach (in-place swap, O(N) time, O(N) space)
 * 2. StringBuilder built-in reverse
 */
public class ReverseString {

    /**
     * Reverses a string using a two-pointer character array swap.
     *
     * @param input The input string
     * @return The reversed string
     */
    public static String reverseUsingTwoPointers(String input) {
        if (input == null) {
            return null;
        }

        char[] chars = input.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }

    /**
     * Reverses a string using StringBuilder's reverse() method.
     *
     * @param input The input string
     * @return The reversed string
     */
    public static String reverseUsingStringBuilder(String input) {
        if (input == null) {
            return null;
        }
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Reverse String Demonstration ===");

        String[] testCases = {
            "hello",
            "Java Programming",
            "Step Semester 3",
            "racecar",
            "12345",
            ""
        };

        for (String test : testCases) {
            String reversedPointers = reverseUsingTwoPointers(test);
            String reversedBuilder = reverseUsingStringBuilder(test);
            System.out.printf("Original : \"%s\"%n", test);
            System.out.printf("Two-Pointer Reversed  : \"%s\"%n", reversedPointers);
            System.out.printf("StringBuilder Reversed: \"%s\"%n", reversedBuilder);
            System.out.println("----------------------------------------");
        }

        // If command-line arguments are provided, reverse them too
        if (args.length > 0) {
            String joined = String.join(" ", args);
            System.out.println("Command line input: " + joined);
            System.out.println("Reversed: " + reverseUsingTwoPointers(joined));
        }
    }
}
