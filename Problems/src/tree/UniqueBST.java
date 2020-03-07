package tree;

public class UniqueBST {
	public static void main(String[] args) {
		System.out.println(numTrees(8));// 1430
//		System.out.println(numTrees(4));// 14
//		System.out.println(numTrees(3));// 5
	}

	static int numTrees(int n) {
		int diffMemory[] = new int[n];
		for (int j = 0; j < diffMemory.length; j++) {
			diffMemory[j] = -1;
		}

		return recursive(1, n, diffMemory);
	}

	static int recursive(int start, int end, int[] diffMemory) {
		if (start > end) {
			return 1;
		} else {
			if (diffMemory[end - start] != -1) {
//				System.out.println(start + " :: " + end + " :::: " + diffMemory[end - start]);
				return diffMemory[end - start];
			} else {
				if (start == end) {
					diffMemory[end - start] = 1;
//					System.out.println(start + " :: " + end + " :::: " + 1);
					return 1;
				} else if (start + 1 == end) {
					diffMemory[end - start] = 2;
//					System.out.println(start + " :: " + end + " :::: " + 2);
					return 2;
				} else {
					int count = 0;
					for (int i = start; i <= end; i++) {
						int a = recursive(start, i - 1, diffMemory);
						int b = recursive(i + 1, end, diffMemory);
//						System.out.println("a [" + start + " :: " + (i - 1) + "] = " + a);
//						System.out.println("b [" + (i + 1) + " :: " + end + "] = " + b);
//						System.out.println("count [" + start + " :: " + end + "] = " + a * b);
						count += a * b;
					}
					diffMemory[end - start] = count;
//					System.out.println(start + " :: " + end + " :::: " + count);
					return count;
				}

			}

		}
	}

}
