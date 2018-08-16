package countTriplets;
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

public class CountTriplet {

    // Complete the countTriplets function below.
  static long countTriplets(long[] arr, long r) {
      long cnt = 0;
      Map<Long, Long> map = new HashMap<>();
      Map<Long, Long> rMap = new HashMap<>();
      for (long n : arr) {
          if (n % r == 0) {
              long pre = n / r;
              Long cnt2 = rMap.get(pre);
              if (cnt2 != null) cnt += cnt2;
              
              Long cnt1 = map.get(pre);
              if (cnt1 != null) rMap.put(n, rMap.getOrDefault(n, 0L) + cnt1);
          }
          map.put(n, map.getOrDefault(n, 0L) + 1);
      }
      return cnt;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
      //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      String[] nr = scanner.nextLine().split(" ");

      long n = Long.parseLong(nr[0]);

      long r = Long.parseLong(nr[1]);

      long[] arr = new long[(int)n];

      String[] arrItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
          long arrItem = Long.parseLong(arrItems[i]);
          arr[i] = arrItem;
      }

      long ans = countTriplets(arr, r);

    /*  bufferedWriter.write(String.valueOf(ans));
      bufferedWriter.newLine();

      bufferedWriter.close();
*/
      scanner.close();
  }
}
