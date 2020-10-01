package M3DSurfaceArea;

/**

 Madison, is a little girl who is fond of toys. Her friend Mason works in a toy manufacturing factory . Mason has a 2D board  of size  with  rows and  columns. The board is divided into cells of size  with each cell indicated by it's coordinate . The cell  has an integer  written on it. To create the toy Mason stacks  number of cubes of size  on the cell .

 Given the description of the board showing the values of  and that the price of the toy is equal to the 3d surface area find the price of the toy.

 image

 Input Format

 The first line contains two space-separated integers  and  the height and the width of the board respectively.

 The next  lines contains  space separated integers. The  integer in  line denotes .

 Constraints

 Output Format

 Print the required answer, i.e the price of the toy, in one line.

 Sample Input 0

 1 1
 1
 Sample Output 0

 6
 Explanation 0

 image The surface area of  cube is 6.

 Sample Input 1

 3 3
 1 3 4
 2 2 3
 1 2 4
 Sample Output 1

 60
 Explanation 1

 The sample input corresponds to the figure described in problem statement.

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int surfaceArea(int[][] A){

        int area = 0;

        for (int i = 0; i < A.length; i++){
            int rowArea = A[i][0];

            for (int j = 0; j < A[i].length - 1; j++){
                if (A[i][j + 1] > A[i][j]){
                    rowArea += A[i][j + 1] - A[i][j];
                }
            }
            area += rowArea * 2;
        }

        for (int i = 0; i < A[0].length; i++){
            int columnArea = A[0][i];

            for (int j = 0; j < A.length - 1; j++){
                if (A[j + 1][i] > A[j][i]){
                    columnArea += A[j + 1][i] - A[j][i];
                }
            }
            area += columnArea * 2;
        }
        area += A.length * A[0].length * 2;

        return area;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] HW = scanner.nextLine().split(" ");

        int H = Integer.parseInt(HW[0]);

        int W = Integer.parseInt(HW[1]);

        int[][] A = new int[H][W];

        for (int i = 0; i < H; i++) {
            String[] ARowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < W; j++) {
                int AItem = Integer.parseInt(ARowItems[j]);
                A[i][j] = AItem;
            }
        }

        int result = surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

