package week1.class_problems;

/**
 * Problem 3: BMI Calculator for a Team
 * Scenario: The Corporate Wellness Program
 * Computes BMI and health classification for a team of people,
 * and prints a clean, formatted report table.
 */
public class BMICalculator {

    /**
     * Classifies health status according to standard BMI categories:
     * BMI < 18.5       -> Underweight
     * 18.5 - 24.9      -> Normal
     * 25.0 - 29.9      -> Overweight
     * >= 30.0          -> Obese
     *
     * @param bmi Calculated Body Mass Index
     * @return Health classification status string
     */
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    /**
     * Computes BMI = weight / (height * height)
     *
     * @param height Height in meters
     * @param weight Weight in kilograms
     * @return Calculated BMI value
     */
    public static double calculateBmi(double height, double weight) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than zero.");
        }
        return weight / (height * height);
    }

    /**
     * Generates and prints the wellness report for parallel arrays of heights and weights.
     *
     * @param heights Array of heights in meters
     * @param weights Array of weights in kilograms
     */
    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            System.out.println("Error: Invalid or mismatched heights and weights data.");
            return;
        }

        System.out.println("=====================================================================");
        System.out.println("              Corporate Wellness Health Check-Up Report              ");
        System.out.println("=====================================================================");
        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-14s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("---------------------------------------------------------------------");

        int count = heights.length;
        int underweight = 0, normal = 0, overweight = 0, obese = 0;

        for (int i = 0; i < count; i++) {
            double h = heights[i];
            double w = weights[i];
            double bmi = calculateBmi(h, w);
            String status = getBmiStatus(bmi);

            switch (status) {
                case "Underweight" -> underweight++;
                case "Normal" -> normal++;
                case "Overweight" -> overweight++;
                case "Obese" -> obese++;
            }

            System.out.printf("Person %-3d | %-12.2f | %-12.1f | %-8.2f | %-14s%n",
                    (i + 1), h, w, bmi, status);
        }

        System.out.println("---------------------------------------------------------------------");
        System.out.printf("Summary: Total: %d | Normal: %d | Overweight: %d | Obese: %d | Underweight: %d%n",
                count, normal, overweight, obese, underweight);
        System.out.println("=====================================================================\n");
    }

    public static void main(String[] args) {
        // Suggested 10 employees test data
        double[] heights = {1.75, 1.60, 1.80, 1.65, 1.70, 1.55, 1.85, 1.68, 1.72, 1.58};
        double[] weights = {70.0, 90.0, 72.0, 48.0, 82.0, 65.0, 95.0, 60.0, 77.0, 45.0};

        printWellnessReport(heights, weights);
    }
}
