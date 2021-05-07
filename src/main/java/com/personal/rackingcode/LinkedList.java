package com.personal.rackingcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LinkedList {

    public static void main(String[] args) {
        System.out.println("4,5,5,6,7,8,8,7,6,6 is " + removeDuplicated_hashTable(new ArrayList<>(java.util.Arrays.asList(4,5,5,6,7,8,8,7,6,6))));
    }

    //O(n) of time complexity and O(n of different values) space complexity
    static List<Integer> removeDuplicated_hashTable(List<Integer> in) {
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

}
