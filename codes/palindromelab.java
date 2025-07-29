import java.util.StringTokenizer;

public class palindromelab {
    public static void main(String[] args) {
        String s = "this is a simple madam level racecar civic sos";
        StringTokenizer str = new StringTokenizer(s);

        System.out.println("Palindrome words:");

       
        while (str.hasMoreTokens()) {
            String word = str.nextToken();
            String reversed = "";

            
            int i = word.length() - 1;
            while (i >= 0) {
                reversed += word.charAt(i);
                i--;
            }

            
            if (word.equalsIgnoreCase(reversed)) {
                System.out.println(word);
            }
        }
        

    }
}
