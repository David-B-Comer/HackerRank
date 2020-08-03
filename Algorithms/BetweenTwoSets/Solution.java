package BetweenTwoSets;

/**

 You will be given two arrays of integers and asked to determine all integers that satisfy the following two conditions:

 The elements of the first array are all factors of the integer being considered
 The integer being considered is a factor of all elements of the second array
 These numbers are referred to as being between the two arrays. You must determine how many such numbers exist.

 For example, given the arrays  and , there are two numbers between them:  and . , ,  and  for the first value. Similarly, ,  and , .

 Function Description

 Complete the getTotalX function in the editor below. It should return the number of integers that are betwen the sets.

 getTotalX has the following parameter(s):

 a: an array of integers
 b: an array of integers
 Input Format

 The first line contains two space-separated integers,  and , the number of elements in array  and the number of elements in array .
 The second line contains  distinct space-separated integers describing  where .
 The third line contains  distinct space-separated integers describing  where .

 Constraints

 Output Format

 Print the number of integers that are considered to be between  and .

 Sample Input

 2 3
 2 4
 16 32 96
 Sample Output

 3
 Explanation

 2 and 4 divide evenly into 4, 8, 12 and 16.
 4, 8 and 16 divide evenly into 16, 32, 96.

 4, 8 and 16 are the only three numbers for which each element of a is a factor and each is a factor of all elements of b.

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    static int total=0;
    static boolean aTrue=false;
    static boolean bTrue=false;

    public static int getTotalX(List<Integer> a, List<Integer> b){

        for(int i = a.get(a.size()-1); i <= b.get(0); i++){
            for(int j = 0; j < a.size(); j++){
                if(i % (a.get(j)) == 0)
                    aTrue=true;
                else{
                    aTrue=false;
                    break;
                }
            }
            if(aTrue){
                for(int k = 0; k < b.size(); k++){
                    if((b.get(k)) % i == 0)
                        bTrue=true;
                    else{
                        bTrue = false;
                        break;
                    }
                }
            }
            if(aTrue && bTrue)
                total++;
        }
        return total;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

