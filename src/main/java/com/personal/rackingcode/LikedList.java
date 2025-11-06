package com.personal.rackingcode;

import java.util.HashSet;

public class LikedList {

    public static void main(String[] args) {
        NodeList head = new NodeList(5);

        head.next(new NodeList(5))
                .next(new NodeList(3))
                .next(new NodeList(4))
                .next(new NodeList(3))
                .next(new NodeList(6))
                .next(new NodeList(6))
                .next(new NodeList(6))
                .next(new NodeList(6))
                .next(new NodeList(6))
                .next(new NodeList(6))
                .next(new NodeList(10));

        printList(head);
        removeDuplicated(head);
        printList(head);

        NodeList head2 = new NodeList(5);

        head2.next(new NodeList(5))
                .next(new NodeList(3))
                .next(new NodeList(4))
                .next(new NodeList(3))
                .next(new NodeList(6))
                .next(new NodeList(6))
                .next(new NodeList(6))
                .next(new NodeList(6))
                .next(new NodeList(6))
                .next(new NodeList(6))
                .next(new NodeList(10));
        removeDuplicated2_hint9(head2);
        printList(head2);

        NodeList head3 = new NodeList(5);

        head3.next(new NodeList(1))
                .next(new NodeList(2))
                .next(new NodeList(3))
                .next(new NodeList(4))
                .next(new NodeList(5))
                .next(new NodeList(6))
                .next(new NodeList(7))
                .next(new NodeList(8))
                .next(new NodeList(9))
                .next(new NodeList(10))
                .next(new NodeList(11));
        printKthToLast(head3, 1);
        printKthToLast_2nd(head3, 1);

        head3 = new NodeList(0);

        NodeList toRemove = new NodeList(225);
        head3.next(new NodeList(1))
                .next(new NodeList(2))
                .next(new NodeList(3))
                .next(new NodeList(4))
                .next(toRemove)
                .next(new NodeList(6))
                .next(new NodeList(7))
                .next(new NodeList(8))
                .next(new NodeList(9))
                .next(new NodeList(10))
                .next(new NodeList(11))
        ;

        printList(head3);
        removeNodeInMiddle(toRemove);
        printList(head3);
    }

    //Time complexit - O(1)
    private static boolean removeNodeInMiddle(NodeList toRemove) {
        if (toRemove == null || toRemove.getNext() == null) {
            return false;
        }

        NodeList next = toRemove.getNext();
        toRemove.setValue(next.getValue());
        toRemove.next(next.getNext());

        return true;
    }

    //Time complexity  - O(n)
    //Space complexity - O(1)
    private static void printKthToLast_2nd(NodeList head, int k) {
        NodeList p1 = head;
        NodeList p2 = head;

        for (int i = 0; i < k; i++) {
            p1 = p1.getNext();
        }

        while (p1 != null) {
            p2 = p2.getNext();
            p1 = p1.getNext();
        }

        System.out.println(k + "th to last node is " + p2.getValue());
    }

    //Time complexity  - O(n)
    //Space complexity - O(n)
    private static int printKthToLast(NodeList head, int k) {
        if (head == null)
            return 0;

        int index = printKthToLast(head.getNext(), k) + 1;

        if (index == k)
            System.out.println(k + "th to last node is " + head.getValue());

        return index;
    }

    private static void removeDuplicated(NodeList in) {
        NodeList head = in;

        while (head.getNext() != null) {

            NodeList current = head;

            while (current.getNext() != null) {
                if (head.getValue() == current.getNext().getValue()) {
                    current.next(current.getNext().getNext());
                } else {
                    current = current.getNext();
                }
            }

            head = head.getNext();
        }
    }

    private static void removeDuplicated2(NodeList in) {
        NodeList head = in;

        while (head.getNext() != null) {

            NodeList current = head;

            while (current.getNext() != null) {

                if (head.getValue() == current.getNext().getValue()) {
                    current.next(current.getNext().getNext());
                } else {
                    current = current.getNext();
                }
            }

            head = head.getNext();
        }
    }

    private static void removeDuplicated2_hint40(NodeList in) {

    }

    private static void removeDuplicated2_hint9(NodeList in) {
        HashSet<Integer> set = new HashSet<>();

        NodeList previous = in;
        for (; in != null; in = in.getNext()) {
            if (set.contains(in.getValue())) {
                previous.next(in.getNext());
            } else {
                set.add(in.getValue());
                previous = in;
            }
        }
    }

    private static void printList(NodeList head) {
        System.out.println("The list is:");

        while (head != null) {
            System.out.print(head.getValue() + " ");
            head = head.getNext();
        }

        System.out.println("");
    }


}

class NodeList {
    private int value;
    private NodeList next;

    public NodeList(int value) {
        this.value = value;
    }

    public NodeList next(NodeList node) {
        this.next = node;
        return node;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public NodeList getNext() {
        return this.next;
    }

}