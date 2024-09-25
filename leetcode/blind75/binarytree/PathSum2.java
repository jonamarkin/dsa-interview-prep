package leetcode.blind75.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    /*
    Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node
    values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

    A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
     */

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(root, targetSum, currentPath, result);
        return result;
    }

    public void dfs(TreeNode node, int remainder, List<Integer> currentPath, List<List<Integer>> result){
        if (node ==null){
            return;
        }

        currentPath.add(node.val);

        if (node.left==null && node.right ==null && remainder == node.val){
            result.add(new ArrayList<>(currentPath));
        }else{
            dfs(node.left, remainder-node.val, currentPath, result);
            dfs(node.right, remainder-node.val, currentPath, result);
        }

        currentPath.remove(currentPath.size()-1);
    }
}
