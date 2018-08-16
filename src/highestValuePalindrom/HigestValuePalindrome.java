package highestValuePalindrom;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HigestValuePalindrome {
	
    // Complete the highestValuePalindrome function below.
    static String highestValuePalindrome(String s, int n, int k) {
    	
    	int action = k;
    	Stack<Character> st = new Stack<Character>();
    	
    	for(Character c : s.toCharArray()){
    		st.push(c);
    	}
    	
    	char[] array = s.toCharArray();
    	for(int i = 0; i<array.length;i++){
    		char top = st.pop();
    		if(top!=array[i] && action>0){
    			/*int x = top -'0';
    			int y = array[i] - '0';
    			if(x>y){
    				array[i]=top;
    				action--;
    			}*/
    			
    			array[array.length-1-i] = '9';
    			action--;
    			
    		}else if(top!=array[i]){
    			return "-1";
    		}
    	}
    	
    	return String.valueOf(array);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String s = scanner.nextLine();

        String result = highestValuePalindrome(s, n, k);
        
        System.out.println(result);

        scanner.close();
    }

}
