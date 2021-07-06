package com.personal.leetcode.graph;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.function.Consumer;

public class BST {
    static class Node <T> implements Serializable {
        public T value;
        public Node<T> rigth;
        public Node<T> left;

        public Node(T value) {
            this.rigth = null;
            this.left = null;
            this.value = value;
        }

        public Node<T> left(T n) {
            this.left = new Node<>(n);
            return this.left;
        }

        public Node<T> rigth(T n) {
            this.rigth = new Node<>(n);
            return this;
        }
    }

    public static void main(String[] args) {
        var root = new Node<Integer>(10);

        Node<Integer> left = new Node<>(5);

        left.rigth(6)
            .left(3)
            .rigth(4)
            .left(2);

        root.left = left;

        Node<Integer> rigth = new Node<>(15);

        rigth.rigth(18)
            .left(13)
            .rigth(14)
            .left(12);

        rigth.rigth.rigth(25)
            .left(17);

        root.rigth = rigth;

        System.out.println("Deep First Search");
        dfs(root, System.out::println);

        System.out.println("Breadth First Search");
        bfs(root, System.out::println);

        System.out.println("Is BST: " + isBST(root));
        System.out.println("Is BST: " + isBST(root, null, null));

        System.out.println("Hard case - Is BST: " + isBST(new Node<>(10).rigth(5), null, null));
        System.out.println("Hard case - Is BST: " + isBST(new Node<>(10).rigth(10)));
    }

    private static <T extends Number> boolean isBST(Node<T> root, T minValue, T maxValue) {
        if (root == null) return true;

        if ((minValue != null && root.value.intValue() <= minValue.intValue()) ||
            (maxValue != null && root.value.intValue() >= maxValue.intValue()))
            return false;

        if (!isBST(root.left, minValue, root.value) || !isBST(root.rigth, root.value, maxValue))
            return false;

        return true;
    }

    //O(nodes) for time complexity and O(nodes) of space complexity
    private static <T extends Number> boolean isBST(Node<T> root) {
        ArrayList<T> values = new ArrayList<T>();

        dfs(root, values::add);

        for (int i = 1; i < values.size(); i++) {
            if (values.get(i).intValue() <= values.get(i - 1).intValue()) return false;
        }

        return true;
    }

    private static <T> void bfs(Node<T> root, Consumer<T> consumer) {
        Deque<Node<T>> nodes = new ArrayDeque<>();

        nodes.add(root);

        while(!nodes.isEmpty()) {
            Node<T> pop = nodes.pop();

            consumer.accept(pop.value);

            if (pop.left != null)
                nodes.add(pop.left);

            if (pop.rigth != null)
                nodes.add(pop.rigth);
        }
    }

    private static <T> void dfs(Node<T> root, Consumer<T> consumer) {
        if (root == null) return;

        dfs(root.left, consumer);
        consumer.accept(root.value);
        dfs(root.rigth, consumer);
    }
}
