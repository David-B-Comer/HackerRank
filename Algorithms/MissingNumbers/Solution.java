package MissingNumbers;

/**

 Numeros the Artist had two lists that were permutations of one another. He was very proud. Unfortunately, while transporting them from one exhibition to another, some numbers were lost out of the first list. Can you find the missing numbers?

 As an example, the array with some numbers missing, . The original array of numbers . The numbers missing are .

 Notes

 If a number occurs multiple times in the lists, you must ensure that the frequency of that number in both lists is the same. If that is not the case, then it is also a missing number.
 You have to print all the missing numbers in ascending order.
 Print each missing number once, even if it is missing multiple times.
 The difference between maximum and minimum number in the second list is less than or equal to .
 Function Description

 Complete the missingNumbers function in the editor below. It should return a sorted array of missing numbers.

 missingNumbers has the following parameter(s):

 arr: the array with missing numbers
 brr: the original array of numbers
 Input Format

 There will be four lines of input:

 - the size of the first list,
 The next line contains  space-separated integers
 - the size of the second list,
 The next line contains  space-separated integers

 Constraints

 Output Format

 Output the missing numbers in ascending order.

 Sample Input

 10
 203 204 205 206 207 208 203 204 205 206
 13
 203 204 204 205 206 207 205 208 203 206 205 206 204
 Sample Output

 204 205 206
 Explanation

 is present in both arrays. Its frequency in  is , while its frequency in  is . Similarly,  and  occur twice in , but three times in . The rest of the numbers have the same frequencies in both lists.

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

    static int[] missingNumbers(int[] arr, int[] brr){

        int[] arrFrequency = new int[10001];
        int[] brrFrequency = new int[10001];

        for (int i = 0; i < arr.length; i++)
            arrFrequency[arr[i]]++;
        for (int i = 0; i < brr.length; i++)
            brrFrequency[brr[i]]++;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arrFrequency.length; i++)
            if (arrFrequency[i] < brrFrequency[i])
                list.add(i);
        Collections.sort(list);

        int[] missingNums = new int[list.size()];

        for (int i = 0; i < list.size(); i++)
            missingNums[i] = list.get(i);
        return missingNums;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] brr = new int[m];

        String[] brrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrItems[i]);
            brr[i] = brrItem;
        }

        int[] result = missingNumbers(arr, brr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

