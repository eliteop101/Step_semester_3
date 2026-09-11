package week1.class_problems;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Problem 4: First Non-Repeating Character
 * Scenario: The Unique Letter Hunt Mini-Game
 * Finds and highlights the first character that appears only once in the entire input.
 * Uses character frequency counting and early-exit scanning.
 */
public class FirstNonRepeatingCharacter {

    public static final char NOT_FOUND = '\0';

    /**
     * Finds the first character in the string that occurs exactly once.
     *
     * @param text The input string
     * @return The first non-repeating character, or '\0' if none exists
     */
    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return NOT_FOUND;
        }

        // Compute frequency of each character using an array or map
        int[] frequencies = new int[256];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < 256) {
                frequencies[ch]++;
            }
        }

        // Scan string from left to right for early-exit
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch < 256 && frequencies[ch] == 1) {
                return ch;
            }
        }

        return NOT_FOUND;
    }

    /**
     * Tests an input text and prints the formatted output as specified in the assignment.
     */
    public static void processInput(String text) {
        char result = findFirstNonRepeatingChar(text);
        System.out.printf("Input : \"%s\"%n", text);
        if (result != NOT_FOUND) {
            System.out.printf("Output: First Non-Repeating Character: '%c'%n", result);
        } else {
            System.out.println("Output: No Non-Repeating Character Found");
        }
        System.out.println("--------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("=== The Unique Letter Hunt Mini-Game ===");

        String[] testCases = {
            "swiss",
            "aabbcc",
            "programming",
            "developer",
            "racecar",
            "step"
        };

        for (String test : testCases) {
            processInput(test);
        }
    }
}
