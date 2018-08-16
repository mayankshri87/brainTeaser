package balancedBracket;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BalancedBracket {


    // Complete the isBalanced function below.
  static String isBalanced(String s) {
      
    Stack<Character> st = new Stack<Character>();
      
      for(Character c: s.toCharArray()){
          if(c=='{' || c=='[' || c=='('){
              st.push(c);
          }else{
        	  if(st.isEmpty()){
        		  return "NO";
        	  }
              if(c=='}' && st.peek()=='{' && !st.isEmpty()){
              st.pop();
          }else if(c==']' && st.peek()=='[' && !st.isEmpty()){
              st.pop();
          }else if(c==')' && st.peek()=='(' && !st.isEmpty()){
              st.pop();
          }else{
              return "NO";
          }
          } 
         }
      if(!st.isEmpty()){
          return "NO";
      }
      return "YES";
  }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);
            
            System.out.println(result);

           // bufferedWriter.write(result);
            //bufferedWriter.newLine();
        }

      //  bufferedWriter.close();

        scanner.close();
    }
}
