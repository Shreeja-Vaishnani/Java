import java.util.ArrayList;
import java.util.StringTokenizer;

class Basic{
    public static int countPelendrom(ArrayList<String>arr)
    {
        for(int i=0;i<arr.size();i++)
        {
            StringBuilder revString = new StringBuilder(arr.get(i));
            revString.reverse();
            if(arr.get(i).equals(revString))
            {
               
            }
        }
        return 0;
    }
}
public class palindromelab {
    public static void main(String[] args) {
        String s = "madam isi veryrev happyppah hii how are  you";
        int count = 0;
        StringTokenizer str = new StringTokenizer(s);
        ArrayList<String>arr=new ArrayList<String>();
        while (str.hasMoreTokens()) {
            String checkString = str.nextToken();
            String lowerString = checkString.toLowerCase(); 
            if(arr.contains(lowerString)==false)
            {
                // StringBuilder temp=new StringBuilder(lowerString);
                // System.out.println("temp String:"+temp);
                StringBuilder revString = new StringBuilder(lowerString);
                revString.reverse();
                String FinalReverse = revString.toString();
                System.out.println("reverse String:"+revString);
                
                if(FinalReverse.equals(lowerString))
                {
                    // System.out.println("Temp insider loop");
                    count++;
                    System.out.println(count);
                    
                }
                // else
                // {
                //     System.out.println("testing called");
                // }
                arr.add(lowerString);
                
            }
                 
        }

        System.out.println("In given paragraph "+count+" pelindrom words present");
        System.out.println("24CE138");
    }
}