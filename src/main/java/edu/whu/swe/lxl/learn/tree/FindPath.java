package edu.whu.swe.lxl.learn.tree;

import java.util.Stack;

public class FindPath {
    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode tree = ReconstructBinaryTree.reconstruct(preOrder, inOrder);

        findPath(tree, 9);

    }

    public static void findPath(BinaryTreeNode tree, int expectSum) {
        Stack<Integer> route = new Stack<>();
        findPath(tree, route, expectSum, 0);
    }

    public static void findPath(BinaryTreeNode root, Stack<Integer> route, int expectSum, int currentSum) {
        int curdata = root.data;
        int cursum = currentSum + curdata;
        route.push(root.data);
        if (root.lChild != null)
            findPath(root.lChild, route, expectSum, cursum);
        if (root.rChild != null)
            findPath(root.rChild, route, expectSum, cursum);
        if (root.lChild == null && root.rChild == null) {
            if (expectSum == cursum) {
                for (int data : route) {
                    System.out.print(data);
                }
                System.out.println();
            }
        }
        route.pop();
    }
}
