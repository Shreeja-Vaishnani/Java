import java.util.*;
import java.util.regex.*;

public class palindrome1 {

    // Normalize string by removing non-alphanumeric characters and converting to lowercase
    static String normalize(String input) {
        return input.toLowerCase().replaceAll("[^a-z0-9]", "");
    }

    // Check if a string is a palindrome
    static boolean isPalindrome(String str) {
        String cleaned = normalize(str);
        return !cleaned.isEmpty() && cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }

    
    static String highlightWordPalindromes(String paragraph, Set<String> uniquePalindromes) {
        Pattern wordPattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = wordPattern.matcher(paragraph);

        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String word = matcher.group();
            if (isPalindrome(word)) {
                String cleaned = normalize(word);
                uniquePalindromes.add(cleaned);
                matcher.appendReplacement(result, "[[" + word + "]]");
            } else {
                matcher.appendReplacement(result, word);
            }
        }
        matcher.appendTail(result);
        return result.toString();
    }

    // Detect sentence-level palindromes using regex
    static void detectSentencePalindromes(String paragraph, Set<String> uniquePalindromes) {
        Pattern sentencePattern = Pattern.compile("[^.!?]+[.!?]?");
        Matcher matcher = sentencePattern.matcher(paragraph);

        while (matcher.find()) {
            String sentence = matcher.group().trim();
            if (isPalindrome(sentence)) {
                uniquePalindromes.add(normalize(sentence));
            }
        }
    }

    public static void main(String[] args) {
        String paragraph = "Madam madam teaches malayalam. Was it a car or a cat I saw? Step on no pets. Noon is the time.";

        Set<String> uniquePalindromes = new HashSet<>();

        // Highlight word-level palindromes
        String highlightedText = highlightWordPalindromes(paragraph, uniquePalindromes);

        // Detect sentence-level palindromes
        detectSentencePalindromes(paragraph, uniquePalindromes);

        // Display results
        System.out.println("==== Highlighted Paragraph ====");
        System.out.println(highlightedText);

        System.out.println("\n==== Unique Palindromes Found ====");
        for (String palindrome : uniquePalindromes) {
            System.out.println("- " + palindrome);
        }

        System.out.println("\nTotal Unique Palindromes: " + uniquePalindromes.size());
    }
}
