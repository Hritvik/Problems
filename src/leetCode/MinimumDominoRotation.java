package leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MinimumDominoRotation {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        Map<Integer, Integer> kf = new HashMap<>();
        TreeMap<Integer, LinkedList<Integer>> fk = new TreeMap<>();
        for (int i = 0; i < tops.length; i++) {
            int t = tops[i];
            int b = bottoms[i];
            kf.put(t, 1 + kf.getOrDefault(t, 0));
            kf.put(b, 1 + kf.getOrDefault(b, 0));
        }
        for (int k : kf.keySet()) {
            int f = kf.get(k);
            if (fk.containsKey(f)) {
                fk.get(f).addFirst(k);
            } else {
                LinkedList<Integer> stack = new LinkedList<>();
                stack.addFirst(k);
                fk.put(f, stack);
            }
        }
        System.out.println(kf);
        System.out.println(fk);
        fk = new TreeMap<>(fk.entrySet().stream().filter(a -> {
            return a.getKey() >= tops.length;
        }).collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue())));
        System.out.println(fk);

        int hf = fk.lastKey();
        if (hf >= tops.length) {
            return fk.get(hf).pollFirst();
        } else {
            return -1;
        }
    }
}