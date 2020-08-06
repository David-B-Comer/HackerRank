package FormingaMagicSquare;

/**

 We define a magic square to be an  matrix of distinct positive integers from  to  where the sum of any row, column, or diagonal of length  is always equal to the same number: the magic constant.

 You will be given a  matrix  of integers in the inclusive range . We can convert any digit  to any other digit  in the range  at cost of . Given , convert it into a magic square at minimal cost. Print this cost on a new line.

 Note: The resulting magic square must contain distinct integers in the inclusive range .

 For example, we start with the following matrix :

 5 3 4
 1 5 8
 6 4 2
 We can convert it to the following magic square:

 8 3 4
 1 5 9
 6 7 2
 This took three replacements at a cost of .

 Function Description

 Complete the formingMagicSquare function in the editor below. It should return an integer that represents the minimal total cost of converting the input square to a magic square.

 formingMagicSquare has the following parameter(s):

 s: a  array of integers
 Input Format

 Each of the lines contains three space-separated integers of row .

 Constraints

 Output Format

 Print an integer denoting the minimum cost of turning matrix  into a magic square.

 Sample Input 0

 4 9 2
 3 5 7
 8 1 5
 Sample Output 0

 1
 Explanation 0

 If we change the bottom right value, , from  to  at a cost of ,  becomes a magic square at the minimum possible cost.

 Sample Input 1

 4 8 2
 4 5 7
 6 1 6
 Sample Output 1

 4
 Explanation 1

 Using 0-based indexing, if we make

 -> at a cost of
 -> at a cost of
 -> at a cost of ,
 then the total cost will be .

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int formingMagicSquare(int[][] s){

        int[][][] magicSquares ={
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}}
        };
        int cost = 0;
        int minimumCost = 100;

        for (int i = 0; i < magicSquares.length; i ++){
            cost = 0;

            for (int x = 0; x < s.length; x++){
                for (int y = 0; y < s.length; y++){
                    cost += Math.abs(magicSquares[i][x][y] - s[x][y]);
                }
            }
            if (cost < minimumCost)
                minimumCost = cost;
        }
        return minimumCost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

