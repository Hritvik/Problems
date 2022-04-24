import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayOfWeek {
    public static void main(String[] args) {
        System.out.println(abc(4, 2022));
    }

    private static Map<Integer, List<Integer>> abc(int month, int year) {
        LocalDate date = LocalDate.of(year, month, 1);
        int len = date.getMonth().length(false);
        System.out.println("len = " + len);
        int dayOfWeek = date.getDayOfWeek().getValue();// Monday = 1
        System.out.println("dayOfWeek = " + dayOfWeek);
        Map<Integer, List<Integer>> res = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int day = i + dayOfWeek;
            int q = day / 7;
            if (res.containsKey(q)) {
                res.get(q).add(day-dayOfWeek+1);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(day-dayOfWeek+1);
                res.put(q, l);
            }
        }
        return res;
    }
}
