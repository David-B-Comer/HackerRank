package FunnyString;

/**

 In this challenge, you will determine whether a string is funny or not. To determine whether a string is funny, create a copy of the string in reverse e.g. . Iterating through each string, compare the absolute difference in the ascii values of the characters at positions 0 and 1, 1 and 2 and so on to the end. If the list of absolute differences is the same for both strings, they are funny.

 Determine whether a give string is funny. If it is, return Funny, otherwise return Not Funny.

 For example, given the string , the ordinal values of the charcters are .  and the ordinals are . The absolute differences of the adjacent elements for both strings are , so the answer is Funny.

 Function Description

 Complete the funnyString function in the editor below. For each test case, it should return a string, either Funny or Not Funny.

 funnyString has the following parameter(s):

 s: a string to test
 Input Format

 The first line contains an integer , the number of queries.
 The next  lines each contain a string, .

 Constraints

 Output Format

 For each string  print whether it is Funny or Not Funny on a new line.

 Sample Input

 2
 acxz
 bcxz
 Sample Output

 Funny
 Not Funny
 Explanation

 You can use  to store the reverse of .

 Test Case 0:

 ,
 Corresponding ASCII values of characters of the strings:
 and
 For both the strings the adjacent difference list is [2, 21, 2] so we print Funny.

 Test Case 1:

 ,
 Corresponding ASCII values of characters of the strings:
 and
 The adjacent difference list for string  is [1, 21, 2] and for string  it is [2, 21, 1]. Since they are not the same we print Not Funny.

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static String funnyString(String s){

        char[] chars = s.toCharArray();
        int j = chars.length-1;

        for(int i = 1; i<chars.length; i++){

            if(Math.abs((int)chars[i]-(int)chars[i-1])== Math.abs((int)chars[j]-(int)chars[j-1])){
                j--;
                continue;
            }
            else{
                return ("Not Funny");
            }
        }
        return ("Funny");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = funnyString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
