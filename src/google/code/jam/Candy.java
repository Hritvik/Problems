package google.code.jam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Candy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());
        while (T-- > 0) {
            String[] inputs = br.readLine().split(" ");
            int N = Integer.valueOf(inputs[0]);
            int M = Integer.valueOf(inputs[1]);
            String[] candies = br.readLine().split(" ");
            Integer total = Arrays.stream(candies).map(c -> Integer.valueOf(c)).collect(Collectors.summingInt(Integer::intValue));

        }
    }
}
