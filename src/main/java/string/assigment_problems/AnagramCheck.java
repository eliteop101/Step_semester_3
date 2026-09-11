package string.assigment_problems;

import java.util.Arrays;

/**
 * Assignment Problem: Anagram Check
 * Determines if two strings are anagrams of each other (contain the exact same
 * characters with the same frequencies, disregarding order and case).
 * Demonstrates:
 * 1. Frequency count array method (O(N) time, O(1) space for 26 letters)
 * 2. Character array sorting method (O(N log N) time, O(N) space)
 */
public class AnagramCheck {

    /**
     * Checks if two strings are anagrams using a character frequency count array.
     * Ignores case and non-letter characters.
     *
     * @param str1 First string
     * @param str2 Second string
     * @return true if anagrams, false otherwise
     */
    public static boolean isAnagramFrequency(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }

        // Clean strings: keep only lowercase letters
        String s1 = str1.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String s2 = str2.replaceAll("[^a-zA-Z]", "").toLowerCase();

        if (s1.length() != s2.length()) {
            return false;
        }

        int[] charCounts = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            charCounts[s1.charAt(i) - 'a']++;
            charCounts[s2.charAt(i) - 'a']--;
        }

        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks if two strings are anagrams by sorting their character arrays.
     *
     * @param str1 First string
     * @param str2 Second string
     * @return true if anagrams, false otherwise
     */
    public static boolean isAnagramSorting(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }

        String s1 = str1.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String s2 = str2.replaceAll("[^a-zA-Z]", "").toLowerCase();

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        System.out.println("=== Anagram Check Demonstration ===");

        String[][] pairs = {
            {"listen", "silent"},
            {"triangle", "integral"},
            {"Debit Card", "Bad Credit"},
            {"apple", "pale"},
            {"Astronomer", "Moon starer"},
            {"hello", "world"}
        };

        for (String[] pair : pairs) {
            String s1 = pair[0];
            String s2 = pair[1];
            boolean freqResult = isAnagramFrequency(s1, s2);
            boolean sortResult = isAnagramSorting(s1, s2);

            System.out.printf("Strings: \"%s\" vs \"%s\"%n", s1, s2);
            System.out.printf("  -> Frequency check: %b%n", freqResult);
            System.out.printf("  -> Sorting check  : %b%n", sortResult);
            System.out.println("----------------------------------------");
        }
    }
}
