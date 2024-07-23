package hackerrank.ds.stacks;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class EqualStacks {

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();

        //Reverse the lists so that the top of the original list becomes the top of the stack too
        Collections.reverse(h1);
        Collections.reverse(h2);
        Collections.reverse(h3);

        for (int height : h1) {
            stack1.push(height);
        }
        for (int height : h2) {
            stack2.push(height);
        }
        for (int height : h3) {
            stack3.push(height);
        }

        //Calculate the total heights of the various stacks
        int height1 = getTotalHeight(stack1);
        int height2 = getTotalHeight(stack2);
        int height3 = getTotalHeight(stack3);

        while (true) {

            if (stack1.isEmpty() || stack2.isEmpty() || stack3.isEmpty()) {
                return 0;
            }

            int maxHeight = Math.max(height1, Math.max(height2, height3));

            //Remove the top element from the stack with the max height
            if (height1 == maxHeight) {
                height1 -= stack1.pop();
            } else if (height2 == maxHeight) {
                height2 -= stack2.pop();
            } else if (height3 == maxHeight) {
                height3 -= stack3.pop();
            }

            if (height1 == height2 && height1 == height3) {
                return height1;
            }
        }

    }

    private static int getTotalHeight(Stack<Integer> stack) {
        int totalHeight = 0;
        for (int elem : stack) {
            totalHeight += elem;
        }

        return totalHeight;
    }


    public static void main(String[] args) {

        List<Integer> h1 = Arrays.asList(1,2,1,1);
        List<Integer> h2 = Arrays.asList(1,1,2);
        List<Integer> h3 = Arrays.asList(1, 1);
        System.out.println(equalStacks(h1, h2, h3)); // Output should be 5

    }
}
