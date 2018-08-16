package castleOnTheGrid;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.InterningXmlVisitor;


public class CastleOnGrid {
	
	static int count=0;
    // Complete the minimumMoves function below.
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
    	
    	int[][] maze = new int[grid.length][grid.length];
    	List<Integer> result = new ArrayList<Integer>();
    	int i=0;
    	for(String str: grid){
    		int j=0;
    		for(Character c: str.toCharArray()){
    			if(c=='X'){
    				maze[i][j] = 1;
    			}else{
    				maze[i][j] = 0;
    			}
    			j++;
    		}
    		i++;
    	}
    	
    	if(solve(startX,startY,goalX,goalY,maze)){
    		for(int k=0;i<maze.length;i++){
    			for(int j=0;j<maze.length;j++){
    				if(maze[k][j]==10){
    					count++;
    				}
    				System.out.print(maze[k][j] + " ");
    			}
    			System.out.println("");
    		}
    		
    		//return count;
    	}
    	for(int k=0;i<maze.length;i++){
			for(int j=0;j<maze.length;j++){
				/*if(maze[k][j]==10){
					count++;
				}*/
				System.out.print(maze[k][j] + " ");
			}
			System.out.println("");
		}
    	return 0;
    }

    private static boolean solve(int startX, int startY, int goalX, int goalY,int[][] maze) {

    	if(isFinished(startX,startY,goalX,goalY)){
    		return true;
    	}
    	
    	if(isValid(startX,startY,maze)){
    		maze[startX][startY] = 10;
    		
    		if(solve(startX+1,startY,goalX, goalY, maze)){
    			return true;
    		}
    		if(solve(startX, startY+1,goalX,goalY, maze)){
    			return true;
    		}
    		if(solve(startX-1,startY,goalX, goalY, maze)){
    			return true;
    		}
    		if(solve(startX, startY-1,goalX,goalY, maze)){
    			return true;
    		}
    		
    		maze[startX][startY] = 0;
    	}
 
		return false;
	}

	private static boolean isValid(int startX, int startY,int[][] maze) {
		
		if(startX<0 || startX>=maze.length){
			return false;
		}
		if(startY<0 || startY>=maze.length){
			return false;
		}
		if(maze[startX][startY]==1 && maze[startX][startY]==10){
			return false;
		}
		return true;
	}

	private static boolean isFinished(int startX, int startY, int goalX, int goalY) {
		
		if(startX==goalX && startY==goalY){
			return true;
		}
		return false;
	}

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);

        int startY = Integer.parseInt(startXStartY[1]);

        int goalX = Integer.parseInt(startXStartY[2]);

        int goalY = Integer.parseInt(startXStartY[3]);

        int result = minimumMoves(grid, startX, startY, goalX, goalY);

       // bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }

}
