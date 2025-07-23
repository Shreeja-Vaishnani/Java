import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class rejax
{
    public static void main(String[] args) {
        String input = "abc123";
         Pattern pattern = Pattern.compile("[a-z]+\\d+");
         Matcher matcher = pattern.matcher(input);
         if(matcher.matches())
         {
            System.out.println("Pattern Matched!");
         }
         else{
            System.out.println("No Match!");
         }
    }
}
