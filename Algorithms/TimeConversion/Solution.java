package TimeConversion;

/**

 Given a time in -hour AM/PM format, convert it to military (24-hour) time.

 Note: Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a 24-hour clock. Noon is 12:00:00PM on a 12-hour clock, and 12:00:00 on a 24-hour clock.

 Function Description

 Complete the timeConversion function in the editor below. It should return a new string representing the input time in 24 hour format.

 timeConversion has the following parameter(s):

 s: a string representing time in  hour format
 Input Format

 A single string  containing a time in -hour clock format (i.e.:  or ), where  and .

 Constraints

 All input times are valid
 Output Format

 Convert and print the given time in -hour format, where .

 Sample Input 0

 07:05:45PM
 Sample Output 0

 19:05:45

 **/

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static String timeConversion(String s){

        int hours   = Integer.parseInt(s.substring(0,2));
        int minutes = Integer.parseInt(s.substring(3,5));
        int seconds = Integer.parseInt(s.substring(6,8));

        if (s.substring(8, 10).equals("PM") && hours != 12){
            hours += 12;
        } else if (s.substring(8, 10).equals("AM") && hours == 12){
            hours = 0;
        }
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}

