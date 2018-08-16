package maximumPalindrome;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaximumPalindrome {

    // Complete the initialize function below.
    static void initialize(String s) {
        //String str = new String(s);
        // This function is called once before all queries.

    }

    // Complete the answerQuery function below.
    static int answerQuery(int l, int r, String s) {
        // Return the answer for this query modulo 1000000007.
    	System.out.println(s);
    	return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scanner.nextLine();

        initialize(s);
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] lr = scanner.nextLine().split(" ");

            int l = Integer.parseInt(lr[0]);

            int r = Integer.parseInt(lr[1]);

            int result = answerQuery(l, r,s);

            System.out.println(result);
        }

        scanner.close();
    }
}
