package edu.whu.swe.lxl.learn.tree;

public class ReconstructBinaryTree {
    public static void main(String[] args){
        int[] preOrder={1,2,4,7,3,5,6,8};
        int[] inOrder={4,7,2,1,5,3,8,6};
        BinaryTreeNode tree=reconstruct(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1);
    }
public static BinaryTreeNode reconstruct(int[] preOrder,int[] inOrder){
   return reconstruct(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1);
}
    public static BinaryTreeNode reconstruct(int[] preOrder,int preStart,int preEnd,int[] inOrder,int inStart,int inEnd){

        BinaryTreeNode root=new BinaryTreeNode();
        root.data=preOrder[preStart];

        int i=inStart;
        while (inOrder[i]!=root.data){
            i++;
        }
        int preLeftEnd=preStart+(i-inStart);
        int preRightStart=preLeftEnd+1;
        if(i>inStart)
        root.lChild=reconstruct(preOrder,preStart+1,preLeftEnd,inOrder,inStart,i-1);
        if(i<inEnd)
        root.rChild=reconstruct(preOrder,preRightStart,preEnd,inOrder,i+1,inEnd);
        return root;
    }
}
