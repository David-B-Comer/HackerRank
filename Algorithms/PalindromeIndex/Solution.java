package PalindromeIndex;

/**

 Given a string of lowercase letters in the range ascii[a-z], determine a character that can be removed to make the string a palindrome. There may be more than one solution, but any will do. For example, if your string is "bcbc", you can either remove 'b' at index  or 'c' at index . If the word is already a palindrome or there is no solution, return -1. Otherwise, return the index of a character to remove.

 Function Description

 Complete the palindromeIndex function in the editor below. It must return the index of the character to remove or .

 palindromeIndex has the following parameter(s):

 s: a string to analyze
 Input Format

 The first line contains an integer , the number of queries.
 Each of the next  lines contains a query string .

 Constraints

 All characters are in the range ascii[a-z].
 Output Format

 Print an integer denoting the zero-indexed position of the character to remove to make  a palindrome. If  is already a palindrome or no such character exists, print .

 Sample Input

 3
 aaab
 baa
 aaa
 Sample Output

 3
 0
 -1
 Explanation

 Query 1: "aaab"
 Removing 'b' at index  results in a palindrome, so we print  on a new line.

 Query 2: "baa"
 Removing 'b' at index  results in a palindrome, so we print  on a new line.

 Query 3: "aaa"
 This string is already a palindrome, so we print . Removing any one of the characters would result in a palindrome, but this test comes first.

 Note: The custom checker logic for this challenge is available here.

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

    static int palindromeIndex(String s){

        int j = s.length() - 1;

        if (palindrome(s))
            return - 1;
        for (int i = 0; i < j; i++, j--){
            if (s.charAt(i) != s.charAt(j)){
                if (palindrome(s.substring(i, j)))
                    return j;
                else if (palindrome(s.substring(i + 1, j + 1)))
                    return i;
            }
        }
        return -1;
    }

    static boolean palindrome(String s){

        int j = s.length() - 1;

        for (int i = 0; i < s.length() - 1; i++, j--){
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = palindromeIndex(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
