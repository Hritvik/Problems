import java.util.*;

public class RemoveCoveredIntervals {
    Set<Integer> drops = null;

    //https://leetcode.com/problems/remove-covered-intervals/
    public static void main(String[] args) {
//        int[][] intervals = {{1, 4}, {3, 6}, {2, 8}};
        int[][] intervals = {{1, 4}, {2, 3}};

        System.out.println(new RemoveCoveredIntervals().removeCoveredIntervals(intervals));
    }

    public int removeCoveredIntervals(int[][] intervals) {
        drops = new HashSet<Integer>();
        List<Map<Integer, List<Integer>>> line = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            insert(line, interval, i);
        }
        line = new ArrayList<>();
        for (int i = intervals.length - 1; i >= 0; i--) {
            int[] interval = intervals[i];
            insert(line, interval, i);
        }
        System.out.println("drops = " + drops);
        return intervals.length - drops.size();
    }

    private void insert(List<Map<Integer, List<Integer>>> line, int[] interval, int i) {
        System.out.println("Inserting interval " + Arrays.toString(interval) + " to line " + line);
        int s = interval[0];
        int e = interval[1];
        int index_s = search(line, s);
        int start = 0;
        // add s to the line //////////////
        if (index_s == -1) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            list.add(i);
            map.put(s, list);
            line.add(0, map);
        } else {
            int curr_s = line.get(index_s).keySet().iterator().next();
            if (curr_s == s) {
                line.get(index_s).values().iterator().next().add(i);
                start = index_s;
            } else {
                Map<Integer, List<Integer>> map = new HashMap<>();
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(s, list);
                line.add(index_s + 1, map);
                start = index_s + 1;
            }
        }
        System.out.println("Line updated with s to " + line);
        //////////////////////////////////
        Set<Integer> idSet = new HashSet<>();
        boolean endAdded = false;
        for (int j = start; j < line.size(); j++) {
            Map<Integer, List<Integer>> map = line.get(j);
            int curr = map.keySet().iterator().next();
            List<Integer> idList = map.get(curr);
            if (curr < e) {
                for (int id : idList) {
                    if (idSet.contains(id)) {
                        drops.add(id);
                    } else {
                        idSet.add(id);
                    }
                }
            } else {
                if (curr == e) {
                    for (int id : idList) {
                        if (idSet.contains(id)) {
                            drops.add(id);
                        } else {
                            idSet.add(id);
                        }
                    }
                    //add e to line
                    line.get(j).values().iterator().next().add(i);
                    System.out.println("Line updated1 with e to " + line);
                } else {
                    //add e to line
                    Map<Integer, List<Integer>> m = new HashMap<>();
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    m.put(e, list);
                    line.add(j, m);
                    endAdded = true;
                    System.out.println("Line updated2 with e to " + line);
                }
                break;
            }
        }
        if (!endAdded) {
            Map<Integer, List<Integer>> m = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            list.add(i);
            m.put(e, list);
            line.add(m);
            System.out.println("Line updated3 with e to " + line);
        }

    }

    private int search(List<Map<Integer, List<Integer>>> line, int target) {
        System.out.println("Searching for target " + target + " in line " + line);

        if (line.size() == 0) {
            System.out.println("Searched1 for target " + target + " :: Found -1");
            return -1;
        }
        int start = 0;
        int end = line.size() - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            int curr = line.get(mid).keySet().iterator().next();
//            System.out.println(start + "-" + end + " :: " + curr);
            if (curr == target) {
                System.out.println("Searched2 for target " + target + " :: Found " + mid);
                return mid;
            } else if (curr > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        int curr = line.get(start).keySet().iterator().next();
//        System.out.println("=" + start + "-" + end + " :: " + curr);
        if (curr < target) {
            System.out.println("Searched3 for target " + target + " :: Found " + (start+1));
            return start;
        }else if (curr == target) {
            System.out.println("Searched3 for target " + target + " :: Found " + start);
            return start;
        } else {
            System.out.println("Searched4 for target " + target + " :: Found " + (start));
            return start - 1;
        }

    }
}
