package TwoCharacters;

/**

 In this challenge, you will be given a string. You must remove characters until the string is made up of any two alternating characters. When you choose a character to remove, all instances of that character must be removed. Your goal is to create the longest string possible that contains just two alternating letters.

 As an example, consider the string abaacdabd. If you delete the character a, you will be left with the string bcdbd. Now, removing the character c leaves you with a valid string bdbd having a length of 4. Removing either b or d at any point would not result in a valid string.

 Given a string , convert it to the longest possible string  made up only of alternating characters. Print the length of string  on a new line. If no string  can be formed, print  instead.

 Function Description

 Complete the alternate function in the editor below. It should return an integer that denotes the longest string that can be formed, or  if it cannot be done.

 alternate has the following parameter(s):

 s: a string
 Input Format

 The first line contains a single integer denoting the length of .
 The second line contains string .

 Constraints

 Output Format

 Print a single integer denoting the maximum length of  for the given ; if it is not possible to form string , print  instead.

 Sample Input

 10
 beabeefeab
 Sample Output

 5
 Explanation

 The characters present in  are a, b, e, and f. This means that  must consist of two of those characters and we must delete two others. Our choices for characters to leave are [a,b], [a,e], [a, f], [b, e], [b, f] and [e, f].

 If we delete e and f, the resulting string is babab. This is a valid  as there are only two distinct characters (a and b), and they are alternating within the string.

 If we delete a and f, the resulting string is bebeeeb. This is not a valid string  because there are consecutive e's present. Removing them would leave consecutive b's, so this fails to produce a valid string .

 Other cases are solved similarly.

 babab is the longest string we can create.

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    public static final int NUM_LETTERS = 26;

    static int alternate(String s){

        int [][] pair  = new int[NUM_LETTERS][NUM_LETTERS];
        int [][] count = new int[NUM_LETTERS][NUM_LETTERS];

        if (s.length() <= 1){
            return 0;
        }

        for (int i = 0; i < s.length(); i++){
            char letter   = s.charAt(i);
            int letterNum = letter - 'a';

            for (int col = 0; col < NUM_LETTERS; col++){
                if (pair[letterNum][col] == letter){
                    count[letterNum][col] = -1;
                }
                if (count[letterNum][col] != -1){
                    pair[letterNum][col] = letter;
                    count[letterNum][col]++;
                }
            }

            for (int row = 0; row < NUM_LETTERS; row++){
                if (pair[row][letterNum] == letter){
                    count[row][letterNum] = -1;
                }
                if (count[row][letterNum] != -1){
                    pair[row][letterNum] = letter;
                    count[row][letterNum]++;
                }
            }
        }

        int max = 0;
        for (int row = 0; row < NUM_LETTERS; row++){
            for (int col = 0; col < NUM_LETTERS; col++){
                max = Math.max(max, count[row][col]);
            }
        }
        return max;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
