package davidStairCase;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class DavidStaircase {

	 static int stepPerms(int n) {
		 
		 if(n==0||n==1){
			 return 1;
		 }
		 int[] ways = new int[n+1];
	        ways[0] = 1;
	        ways[1] = 1;
		for(int i=2;i<=n;i++){
			ways[i] = 0;
			for(int j=1;j<=3 && j<=i;j++){
				ways[i] += ways[i-j];
			}
		}
		return ways[n];
	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int s = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	        
	       
	        
	        for (int sItr = 0; sItr < s; sItr++) {
	            int n = scanner.nextInt();
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	            
	            
	           int res = stepPerms(n);
	            
	          //  stepPerms(n);

	           System.out.println(String.valueOf(res));
	           // bufferedWriter.write(String.valueOf(res));
	           // bufferedWriter.newLine();
	        }

	        //bufferedWriter.close();

	        scanner.close();
	    }
}
