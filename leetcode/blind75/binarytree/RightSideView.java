package leetcode.blind75.binarytree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();

            for (int i=0; i<levelSize; i++){
                TreeNode node = queue.poll();

                if (i == levelSize-1){
                    result.add(node.val);
                }

                if (node.left!=null){
                    queue.offer(node.left);
                }

                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
        }

        return result;
    }
}