import java.util.*;

public class Main {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length() * 2 - 1; i++) {
            int left = i / 2;
            int right = left + i % 2;
            //while判断顺序不能调换
            while ( left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                count++;
            }
        }
        return count;
    }
}
