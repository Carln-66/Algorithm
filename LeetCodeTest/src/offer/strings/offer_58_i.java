package offer.strings;

/**
 * @Auther: Carl
 * @Date: 2021/06/15/19:04
 * @Description: 翻转单词顺序
 */
public class offer_58_i {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
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
