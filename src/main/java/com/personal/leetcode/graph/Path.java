package com.personal.leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Path {

    static class Node <T> {
        public T value;
        public List<Node<T>> relation;
        public boolean visited;

        public Node(T value) {
            this.relation = new ArrayList<>();
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node<String> n1 = new Node<>("1");
        Node<String> n2 = new Node<>("2");
        Node<String> n3 = new Node<>("3");
        Node<String> n4 = new Node<>("4");
        Node<String> n5 = new Node<>("5");

        n1.relation.add(n2);
        n1.relation.add(n3);

        n2.relation.add(n4);
        n2.relation.add(n3);

        n4.relation.add(n3);
        n4.relation.add(n5);

        n5.relation.add(n4);

        String value = "4";
        var head = n2;
        System.out.println("DFS - Value + " + value + " found = " + findNode_dfs(head, value));
    }

    public static boolean findNode_dfs(Node<String> from, String value) {
        if (from == null) return false;

        boolean result = false;
        if (from.value.equals(value)) return true;

        from.visited = true;

        for (Node<String> relative : from.relation) {
            if (!relative.visited) {
                result = findNode_dfs(relative, value);
                if (result) break;
            }
        }

        return result | false;
    }

    public static boolean findNode_bfs(Node<String> from, Predicate<Node<String>> visitor) {
        LinkedList<Node<String>> nodes = new LinkedList<Node<String>>();

        if (from == null) return false;

        nodes.add(from);
        from.visited = true;

        while (!nodes.isEmpty()) {
            var cur = nodes.removeFirst();
            cur.visited = true;

            System.out.println("Visiting: " + cur.value);
            if (visitor.test(cur)) return true;

            for (Node<String> relative : cur.relation) {
                if (!relative.visited) {
                    relative.visited = true;
                    nodes.add(relative);
                }
            }
        }

        return false;
    }
}


