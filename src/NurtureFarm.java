import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NurtureFarm {

    public static int splitIntervals(List<List<Integer>> intervals, int K) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (List<Integer> interval : intervals) {
            int start = interval.get(0);
            int end = interval.get(1);
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
        }
        System.out.println("map = " + map);
        int prev = -1;
        int f = 0;

        List<Element> elements = new ArrayList<>();
        for (int index : map.keySet()) {
            if (map.get(index) != 0) {
                if (prev != -1) {
                    Element e = new Element(index - prev, f, prev, index);
                    elements.add(e);
                }
                prev = index;
            }
            if (map.get(index) > 0) {
                f += map.get(index);
            } else if (map.get(index) < 0) {
                f -= map.get(index);
            }
        }
        System.out.println("elements = " + elements);
        int index = 0;
        for (Element e : elements) {
            if (index + e.size*e.f < K) {
                index += e.size*e.f;
            } else if (index + e.size*e.f > K) {
                return e.start + (K - index)/e.f + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<List<Integer>> l = new ArrayList<>();
        int[][] arrs = {{5, 11}, {10, 15}, {12, 20}};
        for (int[] arr : arrs) {
            List<Integer> li = new ArrayList<>();
            for (int a : arr) {
                li.add(a);
            }
            l.add(li);
        }
        System.out.println("input = " + l);
        int K = 12;
        int result = splitIntervals(l, K);
        System.out.println("result = " + result);
    }

    static class Element {
        int size;
        int f;
        int start;
        int end;

        Element(int size, int f, int start, int end) {
            this.size = size;
            this.f = f;
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "(" + start + "," + end + ") : " + f + " ";
        }
    }
}