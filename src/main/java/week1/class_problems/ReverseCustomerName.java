package week1.class_problems;

/**
 * Problem 5: Reverse Customer Name
 * Scenario: The Customer Identity Verification System
 * Generates a reversed version of a customer's name for internal security verification,
 * ensuring character sequences are processed accurately without modifying the original data.
 */
public class ReverseCustomerName {

    /**
     * Reverses a customer name using character array traversal and reconstruction,
     * keeping the original input string immutable and unmodified.
     *
     * @param customerName The original customer name
     * @return The reversed name
     */
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }

        char[] chars = customerName.toCharArray();
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

    public static void main(String[] args) {
        System.out.println("=== Customer Identity Verification System ===");

        String[] customerNames = {
            "Sunil",
            "Alexander",
            "Priya",
            "John Doe",
            "A"
        };

        for (String name : customerNames) {
            String reversed = reverseCustomerName(name);
            System.out.println("Original Name: " + name);
            System.out.println("Reversed Name: " + reversed);
            System.out.println("---------------------------------------------");
        }
    }
}
