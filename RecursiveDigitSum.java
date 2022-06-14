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

// https://www.hackerrank.com/challenges/one-week-preparation-kit-recursive-digit-sum/problem

class Result {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */
    public static int calculateSuperDigit(String n) {
        Integer sum = 0;
        do {
            sum = n.chars().map(c -> (Integer) (c - '0')).reduce(0, Integer::sum);
            n = sum.toString();
        } while (n.length() > 1);
       return sum.intValue();
    }

    public static int superDigit(String n, int k) {
    // Write your code here
        int result = calculateSuperDigit(n);
        result = result * k;
        return calculateSuperDigit(String.valueOf(result));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
