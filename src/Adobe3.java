//public class Adobe3 {
//}
//import java.io.*;
//        import java.util.*;
//
///*
// * To execute Java, please define "static void main" on a class
// * named Solution.
// *
// * If you need more classes, simply define them inline.
// */
////  {0,0,1,1},
////  {1,0,1,1},
////  {0,1,1,1}
//
//
//
//// {{0,0,1,1}
//// {0,0,0,1},
//// {0,1,1,1}};
//class Solution {
//    public static void main(String[] args) {
//        int[][] arr= {{0,0,1,1}, {0,0,0,1}, {1,1,1,1}};
//        System.out.println(search(arr));
//    }
//
//    private static int search(int[][] arr){
//        int min = Integer.MAX_VALUE;
//        int end = arr[0].length;
//        for(int i = 0; i < arr.length; i++){
//            int index = binarySearch(arr[i], 0, end);
//            if(index != -1){
//                min = index;
//                end = min;
//            }else{
//                min = 0;
//                break;
//            }
//        }
//        return (min!=Integer.MAX_VALUE)?(arr[0].length - min):0;
//    }
//
//    private static int binarySearch(int[] arr, int start, int end){
//        while(start < end){
//            int mid = (start + end)/2;
//            int mid1 = mid +1;
//            if(arr[mid] == 0 && arr[mid1] == 0){
//                start = mid1;
//            }else if(arr[mid] == 0 && arr[mid1] == 1){
//                return mid1;
//            } if(arr[mid] == 1 && arr[mid1] == 1){
//                end = mid;
//            }
//        }
//        if(arr[start] == 0 && start+1 < arr.length && arr[start+1] == 1){
//            return start;
//        }else{
//            return -1;
//        }
//    }
//
//
//
//    private static int island(int[][] arr){
//        // Map<String, Integer> map = new HashMap<>();
//        int max = 0;
//        int[][] visited = new int[arr.length][arr[0].length];
//        for(int i = 0 ; i< arr.length; i++){
//            for(int j = 0; j<arr[i].length; j++){
//                if(arr[i][j] == 1 && visited[i][j] == 0){
//                    System.out.println("start = "+i+", "+j);
//                    Set<int[]> set = new HashSet<>();
//                    dfs(arr, i, j, visited, set);
//                    // map.put(i+"#"+j, set.size());
//                    System.out.print("island = ");
//                    set.stream().forEach(a -> {
//                        System.out.print(Arrays.toString(a) + " ");
//                    });
//                    System.out.println();
//                    max = Math.max(max, set.size());
//                }
//            }
//        }
//        return max;
//    }
//    private static void dfs(int[][] arr, int i, int j, int[][] visited, Set<int[]> set){
//        visited[i][j] = 1;
//        set.add(new int[]{i, j});
//
//        int x = i;
//        int y = j;
//
//        x = i - 1;
//        y = j;
//        if(x >= 0 && y >= 0 && x < arr.length && y < arr[x].length && arr[x][y] == 1 && visited[x][y] == 0){
//            dfs(arr, x, y, visited, set);
//        }
//        x = i + 1;
//        y = j;
//        if(x >= 0 && y >= 0 && x < arr.length && y < arr[x].length && arr[x][y] == 1 &&  visited[x][y] == 0){
//            dfs(arr, x, y, visited, set);
//        }
//        x = i;
//        y = j - 1;
//        if(x >= 0 && y >= 0 && x < arr.length && y < arr[x].length && arr[x][y] == 1 &&  visited[x][y] == 0){
//            dfs(arr, x, y, visited, set);
//        }
//        x = i;
//        y = j + 1;
//        if(x >= 0 && y >= 0 && x < arr.length && y < arr[x].length && arr[x][y] == 1 &&  visited[x][y] == 0){
//            dfs(arr, x, y, visited, set);
//        }
//    }
//}
//
//
//
//// Your Previous  code is preserved below:
//// const _ = require('lodash');
//
//// function helloWorld() {
////   console.log('Hello, World');
//// }
//
//// _.times(5, helloWorld);