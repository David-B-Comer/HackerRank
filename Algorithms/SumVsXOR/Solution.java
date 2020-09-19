package SumVsXOR;

/**

 Given an integer , find each  such that:

 where  denotes the bitwise XOR operator. Print the number of 's satisfying the criteria.

 For example, if , there are four values:

 .
 Function Description

 Complete the sumXor function in the editor below. It should return the number of values determined, as an integer.

 sumXor has the following parameter(s):
 - n: an integer

 Input Format

 A single integer, .

 Constraints

 Subtasks

 for  of the maximum score.
 Output Format

 Print the total number of integers  satisfying the criteria.

 Sample Input 0

 5
 Sample Output 0

 2
 Explanation 0

 For , the  values  and  satisfy the conditions:

 Sample Input 1

 10
 Sample Output 1

 4
 Explanation 1

 For , the  values , , , and  satisfy the conditions:

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

    static long sumXor(long n){

        long zeros = 0;

        while (n > 0){
            if (n % 2 == 0) zeros++;
            n /= 2;
        }
        return (long)Math.pow(2, zeros);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = sumXor(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
