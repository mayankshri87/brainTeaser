package specialPalindrome;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SpecialPalindrome {


	static long substrCount(int n, String s) {
		    long count = n;
		    for(int len=2;len<=n;len++){
		        for(int startIndex=0;startIndex<=n-len;startIndex++){
		            int endIndex=startIndex+len-1;
		            if(s.charAt(startIndex)==s.charAt(endIndex) && len==2){
		                count++;
		            }
		            else if(s.charAt(startIndex)==s.charAt(endIndex) && len==3){
		                count++;
		            }else if(len>3){
		                if(allSameCharacter(s.charAt(startIndex),s.substring(startIndex,endIndex))){
		                    count++;
		                }
		            }
		        }
		    }
		    return count;
		}
		    static boolean allSameCharacter(char ch, String str){
		        for(char c: str.toCharArray()){
		            if(!(c==ch)){
		                return false;
		            }
		        }
		        return true;
		    }
	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int n = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        String s = scanner.nextLine();

	        long result = substrCount(n, s);

	        System.out.println(result);
	        //bufferedWriter.write(String.valueOf(result));
	        //bufferedWriter.newLine();

	       // bufferedWriter.close();

	        scanner.close();
	    }
	}
