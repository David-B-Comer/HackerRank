package Gemstones;

/**

 John has collected various rocks. Each rock has various minerals embeded in it. Each type of mineral is designated by a lowercase letter in the range . There may be multiple occurrences of a mineral in a rock. A mineral is called a gemstone if it occurs at least once in each of the rocks in John's collection.

 Given a list of minerals embedded in each of John's rocks, display the number of types of gemstones he has in his collection.

 For example, the array of mineral composition strings . The minerals  and  appear in each composite, so there are  gemstones.

 Function Description

 Complete the gemstones function in the editor below. It should return an integer representing the number of gemstones found in the list of rocks.

 gemstones has the following parameter(s):

 arr: an array of strings
 Input Format

 The first line consists of an integer , the size of .
 Each of the next  lines contains a string  where each letter represents an occurence of a mineral in the current rock.

 Constraints


 | arr[i] |
 Each composition  consists of only lower-case Latin letters ('a'-'z').

 Output Format

 Print the number of types of gemstones in John's collection. If there are none, print .

 Sample Input

 3
 abcdde
 baccd
 eeabg
 Sample Output

 2
 Explanation

 Only  and  are gemstones because they are the only types that occur in every rock.

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int gemstones(String[] arr){

        String[] alpha ={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","y","x","z"};
        int count1 =0;
        int count2 =0;

        for(int i=0;i<alpha.length;i++){
            count1=0;

            for(int j=0; j<arr.length; j++){
                if(arr[j].contains(alpha[i])){
                    count1++;
                }
                if(count1==arr.length){
                    count2++;
                }
            }
        }
        return count2;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }

        int result = gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
