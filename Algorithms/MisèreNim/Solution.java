package MisèreNim;

/**

 Two people are playing game of Misère Nim. The basic rules for this game are as follows:

 The game starts with  piles of stones indexed from  to . Each pile  (where ) has  stones.
 The players move in alternating turns. During each move, the current player must remove one or more stones from a single pile.
 The player who removes the last stone loses the game.
 Given the value of  and the number of stones in each pile, determine whether the person who wins the game is the first or second person to move. If the first player to move wins, print First on a new line; otherwise, print Second. Assume both players move optimally.

 Input Format

 The first line contains an integer, , denoting the number of test cases.
 Each of the  subsequent lines defines a test case. Each test case is described over the following two lines:

 An integer, , denoting the number of piles.
 space-separated integers, , where each  describes the number of stones at pile .
 Constraints

 Output Format

 For each test case, print the name of the winner on a new line (i.e., either First or Second).

 Sample Input

 2
 2
 1 1
 3
 2 1 3
 Sample Output

 First
 Second
 Explanation

 In the first testcase, the first player removes 1 stone from the first pile and then the second player has no moves other than removing the only stone in the second pile. So first wins.

 In the second testcase, the series of moves can be depicted as:

 image

 In every possible move of first player we see that the last stone is picked by him, so second player wins.

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

    static String misereNim(int[] s){

        int xorValue = 0;
        int stones = 0;

        for (int i = 0; i < s.length; i++){
            xorValue ^= s[i];
            stones += s[i];
        }

        if (s.length % 2 == 0){
            if (s.length != stones && xorValue == 0)
                return "Second";
            return "First";
        }
        else{
            if (s.length == stones || xorValue == 0)
                return "Second";
            return "First";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] s = new int[n];

            String[] sItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int sItem = Integer.parseInt(sItems[i]);
                s[i] = sItem;
            }

            String result = misereNim(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
