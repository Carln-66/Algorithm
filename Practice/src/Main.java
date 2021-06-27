import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        int maxWordLen = 0;
        Set<String> set = new HashSet<>();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (String element : wordDict) {
            set.add(element);
            maxWordLen = Math.max(maxWordLen, element.length());
        }
        for (int i = 1; i < len + 1; i++) {
            for (int j = i; j >= 0 && j >= i - maxWordLen ; j--) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
