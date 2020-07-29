package Pangrams;

/**

 Roy wanted to increase his typing speed for programming contests. His friend suggested that he type the sentence "The quick brown fox jumps over the lazy dog" repeatedly. This sentence is known as a pangram because it contains every letter of the alphabet.

 After typing the sentence several times, Roy became bored with it so he started to look for other pangrams.

 Given a sentence, determine whether it is a pangram. Ignore case.

 Function Description

 Complete the function pangrams in the editor below. It should return the string pangram if the input string is a pangram. Otherwise, it should return not pangram.

 pangrams has the following parameter(s):

 s: a string to test
 Input Format

 Input consists of a string .

 Constraints


 Each character of ,

 Output Format

 Output a line containing pangram if  is a pangram, otherwise output not pangram.

 Sample Input 0

 We promptly judged antique ivory buckles for the next prize

 Sample Output 0

 pangram

 Sample Explanation 0

 All of the letters of the alphabet are present in the string.

 Sample Input 1

 We promptly judged antique ivory buckles for the prize

 Sample Output 1

 not pangram

 Sample Explanation 0

 The string lacks an x.

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

    static String pangrams(String s){

        s=s.toLowerCase();
        String alpha = "abcdefghijklmnopqrstuvwxyz";

        for(char c : alpha.toCharArray()){
            if(!s.contains(""+c))
                return "not pangram";
        }
        return "pangram";
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
