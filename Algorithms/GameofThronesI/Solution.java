package GameofThronesI;

/**

 Dothraki are planning an attack to usurp King Robert's throne. King Robert learns of this conspiracy from Raven and plans to lock the single door through which the enemy can enter his kingdom.

 door

 But, to lock the door he needs a key that is an anagram of a palindrome. He starts to go through his box of strings, checking to see if they can be rearranged into a palindrome.

 For example, given the string , one way it can be arranged into a palindrome is .

 Function Description

 Complete the gameOfThrones function below to determine whether a given string can be rearranged into a palindrome. If it is possible, return YES, otherwise return NO.

 gameOfThrones has the following parameter(s):

 s: a string to analyze
 Input Format

 A single line which contains , the input string.

 Constraints

 |s|
 contains only lowercase letters in the range
 Output Format

 A single line which contains YES or NO.

 Sample Input 0

 aaabbbb
 Sample Output 0

 YES
 Explanation 0

 A palindromic permutation of the given string is bbaaabb.

 Sample Input 1

 cdefghmnopqrstuvw
 Sample Output 1

 NO
 Explanation 1

 Palindromes longer than 1 character are made up of pairs of characters. There are none here.

 Sample Input 2

 cdcdcdcdeeeef
 Sample Output 2

 YES
 Explanation 2

 An example palindrome from the string: ddcceefeeccdd.

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

    static String gameOfThrones(String s){

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int oddCount = 0;
        int evenCount = 0;

        for (int i = 0; i < 26; i++){
            int count = 0;
            for (int j = 0; j < s.length(); j++){
                if (alphabet.charAt(i) == s.charAt(j))
                    count++;
            }
            if (count % 2 == 0)
                evenCount++;
            else
                oddCount++;
        }
        if (oddCount <= 1)
            return "YES";
        else if (oddCount == 2 && s.length() % 2 == 0)
            return "YES";
        else
            return "NO";
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

