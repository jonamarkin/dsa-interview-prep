package crackingcodinginterview.treesandgraphs;

import com.sun.source.tree.Tree;

public class BalancedTree {

    /*
    Implement a function to check if a tree is balanced. For the purposes of this question,
    a balanced tree is defined to be a tree such that no two leaf nodes differ in distance from the root by more than one.
     */

    //So we must check if the max depth and min depth differ by at most 1
    public static int maxDepth(TreeNode root){
        if (root ==null){
            return  0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static int minDepth(TreeNode root){
        if (root == null){
            return 0;
        }

        return 1+ Math.min(minDepth(root.left), minDepth(root.right));
    }


    public static boolean isBalanced(TreeNode root){
        return maxDepth(root)-minDepth(root) <=1;
    }


    public static void main(String[] args) {
        // Test case 1: Balanced tree
        TreeNode balancedRoot = new TreeNode(1);
        balancedRoot.left = new TreeNode(2);
        balancedRoot.right = new TreeNode(3);
        balancedRoot.left.left = new TreeNode(4);
        balancedRoot.left.right = new TreeNode(5);
        balancedRoot.right.right = new TreeNode(6);

        System.out.println("Test case 1 (Balanced tree): " + isBalanced(balancedRoot)); // Should print true

        // Test case 2: Unbalanced tree
        TreeNode unbalancedRoot = new TreeNode(1);
        unbalancedRoot.left = new TreeNode(2);
        unbalancedRoot.left.left = new TreeNode(3);
        unbalancedRoot.left.left.left = new TreeNode(4);

        System.out.println("Test case 2 (Unbalanced tree): " + isBalanced(unbalancedRoot)); // Should print false

        // Test case 3: Single node tree
        TreeNode singleNodeRoot = new TreeNode(1);

        System.out.println("Test case 3 (Single node tree): " + isBalanced(singleNodeRoot)); // Should print true

        // Test case 4: Null tree
        TreeNode nullRoot = null;

        System.out.println("Test case 4 (Null tree): " + isBalanced(nullRoot)); // Should print true

        // Test case 5: Another balanced tree with different structure
        TreeNode balancedRoot2 = new TreeNode(1);
        balancedRoot2.left = new TreeNode(2);
        balancedRoot2.right = new TreeNode(3);
        balancedRoot2.left.left = new TreeNode(4);
        balancedRoot2.right.right = new TreeNode(5);

        System.out.println("Test case 5 (Balanced tree): " + isBalanced(balancedRoot2)); // Should print true
    }
}
