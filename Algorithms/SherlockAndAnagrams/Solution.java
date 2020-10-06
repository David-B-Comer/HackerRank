package SherlockAndAnagrams;

/**

 Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string. Given a string, find the number of pairs of substrings of the string that are anagrams of each other.

 For example , the list of all anagrammatic pairs is  at positions  respectively.

 Function Description

 Complete the function sherlockAndAnagrams in the editor below. It must return an integer that represents the number of anagrammatic pairs of substrings in .

 sherlockAndAnagrams has the following parameter(s):

 s: a string .
 Input Format

 The first line contains an integer , the number of queries.
 Each of the next  lines contains a string  to analyze.

 Constraints



 String  contains only lowercase letters  ascii[a-z].

 Output Format

 For each query, return the number of unordered anagrammatic pairs.

 Sample Input 0

 2
 abba
 abcd
 Sample Output 0

 4
 0
 Explanation 0

 The list of all anagrammatic pairs is  and  at positions  and  respectively.

 No anagrammatic pairs exist in the second query as no character repeats.

 Sample Input 1

 2
 ifailuhkqq
 kkkk
 Sample Output 1

 3
 10
 Explanation 1

 For the first query, we have anagram pairs  and  at positions  and  respectively.

 For the second query:
 There are 6 anagrams of the form  at positions  and .
 There are 3 anagrams of the form  at positions  and .
 There is 1 anagram of the form  at position .

 Sample Input 2

 1
 cdcd
 Sample Output 2

 5
 Explanation 2

 There are two anagrammatic pairs of length :  and .
 There are three anagrammatic pairs of length :  at positions  respectively.

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

    static int sherlockAndAnagrams(String s){
        int anagramPairs = 0;

        for (int i = 0; i < s.length() - 1; i++){
            for (int j = 0; j < s.length() - i - 1; j++){
                String substr = s.substring(j, j + i + 1);
                for (int k = j + 1; k < s.length() - substr.length() + 1; k++){
                    if (anagram(substr, s.substring(k, k + substr.length()))){
                        anagramPairs++;
                    }
                }
            }
        }
        return anagramPairs;
    }

    static boolean anagram(String string1, String string2){

        if (string1.length() != string2.length())
            return false;
        char[] substr1 = string1.toCharArray();
        char[] substr2 = string2.toCharArray();
        Arrays.sort(substr1);
        Arrays.sort(substr2);

        return Arrays.equals(substr1, substr2);
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
