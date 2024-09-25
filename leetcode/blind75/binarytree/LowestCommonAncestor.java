package leetcode.blind75.binarytree;

import com.sun.source.tree.Tree;

public class LowestCommonAncestor {
    /*
    Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

    According to the definition of LCA on Wikipedia:
    “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root ==p || root == q){
            return root;
        }

        //Recur on left anf right
        TreeNode left = lowestCommonAncestor(root.left, p,q);
        TreeNode right = lowestCommonAncestor(root.right, p,q);

        //If both left and right are non-null, root is the LCA
        if (left!=null && right!=null){
            return root;
        }

        //If only one of the left or right is non-null, return the non-null value
        return left!=null? left : right;
    }
}
