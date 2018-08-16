package lonelyInteger;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LonelyInteger {
	
	 static int findLonely(List<Integer> arr) {
	        
		 	int loneyInteger = Integer.MAX_VALUE;
	        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
	        
	        for(Integer element: arr){
	           if(map.containsKey(element)){
	        	   int value = map.get(element) +1;
	        	   map.put(element, value);
	           }else{
	        	   map.put(element, 1);
	           }
	        }

	        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
	        	
	        	int val = entry.getValue();
	        	if(val==1){
	        		loneyInteger =  entry.getKey();
	        	}
	        }
	        
	        return loneyInteger;
	    }

	    public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int n = Integer.parseInt(bufferedReader.readLine().trim());

	        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

	        List<Integer> arr = new ArrayList<>();

	        for (int i = 0; i < n; i++) {
	            int arrItem = Integer.parseInt(arrItems[i]);
	            arr.add(arrItem);
	        }

	        int res = findLonely(arr);

	        bufferedWriter.write(String.valueOf(res));
	        bufferedWriter.newLine();

	        bufferedReader.close();
	        bufferedWriter.close();
	    }

}
