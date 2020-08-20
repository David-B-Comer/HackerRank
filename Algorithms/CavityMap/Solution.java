package CavityMap;

/**

 You are given a square map as a matrix of integer strings. Each cell of the map has a value denoting its depth. We will call a cell of the map a cavity if and only if this cell is not on the border of the map and each cell adjacent to it has strictly smaller depth. Two cells are adjacent if they have a common side, or edge.

 Find all the cavities on the map and replace their depths with the uppercase character X.

 For example, given a matrix:

 989
 191
 111
 You should return:

 989
 1X1
 111
 The center cell was deeper than those on its edges: [8,1,1,1]. The deep cells in the top two corners don't share an edge with the center cell.

 Function Description

 Complete the cavityMap function in the editor below. It should return an array of strings, each representing a line of the completed map.

 cavityMap has the following parameter(s):

 grid: an array of strings, each representing a row of the grid
 Input Format

 The first line contains an integer , the number of rows and columns in the map.

 Each of the following  lines (rows) contains  positive digits without spaces (columns) representing depth at .

 Constraints


 Output Format

 Output  lines, denoting the resulting map. Each cavity should be replaced with the character X.

 Sample Input

 4
 1112
 1912
 1892
 1234
 Sample Output

 1112
 1X12
 18X2
 1234
 Explanation

 The two cells with the depth of 9 are not on the border and are surrounded on all sides by shallower cells. Their values have been replaced by X.

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

    static String[] cavityMap(String[] grid){

        char matrix[][] = new char[grid.length][grid.length];

        for (int i = 0; i < grid.length; i++){
            matrix[i] = grid[i].toCharArray();
        }
        for (int i = 1; i < grid.length - 1; i++){
            for (int j = 1; j < grid.length - 1; j++){
                if ((matrix[i - 1][j] < matrix[i][j]) &&
                        (matrix[i + 1][j] < matrix[i][j]) &&
                        (matrix[i][j - 1] < matrix[i][j]) &&
                        (matrix[i][j + 1] < matrix[i][j]))
                    matrix[i][j] = 'X';
            }
        }
        for (int i = 0; i < grid.length; i++){
            grid[i] = String.valueOf(matrix[i]);
        }
        return grid;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}