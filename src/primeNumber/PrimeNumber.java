package primeNumber;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PrimeNumber {
	
	 private static final Scanner scanner = new Scanner(System.in);
    static String primality(int n) {
        
        if (n < 2) {
          return "Not prime";
       } else if (n == 2) {
           return "Prime";
       } else if (n % 2 == 0) {
           return "Not prime";
       }
       int sqrt = (int) Math.sqrt(n);
       for (int i = 2; i <= sqrt; i ++) {
           if (n % i == 0) {
               return "Not prime";
           }
       }
       return "Prime";
   }

	public static void main(String[] args) {
		// BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int p = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int pItr = 0; pItr < p; pItr++) {
	            int n = scanner.nextInt();
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	            String result = primality(n);

	         /*   bufferedWriter.write(result);
	            bufferedWriter.newLine();*/
	        }

	       // bufferedWriter.close();

	        scanner.close();
	    }

	}

