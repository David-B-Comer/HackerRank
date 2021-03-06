package BeautifulDaysattheMovies;

/**

 Lily likes to play games with integers. She has created a new game where she determines the difference between a number and its reverse. For instance, given the number , its reverse is . Their difference is . The number  reversed is , and their difference is .

 She decides to apply her game to decision making. She will look at a numbered range of days and will only go to a movie on a beautiful day.

 Given a range of numbered days,  and a number , determine the number of days in the range that are beautiful. Beautiful numbers are defined as numbers where  is evenly divisible by . If a day's value is a beautiful number, it is a beautiful day. Print the number of beautiful days in the range.

 Function Description

 Complete the beautifulDays function in the editor below. It must return the number of beautiful days in the range.

 beautifulDays has the following parameter(s):

 i: the starting day number
 j: the ending day number
 k: the divisor
 Input Format

 A single line of three space-separated integers describing the respective values of , , and .

 Constraints

 Output Format

 Print the number of beautiful days in the inclusive range between  and .

 Sample Input

 20 23 6
 Sample Output

 2
 Explanation

 Lily may go to the movies on days , , , and . We perform the following calculations to determine which days are beautiful:

 Day  is beautiful because the following evaluates to a whole number:
 Day  is not beautiful because the following doesn't evaluate to a whole number:
 Day  is beautiful because the following evaluates to a whole number:
 Day  is not beautiful because the following doesn't evaluate to a whole number:
 Only two days,  and , in this interval are beautiful. Thus, we print  as our answer.

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int beautifulDays(int i, int j, int k){

        int start = i;
        int end = j;
        int result = 0;
        int count = 0;
        StringBuilder sb= new StringBuilder();

        for(i = start; start <= end; start++){
            sb.append("" + start);
            sb.reverse();
            result = Math.abs(start - Integer.parseInt(sb.toString())) % k;
            sb.setLength(0);
            if(result == 0){
                count++;
            }

        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

