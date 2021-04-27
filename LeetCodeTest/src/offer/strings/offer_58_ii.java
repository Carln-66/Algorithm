package offer.strings;

/**
 * @Auther: Carl
 * @Date: 2021/04/27/17:29
 * @Description: #58-ii 左旋转字符串
 */
public class offer_58_ii {
    public String reverseLeftWords(String s, int n) {
        String s1 = s.substring(0, n - 1);
        String s2 = s.substring(n, s.length() - 1);
        return s2 + s1;
    }
}
