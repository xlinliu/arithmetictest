package edu.whu.swe.lxl.learn.tree;

import edu.whu.swe.lxl.learn.tree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class MirrorTree {
    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode tree = ReconstructBinaryTree.reconstruct(preOrder, 0, preOrder.length - 1,
                inOrder, 0, inOrder.length - 1);

//        BinaryTreeNode mirroredTree = mirrorTree(tree);
//        List<Integer> list = new ArrayList<>();
//        BinaryTreeNode.inListAll(list,tree);
//        List<Integer> mirroredList = new ArrayList<>();
//        BinaryTreeNode.postListAll_iterative(mirroredList,mirroredTree);
//        BinaryTreeNode.postListAll(mirroredList,mirroredTree);
//        for(int e:list){
//            System.out.print(e);
//        }
//        System.out.println();
//        for(int e:mirroredList){
//            System.out.print(e);
//        }
        List<Integer> list = new ArrayList<>();
        BinaryTreeNode.postListAll_iterative(list,tree);
        for(int e:list){
            System.out.print(e);
        }
    }

    private static BinaryTreeNode mirrorTree(BinaryTreeNode orignalTree) {
        if (orignalTree == null)
            return null;
        BinaryTreeNode root = new BinaryTreeNode();
        root.data = orignalTree.data;
        root.lChild = mirrorTree(orignalTree.rChild);
        root.rChild = mirrorTree(orignalTree.lChild);
        return root;
    }

}
