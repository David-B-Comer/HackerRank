package JavaPrimalityTest;

/**

 A prime number is a natural number greater than  whose only positive divisors are  and itself. For example, the first six prime numbers are , , , , , and .

 Given a large integer, , use the Java BigInteger class' isProbablePrime method to determine and print whether it's prime or not prime.

 Input Format

 A single line containing an integer,  (the number to be checked).

 Constraints

 contains at most  digits.
 Output Format

 If  is a prime number, print prime; otherwise, print not prime.

 Sample Input

 13
 Sample Output

 prime
 Explanation

 The only positive divisors of  are  and , so we print prime.

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger n = in.nextBigInteger();
        in.close();
        System.out.println(n.isProbablePrime(1) ? "prime" :"not prime");
    }
}