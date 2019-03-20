package edu.whu.swe.lxl.learn.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class FindThroughListFromTail2Head {
    public static void main(String[] args) {
//        Node head = null;
//        Node tail = null;
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {
//            if (head == null) {
//                head = new Node();
//                tail = head;
//                head.data = in.nextInt();
//            }else {
//            Node node = new Node();
//            node.data = in.nextInt();
//            tail.next = node;
//            tail = node;}
//        }
//
//        Stack<Node> stack = new Stack<>();
//        Node currentNode = head;
//        while (currentNode != null) {
//            stack.push(currentNode);
//            currentNode = currentNode.next;
//        }
//        while (!stack.isEmpty())
//            System.out.print(stack.pop().data);


        Scanner in = new Scanner(System.in);
        List<Integer> ms=new ArrayList<>();
        List<Integer> ns=new ArrayList<>();
        while(in.hasNextInt()){
            ms.add(in.nextInt());
            ns.add(in.nextInt());
        }
        for(int i=0;i<ms.size();i++){
            int countofMagic=0;
            for(int num=ms.get(i);num<=ns.get(i);num++){
                int a=0;
                int expectedNum=num;
                for(int tmp=num;tmp>0;tmp/=10){
                    a=tmp%10;
                    expectedNum-=a*a*a;
                }
                if(expectedNum==0){
                    ++countofMagic;
                    if(countofMagic==1)
                        System.out.print(num);
                    else
                        System.out.print(" "+num);
                }

            }
            if(countofMagic==0)
            System.out.print("no");
            System.out.print("\n");
        }

    }
}
