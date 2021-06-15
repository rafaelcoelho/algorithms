package com.personal.leetcode.array;

public class MissingPositive {
    public static void main(String[] args) {
        System.out.println("Missing value is: " + firstMissingPositive(new int[]{2147483647}));
    }

    public static int firstMissingPositive(int[] nums) {
        long max = 0L;
        java.util.HashSet<Integer> set = new java.util.HashSet<>(nums.length);

        for (int v : nums) {
            if (v > max) max = v;
            set.add(v);
        }

        for (int i = 1; i <= max + 1; i++) {
            if (!set.contains(i)) return i;
        }

        return -1;
    }
}
