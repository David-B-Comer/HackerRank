package PokerNim;

/**

 Poker Nim is another -player game that's a simple variation on a Nim game. The rules of the games are as follows:

 The game starts with  piles of chips indexed from  to . Each pile  (where ) has  chips.
 The players move in alternating turns. During each move, the current player must perform either of the following actions:

 Remove one or more chips from a single pile.
 Add one or more chips to a single pile.
 At least  chip must be added or removed during each turn.

 To ensure that the game ends in finite time, a player cannot add chips to any pile  more than  times.
 The player who removes the last chip wins the game.
 Given the values of , , and the numbers of chips in each of the  piles, determine whether the person who wins the game is the first or second person to move. Assume both players move optimally.

 Input Format

 The first line contains an integer, , denoting the number of test cases.
 Each of the  subsequent lines defines a test case. Each test case is described over the following two lines:

 Two space-separated integers,  (the number of piles) and  (the maximum number of times an individual player can add chips to some pile ), respectively.
 space-separated integers, , where each  describes the number of chips at pile .
 Constraints

 Output Format

 For each test case, print the name of the winner on a new line (i.e., either  or ).

 Sample Input

 2
 2 5
 1 2
 3 5
 2 1 3
 Sample Output

 First
 Second

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

    static String pokerNim(int k, int[] c){

        int xor = c[0];

        for (int i = 1; i < c.length; i++){
            xor ^= c[i];
        }
        if (xor != 0)
            return "First";
        return "Second";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] c = new int[n];

            String[] cItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int cItem = Integer.parseInt(cItems[i]);
                c[i] = cItem;
            }

            String result = pokerNim(k, c);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

