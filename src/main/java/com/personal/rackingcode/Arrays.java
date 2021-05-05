package com.personal.rackingcode;

import java.util.HashMap;
import java.util.Map;

public class Arrays {

    public static void main(String[] args) {
        String str = "add";

        System.out.println("isUnique(str) = " + isUnique(str));
        System.out.println("isUnique(str) = " + isUniqueNoAdditionalDS(str));

        System.out.println("isPermutation(\"rafael\") = " + isPermutation("rafael", "arafle"));

        urlIfy("Mr John Smith    ".toCharArray(), 13);

        System.out.println("isPalindrome(\"arara\") = " + isPalindrome("arara"));
        System.out.println("isPalindrome(\"\") = " + isPalindrome(""));
        System.out.println("isPalindrome(\"araraa\") = " + isPalindrome("araraa"));
        System.out.println("isPalindrome(\"ovo\") = " + isPalindrome("ovo"));
        System.out.println("isPalindrome(\"car\") = " + isPalindrome("car"));
        System.out.println("isPalindrome(\"reter\") = " + isPalindrome("reter"));
        System.out.println("isPalindrome(\"tact coa\") = " + isPalindrome("tact coa"));
        System.out.println("isPalindrome(\"aNa   \") = " + isPalindrome("aNa   "));
    }

    //"Mr John Smith    "
    //"Mr%20John%20Smith "
    static void urlIfy(char[] str, int realSize) {
        int cur = realSize - 1;
        int index = str.length - 1;

        System.out.print("\nThe string " + new String(str) + " urlfy is ");

        while (index >= 0) {
            if (str[cur] ==  ' ') {
                str[index--] = '0';
                str[index--] = '2';
                str[index--] = '%';
                cur--;
            } else {
                str[index--] = str[cur--];
            }
        }

        for (char s : str) {
            System.out.print(s);
        }

        System.out.println("");
    }

    // ARARA - OVO - reter - tact coa
    static boolean isPalindrome(String str) {
        Map<Character, Integer> hash = new HashMap<>();

        String clearStr = str.toLowerCase().replace(" ", "");

        //O(n) where n is the size of input string
        for (char s : clearStr.toCharArray()) {
            if (hash.containsKey(s)) {
                var v = hash.get(s);
                v++;
                hash.put(s, v);
            } else {
                hash.put(s, 1);
            }
        }

        //O(letters) number of different letter from input string
        return hash.values()
                .stream()
                .filter(v -> v % 2 != 0)
                .count() == 1;
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
