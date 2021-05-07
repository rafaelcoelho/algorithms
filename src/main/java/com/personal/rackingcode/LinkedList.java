package com.personal.rackingcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LinkedList {

    public static void main(String[] args) {
        System.out.println("4,5,5,6,7,8,8,7,6,6 is " + removeDuplicated_constantSpaceComplexity(new java.util.LinkedList<>(java.util.Arrays.asList(4,5,5,6,7,8,8,7,6,6))));
        System.out.println("4,5,5,6,7,8,8,7,6,6 is " + removeDuplicated_hashTable(new java.util.LinkedList<>(java.util.Arrays.asList(4,5,5,6,7,8,8,7,6,6))));
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
}
