package leetcode.blind75.binarytree;

public class PathSum3 {

    /*
    Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values
    along the path equals targetSum.

    The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent
    nodes to child nodes).
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root ==null){
            return 0;
        }

        return pathSumFrom(root, targetSum) +
                pathSumFrom(root.left, targetSum) +
                pathSumFrom(root.right, targetSum);
    }

    public int pathSumFrom(TreeNode node, long remainder){

    }
}
