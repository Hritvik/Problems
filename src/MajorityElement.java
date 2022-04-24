import java.util.*;

public class MajorityElement {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int majorityElement(final List<Integer> A) {
        Map<Integer, Integer> vf = new HashMap<>();
        for (int v : A) {
            vf.put(v, vf.getOrDefault(v, 0) + 1);
        }
        TreeMap<Integer, List<Integer>> fv = new TreeMap<>();
        for (int v : vf.keySet()) {
            int f = vf.get(v);
            if (fv.containsKey(f)) {
                fv.get(f).add(v);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(v);
                fv.put(f, l);
            }
        }
        int f = fv.lastKey();
        return fv.get(f).get(0);
    }
}
