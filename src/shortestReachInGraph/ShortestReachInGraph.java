package shortestReachInGraph;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ShortestReachInGraph {

	public static class Graph {

		int size;
		ArrayList<ArrayList<Integer>> array;
		public Graph(int size) {
			this.size=size;
			array = new ArrayList<ArrayList<Integer>>();
			for(int i=0;i<size;i++){
				array.add(new ArrayList<Integer>());
			}
		}

		public void addEdge(int first, int second) {
			array.get(first).add(second);
			array.get(second).add(first);
			//array[second].add(first);
		}

		public int[] shortestReach(Graph graph,int startId) { 
			
			int[] visited = new int[graph.size];
			int[] distance = new int[graph.size];
			Arrays.fill(distance, -1);
			Queue<Integer> queue = new LinkedList<Integer>();
			
			queue.add(startId);
			distance[startId]=0;
			while(!queue.isEmpty()){
				visited[startId] = 1;
				int current = (int) queue.poll();	
				for(int node: graph.array.get(current)){
					//int next = itr.next();
					if(visited[node]!=1){
						queue.offer(node);
						visited[node]=1;
						distance[node] = distance[current] + 6;
					}
				}
				}
			return distance;
			}
		}

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int queries = scanner.nextInt();

		for (int t = 0; t < queries; t++) {

			// Create a graph of size n where each edge weight is 6:
			Graph graph = new Graph(scanner.nextInt());
			int m = scanner.nextInt();

			// read and set edges
			for (int i = 0; i < m; i++) {
				int u = scanner.nextInt() - 1;
				int v = scanner.nextInt() - 1;

				// add each edge to the graph
				graph.addEdge(u, v);
			}

			// Find shortest reach from node s
			int startId = scanner.nextInt() - 1;
			int[] distances = graph.shortestReach(graph, startId);

			for (int i = 0; i < distances.length; i++) {
				if (i != startId) {
					System.out.print(distances[i]);
					System.out.print(" ");
				}
			}
			System.out.println();
		}

		scanner.close();
	}

}
