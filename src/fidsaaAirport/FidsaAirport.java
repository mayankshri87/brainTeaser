package fidsaaAirport;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FidsaAirport {

	// Complete the findMinGates function below.
	static int findMinGates(List<Integer> arrivals, List<Integer> departures, int flights) {

		int[] arr = new int[arrivals.size()];
		int[] dep = new int[departures.size()];
		int n = arrivals.size();
		for(int i =0;i<arr.length;i++){
			arr[i] = arrivals.get(i);
		}
		
		for(int j=0;j<dep.length;j++){
			dep[j] = departures.get(j);
		}
		
		Arrays.sort(arr);
		Arrays.sort(dep);

		int plat_needed = 1, result = 1;
		int i = 1, j = 0;

		while (i < n && j < n) {

			if (arr[i] <= dep[j]) {
				plat_needed++;
				i++;

				if (plat_needed > result)
					result = plat_needed;
			}
			else {
				plat_needed--;
				j++;
			}
		}

		return result;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int arrivalsCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> arrivals = new ArrayList<>();

		for (int i = 0; i < arrivalsCount; i++) {
			int arrivalsItem = Integer.parseInt(bufferedReader.readLine().trim());
			arrivals.add(arrivalsItem);
		}

		int departuresCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> departures = new ArrayList<>();

		for (int i = 0; i < departuresCount; i++) {
			int departuresItem = Integer.parseInt(bufferedReader.readLine().trim());
			departures.add(departuresItem);
		}

		int flights = Integer.parseInt(bufferedReader.readLine().trim());

		int res = findMinGates(arrivals, departures, flights);

		bufferedWriter.write(String.valueOf(res));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
