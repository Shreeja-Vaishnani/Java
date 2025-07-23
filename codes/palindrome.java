import java.util.*;
import java.util.regex.*;

public class palindrome {

    // Normalize the string: lowercase + remove punctuation and non-alphanumeric
    static String normalize(String s) {
        return s.toLowerCase().replaceAll("[^a-z0-9]", "");
    }

    // Check if a string is a palindrome
    static boolean isPalindrome(String s) {
        String cleaned = normalize(s);
        return !cleaned.isEmpty() && cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }

    // Highlight palindromes in words and update frequency map
    static String highlightWordPalindromes(String paragraph, Map<String, Integer> frequencyMap) {
        Pattern wordPattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = wordPattern.matcher(paragraph);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String word = matcher.group();
            if (isPalindrome(word)) {
                String cleaned = normalize(word);
                frequencyMap.put(cleaned, frequencyMap.getOrDefault(cleaned, 0) + 1);
                matcher.appendReplacement(result, "[[" + word + "]]");
            } else {
                matcher.appendReplacement(result, word);
            }
        }

        matcher.appendTail(result);
        return result.toString();
    }

    // Detect sentence-level palindromes and update frequency map
    static void detectSentencePalindromes(String paragraph, Map<String, Integer> frequencyMap) {
        Pattern sentencePattern = Pattern.compile("[^.!?]+[.!?]?");
        Matcher matcher = sentencePattern.matcher(paragraph);

        while (matcher.find()) {
            String sentence = matcher.group().trim();
            if (isPalindrome(sentence)) {
                String cleaned = normalize(sentence);
                frequencyMap.put(cleaned, frequencyMap.getOrDefault(cleaned, 0) + 1);
            }
        }
    }

    public static void main(String[] args) {

        // Input paragraph
        String paragraph = "Madam Arora teaches malayalam. Was it a car or a cat I saw? Step on no pets. Noon is the time. Madam went to noon.";

        // Frequency map for all palindromes (word/sentence level)
        Map<String, Integer> palindromeFrequency = new HashMap<>();

        // Highlight palindrome words and collect frequency
        String highlighted = highlightWordPalindromes(paragraph, palindromeFrequency);

        // Check and collect sentence-level palindromes
        detectSentencePalindromes(paragraph, palindromeFrequency);

        // Analyze unique and repeated palindromes
        int uniqueCount = 0;
        int repeatedCount = 0;

        for (int count : palindromeFrequency.values()) {
            if (count == 1) {
                uniqueCount++;
            } else {
                repeatedCount++;
            }
        }

        // Output results
        System.out.println("==== Highlighted Paragraph ====");
        System.out.println(highlighted);

        System.out.println("\n==== Palindrome Frequencies ====");
        for (Map.Entry<String, Integer> entry : palindromeFrequency.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue() + " time(s)");
        }

        System.out.println("\n==== Summary ====");
        System.out.println("Total Unique Palindromes: " + uniqueCount);
        System.out.println("Total Repeated Palindromes: " + repeatedCount);
        System.out.println("Total Palindromes Found: " + palindromeFrequency.size());
    }
}
