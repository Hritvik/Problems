package leetCode;

import java.util.Arrays;
import java.util.LinkedList;

public class ZeroOne_Matrix {
    public int[][] updateMatrix(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        boolean[][] vis = new boolean[mat.length][mat[0].length];

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = 1000000;
            }
        }
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                if (mat[i][j] == 0) {
                    LinkedList<int[]> q = new LinkedList<>();
                    q.stream().forEach(a->System.out.print(Arrays.toString(a)+" "));
                    System.out.println();
                    q.addFirst(new int[]{i, j});
                    int value = 0;

                    while (!q.isEmpty()) {
                        int[] item = q.pollLast();
                        int x = item[0];
                        int y = item[1];
                        res[x][y] = value;
                        x = i - 1;
                        y = j;
                        if (x >= 0 && y >= 0 && x <= res.length && y <= res[x].length && res[x][y] > (value + 1)) {
                            q.addFirst(new int[]{x, y});
                        }
                        x = i + 1;
                        y = j;
                        if (x >= 0 && y >= 0 && x <= res.length && y <= res[x].length && res[x][y] > (value + 1)) {
                            q.addFirst(new int[]{x, y});
                        }
                        x = i;
                        y = j + 1;
                        if (x >= 0 && y >= 0 && x <= res.length && y <= res[x].length && res[x][y] > (value + 1)) {
                            q.addFirst(new int[]{x, y});
                        }
                        x = i;
                        y = j - 1;
                        if (x >= 0 && y >= 0 && x <= res.length && y <= res[x].length && res[x][y] > (value + 1)) {
                            q.addFirst(new int[]{x, y});
                        }
                        for (int p = 0; p < res.length; p++) {
                            for (int r = 0; r < res[i].length; r++) {
                                System.out.println(res[p][r]);
                            }
                        }
                        value++;
                    }
                }
            }
        }
        return res;
    }

}
