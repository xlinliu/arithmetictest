package edu.whu.swe.lxl.learn.linkedlist;

public class ComplexNodeCopy {
    public static void main(String[] args){

    }

    public static class ComplexNode {
        int data;
        ComplexNode next;
        ComplexNode sibling;
    }

    public static ComplexNode copy(ComplexNode head) {
        ComplexNode combinatedList = combinate(head);
        return split(combinatedList);
    }

    public static ComplexNode combinate(ComplexNode head) {
        ComplexNode hd = head;
        ComplexNode node = hd;
        ComplexNode clonedNode;
        while (node != null) {
            clonedNode = new ComplexNode();
            clonedNode.data = node.data;
            clonedNode.next = node.next;
            node.next = clonedNode;
            node = clonedNode.next;
        }
        node = hd;
        while (node != null) {
            ComplexNode siblingOfNode = node.sibling;
            ComplexNode newNode = node.next;
            newNode.sibling = siblingOfNode.next;
            node = newNode.next;
        }
        return hd;
    }

    public static ComplexNode split(ComplexNode head) {
        ComplexNode clonedHd = head.next;
        ComplexNode node = head;
        ComplexNode clonedNode = clonedHd;
        while (clonedNode != null) {
            node.next = clonedNode.next;
            node = node.next;
            clonedNode.next = node.next;
            clonedNode = clonedNode.next;
        }
        node.next = null;
        return clonedHd;
    }
}
