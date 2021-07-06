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
            .left(20);

        root.rigth = rigth;

        getArrayUsingDFS(root, System.out::println);
    }

    private static <T> void getArrayUsingDFS(Node<T> root, Consumer<T> consumer) {
        if (root == null) return;

        getArrayUsingDFS(root.left, consumer);
        consumer.accept(root.value);
        getArrayUsingDFS(root.rigth, consumer);
    }
}
