package crackingcodinginterview.treesandgraphs;

import com.sun.source.tree.Tree;

public class ArrayToBinaryTree {

    /*
    Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height.
     */

    public static TreeNode createMinimalBST(int[] array) {
        return addToTree(array, 0, array.length - 1);
    }

    private static TreeNode addToTree(int[] array, int start, int end) {

        if (end < start){
            return null;
        }

        int mid = (start + end)/2;

        //Add mid to the tree
        TreeNode node = new TreeNode(array[mid]);

        //Add the left of the mid to the left of the tree and right of mid to the right of the tree
        node.left = addToTree(array, start, mid-1);
        node.right = addToTree(array, mid+1, end);

        return node;
    }
}
