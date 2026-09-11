package string.class_problems;

/**
 * Live Session Problem: Palindrome Check
 * Demonstrates:
 * 1. Exact string palindrome check using two-pointers
 * 2. Alphanumeric case-insensitive palindrome check (ignoring punctuation and spaces)
 */
public class PalindromeCheck {

    /**
     * Checks if an exact string reads the same forwards and backwards.
     *
     * @param input The input string
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }

        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Checks if a phrase is a palindrome considering only alphanumeric characters
     * and ignoring case differences.
     *
     * @param input The input phrase
     * @return true if alphanumeric palindrome, false otherwise
     */
    public static boolean isAlphanumericPalindrome(String input) {
        if (input == null) {
            return false;
        }

        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(input.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(input.charAt(right))) {
                right--;
            }

            char c1 = Character.toLowerCase(input.charAt(left));
            char c2 = Character.toLowerCase(input.charAt(right));

            if (c1 != c2) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("=== Palindrome Check Demonstration ===");

        String[] exactTests = {
            "racecar",
            "madam",
            "level",
            "hello",
            "noon",
            "Step"
        };

        System.out.println("-- Exact Palindrome Tests --");
        for (String test : exactTests) {
            System.out.printf("Is \"%s\" a palindrome? -> %b%n", test, isPalindrome(test));
        }

        System.out.println("\n-- Alphanumeric / Case-Insensitive Phrase Tests --");
        String[] phraseTests = {
            "A man, a plan, a canal: Panama",
            "Was it a car or a cat I saw?",
            "No 'x' in Nixon",
            "Not a palindrome"
        };

        for (String test : phraseTests) {
            System.out.printf("Is \"%s\" a phrase palindrome? -> %b%n", test, isAlphanumericPalindrome(test));
        }
    }
}
