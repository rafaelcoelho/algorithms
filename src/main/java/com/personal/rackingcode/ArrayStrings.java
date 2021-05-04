package com.personal.rackingcode;

public class ArrayStrings {
    public static void main(String[] args) {
        System.out.println("pale, ple - " + oneEditAway("pale", "ple"));
        System.out.println("paled, pale - " + oneEditAway("pales", "pale"));
        System.out.println("pale, ale - " + oneEditAway("pale", "ale"));
        System.out.println("paled, bae - " + oneEditAway("pales", "bae"));

        System.out.println("aabcccccaaa: " + compressString("aabcccccaaa"));
        System.out.println("abccaasdfghjkl: " + compressString("abccaasdfghjkl"));
    }

    private static String compressString(String str) { 
        StringBuilder compressed = new StringBuilder();

        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            
            counter++;
            if(((i + 1) == str.length()) || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(counter);
                counter = 0;
            }
        }

        return compressed.length() < str.length() ? compressed.toString() : str;
    }
    
    private static boolean oneEditAway(String p1,String p2) {

        if (p1.length() == p2.length()) {
            return oneEditReplacement(p1, p2);
        } else if (p1.length() -1 == p2.length()) {
            return oneEditInsert(p1, p2);
        } else if (p1.length() + 1 == p2.length()) {
            return oneEditInsert(p1, p2);
        }
        
        return false;
    }

    private static boolean oneEditInsert(String p1, String p2) {
        int p1Index = 0;
        int p2Index = 0;

        while (p1.length() > p1Index && p2.length() > p2Index) {
            if (p1.charAt(p1Index) != p2.charAt(p2Index)) {
                if (p1Index != p2Index) {
                    return false;
                }

                p1Index++;
            } else {
                p1Index++;
                p2Index++;
            }
        }

        return true;
    }

    private static boolean oneEditReplacement(String p1, String p2) {
        boolean foundDifference = false;

        for (int i = 0; i < p1.length(); i++) {
            if (p1.charAt(i) != p2.charAt(i)) {
                if (foundDifference)
                    return false;

                foundDifference = true;
            }
        }

        return true;
    }
}
