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
}
