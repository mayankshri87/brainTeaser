package candies;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Candies {

	 // Complete the candies function below.
    static long candies(int n, int[] arr) {
    	if(arr.length==0){
    		return 0;
    	}
    	if(arr.length==1){
    		return 1;
    	}
       
    	long minimum =1;
    	long sum = 0;
    	for(int i=1;i<arr.length;i++){
    		int j = i+1;
    		if(j<arr.length && arr[i]>=arr[j] && minimum>1){
    			minimum--;
    		}else if(i>=0 && arr[i-1]>=arr[i] && minimum>1){
    			minimum--;
    		}else{
    			minimum++;
    		}
    		
    		sum += minimum;
    	}
    	
    	return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);
        
        System.out.println(result);

       /* bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}
