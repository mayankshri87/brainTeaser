package matchingPair;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class MatchingPair {

	/*
	 * Complete the findMatchingPair function below.
	 */
	static int findMatchingPair(String input) {

		StringBuilder sb = new StringBuilder(input);
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int lastUpatedIndex = -1;
		
		for(int i=0;i<input.length();i++){
			map.put(input.charAt(i), i);
		}

		for (int i = 0; i <=sb.length()-2; i++) {
				if (sb.charAt(i) == Character.toUpperCase(sb.charAt(i+1))) {
					lastUpatedIndex = map.get(sb.charAt(i+1));
					sb.deleteCharAt(i+1);
					sb.deleteCharAt(i);
					i=0;
				}
		}
		return lastUpatedIndex;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {


		int res = findMatchingPair("ABbCca");
		System.out.println(res);

	}
}
