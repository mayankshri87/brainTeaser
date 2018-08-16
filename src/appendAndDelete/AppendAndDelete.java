package appendAndDelete;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AppendAndDelete {

	static String appendAndDelete(String s, String t, int k) {
		
 		int totalNumberOfOperations = 0;
		int i;
		for(i=0;i<s.length() && i<t.length();i++){
			if(s.charAt(i)!=t.charAt(i)){
				break;
			}
		}
		
		totalNumberOfOperations = s.length() - i;
		if(t.length()>(i+1)){
			totalNumberOfOperations =totalNumberOfOperations + (t.length()-i);
		}
		
		//System.out.println(totalNumberOfOperations);
		if(totalNumberOfOperations<=k){
			return "Yes";
		}
		
		return "No";

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String s = scanner.nextLine();

		String t = scanner.nextLine();

		int k = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String result = appendAndDelete(s, t, k);
		System.out.println(result);

		scanner.close();
	}

}
