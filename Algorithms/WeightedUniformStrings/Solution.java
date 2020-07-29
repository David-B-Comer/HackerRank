package WeightedUniformStrings;

/**

 A weighted string is a string of lowercase English letters where each letter has a weight. Character weights are  to  from  to  as shown below:

 image

 We define the following terms:

 The weight of a string is the sum of the weights of all the string's characters. For example:

 image

 A uniform string consists of a single character repeated zero or more times. For example, ccc and a are uniform strings, but bcb and cd are not.
 Given a string, , let  be the set of weights for all possible uniform contiguous substrings of string . You have to answer  queries, where each query  consists of a single integer, . For each query, print Yes on a new line if ; otherwise, print No instead.

 Note: The  symbol denotes that  is an element of set .

 Function Description

 Complete the weightedUniformStrings function in the editor below. It should return an array of strings, either Yes or No, one for each query.

 weightedUniformStrings has the following parameter(s):

 s: a string
 queries: an array of integers
 Input Format

 The first line contains a string , the original string.
 The second line contains an integer , the number of queries.
 Each of the next  lines contains an integer , the weight of a uniform subtring of  that may or may not exist.

 Constraints

 will only contain lowercase English letters, ascii[a-z].
 Output Format

 Print  lines. For each query, print Yes on a new line if . Otherwise, print No.

 Sample Input 0

 abccddde
 6
 1
 3
 12
 5
 9
 10
 Sample Output 0

 Yes
 Yes
 Yes
 Yes
 No
 No
 Explanation 0

 The weights of every possible uniform substring in the string abccddde are shown below:

 image

 We print Yes on the first four lines because the first four queries match weights of uniform substrings of . We print No for the last two queries because there are no uniform substrings in  that have those weights.

 Note that while de is a substring of  that would have a weight of , it is not a uniform substring.

 Note that we are only dealing with contiguous substrings. So ccc is not a substring of the string ccxxc.

 Sample Input 1

 aaabbbbcccddd
 5
 9
 7
 8
 12
 5
 Sample Output 1

 Yes
 No
 Yes
 Yes
 No

 **/

public class Solution {
}
