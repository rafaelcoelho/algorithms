package com.personal.rackingcode;

import java.util.HashSet;
import java.util.List;

public class LinkedList {

    public static void main(String[] args) {
        System.out.println("4,5,5,6,7,8,8,7,6,6 is " + removeDuplicated_constantSpaceComplexity(new java.util.LinkedList<>(java.util.Arrays.asList(4,5,5,6,7,8,8,7,6,6))));
        System.out.println("4,5,5,6,7,8,8,7,6,6 is " + removeDuplicated_hashTable(new java.util.LinkedList<>(java.util.Arrays.asList(4,5,5,6,7,8,8,7,6,6))));

        Node<Integer> head = new Node<>(877777);
        head.next(20)
            .next(30)
            .next(32)
            .next(389)
            .next(42);

        int pos = 3;
        printKthElementList_recursive(head, pos);
        printKthElementList_iteratively(head, pos);
        printKthElementList_iteratively_v2(head, pos);
    }

    //O(n) time complexity
    //O(1) space complexity
    static int printKthElementList_iteratively_v2(Node<Integer> head, int index) {
      Node<Integer> p1 = head;

      for (int i = 0; i < index; i++) {
          p1 = p1.next;
      }

      Node<Integer> p2 = head;
      while (p1 != null) {
          p1 = p1.next;
          p2 = p2.next;
      }

      System.out.println("node.value = " + p2.value);
      return p2.value;
    }

    //O(n) time complexity
    //O(1) space complexity
    static int printKthElementList_iteratively(Node<Integer> head, int index) {
        int p1 = 0;

        Node<Integer> node = head;

        while (node != null) {
            node = node.next;
            p1++;
        }

        int p2 = p1 - index;
        node = head;

        while (p2 > 0) {
            node = node.next;
            p2--;
        }

        System.out.println("node.value = " + node.value);
        return node.value;
    }

    //O(n) in the worst case of time complexity
    //O(1) space complexity
    static int printKthElementList_recursive(Node<Integer> head, int index) {
        if (head == null) return 0;

        int pos = printKthElementList_recursive(head.next, index) + 1;

        if (pos == index) System.out.println("head.value = " + head.value);

        return pos;
    }

    //O(n) of time complexity and O(n of different values) space complexity
    static List<Integer> removeDuplicated_hashTable(java.util.LinkedList<Integer> in) {
        HashSet<Integer> hash = new HashSet<>();

        int i = 0;
        while (i < in.size()) {
            if (hash.contains(in.get(i))) {
                in.remove(i);
                continue;
            }

            hash.add(in.get(i));
            i++;
        }

        return in;
    }

    //O(n²) of time complexity and O(1) space complexity
    static List<Integer> removeDuplicated_constantSpaceComplexity(java.util.LinkedList<Integer> in) {

        int i = 0, j;

        while (i < in.size()) {
            j = i + 1;
            while (j < in.size()) {
                if (in.get(i).equals(in.get(j))) {
                    in.remove(j);
                    continue;
                }
                j++;
            }
            i++;
        }

        return in;
    }

    static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }

        Node<T> next(T value) {
            this.next = new Node<>(value);
            return this.next;
        }
    }
}
