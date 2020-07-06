package JavaDequeue;

/**

 In computer science, a double-ended queue (dequeue, often abbreviated to deque, pronounced deck) is an abstract data type that generalizes a queue, for which elements can be added to or removed from either the front (head) or back (tail).

 Deque interfaces can be implemented using various types of collections such as LinkedList or ArrayDeque classes. For example, deque can be declared as:

 Deque deque = new LinkedList<>();
 or
 Deque deque = new ArrayDeque<>();
 You can find more details about Deque here.

 In this problem, you are given  integers. You need to find the maximum number of unique integers among all the possible contiguous subarrays of size .

 Note: Time limit is  second for this problem.

 Input Format

 The first line of input contains two integers  and : representing the total number of integers and the size of the subarray, respectively. The next line contains  space separated integers.

 Constraints

 The numbers in the array will range between .

 Output Format

 Print the maximum number of unique integers among all possible contiguous subarrays of size .

 Sample Input

 6 3
 5 3 5 2 3 2
 Sample Output

 3
 Explanation

 In the sample testcase, there are 4 subarrays of contiguous numbers.

 - Has  unique numbers.

 - Has  unique numbers.

 - Has  unique numbers.

 - Has  unique numbers.

 In these subarrays, there are  unique numbers, respectively. The maximum amount of unique numbers among all possible contiguous subarrays is .

 **/

import java.util.*;
public class test{
    public static void main(String[] args){
        HashMap<Integer, Integer> map = new HashMap<>();
        Deque<Integer> deque          = new ArrayDeque<>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int max = map.size();

        for (int i = 0; i < n; i++){
            if (i >= m){
                int old = deque.remove();
                if (map.get(old) == 1){
                    map.remove(old);
                } else{
                    map.put(old, map.get(old) - 1);
                }
            }
            int num = scan.nextInt();
            deque.add(num);
            map.merge(num, 1, Integer::sum);
            max = Math.max(max, map.size());
            if (max == m) {
                break;
            }
        }
        scan.close();
        System.out.println(max);
    }
}
