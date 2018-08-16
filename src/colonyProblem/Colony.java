package colonyProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Colony {

	static List<Integer> activeAndInactive(int cells[], int k) {
		int n = cells.length;
		int temp[] = new int[n];
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			temp[i] = cells[i];

		while (k-- > 0) {

			temp[0] = 0 ^ cells[1];
			temp[n - 1] = 0 ^ cells[n - 2];

			for (int i = 1; i <= n - 2; i++)
				temp[i] = cells[i - 1] ^ cells[i + 1];

			for (int i = 0; i < n; i++)
				cells[i] = temp[i];
		}
		for(int i=0;i<n;i++){
			result.add(i, cells[i]);
		}
		
		return result;
	}

	// Driver code
	public static void main(String[] args) {
		int cells[] = { 1, 1, 1, 0, 1, 1, 1, 1 };
		int k = 3;
		int n = cells.length;
		List<Integer> result = activeAndInactive(cells, k);

		for (Integer i : result) {
			System.out.print(i);
		}
	}

}
