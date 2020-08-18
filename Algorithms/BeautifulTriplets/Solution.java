package BeautifulTriplets;

/**

 Given a sequence of integers , a triplet  is beautiful if:

 Given an increasing sequenc of integers and the value of , count the number of beautiful triplets in the sequence.

 For example, the sequence  and . There are three beautiful triplets, by index: . To test the first triplet,  and .

 Function Description

 Complete the beautifulTriplets function in the editor below. It must return an integer that represents the number of beautiful triplets in the sequence.

 beautifulTriplets has the following parameters:

 d: an integer
 arr: an array of integers, sorted ascending
 Input Format

 The first line contains  space-separated integers  and , the length of the sequence and the beautiful difference.
 The second line contains  space-separated integers .

 Constraints

 Output Format

 Print a single line denoting the number of beautiful triplets in the sequence.

 Sample Input

 7 3
 1 2 4 5 7 8 10
 Sample Output

 3
 Explanation

 The input sequence is , and our beautiful difference . There are many possible triplets , but our only beautiful triplets are  ,  and  by value not index. Please see the equations below:





 Recall that a beautiful triplet satisfies the following equivalence relation:  where .

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class Solution{

    static int beautifulTriplets(int d, int[] arr){

        int triplets = 0;

        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] - arr[i] == d){
                    for (int k = j + 1; k < arr.length; k++){
                        if (arr[k] - arr[j] == d){
                            triplets++;
                        }
                    }
                }
            }
        }
        return triplets;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = beautifulTriplets(d, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
