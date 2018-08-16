package sherlockAndAnagram;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class sherlockAndAnagram {
	
	// Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int count =0;
        for(int len=1;len<=s.length();len++){
            for(int startIndex=0;startIndex<=s.length()-1;startIndex++){
                int endIndex = startIndex + len -1;
                int newStartIndex = startIndex+1;
                int newEndIndex = newStartIndex + len -1;
                if(newEndIndex+1<s.length() && checkIfAnagram(s.substring(startIndex,endIndex+1),s.substring(newStartIndex,newEndIndex+1))){
                    count++;
                }
            }
        }
        return count;
    }
    
    static boolean checkIfAnagram(String str1, String str2){
        Map<Character, Integer> charMap1 = new HashMap<Character, Integer>();
        Map<Character, Integer> charMap2 = new HashMap<Character, Integer>();
        
        for(char c: str1.toCharArray()){
            if(charMap1.containsKey(c)){
                charMap1.put(c,(charMap1.get(c)+1));
            }else{
                charMap1.put(c,1);
            }
        }
        
        for(char c: str2.toCharArray()){
           if(charMap2.containsKey(c)){
                charMap2.put(c,(charMap2.get(c)+1));
            }else{
                charMap2.put(c,1);
            }
        }
        
        for(Map.Entry<Character,Integer> entry: charMap1.entrySet()){
            char key = entry.getKey();
            if(!charMap2.containsKey(key)){
                return false;
            }else if(charMap2.containsKey(key) && !(entry.getValue()==charMap2.get(key))){
                return false;
            }
        }
        
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            System.out.println(result);
           // bufferedWriter.write(String.valueOf(result));
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }

}
