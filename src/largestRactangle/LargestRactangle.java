package largestRactangle;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LargestRactangle {
	

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] arr) {
        long maxArea = -1;
        Stack<Integer> st = new Stack<Integer>();
        int i=0;
        while(i<arr.length){
        	if(st.isEmpty() || arr[i]>=arr[st.peek()]){
        		st.push(i);
        		i++;
        	}else{
        		int temp = arr[st.peek()];
        		st.pop();
        		int area = i*temp;
        		
        		if(!st.isEmpty()){
        			area = temp * (i-st.peek()-1);
        		}
        		maxArea = Math.max(area, maxArea);
        	}
        }
        
        while(!st.isEmpty()){
        	
        	int temp = arr[st.peek()];
        	st.pop();
        	int area = i*temp;
        	
        	if(!st.isEmpty()){
        		area = temp * (i-st.peek()-1);
        	}
        	maxArea = Math.max(area, maxArea);
        }
        
        return maxArea;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
