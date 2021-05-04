package com.personal.rackingcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MyQueue<T> {
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> first;
    private Node<T> last;

    public void enqueue(T value) {
        Node<T> node = new Node<>(value);

        if (first == null) {
            first = node;
            last = node;
        } else {
            Node<T> tmp = last;
            last = node;
            tmp.next = last;
        }
    }

    public T dequeue() {
        if (first == null) {
            return null;
        }

        T tmp = first.data;
        first = first.next;

        return tmp;
    }

    private static int groupCopy(List<String> list) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> bin = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String user = list.get(i);

            map.put(i, 1);
            
            int b = 0;
            for (int j = 0; j < user.length(); j++) {
                b |= Integer.valueOf(user.charAt(j) - 48) << (user.length() - 1 - j);
                int max = Math.max(i, j);
                int min = Math.min(i, j);

                if (user.charAt(j) == '1' && i != j) {
                    map.remove(i);
                    map.put(max - min, 1);
                }
            }

            bin.add(b);
        }

        for (int i = 0; i < bin.size(); i++) {
            var cur = bin.get(i);

            if (cur != -1) {
                int j = i + 1;
                while (j < bin.size()) {
                    if ((cur & bin.get(j)) > 0) {
                        bin.set(j, -1);
                    }
                    j++;
                }
            }
        }

        return (int) bin.stream().filter(it -> it != -1).count();
        // return map.size();
    }

    private static int groupBinary(List<String> list) {
        List<Integer> bin = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String user = list.get(i);

            int b = 0;

            for (int j = 0; j < user.length(); j++) {
                b |= Integer.valueOf(user.charAt(j) - 48) << (user.length() - 1 - j);
            }

            bin.add(b);
        }

        for (int i = 0; i < bin.size(); i++) {
            var cur = bin.get(i);

            if (cur != -1) {
                for (int j = i + 1; j < bin.size(); j++) {
                    if ((cur & bin.get(j)) > 0) {
                        bin.set(j, -1);
                    }
                }
            }
        }

        return (int) bin.stream().filter(it -> it != -1).count();
    }

    private static int graph(List<String> nodes, int n) {
        Map<Integer, Integer> map = new HashMap<>();

        Integer count = 0;

        for (String node : nodes) {
            var f1 = Integer.valueOf(node.split(" ")[0]);
            var f2 = Integer.valueOf(node.split(" ")[1]);

            var r = map.computeIfPresent(f2, (k, val) -> {
                map.remove(f1);
                return val++;
            });

            r = map.computeIfPresent(f1, (k, val) -> {
                map.remove(f2);
                return val++;
            });

            if (r == null) {
                map.put((int) f1, 2);
                map.put((int) f2, 2);
                count += 2;
            } else {
                count += r;
            }

        }

        var result = map.values()
                        .stream()
                        .mapToInt(it -> (int)Math.sin(Math.sqrt(it)))
                        .sum();

        return (n - count) + result;
    }

    private static int graph2(List<String> nodes, int n) {
        int ctrl[] = new int[n];
        
        for (String node : nodes) {
            var v1 = Integer.valueOf(node.split(" ")[0]) - 1;
            var v2 = Integer.valueOf(node.split(" ")[1]) - 1;

            if (ctrl[v1] != 0) {
                ctrl[v1] += 1; 
            } else if (ctrl[v2] != 0) {
                ctrl[v2] += 1;
            } else {
                ctrl[v1] = 1;
                ctrl[v2] = 1;
            }
        }

        int result = 0;
        int single = 0;
        for (int i : ctrl) {
            if (i > 1) {
                result += Math.sqrt(i + 1);
            } else if (i == 1) {
                single++;
            }
        }
        
        result += Math.sqrt(single - (single % 2));
        return result;
    }

    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();

        queue.enqueue("Rafael");
        queue.enqueue("Carol");
        queue.enqueue("Kariny");
        
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        
        // var nGroup = groupBinary(List.of("1100", "1110", "0110", "0001"));
        System.out.println("Group is: " + groupBinary(List.of("1100", "1110", "0110", "0001")));
        System.out.println("Group is: " + groupBinary(List.of("1101", "1110", "0110", "1001")));

        System.out.println("Group0 is: " + groupBinary(List.of("10000", "01111", "01100", "01010", "01001")));
        System.out.println("Group1 is: " + groupBinary(List.of("11000", "11000", "00100", "00011", "00011")));
        System.out.println("Group1 is: " + groupBinary(List.of("10001", "01100", "00101", "00011", "00011")));
        System.out.println("Group2 is: " + groupBinary(List.of("10000", "01000", "00100", "00010", "00001")));
        
        System.out.println("Graph Nodes is: " + graph2(List.of("1 2", "2 5", "2 6", "8 9"), 9));
        System.out.println("Graph Nodes is: " + graph2(List.of("1 2", "2 5", "2 6", "2 7", "8 9"), 9));

        System.out.println("Graph Nodes is: " + graph2(List.of("1 2", "2 3"), 3));
    }
}