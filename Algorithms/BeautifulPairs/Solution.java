package BeautifulPairs;

/**

 You are given two arrays,  and , both containing  integers.

 A pair of indices  is beautiful if the  element of array  is equal to the  element of array . In other words, pair  is beautiful if and only if . A set containing beautiful pairs is called a beautiful set.

 A beautiful set is called pairwise disjoint if for every pair  belonging to the set there is no repetition of either  or  values. For instance, if  and  the beautiful set  is not pairwise disjoint as there is a repetition of , that is .

 Your task is to change exactly  element in  so that the size of the pairwise disjoint beautiful set is maximum.

 Function Description

 Complete the beautifulPairs function in the editor below. It should return an integer that represents the maximum number of pairwise disjoint beautiful pairs that can be formed.

 beautifulPairs has the following parameters:

 A: an array of integers
 B: an array of integers
 Input Format

 The first line contains a single integer , the number of elements in  and .
 The second line contains  space-separated integers .
 The third line contains  space-separated integers .

 Constraints

 Output Format

 Determine and print the maximum possible number of pairwise disjoint beautiful pairs.

 Note: You must first change  element in , and your choice of element must be optimal.

 Sample Input 0

 4
 1 2 3 4
 1 2 3 3
 Sample Output 0

 4
 Explanation 0

 You are given  and .
 The beautiful set is  and maximum sized pairwise disjoint beautiful set is either  or .
 We can do better. We change the  element of array  from  to . Now new B array is:  and the pairwise disjoint beautiful set is . So, the answer is 4.
 Note that we could have also selected index 3 instead of index 2 but it would have yeilded the same result. Any other choice of index is not optimal.

 Sample Input 1

 6
 3 5 7 11 5 8
 5 7 11 10 5 8
 Sample Output 1

 6

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

    static int beautifulPairs(int[] A, int[] B){

        int pairs = 0;

        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < B.length; j++){
                if (A[i] == B[j]){
                    A[i] = - 1;
                    B[j] = - 1;
                    pairs++;
                    break;
                }
            }
        }
        if (pairs == A.length)
            return pairs - 1;

        return pairs + 1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int AItem = Integer.parseInt(AItems[i]);
            A[i] = AItem;
        }

        int[] B = new int[n];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        int result = beautifulPairs(A, B);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

