package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sum3 {
	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		System.out.println(Arrays.toString(nums));
		System.out.println(new Sum3().threeSum(nums));
	}

	public List<List<Integer>> threeSum(int[] nums) {
		Set<String> hash = new HashSet<>();
		List<List<Integer>> output = new ArrayList<>();
		List<Integer> set = new ArrayList<>();
		recursive(nums, 0, output, 0, set, 0, hash, "");
		return output;
	}

	public void recursive(int[] nums, int index, List<List<Integer>> output, int sum, List<Integer> set, int count,
			Set<String> hash, String indent) {

		if (index < nums.length) {
			int num = nums[index];
			System.out.println(indent + index + " :: " + num + " :: " + set + " :: " + count);
			if (count == 0) {
				List<Integer> set1 = new ArrayList<>();
				set1.addAll(set);
				set1.add(num);
				List<Integer> set2 = new ArrayList<>();
				set2.addAll(set);
				recursive(nums, index + 1, output, sum + num, set1, count + 1, hash, "   " + indent);
				recursive(nums, index + 1, output, sum, set2, count, hash, indent);

			} else if (count == 1) {
				List<Integer> set1 = new ArrayList<>();
				set1.addAll(set);
				set1.add(num);
				List<Integer> set2 = new ArrayList<>();
				set2.addAll(set);
				String key = set1.get(0) + "#" + set1.get(1);
				if (!hash.contains(key)) {
					recursive(nums, index + 1, output, sum + num, set1, count + 1, hash, "   " + indent);
					recursive(nums, index + 1, output, sum, set2, count, hash, indent);
				} else {
					recursive(nums, index + 1, output, sum, set2, count, hash, indent);
					System.out.println(indent + index + " :: " + key + " :: already exists");
				}
			} else if (count == 2) {
				if (sum + num == 0) {
					List<Integer> set1 = new ArrayList<>();
					set1.addAll(set);
					set1.add(num);
					System.out.println(indent + " :: " + set1 + " :: inserted");
					output.add(set1);
					hash.add(set1.get(0) + "#" + set1.get(1));
					hash.add(set1.get(1) + "#" + set1.get(0));
					hash.add(set1.get(0) + "#" + set1.get(2));
					hash.add(set1.get(2) + "#" + set1.get(0));
					hash.add(set1.get(2) + "#" + set1.get(1));
					hash.add(set1.get(1) + "#" + set1.get(2));
				} else {
					List<Integer> set2 = new ArrayList<>();
					set2.addAll(set);
					recursive(nums, index + 1, output, sum, set2, count, hash, indent);
				}
			}
		} else {
			System.out.println(indent + index + " :: " + set);
		}
	}
}