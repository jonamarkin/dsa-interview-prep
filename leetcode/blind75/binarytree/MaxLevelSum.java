package leetcode.blind75.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {

    public int maxLevelSum(TreeNode root) {

        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        int currentLevel=1;
        Queue<TreeNode> integerQueue = new LinkedList<>();
        integerQueue.offer(root);

        while(!integerQueue.isEmpty()){

            int levelSize = integerQueue.size();

            int levelSum = 0;
            for (int i=0; i<levelSize; i++){
                TreeNode node = integerQueue.poll();
                levelSum+=node.val;

                if (node.left!=null){
                    integerQueue.offer(node.left);
                }
                if (node.right!=null){
                    integerQueue.offer(node.right);
                }
            }

            if (levelSum > maxSum){
                maxSum = levelSum;
                maxLevel = currentLevel;
            }

            currentLevel++;

        }
        return maxLevel;
    }
}
