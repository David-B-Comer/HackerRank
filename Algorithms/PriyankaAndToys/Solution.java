package PriyankaAndToys;

/**

 Priyanka works for an international toy company that ships by container. Her task is to the determine the lowest cost way to combine her orders for shipping. She has a list of item weights. The shipping company has a requirement that all items loaded in a container must weigh less than or equal to 4 units plus the weight of the minimum weight item. All items meeting that requirement will be shipped in one container.

 What is the smallest number of containers that can be contracted to ship the items based on the given list of weights?

 For example, there are items with weights . This can be broken into two containers:  and . Each container will contain items weighing within  units of the minimum weight item.

 Function Description

 Complete the toys function in the editor below. It should return the minimum number of containers required to ship.

 toys has the following parameter(s):

 w: an array of integers that represent the weights of each order to ship
 Input Format

 The first line contains an integer , the number of orders to ship.
 The next line contains  space-separated integers, , representing the orders in a weight array.

 Constraints



 Output Format

 Return the integer value of the number of containers Priyanka must contract to ship all of the toys.

 Sample Input

 8
 1 2 3 21 7 12 14 21
 Sample Output

 4
 Explanation

 The first container holds items weighing ,  and . (weights in range )
 The second container holds the items weighing  units. ()
 The third container holds the item weighing  units. ()
 The fourth container holds the items weighing  and  units. ()

 containers are required.

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

    static int toys(int[] w){

        Arrays.sort(w);
        int containers = 1;
        int minimumCWeightItem = w[0];

        for (int i = 0; i < w.length; i++){
            if (w[i] > minimumCWeightItem + 4){
                containers++;
                minimumCWeightItem = w[i];
            }
        }
        return containers;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] w = new int[n];

        String[] wItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int wItem = Integer.parseInt(wItems[i]);
            w[i] = wItem;
        }

        int result = toys(w);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

