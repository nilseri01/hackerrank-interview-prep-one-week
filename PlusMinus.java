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

// https://www.hackerrank.com/challenges/one-week-preparation-kit-plus-minus/problem

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
    // Write your code here
        int positiveCount = 0, negativeCount = 0, zeroCount = 0;
        for (int i = 0; i < arr.size(); i++) {
            int intValue = arr.get(i).intValue();
            if (intValue == 0) {
                zeroCount++;
            } else if (intValue < 0) {
                negativeCount++;
            } else {
                positiveCount++;
            }
        }
        System.out.println((double) positiveCount / arr.size());
        System.out.println((double) negativeCount / arr.size());
        System.out.println((double) zeroCount / arr.size());
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
