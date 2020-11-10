package SpecialStringAgain;

/**

 A string is said to be a special string if either of two conditions is met:

 All of the characters are the same, e.g. aaa.
 All characters except the middle one are the same, e.g. aadaa.
 A special substring is any substring of a string which meets one of those criteria. Given a string, determine how many special substrings can be formed from it.

 For example, given the string , we have the following special substrings: .

 Function Description

 Complete the substrCount function in the editor below. It should return an integer representing the number of special substrings that can be formed from the given string.

 substrCount has the following parameter(s):

 n: an integer, the length of string s
 s: a string
 Input Format

 The first line contains an integer, , the length of .
 The second line contains the string .

 Constraints


 Each character of the string is a lowercase alphabet, .

 Output Format

 Print a single line containing the count of total special substrings.

 Sample Input 0

 5
 asasd
 Sample Output 0

 7
 Explanation 0

 The special palindromic substrings of  are

 Sample Input 1

 7
 abcbaba
 Sample Output 1

 10
 Explanation 1

 The special palindromic substrings of  are

 Sample Input 2

 4
 aaaa
 Sample Output 2

 10
 Explanation 2

 The special palindromic substrings of  are

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

    static long substrCount(int n, String s){

        int specialSubstrings = n;
        int consecutiveCharacters = 1;
        int middleIndex = - 1;

        for (int i = 1; i < n; i++){
            if (s.charAt(i) == s.charAt(i-1)) {
                specialSubstrings += consecutiveCharacters;
                consecutiveCharacters++;

                if (middleIndex > 0){
                    if ((middleIndex - consecutiveCharacters) >= 0 && s.charAt(middleIndex - consecutiveCharacters) == s.charAt(i)){
                        specialSubstrings++;
                    }
                    else{
                        middleIndex = - 1;
                    }
                }
            }
            else{
                consecutiveCharacters = 1;

                if (((i - 2) >= 0) && s.charAt(i - 2) == s.charAt(i)){
                    specialSubstrings++;
                    middleIndex = i - 1;
                }
                else{
                    middleIndex = - 1;
                }
            }
        }
        return specialSubstrings;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
