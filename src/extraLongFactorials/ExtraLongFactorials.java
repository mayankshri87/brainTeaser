package extraLongFactorials;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.HashMap;
import java.util.Map;

public class ExtraLongFactorials {

	static Map memorizeMap;
    private static final Scanner scanner = new Scanner(System.in);
    
    
    static void extraLongFactorials(int n) {
    	
    	

    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  int n = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	        
	        memorizeMap = new HashMap<>();
	        memorizeMap.put(0, 1);
	        memorizeMap.put(1, 1);
	        memorizeMap.put(2, 2);

	        extraLongFactorials(n);

	        scanner.close();
	}

}
