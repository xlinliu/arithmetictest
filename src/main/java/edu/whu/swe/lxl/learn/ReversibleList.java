package edu.whu.swe.lxl.learn;

public class ReversibleList<T> {
    public static void main(String[] args){
        ReversibleList<Integer> list = new ReversibleList<>(1, 2, 3, 4, 5, 6);
        ReversibleList.kReverse(list,3);
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+", ");
        }
    }

    private static class Node<T> {
        public T data;
        public Node<T> next;
    }

    private Node<T> head = new Node<>();
    private int size = 0;

    public ReversibleList(T... nums) {
        for(T num :nums){
            add(num);
        }
    }
public static <T>void kReverse(ReversibleList<T> list,int k){
        Node<T> node=list.getNode(0);
        Node<T> pre,cur,nex,head;
        head=pre=node;
        cur=node.next;
        nex=node.next.next;
        try {
            for (int i = 2; i <= k; i++) {
                cur.next = pre;
                pre = cur;
                cur = nex;
                nex = nex.next;
            }
            head.next=cur;
            list.head.next=pre;
        }catch (NullPointerException e){
            e.printStackTrace();
        }

}

    public void add(T x) {
        add(size, x);
    }

    public void add(int i, T x) {
        if (i < 0 || i > size)
            throw new IndexOutOfBoundsException();
        Node<T> pre = getNode(i - 1);
        addAfter(pre, x);
    }
    public T get(int i){
        return getNode(i).data;
    }

    private void addAfter(Node<T> pre, T x) {
        Node<T> newNode = new Node<>();
        newNode.data = x;
        newNode.next = pre.next;
        pre.next = newNode;
        ++size;
    }

    private Node<T> getNode(int i) {
        if (i == -1)
            return head;
        Node<T> node = head.next;
        for (int index = 0; index < i; index++) {
            node = node.next;
        }
        return node;
    }
    public  int size(){
        return size;
    }
}
