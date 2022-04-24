package leetCode;

import java.util.TreeSet;

public class NextPermutation {
//https://leetcode.com/problems/next-permutation/
public void nextPermutation(int[] nums) {
    TreeSet<Integer> ts = new TreeSet<>();
    int prev = nums[nums.length - 1];
    boolean flag = false;
    for(int i = nums.length - 2; i >= 0; i--){
        int curr = nums[i];
        if(curr < prev){
            flag = true;
            final int c = curr;
            int next = ts.stream().filter(a -> a>c).min(Integer::compare).orElse(curr);
            if(next != curr){
                ts.remove(next);
                ts.add(curr);
            }
            nums[i] = next;
            int j = i+1;
            for(int a : ts){
                nums[j++] = a;
            }
        }else{
            ts.add(curr);
        }
        prev = curr;
    }
    if(!flag){
        nums = ts.stream().mapToInt(Number::intValue).toArray();
    }
}
}
