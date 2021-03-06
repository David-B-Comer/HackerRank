package IntroductionToNimGame;

/**

 Nim is the most famous two-player algorithm game. The basic rules for this game are as follows:

 The game starts with a number of piles of stones. The number of stones in each pile may not be equal.
 The players alternately pick up  or more stones from  pile
 The player to remove the last stone wins.
 For example, there are  piles of stones having  stones in them. Play may proceed as follows:

 Player  Takes           Leaving
 pile=[3,2,4]
 1       2 from pile[1]  pile=[3,4]
 2       2 from pile[1]  pile=[3,2]
 1       1 from pile[0]  pile=[2,2]
 2       1 from pile[0]  pile=[1,2]
 1       1 from pile[1]  pile=[1,1]
 2       1 from pile[0]  pile=[0,1]
 1       1 from pile[1]  WIN
 Given the value of  and the number of stones in each pile, determine the game's winner if both players play optimally.

 Function Desctription

 Complete the nimGame function in the editor below. It should return a string, either First or Second.

 nimGame has the following parameter(s):

 pile: an integer array that represents the number of stones in each pile
 Input Format

 The first line contains an integer, , denoting the number of games they play.

 Each of the next  pairs of lines is as follows:

 The first line contains an integer , the number of piles.
 The next line contains  space-separated integers , the number of stones in each pile.
 Constraints

 Player 1 always goes first.
 Output Format

 For each game, print the name of the winner on a new line (i.e., either First or Second).

 Sample Input

 2
 2
 1 1
 3
 2 1 4
 Sample Output

 Second
 First
 Explanation

 In the first case, there are  piles of  stones. Player  has to remove one pile on the first move. Player  removes the second for a win.

 In the second case, there are  piles of  stones. If player  removes any one pile, player  can remove all but one of another pile and force a win. If player  removes less than a pile, in any case, player  can force a win as well, given optimal play.

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

    static String nimGame(int[] pile){

        int result = 0;

        for (int i = 0; i < pile.length; i++)
            result ^= pile[i];

        if (result == 0)
            return "Second";
        else
            return "First";
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] pile = new int[n];

            String[] pileItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int pileItem = Integer.parseInt(pileItems[i]);
                pile[i] = pileItem;
            }

            String result = nimGame(pile);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

