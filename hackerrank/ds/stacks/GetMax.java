package hackerrank.ds.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GetMax {

    /*
    ou have an empty sequence, and you will be given  queries. Each query is one of these three types:

    1 x  -Push the element x into the stack.
    2    -Delete the element present at the top of the stack.
    3    -Print the maximum element in the stack.
    Function Description

    Complete the getMax function in the editor below.

    getMax has the following parameters:
    - string operations[n]: operations as strings

    Returns
    - int[]: the answers to each type 3 query

    Input Format

    The first line of input contains an integer, . The next  lines each contain an above mentioned query.
     */

    static class ElementsWithMax {
        int value;
        int max;

        public ElementsWithMax(int value, int max) {
            this.value = value;
            this.max = max;
        }

    }

    public static List<Integer> getMax(List<String> operations) {
        // Write your code here
        Stack<ElementsWithMax> maxStack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        for (String operation : operations) {

            String[] operationPairs = operation.split(" ");
            int command = Integer.parseInt(operationPairs[0]);

            switch (command) {
                case 1:
                    int val = Integer.parseInt(operationPairs[1]);
                    int max = maxStack.isEmpty() ? val : Math.max(val, maxStack.peek().max);
                    ElementsWithMax elem = new ElementsWithMax(val, max);
                    maxStack.push(elem);
                    break;
                case 2:
                    if (!maxStack.isEmpty()) {
                        maxStack.pop();
                    }
                    break;
                case 3:
                    if (!maxStack.isEmpty()) {
                        result.add(maxStack.peek().max);
                    }

            }

        }

        return result;

    }


    public static List<Integer> getMax2(List<String> operations) {
        // Write your code here
        Stack<Integer> maxStack = new Stack<>();
        Stack<Integer> mainStack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        for (String operation : operations) {

            String[] operationPairs = operation.split(" ");
            int command = Integer.parseInt(operationPairs[0]);

            switch (command) {
                case 1:
                    int val = Integer.parseInt(operationPairs[1]);
                    int max = maxStack.isEmpty() ? val : Math.max(val, maxStack.peek());
                    maxStack.push(max);
                    mainStack.push(val);
                    break;
                case 2:
                    if (!mainStack.isEmpty()) {
                        maxStack.pop();
                        mainStack.pop();
                    }
                    break;
                case 3:
                    if (!maxStack.isEmpty()) {
                        result.add(maxStack.peek());
                    }

            }

        }

        return result;

    }
}