package edu.whu.swe.lxl.learn.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintTreeLevelByLevel {
    public static void main(String[] args){
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode tree = ReconstructBinaryTree.reconstruct(preOrder, 0, preOrder.length - 1,
                inOrder, 0, inOrder.length - 1);
        printTree(tree);
    }
    public static void printTree(BinaryTreeNode root){
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryTreeNode node;

        while (!queue.isEmpty()){
            node=queue.remove();
            System.out.print(node.data);
            BinaryTreeNode child;
            if((child=node.lChild)!=null)
                queue.add(child);
            if((child=node.rChild)!=null)
                queue.add(child);
        }
    }
}
