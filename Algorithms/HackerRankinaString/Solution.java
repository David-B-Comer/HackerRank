package HackerRankinaString;

/**

 We say that a string contains the word hackerrank if a subsequence of its characters spell the word hackerrank. For example, if string  it does contain hackerrank, but  does not. In the second case, the second r is missing. If we reorder the first string as , it no longer contains the subsequence due to ordering.

 More formally, let  be the respective indices of h, a, c, k, e, r, r, a, n, k in string . If  is true, then  contains hackerrank.

 For each query, print YES on a new line if the string contains hackerrank, otherwise, print NO.

 Function Description

 Complete the hackerrankInString function in the editor below. It must return YES or NO.

 hackerrankInString has the following parameter(s):

 s: a string
 Input Format

 The first line contains an integer , the number of queries.
 Each of the next  lines contains a single query string .

 Constraints

 Output Format

 For each query, print YES on a new line if  contains hackerrank, otherwise, print NO.

 Sample Input 0

 2
 hereiamstackerrank
 hackerworld
 Sample Output 0

 YES
 NO
 Explanation 0

 We perform the following  queries:


 The characters of hackerrank are bolded in the string above. Because the string contains all the characters in hackerrank in the same exact order as they appear in hackerrank, we print YES on a new line.
 does not contain the last three characters of hackerrank, so we print NO on a new line.
 Sample Input 1

 2
 hhaacckkekraraannk
 rhbaasdndfsdskgbfefdbrsdfhuyatrjtcrtyytktjjt
 Sample Output 1

 YES
 NO

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static String hackerrankInString(String s){

        String hackerrank = "hackerrank";
        int index = 0;

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == hackerrank.charAt(index)){
                index++;
            }
            if (index == hackerrank.length()){
                return "YES";
            }
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = hackerrankInString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

