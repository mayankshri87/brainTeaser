package iceCreamParlor;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class IceCreamParlor {

	  // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money, HashMap<Integer, Integer> costMap) {

    	for(int i=0;i<cost.length;i++){
    		int remainingMoney = money - cost[i];
    		if(costMap.containsKey(remainingMoney)){
    			System.out.println((i+1) + " "+(costMap.get(remainingMoney)+1));
    			break;
    		}
    		
    	}

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            Map<Integer,Integer> costMap = new HashMap<Integer,Integer>();
            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
               costMap.put(costItem, i);
            }

            whatFlavors(cost, money,(HashMap<Integer, Integer>) costMap);
        }

        scanner.close();
    }
}
