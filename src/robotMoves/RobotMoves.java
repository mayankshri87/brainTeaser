package robotMoves;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RobotMoves {
	
   static class Pair{
        int x;
        int y;
        
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
        
        void moveXDirection(Pair pair){
        	pair.x = pair.x + pair.y;
        }
        
        void moveYDirection(Pair pair){
        	pair.y= pair.x + pair.y;
        }
    }    

// Complete the canReach function below.
    static String canReach(int x1, int y1, int x2, int y2) {

    	Pair p1= new Pair(x1, y1);
    	Pair p2 = new Pair(x2,y2);
    	
    	while(p1.x<p2.x){
    		p1.moveXDirection(p1);
    	}
    	while(p1.y<p2.y){
    		p1.moveYDirection(p1);
    	}
    	
    	if(p1.x==p2.x && p1.y==p2.y){
    		return "YES";
    	}
    	
    	return "NO";
    }
	
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int x1 = Integer.parseInt(bufferedReader.readLine().trim());

        int y1 = Integer.parseInt(bufferedReader.readLine().trim());

        int x2 = Integer.parseInt(bufferedReader.readLine().trim());

        int y2 = Integer.parseInt(bufferedReader.readLine().trim());

        String res = canReach(x1, y1, x2, y2);
        System.err.println(res);

        //bufferedWriter.write(res);
       // bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}

