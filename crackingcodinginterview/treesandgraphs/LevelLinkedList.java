package crackingcodinginterview.treesandgraphs;


import java.util.ArrayList;
import java.util.LinkedList;

public class LevelLinkedList {

    /*
    Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth
    (eg, if you have a tree with depth D, you’ll have D linked lists).
     */

    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedLists(TreeNode root){
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        int level = 0;
        linkedList.add(root);

        result.add(level, linkedList);

        while(true){
            linkedList = new LinkedList<>();

            for (int i=0; i<result.get(level).size(); i++){

                TreeNode node = result.get(level).get(i);

                if (node!=null){
                    if (node.left!=null){
                        linkedList.add(node.left);
                    }
                    if (node.right!=null){
                        linkedList.add(node.right);
                    }
                }
            }

            if (!linkedList.isEmpty()){
                result.add(level+1, linkedList);
            }else{
                break;
            }

            level++;
        }

        return result;
    }


    public static void main(String[] args) {

    }
}
