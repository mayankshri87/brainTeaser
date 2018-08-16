package amazonDeliveries;

import java.util.*;

public class AmazonDeliveries {
	
	class Pair{
		int x;
		int y;
		int distance;
		
		Pair(int x, int y){
			this.x = x;
			this.y = y;
			this.distance = ((this.x*this.x + this.y*this.y));
			this.distance = (int) Math.sqrt(this.distance);
		}
	}

	List<List<Integer>> ClosestXdestinations(int numDestinations, List<List<Integer>> allLocations, int numDeliveries) {
		
		int[] arr = new int[allLocations.size()];
		Map<Integer, Pair> map = new HashMap<Integer,Pair>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(numDeliveries<=numDestinations){
			int i =0;
			for(List list: allLocations){
				Pair p = new Pair((int)list.get(0),(int)list.get(1));
				map.put(i, p);
				arr[i] = p.distance;
				i++;
			}
			
			Arrays.sort(arr);
			
			for(int j =0;j<=numDeliveries;j++){
				int temp = arr[0];
				for(Map.Entry<Integer, Pair> entry: map.entrySet()){
					if(entry.getValue().distance==temp){
						List<Integer> newList = new ArrayList<Integer>();
						newList.add(entry.getValue().x);
						newList.add(entry.getValue().y);
						result.add(newList);
					}
					
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] arg){
		
	}

}
