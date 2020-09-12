package LargestPermutation;

/**

 You are given an unordered array of unique integers incrementing from . You can swap any two elements a limited number of times. Determine the largest lexicographical value array that can be created by executing no more than the limited number of swaps.

 For example, if  and the maximum swaps , the following arrays can be formed by swapping the  with the other elements:

 [2,1,3,4]
 [3,2,1,4]
 [4,2,3,1]
 The highest value of the four (including the original) is . If , we can swap to the highest possible value: .

 Function Description

 Complete the largestPermutation function in the editor below. It must return an array that represents the highest value permutation that can be formed.

 largestPermutation has the following parameter(s):

 k: an integer that represents the limit of swaps
 arr: an array of integers
 Input Format

 The first line contains two space-separated integers  and , the length of  and the maximum swaps that can be performed. The second line contains  unique space-separated integers  where .

 Constraints



 Output Format

 Print the lexicographically largest permutation you can make with at most  swaps.
 Sample Input 0

 5 1
 4 2 3 5 1
 Sample Output 0

 5 2 3 4 1
 Explanation 0

 You can swap any two numbers in  and see the largest permutation is

 Sample Input 1

 3 1
 2 1 3
 Sample Output 1

 3 1 2
 Explanation 1

 With 1 swap we can get ,  and . Of these,  is the largest permutation.

 Sample Input 2

 2 1
 2 1
 Sample Output 2

 2 1
 Explanation 2

 We can see that  is already the largest permutation. We don't make any swaps.

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

    static int[] largestPermutation(int k, int[] arr){

        int j;

        for (int i = 0; i < arr.length; i++){
            if (k == 0)
                break;
            if (arr[i] == arr.length - i)
                continue;
            for (j = i + 1; j < arr.length; j++)
                if (arr[j] == arr.length - i)
                    break;
            arr[i] = arr[i] + arr[j] - (arr[j] = arr[i]);
            k--;
        }
        return arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = largestPermutation(k, arr);

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
