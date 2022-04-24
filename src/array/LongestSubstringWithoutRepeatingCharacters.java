package array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        LinkedList<Character> q = new LinkedList();
        Set<Character> set = new HashSet<>();
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (set.contains(c)) {
                while (q.peekLast() != c) {
                    Character t = q.pollLast();
                    set.remove(t);
                }
                if (q.peekLast() == 'c') {
                    q.pollLast();
                    q.addFirst(c);
                } else {
                    System.out.println("weird");
                }

            } else {
                q.addFirst(c);
                set.add(c);
            }
            len = Math.max(len, q.size());
        }
        return len;
    }
}