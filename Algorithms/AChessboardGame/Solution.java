package AChessboardGame;

/**

 Two players are playing a game on a  chessboard. The rules of the game are as follows:

 The game starts with a single coin located at some  coordinates. The coordinates of the upper left cell are , and of the lower right cell are .

 In each move, a player must move the coin from cell  to one of the following locations:

 Note: The coin must remain inside the confines of the board.

 Beginning with player 1, the players alternate turns. The first player who is unable to make a move loses the game.

 The figure below shows all four possible moves using an  board for illustration:

 chess(1)

 Given the initial coordinates of the players' coins, assuming optimal play, determine which player will win the game.

 Function Description

 Complete the chessboardGame function in the editor below. It should return a string, either First or Second.

 chessboardGame has the following parameter(s):

 x: an integer that represents the starting column position
 y: an integer that represents the starting row position
 Input Format

 The first line contains an integer , the number of test cases.
 Each of the next  lines contains  space-separated integers  and .

 Constraints

 Output Format

 On a new line for each test case, print  if the first player is the winner. Otherwise, print .

 Sample Input

 3
 5 2
 5 3
 8 8
 Sample Output

 Second
 First
 First
 Explanation

 In the first case, player1 starts at the red square and can move to any of the blue squares. Regardless of which one is chosen, the player 2 can move to one of the green squares to win the game.

 image

 In the second case, player 1 starts at the red square and can move to any of the blue squares or the purple one. Moving to the purple one limits player 2 to the yellow square. From the yellow square, player 1 moves to the green square and wins.

 image

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

    static String chessboardGame(int x, int y){

        if ((x % 4 == 1 || x % 4 == 2) && (y % 4 == 1 || y % 4 == 2)){
            return("Second");
        }
        return("First");
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] xy = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xy[0]);

            int y = Integer.parseInt(xy[1]);

            String result = chessboardGame(x, y);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
