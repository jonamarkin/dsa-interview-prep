package leetcode.blind75.binarytree;

import com.sun.source.tree.Tree;

public class DeleteNode {

    /*
    Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

    Basically, the deletion can be divided into two stages:

    Search for a node to remove.
    If the node is found, delete the node.

     */

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }

        //Search fo the node to delete
        if (key <root.val){
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }else {
            //Node to delete has been found

            //Case 1: Leaf node
            if (root.left == null && root.right ==null){
                return null;
            }

            //Case 2: Node has one child
            if (root.left ==null){
                return root.right;
            }
            if (root.right ==null){
                return root.left;
            }

            //Case 3 : Node has two children
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }

        return root;
    }

    private TreeNode findMin(TreeNode node){
        while (node.left!=null){
            node = node.left;
        }

        return node;
    }
}
