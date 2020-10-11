package TheGridSearch;

/**

 Given a 2D array of digits or grid, try to find the occurrence of a given 2D pattern of digits. For example, consider the following grid:

 1234567890
 0987654321
 1111111111
 1111111111
 2222222222
 Assume we need to look for the following 2D pattern array:

 876543
 111111
 111111
 The 2D pattern begins at the second row and the third column of the grid. The pattern is said to be present in the grid.

 Function Description

 Complete the gridSearch function in the editor below. It should return YES if the pattern exists in the grid, or NO otherwise.

 gridSearch has the following parameter(s):

 G: the grid to search, an array of strings
 P: the pattern to search for, an array of strings
 Input Format

 The first line contains an integer , the number of test cases.

 Each of the  test cases is represented as follows:
 The first line contains two space-separated integers  and , indicating the number of rows and columns in the grid .
 This is followed by  lines, each with a string of  digits representing the grid .
 The following line contains two space-separated integers,  and , indicating the number of rows and columns in the pattern grid .
 This is followed by  lines, each with a string of  digits representing the pattern .

 Constraints





 Output Format

 Display YES or NO, depending on whether  is present in .

 Sample Input

 2
 10 10
 7283455864
 6731158619
 8988242643
 3830589324
 2229505813
 5633845374
 6473530293
 7053106601
 0834282956
 4607924137
 3 4
 9505
 3845
 3530
 15 15
 400453592126560
 114213133098692
 474386082879648
 522356951189169
 887109450487496
 252802633388782
 502771484966748
 075975207693780
 511799789562806
 404007454272504
 549043809916080
 962410809534811
 445893523733475
 768705303214174
 650629270887160
 2 2
 99
 99
 Sample Output

 YES
 NO
 Explanation

 The first test in the input file is:

 10 10
 7283455864
 6731158619
 8988242643
 3830589324
 2229505813
 5633845374
 6473530293
 7053106601
 0834282956
 4607924137
 3 4
 9505
 3845
 3530
 As one may see, the given pattern is present in the larger grid, as marked in bold below.

 7283455864
 6731158619
 8988242643
 3830589324
 2229505813
 5633845374
 6473530293
 7053106601
 0834282956
 4607924137
 The second test in the input file is:

 15 15
 400453592126560
 114213133098692
 474386082879648
 522356951189169
 887109450487496
 252802633388782
 502771484966748
 075975207693780
 511799789562806
 404007454272504
 549043809916080
 962410809534811
 445893523733475
 768705303214174
 650629270887160
 2 2
 99
 99
 The search pattern is:

 99
 99
 This cannot be found in the larger grid.

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

    static String gridSearch(String[] G, String[] P){
        int search = 0;

        for (int i = 0; i < G.length; i++){
            int index = G[i].indexOf(P[0]);

            while (index >= 0){
                int n = i;
                search = 1;

                for (int j = 1; j < P.length; j++){
                    n++;
                    String str = G[n].substring(index, index + P[0].length());

                    if (str.equals(P[j]) == false)
                        search = 0;
                }
                if (search == 1)
                    return "YES";
                index = G[i].indexOf(P[0], index + 1);
            }
        }
        return "NO";
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            String result = gridSearch(G, P);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
