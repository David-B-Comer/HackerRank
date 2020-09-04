package BigSorting;

/**

 Consider an array of numeric strings where each string is a positive number with anywhere from  to  digits. Sort the array's elements in non-decreasing, or ascending order of their integer values and print each element of the sorted array on a new line.

 Function Description

 Complete the bigSorting function in the editor below. It should return the sorted string array.

 bigSorting has the following parameter(s):

 unsorted: an unsorted array of integers as strings
 Input Format

 The first line contains an integer, , denoting the number of strings in .
 Each of the  subsequent lines contains an integer string .

 Constraints

 Each string is guaranteed to represent a positive integer without leading zeros.
 The total number of digits across all strings in  is between  and  (inclusive).
 Output Format

 Print each element of the sorted array on a new line.

 Sample Input 0

 6
 31415926535897932384626433832795
 1
 3
 10
 3
 5
 Sample Output 0

 1
 3
 3
 5
 10
 31415926535897932384626433832795
 Explanation 0

 The initial array of strings is . When we order each string by the real-world integer value it represents, we get:

 We then print each value on a new line, from smallest to largest.

 Sample Input 1

 8
 1
 2
 100
 12303479849857341718340192371
 3084193741082937
 3084193741082938
 111
 200
 Sample Output 1

 1
 2
 100
 111
 200
 3084193741082937
 3084193741082938
 12303479849857341718340192371

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

    static String[] bigSorting(String[] unsorted){

        BigInteger[] unsortedArray = new BigInteger[unsorted.length];

        for (int i = 0; i < unsorted.length; i++)
            unsortedArray[i] = new BigInteger(unsorted[i]);
        Arrays.sort(unsortedArray);
        String[] sorted = new String[unsorted.length];

        for (int i = 0; i < unsorted.length; i++)
            sorted[i] = unsortedArray[i].toString();

        return sorted;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] unsorted = new String[n];

        for (int i = 0; i < n; i++) {
            String unsortedItem = scanner.next();
            unsorted[i] = unsortedItem;
        }

        String[] result = bigSorting(unsorted);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}