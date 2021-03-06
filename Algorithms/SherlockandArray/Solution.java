package SherlockandArray;

/**

 Watson gives Sherlock an array of integers. His challenge is to find an element of the array such that the sum of all elements to the left is equal to the sum of all elements to the right. For instance, given the array ,  is between two subarrays that sum to . If your starting array is , that element satisfies the rule as left and right sum to .

 You will be given arrays of integers and must determine whether there is an element that meets the criterion.

 Function Description

 Complete the balancedSums function in the editor below. It should return a string, either YES if there is an element meeting the criterion or NO otherwise.

 balancedSums has the following parameter(s):

 arr: an array of integers
 Input Format

 The first line contains , the number of test cases.

 The next  pairs of lines each represent a test case.
 - The first line contains , the number of elements in the array .
 - The second line contains  space-separated integers  where .

 Constraints





 Output Format

 For each test case print YES if there exists an element in the array, such that the sum of the elements on its left is equal to the sum of the elements on its right; otherwise print NO.

 Sample Input 0

 2
 3
 1 2 3
 4
 1 2 3 3
 Sample Output 0

 NO
 YES
 Explanation 0

 For the first test case, no such index exists.
 For the second test case, , therefore index  satisfies the given conditions.

 Sample Input 1

 3
 5
 1 1 4 1 1
 4
 2 0 0 0
 4
 0 0 2 0
 Sample Output 1

 YES
 YES
 YES
 Explanation 1

 In the first test case,  is between two subarrays summing to .
 In the second case,  is between two subarrays summing to .
 In the third case,  is between two subarrays summing to .

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

public class Solution{

    static String balancedSums(List<Integer> arr){

        int element = 0;
        int sum = 0;

        for (int i : arr){
            sum += i;
        }

        for (int j : arr){
            if (element * 2 == sum - j){
                return "YES";
            }
            element = element + j;
        }
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = balancedSums(arr);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

