package JavaStringReverse;

/**

 A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward or forward.(Wikipedia)
 Given a string , print Yes if it is a palindrome, print No otherwise.

 Constraints

 will consist at most  lower case english letters.
 Sample Input

 madam
 Sample Output

 Yes

 **/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        for(int i=0;i<A.length()/2;i++){
            if( A.charAt(i)!= A.charAt(A.length()-i-1)){
                System.out.print("No");
                System.exit(0);
            }
        }
        System.out.print("Yes");
    }
}
