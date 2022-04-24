package array;

import java.util.LinkedList;
import java.util.Queue;

public class RotateArray_Solved {
    //https://leetcode.com/problems/rotate-array/

    public void rotate(int[] nums, int k) {
        Queue<Integer> q = new LinkedList<>();
        k %= nums.length;
        if (k == nums.length) {
            return;
        }
        for (int i = 0; i < k; i++) {
            q.add(nums[i]);
        }
        int i = k;
        int len = nums.length;
        while (len-- > 0) {
            q.add(nums[i]);
            nums[i] = q.poll();
            i = (i + 1) % nums.length;
        }
    }
}

