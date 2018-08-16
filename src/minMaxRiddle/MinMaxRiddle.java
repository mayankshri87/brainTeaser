package minMaxRiddle;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinMaxRiddle {

	// Complete the riddle function below.
	static long[] riddle(long[] arr) {
		// complete this function
		
		
		long[] result = new long[arr.length];
		
		for(int i=1;i<=arr.length;i++){
			List<Long> tempList = new ArrayList<Long>();
			Deque<Integer> queue = new LinkedList<Integer>();
			int j;
			for(j=0;j<i;j++){
				
				while(!queue.isEmpty() && arr[queue.peekLast()]>=arr[j]){
					queue.removeLast();
				}
				queue.addLast(j);
			}
			
			for(;j<arr.length;j++){
				
				tempList.add(arr[queue.peek()]);
				
				while(!queue.isEmpty() && queue.peekFirst()<=j-i){
					queue.removeFirst();
				}
				
				while(!queue.isEmpty() && arr[queue.peekLast()]>=arr[j]){
					queue.removeLast();
				}
				queue.addLast(j);			
			}
			if(!queue.isEmpty()){
				tempList.add(arr[queue.peek()]);
			}
			Collections.sort(tempList);
			result[i-1]=tempList.get(tempList.size()-1);
		}
		
		return result;
		
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		long[] arr = new long[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			long arrItem = Long.parseLong(arrItems[i]);
			arr[i] = arrItem;
		}

		long[] res = riddle(arr);

		for (int i = 0; i < res.length; i++) {
			//bufferedWriter.write(String.valueOf(res[i]));
			System.out.println(String.valueOf(res[i]));

			if (i != res.length - 1) {
				System.out.println(" ");
			}
		}

		//bufferedWriter.newLine();

		//bufferedWriter.close();

		scanner.close();
	}

}
