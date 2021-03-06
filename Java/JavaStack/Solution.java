package JavaStack;

/**

 In computer science, a stack or LIFO (last in, first out) is an abstract data type that serves as a collection of elements, with two principal operations: push, which adds an element to the collection, and pop, which removes the last element that was added.(Wikipedia)
 A string containing only parentheses is balanced if the following is true: 1. if it is an empty string 2. if A and B are correct, AB is correct, 3. if A is correct, (A) and {A} and [A] are also correct.

 Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"

 Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.

 Given a string, determine if it is balanced or not.

 Input Format

 There will be multiple lines in the input file, each having a single non-empty string. You should read input till end-of-file.

 The part of the code that handles input operation is already provided in the editor.

 Output Format

 For each case, print 'true' if the string is balanced, 'false' otherwise.

 Sample Input

 {}()
 ({()})
 {}(
 []
 Sample Output

 true
 true
 false
 true

 **/

import java.util.*;
class Solution{

    private static Map<String,String> myMap = createMap();
    private static Map<String,String> createMap() {
        HashMap<String,String> result = new HashMap<String,String>();
        result.put("(",")");
        result.put("[","]");
        result.put("{","}");
        return Collections.unmodifiableMap(result);
    }

    public static void main(String []argh){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input=sc.nextLine();
            Stack myStack = new Stack();
            String last;
            String next;
            for (int i=0 ; i<input.length(); i++){
                next = Character.toString(input.charAt(i));
                if (myStack.empty()) {
                    myStack.push(next);
                } else {
                    last = myStack.peek().toString();
                    if (myMap.containsKey(last)) {
                        if (myMap.get(last).equals(next)){
                            myStack.pop();
                        } else {
                            myStack.push(next);
                        }
                    } else {
                        myStack.push(next);
                        break;
                    }
                }
            }
            System.out.println(myStack.empty());
        }
    }
}

