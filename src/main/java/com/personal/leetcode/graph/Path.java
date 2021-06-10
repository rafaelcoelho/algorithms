package com.personal.leetcode.graph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

import org.apache.commons.lang3.SerializationUtils;

public class Path {

    static class Node <T> implements Serializable {
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
        Node<String> n6 = new Node<>("6");
        Node<String> n7 = new Node<>("7");
        Node<String> n8 = new Node<>("8");

        n1.relation.add(n2);
        n1.relation.add(n3);

        n2.relation.add(n4);
        n2.relation.add(n3);
        n2.relation.add(n1);
        n2.relation.add(n8);

        n3.relation.add(n2);
        n3.relation.add(n1);

        n4.relation.add(n3);
        n4.relation.add(n5);
        n4.relation.add(n2);

        n5.relation.add(n4);
        n5.relation.add(n6);

        n6.relation.add(n7);
        n7.relation.add(n8);

        String value = "8";

        var head = n1;
        System.out.println("BFS - Value + " + value + " found = " + findNode_bfs(SerializationUtils.clone(head), n -> n.value.equals(value)));
        System.out.println("DFS - Value + " + value + " found = " + findNode_dfs(head, value));
    }

    public static boolean findNode_dfs(Node<String> from, String value) {
        if (from == null) return false;

        boolean result = false;

        System.out.println("DFS - Visiting: " + from.value);
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

            System.out.println("BFS - Visiting: " + cur.value);
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


