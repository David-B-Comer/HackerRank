package MiniMaxSum;

/**

 Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers.

 Example

 The minimum sum is  and the maximum sum is . The function prints

 16 24
 Function Description

 Complete the miniMaxSum function in the editor below.

 miniMaxSum has the following parameter(s):

 arr: an array of  integers
 Print
 Print two space-separated integers on one line: the minimum sum and the maximum sum of  of  elements.

 Input Format

 A single line of five space-separated integers.

 Constraints


 Output Format

 Print two space-separated long integers denoting the respective minimum and maximum values that can be calculated by summing exactly four of the five integers. (The output can be greater than a 32 bit integer.)

 Sample Input

 1 2 3 4 5
 Sample Output

 10 14
 Explanation

 The numbers are , , , , and . Calculate the following sums using four of the five integers:

 Sum everything except , the sum is .
 Sum everything except , the sum is .
 Sum everything except , the sum is .
 Sum everything except , the sum is .
 Sum everything except , the sum is .
 Hints: Beware of integer overflow! Use 64-bit Integer.

 Need help to get started? Try the Solve Me First problem

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static void miniMaxSum(int[] arr) {

        long min = arr[0];
        long max = arr[0];
        long sum = arr[0];

        for (int i = 1; i < arr.length; i++){
            sum += arr[i];
            if (arr[i] < min){
                min = arr[i];
            }
            if (arr[i] > max){
                max = arr[i];
            }
        }
        System.out.print((sum - max) + " " + (sum - min));

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
