package PickingNumbers;

/**

 Given an array of integers, find and print the maximum number of integers you can select from the array such that the absolute difference between any two of the chosen integers is less than or equal to . For example, if your array is , you can create two subarrays meeting the criterion:  and . The maximum length subarray has  elements.

 Function Description

 Complete the pickingNumbers function in the editor below. It should return an integer that represents the length of the longest array that can be created.

 pickingNumbers has the following parameter(s):

 a: an array of integers
 Input Format

 The first line contains a single integer , the size of the array .
 The second line contains  space-separated integers .

 Constraints

 The answer will be .
 Output Format

 A single integer denoting the maximum number of integers you can choose from the array such that the absolute difference between any two of the chosen integers is .

 Sample Input 0

 6
 4 6 5 3 3 1
 Sample Output 0

 3
 Explanation 0

 We choose the following multiset of integers from the array: . Each pair in the multiset has an absolute difference  (i.e.,  and ), so we print the number of chosen integers, , as our answer.

 Sample Input 1

 6
 1 2 2 3 1 2
 Sample Output 1

 5
 Explanation 1

 We choose the following multiset of integers from the array: . Each pair in the multiset has an absolute difference  (i.e., , , and ), so we print the number of chosen integers, , as our answer.

 **/

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

class Result {

    public static int pickingNumbers(List<Integer> a){

        int[] count = new int[101];

        for (Integer i : a)
            count[i]++;

        int maximum = 0;

        for (int i = 1; i < count.length-1; i++)
            if (count[i] + count[i+1] > maximum)
                maximum = count[i] + count[i+1];
        return maximum;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}