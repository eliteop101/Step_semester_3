package string.assigment_problems;

/**
 * Assignment Problem: Count Vowels, Consonants, Digits, and Special Characters
 * Analyzes an input string and counts frequencies of character categories.
 */
public class CountVowelsConsonants {

    public static class CountSummary {
        private final int vowels;
        private final int consonants;
        private final int digits;
        private final int spaces;
        private final int specialCharacters;

        public CountSummary(int vowels, int consonants, int digits, int spaces, int specialCharacters) {
            this.vowels = vowels;
            this.consonants = consonants;
            this.digits = digits;
            this.spaces = spaces;
            this.specialCharacters = specialCharacters;
        }

        public int getVowels() {
            return vowels;
        }

        public int getConsonants() {
            return consonants;
        }

        public int getDigits() {
            return digits;
        }

        public int getSpaces() {
            return spaces;
        }

        public int getSpecialCharacters() {
            return specialCharacters;
        }

        @Override
        public String toString() {
            return String.format(
                "Vowels: %d | Consonants: %d | Digits: %d | Spaces: %d | Special Characters: %d",
                vowels, consonants, digits, spaces, specialCharacters
            );
        }
    }

    /**
     * Counts the different types of characters in the given input string.
     *
     * @param input The input string to analyze
     * @return A CountSummary object with counts
     */
    public static CountSummary count(String input) {
        if (input == null) {
            return new CountSummary(0, 0, 0, 0, 0);
        }

        int vowels = 0;
        int consonants = 0;
        int digits = 0;
        int spaces = 0;
        int specials = 0;

        String vowelsList = "aeiouAEIOU";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isLetter(ch)) {
                if (vowelsList.indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            } else if (Character.isDigit(ch)) {
                digits++;
            } else if (Character.isWhitespace(ch)) {
                spaces++;
            } else {
                specials++;
            }
        }

        return new CountSummary(vowels, consonants, digits, spaces, specials);
    }

    public static void main(String[] args) {
        System.out.println("=== Count Vowels, Consonants & Characters Demonstration ===");

        String[] testStrings = {
            "Hello World 2026!",
            "Java Programming @ Step_Semester_3",
            "AEIOU and sometimes Y",
            "12345!@#$%",
            "Quick brown fox jumps over 13 lazy dogs."
        };

        for (String test : testStrings) {
            CountSummary summary = count(test);
            System.out.printf("Input: \"%s\"%n", test);
            System.out.println("  " + summary);
            System.out.println("----------------------------------------");
        }
    }
}
