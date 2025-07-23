import java.util.*;

public class palindrome2 {

    // Normalize string: lowercase + remove all non-alphanumeric characters
    static String normalize(String s) {
        return s.toLowerCase().replaceAll("[^a-z0-9]", "");
    }

    // Check if a string is a palindrome
    static boolean isPalindrome(String s) {
        String cleaned = normalize(s);
        return !cleaned.isEmpty() && cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Map to track palindrome frequency
        Map<String, Integer> palindromeFrequency = new HashMap<>();

        System.out.print("How many palindrome strings do you want to enter? ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.println("Enter " + n + " string(s):");

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter string " + i + ": ");
            String input = scanner.nextLine();

            if (isPalindrome(input)) {
                String key = normalize(input);
                palindromeFrequency.put(key, palindromeFrequency.getOrDefault(key, 0) + 1);
                System.out.println("'" + input + "' is a palindrome.");
            } else {
                System.out.println("'" + input + "' is not a palindrome.");
            }
        }

        // Count unique and repeated palindromes
        int uniqueCount = 0;
        int repeatedCount = 0;

        for (int count : palindromeFrequency.values()) {
            if (count == 1) uniqueCount++;
            else repeatedCount++;
        }

        // Output summary
        System.out.println("\nPalindrome Frequency Summary:");
        if (palindromeFrequency.isEmpty()) {
            System.out.println("No valid palindromes were entered.");
        } else {
            for (Map.Entry<String, Integer> entry : palindromeFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " time(s)");
            }

            System.out.println("\nTotal Palindromes Found: " + palindromeFrequency.size());
            System.out.println("Unique Palindromes: " + uniqueCount);
            System.out.println("Repeated Palindromes: " + repeatedCount);
        }

        scanner.close();
    }
}
