package array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ContainsDuplicates3 {
    //https://leetcode.com/problems/contains-duplicate-iii/

    PriorityQueue<Integer> q;
    int[] arr;
    int i;

    public static void main(String[] args) {
        int[] nums = {1, 5, 9, 1, 5, 9};
        int k = 2;
        int t = 3;
        System.out.println(new ContainsDuplicates3().containsNearbyAlmostDuplicate(nums, k, t));
        System.out.println(new ContainsDuplicates3().containsNearbyAlmostDuplicateOld(nums, k, t));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        arr = nums;
        q = new PriorityQueue<>(k, new MyComp());
        for (i = 0; i < arr.length; i++) {
            q.add(i);
            if (i > k) {
                q.remove(i - k);
            }
            if (q.peek() <= t) {
                return true;
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicateOld(int[] nums, int k, int t) {
        for (i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < Math.min(i + k + 1, nums.length); j++) {
                if (Math.abs((long) nums[i] - (long) nums[j]) <= (long) t) {
                    return true;
                }
            }
        }
        return false;
    }

    class MyComp implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return (int) Math.abs((long) arr[a] - (long) arr[i]) - (int) Math.abs((long) arr[b] - (long) arr[i]);
        }
    }
}
