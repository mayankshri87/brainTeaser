package amazonAircraft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.print.attribute.HashAttributeSet;

public class AmazonAirCraft {

	class Route {
		int[] arr;
		int distance;

		Route(List<Integer> l1, List<Integer> l2) {

			this.arr = new int[2];
			this.arr[0] = l1.get(0);
			this.arr[1] = l2.get(0);
			this.distance = l1.get(1) + l2.get(1);
		}
	}

	List<List<Integer>> optimalUtilization(int maximumOperatingTravelDistance,
			List<List<Integer>> forwardShippingRouteList, List<List<Integer>> returnShippingRouteList) {
		Map<Integer, Route> map = new HashMap<Integer, Route>();
		List<Integer> distanceList = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int i=0;i<forwardShippingRouteList.size();i++){
			for(int j=0;j<returnShippingRouteList.size();j++){
				System.out.println((forwardShippingRouteList.get(i)).get(1)+"   "+(returnShippingRouteList.get(j)).get(1));
				Route route = new Route(forwardShippingRouteList.get(i), returnShippingRouteList.get(j));
				map.put(route.distance, route);
				distanceList.add(route.distance);
			}
		}
		Collections.sort(distanceList);
		
		for(int k =0;k<distanceList.size();k++){
			if(distanceList.get(k)>maximumOperatingTravelDistance && k>0){
				Route new_route = map.get(distanceList.get(k-1));
				List<Integer> new_list = new ArrayList<Integer>();
				new_list.add(new_route.arr[0]);
				new_list.add(new_route.arr[1]);
				result.add(new_list);
				break;
			}else if(distanceList.get(k)==maximumOperatingTravelDistance){
				Route new_route = map.get(distanceList.get(k));
				List<Integer> new_list = new ArrayList<Integer>();
				new_list.add(new_route.arr[0]);
				new_list.add(new_route.arr[1]);
				result.add(new_list);
			}
		}

		return result;
	}

	public static void main(String[] arg) {

		int maxDistance = 20;
		List<List<Integer>> forwardShippingRouteList = new ArrayList<List<Integer>>();
		List<Integer> l10 = new ArrayList<Integer>();
		l10.add(1);
		l10.add(8);
		forwardShippingRouteList.add(l10);
		List<Integer> l11 = new ArrayList<Integer>();
		l11.add(2);
		l11.add(15);
		forwardShippingRouteList.add(l11);
		List<Integer> l12 = new ArrayList<Integer>();
		l12.add(3);
		l12.add(9);
		forwardShippingRouteList.add(l12);
		
		List<List<Integer>> returnShippingRouteList = new ArrayList<List<Integer>>();
		List<Integer> f10 = new ArrayList<Integer>();
		f10.add(1);
		f10.add(8);
		returnShippingRouteList.add(f10);
		List<Integer> f11 = new ArrayList<Integer>();
		f11.add(2);
		f11.add(11);
		returnShippingRouteList.add(f11);
		List<Integer> f12 = new ArrayList<Integer>();
		f12.add(3);
		f12.add(12);
		returnShippingRouteList.add(f12);
		AmazonAirCraft obj = new AmazonAirCraft();
		List<List<Integer>> result = obj.optimalUtilization(maxDistance, forwardShippingRouteList, returnShippingRouteList);
		
		
	}

}
