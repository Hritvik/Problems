package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PairsOfSongsWithTotalDurationsDivisibleby60 {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        int count = 0;
        for (int i = 0; i < time.length; i++) {
            int num = time[i] % 60;
            if (map.containsKey(num)) {
                map.get(num).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(num, list);
            }
        }
        for (int i = 0; i <= 30; i++) {
            if (map.containsKey(i) && map.containsKey(60 - i)) {
                if (i == 0 || i == 30) {
                    count += fact(map.get(i).size()) / (fact(2) * fact(map.get(i).size() - 2));
                } else {
                    count += map.get(i).size() * map.get(60 - i).size();
                }
            }
        }

        return count;
    }

    int fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

}
