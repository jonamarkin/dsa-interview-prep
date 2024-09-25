package leetcode.blind75.binarytree;

public class GoodNodes {

    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    public int dfs(TreeNode root, int maxSoFar){
        if(root  ==null){
            return 0;
        }

        int goodCount = 0;

        if(root.val>=maxSoFar){
            goodCount++;
        }

        maxSoFar = Math.max(maxSoFar, root.val);

        goodCount+=dfs(root.left, maxSoFar);
        goodCount+=dfs(root.right, maxSoFar);

        return goodCount;
    }
}
