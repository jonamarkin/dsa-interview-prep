package leetcode.blind75.binarytree;

public class LongestZigZag {
    /*
    You are given the root of a binary tree.

    A ZigZag path for a binary tree is defined as follow:

    Choose any node in the binary tree and a direction (right or left).
    If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
    Change the direction from right to left or from left to right.
    Repeat the second and third steps until you can't move in the tree.
    Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

    Return the longest ZigZag path contained in that tree.
     */

    private int maxZigZag = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Start DFS from the root node, exploring both left and right directions
        dfs(root, true, 0);  // Start by going right
        dfs(root, false, 0); // Start by going left

        return maxZigZag;
    }

    // Recursive DFS helper function
    private void dfs(TreeNode node, boolean isRight, int length) {
        if (node == null) {
            return;
        }

        // Update the maximum ZigZag length found so far
        maxZigZag = Math.max(maxZigZag, length);

        // If direction is right, move to the right and switch to left
        if (isRight) {
            dfs(node.right, false, length + 1); // Move right, next direction is left
            dfs(node.left, true, 1);            // Restart on the left, next direction is right
        }
        // If direction is left, move to the left and switch to right
        else {
            dfs(node.left, true, length + 1);   // Move left, next direction is right
            dfs(node.right, false, 1);          // Restart on the right, next direction is left
        }
    }
}
