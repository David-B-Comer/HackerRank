package JimAndTheOrders;

/**

 Jim's Burgers has a line of hungry customers. Orders vary in the time it takes to prepare them. Determine the order the customers receive their orders. Start by numbering each of the customers from  to , front of the line to the back. You will then be given an order number and a preparation time for each customer.

 The time of delivery is calculated as the sum of the order number and the preparation time. If two orders are delivered at the same time, assume they are delivered in ascending customer number order.

 For example, there are  customers in line. They each receive an order number  and a preparation time .:

 Customer	1	2	3	4	5
 Order #		8	5	6	2	4
 Prep time	3	6	2	3	3
 Calculate:
 Serve time	11	11	8	5	7
 We see that the orders are delivered to customers in the following order:

 Order by:
 Serve time	5	7	8	11	11
 Customer	4	5	3	1	2
 Function Description

 Complete the jimOrders function in the editor below. It should return an array of integers that represent the order that customers' orders are delivered.

 jimOrders has the following parameter(s):

 orders: a 2D integer array where each  is in the form .
 Input Format

 The first line contains an integer , the number of customers.
 Each of the next  lines contains two space-separated integers, an order number and prep time for .

 Constraints

 Output Format

 Print a single line of  space-separated customer numbers (recall that customers are numbered from  to ) that describes the sequence in which the customers receive their burgers. If two or more customers receive their burgers at the same time, print their numbers in ascending order.

 Sample Input 0

 3
 1 3
 2 3
 3 3
 Sample Output 0

 1 2 3
 Explanation 0

 Jim has the following orders:

 . This order is delivered at time .
 . This order is delivered at time .
 . This order is delivered at time .
 The orders were delivered in the same order as the customers stood in line. The index in  is the customer number and is what is printed. In this case, the customer numbers match the order numbers.

 Sample Input 1

 5
 8 1
 4 2
 5 6
 3 1
 4 3
 Sample Output 1

 4 2 5 1 3
 Explanation 1

 Jim has the following orders:

 . This order is delivered at time .
 . This order is delivered at time .
 . This order is delivered at time .
 . This order is delivered at time .
 . This order is delivered at time .
 When we order these by ascending fulfillment time, we get:

 : customer .
 : customer .
 : customer .
 : customer .
 : customer .
 We print the ordered numbers in the bulleted listed above as 4 2 5 1 3.

 Note: While not demonstrated in these sample cases, recall that any orders fulfilled at the same time must be listed by ascending order number.

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

    static int[] jimOrders(int[][] orders){

        int[] customersServed = new int[orders.length];
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < orders.length; i++){
            list.add(orders[i][0] + orders[i][1]);
        }
        for (int i = 0; i < list.size(); i++){
            int index = list.indexOf(Collections.min(list));
            customersServed[i] = (Integer)index + 1;
            list.set(index, 99999999);
        }
        return customersServed;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] orders = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] ordersRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int ordersItem = Integer.parseInt(ordersRowItems[j]);
                orders[i][j] = ordersItem;
            }
        }

        int[] result = jimOrders(orders);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

