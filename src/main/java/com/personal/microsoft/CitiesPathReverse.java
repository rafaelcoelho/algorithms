package com.personal.microsoft;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    /*
     * Complete the 'countReverseEdges' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts UNWEIGHTED_INTEGER_GRAPH g as parameter.
     */

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i].
     *
     */

    public static List<Integer> countReverseEdges(int gNodes, List<Integer> gFrom, List<Integer> gTo) {

        List<List<int[]>> cities = new ArrayList<>(gNodes);

        for (int i = 0; i < gNodes; i++) {
            cities.add(new ArrayList<>());
        }

        for (int index = 0; index < gFrom.size(); index++) {
            int from = gFrom.get(index);
            int to = gTo.get(index);

//            if (from < 0 || from >= gNodes || to < 0 || to >= gNodes) continue;

            cities.get(from - 1).add(new int[]{to - 1, 0});
            cities.get(to - 1).add(new int[]{from - 1, 1});
        }

        int[] result = new int[gNodes];
        boolean[] checked = new boolean[gNodes];

        result[0] = reverse(0, cities, checked);

        Arrays.fill(checked, false);
        value(0, cities, checked, result);

        List<Integer> finalResult = new ArrayList<>();
        for (int x : result) finalResult.add(x);

        return finalResult;
    }

    private static void value(int n, List<List<int[]>> cities, boolean[] checked, int[] result) {
        checked[n] = true;

        for (int[] edge : cities.get(n)) {
            int next = edge[0];
            int cost = edge[1];

            if (!checked[next]) {
                result[next] = result[n] + (cost == 0 ? 1 : -1);
                value(next, cities, checked, result);
            }
        }
    }

    private static int reverse(int n, List<List<int[]>> cities, boolean[] checked) {
        checked[n] = true;
        int reverse = 0;

        for (int[] edge : cities.get(n)) {
            int next = edge[0];
            int cost = edge[1];

            if (!checked[next]) {
                reverse += cost + reverse(next, cities, checked);
            }
        }

        return reverse;
    }
}

public class CitiesPathReverse {
    public static void main(String[] args) throws IOException {


//        List<Integer> gFrom = List.of(1, 2, 3, 4);
//        List<Integer> gTo = List.of(2, 3, 4, 5);

        List<Integer> gFrom = List.of(1, 2, 3);
        List<Integer> gTo = List.of(4, 4, 4);

//        List<Integer> gFrom = List.of(2, 2, 3, 4, 5);
//        List<Integer> gTo = List.of(1, 3, 4, 5, 1);

        List<Integer> result = Solution.countReverseEdges(gFrom.size() + 1, gFrom, gTo);

        result.forEach(System.out::println);
    }
}

//4 3
//1 2
//2 3
//3 4
//
//0 1 2 3