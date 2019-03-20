package edu.whu.swe.lxl.learn.tree;

import java.util.ArrayList;
import java.util.List;

public class DoesTree1HasTree2 {
    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode tree1 = ReconstructBinaryTree.reconstruct(preOrder, 0, preOrder.length - 1,
                inOrder, 0, inOrder.length - 1);
        int[] preOrder2 = {6,8};
        int[] inOrder2 = {8,6};
        BinaryTreeNode tree2 = ReconstructBinaryTree.reconstruct(preOrder2, 0, preOrder2.length - 1,
                inOrder2, 0, inOrder2.length - 1);
        boolean hasTree= hasTree(tree1, tree2);
        assert hasTree;
    }

    public static boolean hasTree(BinaryTreeNode tree1, BinaryTreeNode tree2) {
        if (tree1 == null || tree2 == null)
            return false;
        List<BinaryTreeNode> roots = new ArrayList<>();
        findRoots(roots, tree1, tree2);
        if (roots.size() == 0)
            return false;
        for (BinaryTreeNode root : roots) {
            if (has0(root, tree2))
                return true;
        }
        return false;
    }

    private static void findRoots(List<BinaryTreeNode> roots, BinaryTreeNode tree, BinaryTreeNode root) {
        if (tree == null)
            return;
        if (tree.data == root.data)
            roots.add(tree);
        findRoots(roots, tree.lChild, root);
        findRoots(roots, tree.rChild, root);
    }

    private static boolean has0(BinaryTreeNode tree1, BinaryTreeNode tree2) {
        if (tree2 == null)
            return true;
        if (tree1 == null)
            return false;
        if (tree1.data != tree2.data)
            return false;
        return has0(tree1.lChild, tree2.lChild) && has0(tree1.rChild, tree2.rChild);

    }
}
