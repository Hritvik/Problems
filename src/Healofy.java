import java.util.*;

public class Healofy {
    public static void main(String[] args) {
        int[] input = {-1, 2, -1, -1, 5, 5, 20};
        int target = 4;
        int[] res = finder(input, target);
        System.out.println("res = " + Arrays.toString(res));
    }

    private static int[] finder(int[] input, int target) {
        int len = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;

        List<Map<Integer, Integer>> map_list = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            if (i == 1) {
                System.out.println(map_list);
            }
            Map<Integer, Integer> vf = new HashMap<>();
            for (int j = i; j < input.length; j++) {
                if (i == 0) {
                    vf.put(input[j], vf.getOrDefault(input[j], 0) + 1);
                    if (vf.size() == target) {
                        if (len > (j - i)) {
                            len = j - i + 1;
                            a = i;
                            b = j;
                            if (len == target) {
                                return new int[]{a, b};
                            }
                        }
                    }
                    map_list.add(new HashMap<>(vf));
                } else {
                    vf = map_list.get(j);
                    vf.put(input[i - 1], vf.get(input[i - 1]) - 1);
                    if (vf.get(input[i - 1]) == 0) {
                        vf.remove(input[i - 1]);
                    }
                    if (i == 4 && j == 6) {
                        System.out.println("x = " + vf);
                    }
                    if (vf.size() == target) {
                        if (len > (j - i)) {
                            len = j - i + 1;
                            a = i;
                            b = j;
                            if (len == target) {
                                System.out.println("ans = " + vf);
                                return new int[]{a, b};
                            }
                        }
                    }
                }
            }
        }
        return new int[]{a, b};
    }

}
