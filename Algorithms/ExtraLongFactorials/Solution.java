package ExtraLongFactorials;

/**

 The factorial of the integer , written , is defined as:

 Calculate and print the factorial of a given integer.

 For example, if , we calculate  and get .

 Function Description

 Complete the extraLongFactorials function in the editor below. It should print the result and return.

 extraLongFactorials has the following parameter(s):

 n: an integer
 Note: Factorials of  can't be stored even in a  long long variable. Big integers must be used for such calculations. Languages like Java, Python, Ruby etc. can handle big integers, but we need to write additional code in C/C++ to handle huge values.

 We recommend solving this challenge using BigIntegers.

 Input Format

 Input consists of a single integer

 Constraints


 Output Format

 Print the factorial of .

 Sample Input


 Sample Output


 Explanation




 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

    static void extraLongFactorials(int n){

        BigInteger factorial = new BigInteger("1");

        for (int i = 1; i <= n; i++){
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        System.out.println(factorial);
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}

