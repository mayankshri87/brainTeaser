package dfs;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import sun.security.krb5.internal.ccache.CCacheOutputStream;

public class DFS {
	
	static int largestIsland;
	static int max;
	
	static int maxRegion(int rows,int columns, int[][] grid,boolean[][] visited) {
		max =0;
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				if(grid[i][j]==1 && !visited[i][j]){
					largestIsland=1;
					dfsUtil(rows, columns, grid, visited,i,j);
				}
			}
		}
		
		return max;
    }

    private static void dfsUtil(int rows,int columns, int[][] grid, boolean[][] visited,int rowNum, int columnNum) {
		
    	int[] connectedRow = {-1,-1,-1,0,0,1,1,1};
    	int[] connectedColumn = {-1,0,1,-1,1,-1,0,1};
    	visited[rowNum][columnNum] = true;
    	for(int i=0;i<connectedRow.length;i++){
    		if(isPartOfIsland(rows, columns, rowNum+connectedRow[i],columnNum+connectedColumn[i],visited, grid)){
    	    	
    	    		dfsUtil(rows, columns, grid, visited, rowNum+connectedRow[i], columnNum+connectedColumn[i]);
    	    	}
    		}
	}

	private static boolean isPartOfIsland(int rows, int columns, int rowNum, int columnNum, boolean[][] visited,int[][] grid) {
		
		if(rowNum<0 || rowNum>=rows) return false;
		if(columnNum<0 || columnNum>=columns) return false;
		if(grid[rowNum][columnNum]==0 || visited[rowNum][columnNum]) {
			return false;
		}
		
		largestIsland++;
    	if(max<largestIsland){
    		max=largestIsland;
    	}
		return true;
	}

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
              int gridItem = Integer.parseInt(gridRowItems[j]);
                grid[i][j] = gridItem;
            }
        }

        int res = maxRegion(n,m,grid,visited);
        System.out.println(res);

      

        scanner.close();
    }

}
