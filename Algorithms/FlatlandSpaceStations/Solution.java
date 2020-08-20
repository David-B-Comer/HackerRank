package FlatlandSpaceStations;

/**

 Flatland is a country with a number of cities, some of which have space stations. Cities are numbered consecutively and each has a road of  length connecting it to the next city. It is not a circular route, so the first city doesn't connect with the last city. Determine the maximum distance from any city to it's nearest space station.

 For example, there are  cities and  of them has a space station, city . They occur consecutively along a route. City  is  unit away and city  is  units away. City  is  units from its nearest space station as one is located there. The maximum distance is .

 Function Description

 Complete the flatlandSpaceStations function in the editor below. It should return an integer that represents the maximum distance any city is from a space station.

 flatlandSpaceStations has the following parameter(s):

 n: the number of cities
 c: an integer array that contains the indices of cities with a space station, -based indexing
 Input Format

 The first line consists of two space-separated integers,  and .
 The second line contains  space-separated integers, the indices of each city having a space-station. These values are unordered and unique.

 Constraints

 There will be at least  city with a space station.
 No city has more than one space station.
 Output Format

 Print an integer denoting the maximum distance that an astronaut in a Flatland city would need to travel to reach the nearest space station.

 Sample Input 0

 5 2
 0 4
 Sample Output 0

 2
 Explanation 0

 This sample corresponds to following graphic:

 hreasy(5).png

 The distance to the nearest space station for each city is listed below:

 has distance , as it contains a space station.
 has distance  to the space station in .
 has distance  to the space stations in  and .
 has distance  to the space station in .
 has distance , as it contains a space station.
 We then take .

 Sample Input 1

 6 6
 0 1 2 4 3 5
 Sample Output 1

 0
 Explanation 1

 In this sample,  so every city has space station and we print  as our answer.

 **/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution{

    static int flatlandSpaceStations(int n, int[] c){

        int [] array = new int[c.length + 1];
        Arrays.sort(c);

        for (int i = 0; i < c.length - 1; i++){
            array[i] = (c[i + 1] - c[i]) / 2;
        }
        array[c.length - 1] = c[0];
        array[c.length] = n - 1 - c[c.length - 1];
        int maximumDistance = array[0];

        for (int i = 1; i < c.length + 1; i++){
            if (array[i] > maximumDistance)
                maximumDistance = array[i];
        }
        return maximumDistance;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}