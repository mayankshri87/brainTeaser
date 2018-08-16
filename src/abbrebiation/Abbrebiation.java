package abbrebiation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Abbrebiation {
	

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
       Set<Character> set = new HashSet<Character>();
        
        for(char c: (a.toLowerCase()).toCharArray()){
            set.add(c);
        }
        
        for(char c: (b.toLowerCase()).toCharArray()){
            if(!set.contains(c)){
                return "NO";
            }else{
                if(!checkNumberOfCapitals(a, b)){
                    return "NO";
                }
            }
        }
        
        return "YES";
    }

    static boolean checkNumberOfCapitals(String a, String b){
        Set<Character> set2 = new HashSet<Character>();
        
        for(Character c: (b.toLowerCase()).toCharArray()){
            set2.add(c);
        }
        
        for(Character c: a.toCharArray()){
            if(!set2.contains(Character.toLowerCase(c))){
                if(Character.isUpperCase(c)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);
            
            System.out.println(result);

            //bufferedWriter.write(result);
            //bufferedWriter.newLine();
        }

       // bufferedWriter.close();

        scanner.close();
    }

}
