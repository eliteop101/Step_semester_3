package week1.class_problems;

/**
 * Problem 2: Palindrome Checker (3 Approaches)
 * Scenario: The QA Text Verification Toolkit
 * Verifies a string using three independent approaches:
 * 1. Iterative two-pointer comparison
 * 2. Recursive substring check
 * 3. Character array reversal and comparison
 * Confirms that all three approaches agree on the result.
 */
public class PalindromeChecker {

    /**
     * Approach 1: Iterative check comparing characters from both ends moving towards the middle.
     *
     * @param text Input text
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindromeIterative(String text) {
        if (text == null) {
            return false;
        }

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Approach 2: Recursive check comparing the first and last characters,
     * shrinking the substring in each recursive call.
     *
     * @param text Input text
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) {
            return false;
        }
        // Base case: empty string or single character is always a palindrome
        if (text.length() <= 1) {
            return true;
        }
        // If boundary characters don't match, it's not a palindrome
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        // Recurse on the inner substring
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    /**
     * Approach 3: Array-reversal check converting string to char array, reversing it,
     * and comparing against the original string.
     *
     * @param text Input text
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) {
            return false;
        }

        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        String reversedString = new String(reversed);
        return text.equals(reversedString);
    }

    /**
     * Helper method to format palindrome test output.
     */
    public static String formatResult(boolean isPal) {
        return isPal ? "Palindrome" : "Not Palindrome";
    }

    /**
     * Evaluates all three approaches on an input string and prints the comparison.
     */
    public static void verifyText(String text) {
        boolean iter = isPalindromeIterative(text);
        boolean recur = isPalindromeRecursive(text);
        boolean arrRev = isPalindromeArrayReversal(text);

        boolean allAgree = (iter == recur) && (recur == arrRev);

        System.out.printf("Input: \"%s\"%n", text);
        System.out.printf("Output: Iterative: %s | Recursive: %s | Array Reversal: %s%n",
                formatResult(iter), formatResult(recur), formatResult(arrRev));
        System.out.printf("Sanity Check: All 3 approaches agree? -> %b%n", allAgree);
        System.out.println("----------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("=== QA Text Verification Toolkit: Palindrome Checker ===");

        String[] testCases = {
            "madam",
            "hello",
            "racecar",
            "step",
            "noon",
            "radar",
            "a",
            ""
        };

        for (String test : testCases) {
            verifyText(test);
        }
    }
}
