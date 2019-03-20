package edu.whu.swe.lxl.learn.tree;

import java.util.List;
import java.util.Stack;

public class BinaryTreeNode {
    public int data;
    public BinaryTreeNode lChild;
    public BinaryTreeNode rChild;

    private static class PostNode {
        public BinaryTreeNode node;
        public boolean isFirst;

        public PostNode(BinaryTreeNode node, boolean isFirst) {
            this.node = node;
            this.isFirst = isFirst;
        }
    }

    public static void preListAll(List<Integer> list, BinaryTreeNode root) {
        if (root == null)
            return;
        list.add(root.data);
        preListAll(list, root.lChild);
        preListAll(list, root.rChild);
    }

    public static void inListAll(List<Integer> list, BinaryTreeNode root) {
        if (root == null)
            return;

        inListAll(list, root.lChild);
        list.add(root.data);
        inListAll(list, root.rChild);
    }

    public static void postListAll(List<Integer> list, BinaryTreeNode root) {
        postListAll(list, root.lChild);
        postListAll(list, root.rChild);
        list.add(root.data);
    }

    public static void preListAll_iterative(List<Integer> list, BinaryTreeNode root) {
        Stack<BinaryTreeNode> s = new Stack<>();
        BinaryTreeNode p = root;
        while (!s.isEmpty() || p != null) {
            while (p != null) {
                list.add(p.data);
                s.push(p);
                p = p.lChild;
            }
            if (!s.isEmpty()) {
                p = s.pop().rChild;
            }
        }
    }

    public static void inListAll_iterative(List<Integer> list, BinaryTreeNode root) {
        Stack<BinaryTreeNode> s = new Stack<>();
        BinaryTreeNode p = root;
        while (!s.isEmpty() || p != null) {
            while (p != null) {
                s.push(p);
                p = p.lChild;
            }
            if (!s.isEmpty()) {
                p = s.pop();
                list.add(p.data);
                p = p.rChild;
            }
        }
    }

    public static void postListAll_iterative(List<Integer> list, BinaryTreeNode root) {
        PostNode p = new PostNode(root, true);
        Stack<PostNode> s = new Stack<>();
        while (p.node != null || !s.isEmpty()) {
            while (p.node != null) {
                    s.push(p);
                    p = new PostNode(p.node.lChild, true);

            }
            if (!s.isEmpty()) {
                p = s.pop();
                if (p.isFirst) {
                    s.push(new PostNode(p.node, false));
                    p = new PostNode(p.node.rChild, true);
                } else {
                    list.add(p.node.data);
                    p.node=null;
                }
            }
        }
    }

    /**
     * 递归法查找二叉树
     * @param tree 查找的根节点
     * @param target 查找的目标
     * @return 目标节点
     */
    public static BinaryTreeNode find(BinaryTreeNode tree,int target){
        if(tree==null)
            return null;
        if(tree.data==target)
            return tree;
        BinaryTreeNode r,l;
        l=find(tree.lChild,target);
        if(l!=null)
            return l;
        r=find(tree.rChild,target);
        if(r!=null)
            return r;

        return null;
    }


}
