package EqualizetheArray;

/**

 Karl has an array of integers. He wants to reduce the array until all remaining elements are equal. Determine the minimum number of elements to delete to reach his goal.

 For example, if his array is , we see that he can delete the  elements  and  leaving . He could also delete both twos and either the  or the , but that would take  deletions. The minimum number of deletions is .

 Function Description

 Complete the equalizeArray function in the editor below. It must return an integer that denotes the minimum number of deletions required.

 equalizeArray has the following parameter(s):

 arr: an array of integers
 Input Format

 The first line contains an integer , the number of elements in .
 The next line contains  space-separated integers .

 Constraints

 Output Format

 Print a single integer that denotes the minimum number of elements Karl must delete for all elements in the array to be equal.

 Sample Input

 5
 3 3 2 1 3
 Sample Output

 2
 Explanation

 Array . If we delete  and , all of the elements in the resulting array, , will be equal. Deleting these  elements is minimal. Our only other options would be to delete  elements to get an array of either  or .

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int equalizeArray(int[] arr){

        int array[] = new int[101];

        for (int i = 0; i < arr.length; i++){
            array[arr[i]]++;
        }
        int max = getMax(array);

        return arr.length - max;
    }

    private static int getMax(int[] array){

        int max = Integer.MIN_VALUE;

        for (int most : array){
            if (most > max){
                max = most;
            }
        }
        return max;
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

        int result = equalizeArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

