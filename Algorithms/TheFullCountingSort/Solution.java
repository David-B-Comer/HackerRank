package TheFullCountingSort;

/**

 In this challenge you need to print the string that accompanies each integer in a list sorted by the integers. If two strings are associated with the same integer, they must be printed in their original order so your sorting algorithm should be stable. There is one other twist. The first half of the strings encountered in the inputs are to be replaced with the character "".

 Insertion Sort and the simple version of Quicksort are stable, but the faster in-place version of Quicksort is not since it scrambles around elements while sorting.

 In this challenge, you will use counting sort to sort a list while keeping the order of the strings preserved.

 For example, if your inputs are  you could set up a helper array with three empty arrays as elements. The following shows the insertions:

 i	string	converted	list
 0				[[],[],[]]
 1 	a 	-		[[-],[],[]]
 2	b	-		[[-],[-],[]]
 3	c			[[-,c],[-],[]]
 4	d			[[-,c],[-,d],[]]
 The result is then printed:  .

 Function Description

 Complete the countSort function in the editor below. It should construct and print out the sorted strings.

 countSort has the following parameter(s):

 arr: a 2D array where each arr[i] is comprised of two strings: x and s.
 Note: The first element of each , , must be cast as an integer to perform the sort.

 Input Format

 The first line contains , the number of integer/string pairs in the array .
 Each of the next  contains  and , the integers (as strings) with their associated strings.

 Constraints


 is even


 consists of characters in the range

 Output Format

 Print the strings in their correct order, space-separated on one line.

 Sample Input

 20
 0 ab
 6 cd
 0 ef
 6 gh
 4 ij
 0 ab
 6 cd
 0 ef
 6 gh
 0 ij
 4 that
 3 be
 0 to
 1 be
 5 question
 1 or
 2 not
 4 is
 2 to
 4 the
 Sample Output

 - - - - - to be or not to be - that is the question - - - -
 Explanation

 Below is the list in the correct order. In the array at the bottom, strings from the first half of the original array were replaced with dashes.

 0 ab
 0 ef
 0 ab
 0 ef
 0 ij
 0 to
 1 be
 1 or
 2 not
 2 to
 3 be
 4 ij
 4 that
 4 is
 4 the
 5 question
 6 cd
 6 gh
 6 cd
 6 gh
 sorted = [['-', '-', '-', '-', '-', 'to'], ['be', 'or'], ['not', 'to'], ['be'], ['-', 'that', 'is', 'the'], ['question'], ['-', '-', '-', '-'], [], [], [], []]

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

    static void countSort(List<List<String>> arr){

        StringBuffer[] sb = new StringBuffer[100];
        int[] iArr = new int[100];
        int middle = arr.size() / 2;

        for (int i = 0; i < arr.size(); i++){
            int x = Integer.parseInt(arr.get(i).get(0));
            String s = arr.get(i).get(1);

            if (i < middle){
                s = "-";
            }
            if (iArr[x] == - 1){
                sb[x] = sb[x].append(" ");
                sb[x] = sb[x].append(s);
            }
            else {
                sb[x] = new StringBuffer(s);
                iArr[x] = - 1;
            }
        }
        StringBuffer sBuff = new StringBuffer("");

        for (int i = 0; i < 100; i++){
            if ( iArr[i] == - 1){
                sBuff = sBuff.append(sb[i] + " ");
            }
        }
        System.out.println(sBuff);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")));
        }

        countSort(arr);

        bufferedReader.close();
    }
}
