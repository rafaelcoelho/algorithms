package com.personal.rackingcode;

import java.util.*;

public class LikedList {
	
    public static void main (String[] args) {
        Node head = new Node(5);
        
        head.next(new Node(5))
            .next(new Node(3))
            .next(new Node(4))
            .next(new Node(3))
            .next(new Node(6))
            .next(new Node(6))
            .next(new Node(6))
            .next(new Node(6))
            .next(new Node(6))
            .next(new Node(6))
            .next(new Node(10));

        printList(head);
        removeDuplicated(head);
        printList(head); 
        
        Node head2 = new Node(5);
        
        head2.next(new Node(5))
            .next(new Node(3))
            .next(new Node(4))
            .next(new Node(3))
            .next(new Node(6))
            .next(new Node(6))
            .next(new Node(6))
            .next(new Node(6))
            .next(new Node(6))
            .next(new Node(6))
            .next(new Node(10));
        removeDuplicated2_hint9(head2);
        printList(head2);

        Node head3 = new Node(5);
        
        head3.next(new Node(1))
            .next(new Node(2))
            .next(new Node(3))
            .next(new Node(4))
            .next(new Node(5))
            .next(new Node(6))
            .next(new Node(7))
            .next(new Node(8))
            .next(new Node(9))
            .next(new Node(10))
            .next(new Node(11));
        printKthToLast(head3, 1);
        printKthToLast_2nd(head3, 1);

        head3 = new Node(0);
        
        Node toRemove = new Node(225);
        head3.next(new Node(1))
            .next(new Node(2))
            .next(new Node(3))
            .next(new Node(4))
            .next(toRemove)
            .next(new Node(6))
            .next(new Node(7))
            .next(new Node(8))
            .next(new Node(9))
            .next(new Node(10))
            .next(new Node(11))
            ;
        
        printList(head3);
        removeNodeInMiddle(toRemove);
        printList(head3);
    }

    //Time complexit - O(1)
    private static boolean removeNodeInMiddle(Node toRemove) {
        if (toRemove == null || toRemove.getNext() == null) {
            return false;
        }

        Node next = toRemove.getNext();
        toRemove.setValue(next.getValue());
        toRemove.next(next.getNext());

        return true;
    }

    //Time complexity  - O(n)
    //Space complexity - O(1)
    private static void printKthToLast_2nd(Node head, int k) {
        Node p1 = head;
        Node p2 = head;

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
    private static int printKthToLast(Node head, int k) {
        if (head == null)
            return 0;

        int index = printKthToLast(head.getNext(), k) + 1;

        if (index == k)
            System.out.println(k + "th to last node is " + head.getValue());

        return index;
    }

    private static void removeDuplicated(Node in) {
        Node head = in;

        while (head.getNext() != null) {

            Node current = head;

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

    private static void removeDuplicated2(Node in) {
        Node head = in;

        while (head.getNext() != null) {

            Node current = head;

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

    private static void removeDuplicated2_hint40(Node in) {
        
    }

    private static void removeDuplicated2_hint9(Node in) {
        HashSet<Integer> set = new HashSet<>();

        Node previous = in;
        for (; in != null; in = in.getNext()) {
            if (set.contains(in.getValue())) {
                previous.next(in.getNext());
            } else {
                set.add(in.getValue());
                previous = in;
            }
        }
    }

    private static void printList(Node head) {
        System.out.println("The list is:");

        while (head != null) {
            System.out.print(head.getValue() + " ");
            head = head.getNext();
        }

        System.out.println("");
    }

    
}

class Node {
    private int value;
    private Node next;

    public Node(int value) {
        this.value = value;
    }

    public Node next(Node node) {
        this.next = node;
        return node;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public Node getNext() {
        return this.next;
    }

}