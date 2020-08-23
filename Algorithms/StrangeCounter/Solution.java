package StrangeCounter;

/**

 Bob has a strange counter. At the first second, it displays the number . Each second, the number displayed by the counter decrements by  until it reaches .

 The counter counts down in cycles. In next second, the timer resets to  and continues counting down. The diagram below shows the counter values for each time  in the first three cycles:

 strange(1).png

 Find and print the value displayed by the counter at time .

 Function Description

 Complete the strangeCounter function in the editor below. It should return the integer value displayed by the counter at time .

 strangeCounter has the following parameter(s):

 t: an integer
 Input Format

 A single integer denoting the value of .

 Constraints

 Subtask

 for  of the maximum score.
 Output Format

 Print the value displayed by the strange counter at the given time .

 Sample Input

 4
 Sample Output

 6
 Explanation

 Time  marks the beginning of the second cycle. It is double the number displayed at the beginning of the first cycle:. This is also shown in the diagram in the Problem Statement above.

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

    static long strangeCounter(long t){

        long value = 2;

        while (3 * (value - 1) < t)
            value = 2 * value;

        return((3 * (value - 1) - t + 1));
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long t = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = strangeCounter(t);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}