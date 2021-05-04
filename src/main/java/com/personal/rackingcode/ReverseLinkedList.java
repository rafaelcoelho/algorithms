package com.personal.rackingcode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        Node head = new Node('A');

        head.addNode('B').addNode('C').addNode('D').addNode('E');

        print(head);
        head = reverse(head);
        print(head);

        int[] array = {1, 2, 3, 4, 5, 6, 7, 10};
        printArray(array);
        reverse(array);
        printArray(array);

        int n = 48;
        int[] memo = new int[n + 1];
        System.out.println(fibo(n, memo));
        System.out.println(fiboDummy(n));
    }

    static int fibo(int n, int[] memo) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else if (memo[n] > 0) return memo[n];

        memo[n] = fibo(n - 1, memo) + fibo(n - 2, memo);
        return memo[n];
    }

    static int fiboDummy(int n) {
        if (n > 50) throw new RuntimeException("Is not feasible to compute Fibonacci sequence for " + n);
        if (n == 0) return 0;
        else if (n == 1) return 1;

        return fiboDummy(n - 1) + fiboDummy(n - 2);
    }

    static Node reverse(Node head) {
        Node p2 = head.next;

        head.next = null;
        while (p2 != null) {
            Node tmp = p2.next;
            p2.next = head;

            head = p2;
            p2 = tmp;
        }

        return head;
    }

    static void printArray(int[] array) {
        for (int v : array) {
            System.out.print(v + " ");
        }

        System.out.println("");
    }

    static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int other = array.length - i - 1;

            int tmp = array[i];
            array[i] = array[other];
            array[other] = tmp;
        }
    }

    static void print(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");

            head = head.next;
        }

        System.out.println("");
    }

    public static class Node {
        Node next;
        char value;

        private Node(char value) {
            this.value = value;
        }

        public Node addNode(char value) {
            Node node = new Node(value);
            this.next = node;

            return node;
        }

    }
}
