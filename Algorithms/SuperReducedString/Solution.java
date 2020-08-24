package SuperReducedString;

/**

 Steve has a string of lowercase characters in range ascii[‘a’..’z’]. He wants to reduce the string to its shortest length by doing a series of operations. In each operation he selects a pair of adjacent lowercase letters that match, and he deletes them. For instance, the string aab could be shortened to b in one operation.

 Steve’s task is to delete as many characters as possible using this method and print the resulting string. If the final string is empty, print Empty String

 Function Description

 Complete the superReducedString function in the editor below. It should return the super reduced string or Empty String if the final string is empty.

 superReducedString has the following parameter(s):

 s: a string to reduce
 Input Format

 A single string, .

 Constraints

 Output Format

 If the final string is empty, print Empty String; otherwise, print the final non-reducible string.

 Sample Input 0

 aaabccddd
 Sample Output 0

 abd
 Explanation 0

 Steve performs the following sequence of operations to get the final string:

 aaabccddd → abccddd → abddd → abd
 Sample Input 1

 aa
 Sample Output 1

 Empty String
 Explanation 1

 aa → Empty String
 Sample Input 2

 baab
 Sample Output 2

 Empty String
 Explanation 2

 baab → bb → Empty String

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

public class Solution{

    static String superReducedString(String s){

        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == s.charAt(i - 1)){
                s = s.substring(0, i - 1) + s.substring(i + 1);
                i = 0;
            }
        }
        if (s.length() == 0){
            return("Empty String");
        }
        else{
            return (s);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

