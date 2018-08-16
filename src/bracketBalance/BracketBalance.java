package bracketBalance;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BracketBalance {
	
	   // Complete the balancedOrNot function below.
    static List<Integer> balancedOrNot(List<String> expressions, List<Integer> maxReplacements) {
        
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<expressions.size() && i<maxReplacements.size();i++){
            result.add(canBalanced(expressions.get(i),maxReplacements.get(i)));
        }
        
        return result;
    }

    static int canBalanced(String s, int trials){
        
        Stack<Character> st = new Stack<Character>();
        for(Character c: s.toCharArray()){
        	if(st.isEmpty()){
        		st.push(c);
        	}else if(st.peek()=='<' && c=='>'){
        		st.pop();
        	}else{
        		st.push(c);
        	}
        }
        
        if(st.size()<=2){
        	for(Character c:st){
        		if(c=='>'){
        			return 0;
        		}
        	}
        	
        	return 1;
        }
        
        return 0;
    }


	
	  public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int expressionsCount = Integer.parseInt(bufferedReader.readLine().trim());

	        List<String> expressions = new ArrayList<>();

	        for (int i = 0; i < expressionsCount; i++) {
	            String expressionsItem = bufferedReader.readLine();
	            expressions.add(expressionsItem);
	        }

	        int maxReplacementsCount = Integer.parseInt(bufferedReader.readLine().trim());

	        List<Integer> maxReplacements = new ArrayList<>();

	        for (int i = 0; i < maxReplacementsCount; i++) {
	            int maxReplacementsItem = Integer.parseInt(bufferedReader.readLine().trim());
	            maxReplacements.add(maxReplacementsItem);
	        }

	        List<Integer> res = balancedOrNot(expressions, maxReplacements);

	        for (int i = 0; i < res.size(); i++) {
	           // bufferedWriter.write(String.valueOf(res.get(i)));
	        	System.out.println(String.valueOf(res.get(i)));

	            if (i != res.size() - 1) {
	               // bufferedWriter.write("\n");
	            }
	        }

	       // bufferedWriter.newLine();

	        bufferedReader.close();
	        //bufferedWriter.close();
	    }
}
