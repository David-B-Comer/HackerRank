package IceCreamParlor;

/**

 Sunny and Johnny like to pool their money and go to the ice cream parlor. Johnny never buys the same flavor that Sunny does. The only other rule they have is that they spend all of their money.

 Given a list of prices for the flavors of ice cream, select the two that will cost all of the money they have.

 For example, they have  to spend and there are flavors costing . The two flavors costing  and  meet the criteria. Using -based indexing, they are at indices  and .

 Function Description

 Complete the icecreamParlor function in the editor below. It should return an array containing the indices of the prices of the two flavors they buy, sorted ascending.

 icecreamParlor has the following parameter(s):

 m: an integer denoting the amount of money they have to spend
 cost: an integer array denoting the cost of each flavor of ice cream
 Input Format

 The first line contains an integer, , denoting the number of trips to the ice cream parlor. The next  sets of lines each describe a visit. Each trip is described as follows:

 The integer , the amount of money they have pooled.
 The integer , the number of flavors offered at the time.
 space-separated integers denoting the cost of each flavor: .
 Note: The index within the cost array represents the flavor of the ice cream purchased.

 Constraints

 , ∀
 There will always be a unique solution.
 Output Format

 For each test case, print two space-separated integers denoting the indices of the two flavors purchased, in ascending order.

 Sample Input

 2
 4
 5
 1 4 5 3 2
 4
 4
 2 2 4 3
 Sample Output

 1 4
 1 2
 Explanation

 Sunny and Johnny make the following two trips to the parlor:

 The first time, they pool together  dollars. Of the five flavors available that day, flavors  and  have a total cost of .
 The second time, they pool together  dollars. TOf the four flavors available that day, flavors  and  have a total cost of .

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

    static int[] icecreamParlor(int m, int[] arr){

        int[] flavorPair = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++){
            int flavor1Cost = arr[i];
            int flavor2Cost = m - flavor1Cost;
            Integer flavor2Index = map.get(flavor2Cost);

            if (flavor2Index != null){
                flavorPair[0] = flavor2Index + 1;
                flavorPair[1] = i + 1;
                break;
            }
            map.put(flavor1Cost, i);
        }
        return flavorPair;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int m = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = icecreamParlor(m, arr);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

