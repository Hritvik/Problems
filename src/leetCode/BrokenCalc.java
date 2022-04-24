package leetCode;
public class BrokenCalc {
    static int min;
    //https://leetcode.com/problems/broken-calculator/
    public static void main(String[] args) {
        min = Integer.MAX_VALUE;
        new BrokenCalc().brokenCalc(5, 8, 0);
        System.out.println(min);
        min = Integer.MAX_VALUE;
        new BrokenCalc().brokenCalc(3, 10, 0);
        System.out.println(min);
        min = Integer.MAX_VALUE;
        new BrokenCalc().brokenCalc(2, 3, 0);
        System.out.println(min);
        min = Integer.MAX_VALUE;
        new BrokenCalc().brokenCalc(1000, 100000, 0);
        System.out.println(min);

    }

    public int brokenCalc(int startValue, int target, int moves) {
        System.out.println(startValue + " :: " + target);
        if(moves > min){
            return Integer.MAX_VALUE;
        }
        if (startValue == target) {
            min = Math.min(min, moves);
            return 0;
        } else {
            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;
            if (startValue * 2 < target * 1.1) {
//                System.out.println("time 2");
                a = brokenCalc(startValue * 2, target, moves+1);
            }
            if (startValue - 1 >= target / 1.1) {
//                System.out.println("minus 1");
                b = brokenCalc(startValue - 1, target, moves+1);
            }
            return Math.min(a, b);
        }
    }

}
