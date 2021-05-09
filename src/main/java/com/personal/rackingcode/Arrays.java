package com.personal.rackingcode;

import java.util.*;

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

        System.out.println("isOneStringEdit(\"pale\", \"ple\") = " + isOneStringEdit("pale", "ple"));
        System.out.println("isOneStringEdit(\"pale\", \"bake\") = " + isOneStringEdit("pale", "bake"));
        System.out.println("isOneStringEdit(\"pales\", \"pale\") = " + isOneStringEdit("pales", "pale"));
        System.out.println("isOneStringEdit(\"pale\", \"pale\") = " + isOneStringEdit("pale", "pale"));
        System.out.println("isOneStringEdit(\"pale\", \"bale\") = " + isOneStringEdit("pale", "bale"));
        System.out.println("isOneStringEdit(\"pae\", \"pale\") = " + isOneStringEdit("pae", "pale"));

        stringCompression("aaaabcccddef");
        stringCompression("a");
        stringCompression("aabbcdfgghhkuitrAaAAaaaaaaaaaaaaaaaaaa");
        stringCompression("");

        compressionWithOneLetter("aaaabcccddef");
        compressionWithOneLetter("a");
        compressionWithOneLetter("aabbcdfgghhkuitrAaAAaaaaaaaaaaaaaaaaaa");
        compressionWithOneLetter("qwertyuioasdfghjkl");
        compressionWithOneLetter("");

        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printMatrix(matrix);
        rotateMatrixConstantSpaceComplexity(matrix);
        printMatrix(matrix);

        int[][] matrix2 = {{1,2,3},{5,6,7},{9,10,11}};
        printMatrix(matrix2);
        int[][] rotateMatrix2 = rotateMatrix(matrix2);
        printMatrix(rotateMatrix2);

        int[][] matrix3 = {{1,2,3},{5,6,7},{9,10,11}};
        printMatrix(matrix3);
        rotateMatrixConstantSpaceComplexity(matrix3);
        printMatrix(matrix3);

        List<List<Integer>> array2Dimension = new ArrayList<>();
        array2Dimension.add(List.of(1,1,1,0,0,0));
        array2Dimension.add(List.of(0,1,0,0,0,0));
        array2Dimension.add(List.of(1,1,1,0,0,0));
        array2Dimension.add(List.of(0,0,2,4,4,0));
        array2Dimension.add(List.of(0,0,0,2,0,0));
        array2Dimension.add(List.of(0,0,1,2,4,0));

        System.out.println("hourglassSum(array2Dimension) = " + hourglassSum(array2Dimension));

        List<Integer> baseValues = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> input = new ArrayList<>(baseValues);
        int shiftOf = 3;
        arrayLeftRotation(input, shiftOf);
        arrayLeftRotation_constantSpace(input, shiftOf);
    }

    //4 2
    //{1 - 2 - 3 - 4} -> {2 - 3 - 4 - 1}
    //{1 - 2 - 3 - 4} -> {3 - 4 - 1 - 2}
    public static List<Integer> arrayLeftRotation_constantSpace(List<Integer> a, int d) {
        System.out.print("arrayLeftRotation_constantSpace of " + a);

        while (d > 0) {
            int head = a.remove(0);
            a.add(head);
            d--;
        }
        System.out.print(" is " + a + "\n");

        return a;
    }

    public static List<Integer> arrayLeftRotation(List<Integer> a, int d) {
        System.out.print("arrayLeftRotation of " + a);

        java.util.LinkedList<Integer> result = new java.util.LinkedList<>(a);

        for (int i = 0; i < d; i++) {
            int v = result.remove();
            result.addLast(v);
        }

        System.out.print(" is " + result + "\n");
        return result;
    }

    /*
    *   1 1 1 0 0 0
    *   0 1 0 0 0 0
    *   1 1 1 0 0 0
    *   0 0 2 4 4 0
    *   0 0 0 2 0 0
    *   0 0 1 2 4 0
    *
    *  Time complexity O(n/2 * m/2) - Space complexity of O(1)
    * */
    static int hourglassSum(List<List<Integer>> arr) {
        int sum = Integer.MIN_VALUE;

        for (int row = 0; row <= arr.size() / 2; row++) {
            for (int column = 0; column <= arr.get(row).size() / 2; column++) {
                int top = arr.get(row).get(column) + arr.get(row).get(column + 1) + arr.get(row).get(column + 2);
                int mid = arr.get(row + 1).get(column + 1);
                int bottom = arr.get(row + 2).get(column) + arr.get(row + 2).get(column + 1) + arr.get(row + 2).get(column + 2);

                if (sum < (top + mid + bottom)) sum = top + mid + bottom;
            }
        }

        return sum;
    }


    static void printMatrix(int[][] matrix) {
        System.out.println("\nMatrix is:");
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print("\t" + anInt + "\t");
            }

            System.out.println();
        }
    }

    static void rotateMatrixConstantSpaceComplexity(int[][] matrix) {
        int n = matrix.length;

        for (int row = 0; row < n/2; row++) {
            int last = n - 1 - row;

            for (int collumn = row; collumn < last; collumn++) {
                int offset = collumn - row;

                int top = matrix[row][collumn];

                //left -> top
                matrix[row][collumn] = matrix[last - offset][row];

                //bottom -> left
                matrix[last - offset][row] = matrix[last][last - offset];

                //right -> bottom
                matrix[last][last - offset] = matrix[collumn][last];

                //top -> right
                matrix[collumn][last] = top;
            }
        }
    }

    static int[][] rotateMatrix(int[][] matrix) {
        int[][] rt = new int[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                rt[col][rt.length -1 - row] = matrix[row][col];
            }
        }

        return rt;
    }

    static String compressionWithOneLetter(String input) {
        System.out.print("2 - Compress from " + input);

        if (input.isEmpty()) return input;

        int count = 0;
        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            count++;

            if (i + 1 >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
                buffer.append(input.charAt(i));
                buffer.append(count);
                count = 0;
            }
        }

        String result = buffer.length() < input.length() ? buffer.toString() : input;
        System.out.println(" to " + result);

        return result;

    }

    //aaaabcccdde - a4bc3d2e - O(size of input string)
    static String stringCompression(String input) {
        System.out.print("1 - Compress from " + input);

        if (input.isEmpty()) return input;

        StringBuilder result = new StringBuilder();

        char[] chars = input.toCharArray();
        int count = 1, p1 = 0, p2 = 1;

        while (p2 < chars.length) {
            if (chars[p1] != chars[p2] && count > 1) {
                result.append(chars[p1]);
                result.append(count);
                count = 0;
            } else if (chars[p1] != chars[p2] && count == 1) {
                result.append(chars[p1]);
                count = 0;
            }

            count++;
            p1 = p2;
            p2++;
        }

        result.append(chars[p1]);

        if (count > 1) {
            result.append(count);
        }

        if (result.length() == 0) return input;

        String compressResult = result.length() < input.length() ? result.toString() : input;
        System.out.println(" to " + compressResult);

        return compressResult;
    }

    //O(size of delta string)
    static boolean isOneStringEdit(String base, String delta) {
        int lengthDif = Math.abs(base.length() - delta.length());

        if (lengthDif > 1) return false;

        int maxDif = 1;

        char[] bases = base.toCharArray();
        char[] deltas = delta.toCharArray();

        int i = 0, j = 0;
        while (i < deltas.length && j < bases.length && maxDif != -1) {
            if (deltas[i] != bases[j]) {
                maxDif--;
                j++;

                if (lengthDif == 0) i++;
                continue;
            }

            i++;
            j++;
        }

        return maxDif != -1;
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

        System.out.println();
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
