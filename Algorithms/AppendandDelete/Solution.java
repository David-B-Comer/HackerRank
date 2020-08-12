package AppendandDelete;

/**

 You have a string of lowercase English alphabetic letters. You can perform two types of operations on the string:

 Append a lowercase English alphabetic letter to the end of the string.
 Delete the last character in the string. Performing this operation on an empty string results in an empty string.
 Given an integer, , and two strings,  and , determine whether or not you can convert  to  by performing exactly  of the above operations on . If it's possible, print Yes. Otherwise, print No.

 For example, strings  and . Our number of moves, . To convert  to , we first delete all of the characters in  moves. Next we add each of the characters of  in order. On the  move, you will have the matching string. If there had been more moves available, they could have been eliminated by performing multiple deletions on an empty string. If there were fewer than  moves, we would not have succeeded in creating the new string.

 Function Description

 Complete the appendAndDelete function in the editor below. It should return a string, either Yes or No.

 appendAndDelete has the following parameter(s):

 s: the initial string
 t: the desired string
 k: an integer that represents the number of operations
 Input Format

 The first line contains a string , the initial string.
 The second line contains a string , the desired final string.
 The third line contains an integer , the number of operations.

 Constraints

 and  consist of lowercase English alphabetic letters, .
 Output Format

 Print Yes if you can obtain string  by performing exactly  operations on . Otherwise, print No.

 Sample Input 0

 hackerhappy
 hackerrank
 9
 Sample Output 0

 Yes
 Explanation 0

 We perform  delete operations to reduce string  to hacker. Next, we perform  append operations (i.e., r, a, n, and k), to get hackerrank. Because we were able to convert  to  by performing exactly  operations, we print Yes.

 Sample Input 1

 aba
 aba
 7
 Sample Output 1

 Yes
 Explanation 1

 We perform  delete operations to reduce string  to the empty string (recall that, though the string will be empty after  deletions, we can still perform a delete operation on an empty string to get the empty string). Next, we perform  append operations (i.e., a, b, and a). Because we were able to convert  to  by performing exactly  operations, we print Yes.

 Sample Input 2

 ashley
 ash
 2
 Sample Output 2

 No
 Explanation 2

 To convert ashley to ash a minimum of  steps are needed. Hence we print No as answer.

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static String appendAndDelete(String s, String t, int k){
        if (canConvert(s, t, k))
            return "Yes";
        return "No";
    }

    private static boolean canConvert(String s, String t, int k){

        if (s.length() + t.length() <= k){
            return true;
        }
        int i = 0;
        for (; i < s.length() && i < t.length(); i++){
            if (s.charAt(i) != t.charAt(i)){
                break;
            }
        }
        int minimumOperations = (s.length() - i) + (t.length() - i);
        return k >= minimumOperations && (k - minimumOperations) % 2 == 0;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}