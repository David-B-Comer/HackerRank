package DivisibleSumPairs;

/**

 You are given an array of  integers, , and a positive integer, . Find and print the number of  pairs where  and  +  is divisible by .

 For example,  and . Our three pairs meeting the criteria are  and .

 Function Description

 Complete the divisibleSumPairs function in the editor below. It should return the integer count of pairs meeting the criteria.

 divisibleSumPairs has the following parameter(s):

 n: the integer length of array
 ar: an array of integers
 k: the integer to divide the pair sum by
 Input Format

 The first line contains  space-separated integers,  and .
 The second line contains  space-separated integers describing the values of .

 Constraints

 Output Format

 Print the number of  pairs where  and  +  is evenly divisible by .

 Sample Input

 6 3
 1 3 2 6 1 2
 Sample Output

 5
 Explanation

 Here are the  valid pairs when :

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int divisibleSumPairs(int n, int k, int[] ar){

        int [] bucket = new int[k];
        int pairs = 0;

        for (int value : ar){
            int modValue = value % k;
            pairs += bucket[(k - modValue) % k];
            bucket[modValue]++;
        }
        return pairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = divisibleSumPairs(n, k, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
