package edu.whu.swe.lxl.learn.tree;

public class ConvertTreeToDList {

    public static void main(String[] args){
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode tree = ReconstructBinaryTree.reconstruct(preOrder, inOrder);
        BinaryTreeNode head=convert(tree).head;

    }

    private static class Pair{
        public Pair(BinaryTreeNode head, BinaryTreeNode tail) {
            this.head = head;
            this.tail = tail;
        }

        BinaryTreeNode head;
        BinaryTreeNode tail;
    }
    public static Pair convert(BinaryTreeNode root){
        Pair leftPair;
        Pair rightPair;
        BinaryTreeNode head=root;
        BinaryTreeNode tail=root;
        if(root.lChild!=null) {
            leftPair =convert(root.lChild);
            root.lChild=leftPair.tail;
            leftPair.tail.rChild=root;
            head=leftPair.head;
        }
        if(root.rChild!=null){
            rightPair = convert(root.rChild);
            root.rChild=rightPair.head;
            rightPair.head.lChild=root;
            tail=rightPair.tail;
        }
        return new Pair(head,tail);

    }
}
