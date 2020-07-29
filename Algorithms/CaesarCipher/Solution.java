package CaesarCipher;

/**

 Julius Caesar protected his confidential information by encrypting it using a cipher. Caesar's cipher shifts each letter by a number of letters. If the shift takes you past the end of the alphabet, just rotate back to the front of the alphabet. In the case of a rotation by 3, w, x, y and z would map to z, a, b and c.

 Original alphabet:      abcdefghijklmnopqrstuvwxyz
 Alphabet rotated +3:    defghijklmnopqrstuvwxyzabc
 For example, the given cleartext  and the alphabet is rotated by . The encrypted string is .

 Note: The cipher only encrypts letters; symbols, such as -, remain unencrypted.

 Function Description

 Complete the caesarCipher function in the editor below. It should return the encrypted string.

 caesarCipher has the following parameter(s):

 s: a string in cleartext
 k: an integer, the alphabet rotation factor
 Input Format

 The first line contains the integer, , the length of the unencrypted string.
 The second line contains the unencrypted string, .
 The third line contains , the number of letters to rotate the alphabet by.

 Constraints



 is a valid ASCII string without any spaces.

 Output Format

 For each test case, print the encoded string.

 Sample Input

 11
 middle-Outz
 2
 Sample Output

 okffng-Qwvb
 Explanation

 Original alphabet:      abcdefghijklmnopqrstuvwxyz
 Alphabet rotated +2:    cdefghijklmnopqrstuvwxyzab

 m -> o
 i -> k
 d -> f
 d -> f
 l -> n
 e -> g
 -    -
 O -> Q
 u -> w
 t -> v
 z -> b

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static String caesarCipher(String s, int k){

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            sb.append(encrypt(ch, k));
        }
        return sb.toString();
    }

    private static char encrypt(char ch, int K){

        if (!Character.isLetter(ch)){
            return ch;
        }
        char base = Character.isLowerCase(ch) ? 'a' : 'A';
        return (char) ((ch - base + K) % 26 + base);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}