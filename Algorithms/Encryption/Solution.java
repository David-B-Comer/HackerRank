package Encryption;

/**

An English text needs to be encrypted using the following encryption scheme.
        First, the spaces are removed from the text. Let  be the length of this text.
        Then, characters are written into a grid, whose rows and columns have the following constraints:

        For example, the sentence , after removing spaces is  characters long.  is between  and , so it is written in the form of a grid with 7 rows and 8 columns.

        ifmanwas
        meanttos
        tayonthe
        groundgo
        dwouldha
        vegivenu
        sroots
        Ensure that
        If multiple grids satisfy the above conditions, choose the one with the minimum area, i.e. .
        The encoded message is obtained by displaying the characters in a column, inserting a space, and then displaying the next column and inserting a space, and so on. For example, the encoded message for the above rectangle is:

        imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau

        You will be given a message to encode and print.

        Function Description

        Complete the encryption function in the editor below. It should return a single string composed as described.

        encryption has the following parameter(s):

        s: a string to encrypt
        Input Format

        One line of text, the string

        Constraints


        is comprised only of characters in the range ascii[a-z].

        Output Format

        Print the encoded message on one line as described.

        Sample Input

        haveaniceday
        Sample Output 0

        hae and via ecy
        Explanation 0

        ,  is between  and .
        Rewritten with  rows and  columns:

        have
        anic
        eday
        Sample Input 1

        feedthedog
        Sample Output 1

        fto ehg ee dd
        Explanation 1

        ,  is between  and .
        Rewritten with  rows and  columns:

        feed
        thed
        og
        Sample Input 2

        chillout
        Sample Output 2

        clu hlt io
        Explanation 2

        ,  is between  and .
        Rewritten with  columns and  rows ( so we have to use .)

        chi
        llo
        ut
 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

    static String encryption(String s){

        int columns = (int)Math.ceil(Math.sqrt(Double.valueOf(s.length())));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < columns; i++){
            for (int j = i; j < s.length(); j += columns){
                sb.append(s.charAt(j));
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
