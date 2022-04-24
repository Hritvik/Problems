import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2};
        ArrayList<Integer> list = new ArrayList<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        Collections.sort(list);
        System.out.println(list);
    }
}
