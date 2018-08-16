package frequencyQuery;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FrequencyQuery {

	// Complete the freqQuery function below.
	static List<Integer> freqQuery(List<List<Integer>> queries) {
		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
		List<Integer> output = new ArrayList<Integer>();

		for (List list : queries) {
			int action = (int) list.get(0);
			if (action == 1) {
				if (frequencyMap.containsKey(list.get(1))) {
					frequencyMap.put((Integer) list.get(1), frequencyMap.get(list.get(1)) + 1);
				} else {
					frequencyMap.put((Integer) list.get(1), 1);
				}
			} else if (action == 2) {
				if(frequencyMap.containsKey((Integer) list.get(1))){
					int value = frequencyMap.get(list.get(1));
					if(value>1){
						frequencyMap.put((Integer) list.get(1), frequencyMap.get(list.get(1)) - 1);
					}else{
						frequencyMap.remove((Integer) list.get(1));
					}
					
				}		
			} else if (action == 3) {
				if (frequencyMap.containsValue(list.get(1))) {
					output.add(1);
				} else {
					output.add(0);
				}
			}
		}

		return output;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> queries = new ArrayList<>();

		IntStream.range(0, q).forEach(i -> {
			try {
				queries.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		List<Integer> ans = freqQuery(queries);

		/*bufferedWriter.write(ans.stream().map(Object::toString).collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();*/
	}
}
