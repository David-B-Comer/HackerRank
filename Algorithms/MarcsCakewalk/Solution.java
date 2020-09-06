package MarcsCakewalk;

/**

 Marc loves cupcakes, but he also likes to stay fit. Each cupcake has a calorie count, and Marc can walk a distance to expend those calories. If Marc has eaten  cupcakes so far, after eating a cupcake with  calories he must walk at least  miles to maintain his weight.

 For example, if he eats  cupcakes with calorie counts in the following order: , the miles he will need to walk are . This is not the minimum, though, so we need to test other orders of consumption. In this case, our minimum miles is calculated as .

 Given the individual calorie counts for each of the cupcakes, determine the minimum number of miles Marc must walk to maintain his weight. Note that he can eat the cupcakes in any order.

 Function Description

 Complete the marcsCakewalk function in the editor below. It should return a long integer that represents the minimum miles necessary.

 marcsCakewalk has the following parameter(s):

 calorie: an integer array that represents calorie count for each cupcake
 Input Format

 The first line contains an integer , the number of cupcakes in .
 The second line contains  space-separated integers .

 Constraints

 Output Format

 Print a long integer denoting the minimum number of miles Marc must walk to maintain his weight.

 Sample Input 0

 3
 1 3 2
 Sample Output 0

 11
 Explanation 0

 Let's say the number of miles Marc must walk to maintain his weight is . He can minimize  by eating the  cupcakes in the following order:

 Eat the cupcake with  calories, so .
 Eat the cupcake with  calories, so .
 Eat the cupcake with  calories, so .
 We then print the final value of , which is , as our answer.

 Sample Input 1

 4
 7 4 9 6
 Sample Output 1

 79
 Explanation 1

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

    static long marcsCakewalk(int[] calorie){

        Arrays.sort(calorie);
        int j = 0;
        long miles = 0;

        for (int i = (calorie.length - 1); i >= 0; i--){
            miles = miles + (long)(calorie[i] * Math.pow(2, j));
            j++;
        }
        return miles;
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] calorie = new int[n];

        String[] calorieItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int calorieItem = Integer.parseInt(calorieItems[i]);
            calorie[i] = calorieItem;
        }

        long result = marcsCakewalk(calorie);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

