package coinChange;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CoinChange {
    static int ways(int n, int[] coins) {
        int[][] solutionMatrix = new int[coins.length+1][n+1];
   		        
       for(int i=0;i<coins.length+1;i++){
           solutionMatrix[i][0] = 1;
       }
       for(int j=1;j<n+1;j++){
           solutionMatrix[0][1] = 0;
       }

       for(int i=1; i<coins.length+1;i++){
           for(int j=1;j<n+1;j++){
               if(coins[i-1]<=j){
                   solutionMatrix[i][j] = solutionMatrix[i-1][j] +  solutionMatrix[i][j-coins[i-1]];
               }else{
                   solutionMatrix[i][j] = solutionMatrix[i][j-1];
               }
           }
       }

       for(int i=0;i<coins.length+1;i++){
    	   for(int j=1;j<n+1;j++){
    		   System.out.print(solutionMatrix[i][j]+" ");
    	   }
    	   System.out.println();
       }
   		        return (solutionMatrix[coins.length][n]);
       }
		    private static final Scanner scanner = new Scanner(System.in);

		    public static void main(String[] args) throws IOException {
		       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		        String[] nm = scanner.nextLine().split(" ");

		        int n = Integer.parseInt(nm[0]);

		        int m = Integer.parseInt(nm[1]);

		        int[] coins = new int[m];

		        String[] coinsItems = scanner.nextLine().split(" ");
		        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		        for (int i = 0; i < m; i++) {
		            int coinsItem = Integer.parseInt(coinsItems[i]);
		            coins[i] = coinsItem;
		        }

		        int res = ways(n, coins);
		        System.out.println(res);
/*
		        bufferedWriter.write(String.valueOf(res));
		        bufferedWriter.newLine();

		        bufferedWriter.close();*/

		        scanner.close();
		    }

}
