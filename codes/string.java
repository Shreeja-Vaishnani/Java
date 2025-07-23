import java.util.Scanner;

public class string {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // -------- Trim using length and charAt --------
        int start = 0, end = str.length() - 1;

        // Find first non-space character
        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }

        // Find last non-space character
        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }

        String trimmed = "";
        if (start <= end) {
            trimmed = str.substring(start, end + 1);
        }

        System.out.println("After manual trim: '" + trimmed + "'");

        // -------- Replace example --------
        System.out.println("Enter character to replace: ");
        char oldChar = sc.next().charAt(0);
        System.out.println("Enter new character: ");
        char newChar = sc.next().charAt(0);

        String replaced = trimmed.replace(oldChar, newChar);
        System.out.println("After replace: '" + replaced + "'");

        // -------- ToUpperCase example --------
        String upper = trimmed.toUpperCase();
        System.out.println("After toUpperCase: '" + upper + "'");

        sc.close();
    }
}
