package kickstart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpeedTyping {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
//        System.out.println("T = " + T);
        while (T-- > 0) {
            int counter = 0;
            String O = br.readLine();
            String P = br.readLine();
//            System.out.println("O = " + O);
//            System.out.println("P = " + P);
            int j = 0;
            for (int i = 0; i < P.length(); i++) {
                char p = P.charAt(i);
//                System.out.println("p = " + p);
                if (j < O.length()) {
                    char o = O.charAt(j);
//                    System.out.println("o = " + o);
                    if (o == p) {
                        j++;
                    } else {
                        counter++;
                    }
                } else {
                    counter++;
                }
            }
            if (j == O.length()) {
                System.out.println(counter);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}