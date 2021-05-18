package string;

/**
 * @Auther: Carl
 * @Date: 2021/05/18/15:00
 * @Description: 最长公共前缀
 */
public class LeetCode_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (strs[i].charAt(j) != ans.charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0, j);
        }
        return ans;
    }
}
