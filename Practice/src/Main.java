import java.util.*;

public class Main {
    public String reverseWords(String s) {
        s.trim();
        int fast = s.length() - 1;
        int slow = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (fast >= 0) {
            while (fast >= 0 && s.charAt(fast) != ' ') {
                fast--;
            }
            sb.append(s.substring(fast + 1, slow + 1) + " ");
            while (fast >= 0 && s.charAt(fast) == ' ') {
                fast--;
            }
            slow = fast;
        }
        return sb.toString().trim();
    }
}
