package com.personal.rackingcode;

public class Arrays {

    public static void main(String[] args) {
        String str = "add";

        System.out.println("isUnique(str) = " + isUnique(str));
        System.out.println("isUnique(str) = " + isUniqueNoAdditionalDS(str));

        System.out.println("isPermutation(\"rafael\") = " + isPermutation("rafael", "arafle"));
    }


    static boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        char[] s1 = str1.toLowerCase().toCharArray();
        char[] s2 = str2.toLowerCase().toCharArray();

        java.util.Arrays.sort(s1);
        java.util.Arrays.sort(s2);

        return java.util.Arrays.equals(s1, s2);
    }

    static boolean isUniqueNoAdditionalDS(String str) {
        char[] array = str.toLowerCase().toCharArray();
        java.util.Arrays.sort(array);

        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) return false;
        }

        return true;
    }

    static boolean isUnique(String str) {
        char[] chars = str.toLowerCase().toCharArray();

        int[] hash = new int[27];
        
        for (char letter : chars) {
            int key = (int) letter - 'a';
            if (hash[key] != 0)
                return false;
            hash[key] = 1;
        }
        
        return true;
    }
}
