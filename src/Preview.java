/**
 * @Auther: Carl
 * @Date: 2021/03/29/18:18
 * @Description:
 */
public class Preview {

    public static void main(String[] args) {
        String s = "()))";
        System.out.println(solution(s));
        System.out.println(10 / 10);

    }

    public static int solution(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int result = 0;

        for (int i = 0; i < len; i++) {
            if (right > left) {
                left = 0;
                right = 0;
            }
            if (chars[i] == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                result = right * 2;
            }
        }

        left = 0;
        right = 0;

        for (int i = len - 1; i >= 0; i--) {
            if (left > right) {
                left = 0;
                right = 0;
            }
            if (chars[i] == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                result = right * 2;
            }
        }
        return result;
    }
}
