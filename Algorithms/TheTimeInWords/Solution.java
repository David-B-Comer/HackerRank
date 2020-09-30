package TheTimeInWords;

/**

 Given the time in numerals we may convert it into words, as shown below:

 At , use o' clock. For , use past, and for  use to. Note the space between the apostrophe and clock in o' clock. Write a program which prints the time in words for the input given in the format described.

 Function Description

 Complete the timeInWords function in the editor below. It should return a time string as described.

 timeInWords has the following parameter(s):

 h: an integer representing hour of the day
 m: an integer representing minutes after the hour
 Input Format

 The first line contains , the hours portion The second line contains , the minutes portion

 Constraints

 Output Format

 Print the time in words as described.

 Sample Input 0

 5
 47
 Sample Output 0

 thirteen minutes to six
 Sample Input 1

 3
 00
 Sample Output 1

 three o' clock
 Sample Input 2

 7
 15
 Sample Output 2

 quarter past seven

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

    static String timeInWords(int h, int m){

        String numbers[] = { "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen",
                "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen", "twenty", "twenty one",
                "twenty two", "twenty three", "twenty four",
                "twenty five", "twenty six", "twenty seven",
                "twenty eight", "twenty nine",
        };
        String time = "";

        if (m == 0)
            time = (numbers[h] + " o' clock ");
        else if (m == 1)
            time = ("one minute past " + numbers[h]);
        else if (m == 59)
            time = ("one minute to " + numbers[(h % 12) + 1]);
        else if (m == 15)
            time = ("quarter past " + numbers[h]);
        else if (m == 30)
            time = ("half past " + numbers[h]);
        else if (m == 45)
            time = ("quarter to " + numbers[(h % 12) + 1]);
        else if (m <= 30)
            time = (numbers[m] + " minutes past " + numbers[h]);
        else if (m > 30)
            time = (numbers[60 - m] + " minutes to " + numbers[(h % 12) + 1]);

        return time;
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
