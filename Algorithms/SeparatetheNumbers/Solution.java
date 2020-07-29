package SeparatetheNumbers;

/**

 A numeric string, , is beautiful if it can be split into a sequence of two or more positive integers, , satisfying the following conditions:

 for any  (i.e., each element in the sequence is  more than the previous element).
 No  contains a leading zero. For example, we can split  into the sequence , but it is not beautiful because  and  have leading zeroes.
 The contents of the sequence cannot be rearranged. For example, we can split  into the sequence , but it is not beautiful because it breaks our first constraint (i.e., ).
 The diagram below depicts some beautiful strings:

 image

 You must perform  queries where each query consists of some integer string . For each query, print whether or not the string is beautiful on a new line. If it's beautiful, print YES x, where  is the first number of the increasing sequence. If there are multiple such values of , choose the smallest. Otherwise, print NO.

 Function Description

 Complete the separateNumbers function in the editor below. It should print a string as described above.

 separateNumbers has the following parameter:

 s: an integer value represented as a string
 Input Format

 The first line contains an integer , the number of strings to evaluate.
 Each of the next  lines contains an integer string  to query.

 Constraints

 Output Format

 For each query, print its answer on a new line (i.e., either YES x where  is the smallest first number of the increasing sequence, or NO).

 Sample Input 0

 7
 1234
 91011
 99100
 101103
 010203
 13
 1
 Sample Output 0

 YES 1
 YES 9
 YES 99
 NO
 NO
 NO
 NO
 Explanation 0

 The first three numbers are beautiful (see the diagram above). The remaining numbers are not beautiful:

 For , all possible splits violate the first and/or second conditions.
 For , it starts with a zero so all possible splits violate the second condition.
 For , the only possible split is , which violates the first condition.
 For , there are no possible splits because  only has one digit.
 Sample Input 1

 4
 99910001001
 7891011
 9899100
 999100010001
 Sample Output 1

 YES 999
 YES 7
 YES 98
 NO

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static void separateNumbers(String s){

        int x = 0;
        String str = "";
        String temp = "";

        for(int i=1; i<=s.length()/2; i++){
            str = s.substring(0,i);
            Long y = Long.parseLong(str);
            while(str.length() < s.length()){
                str+= Long.toString(++y);
            }
            if(str.equals(s)){
                temp = s.substring(0,i);
                x = 1;
                break;
            }
        }
        if(x == 1)
            System.out.println("YES "+temp);
        else
            System.out.println("NO");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            separateNumbers(s);
        }

        scanner.close();
    }
}
