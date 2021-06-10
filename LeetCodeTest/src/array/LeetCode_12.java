package array;

/**
 * @Auther: Carl
 * @Date: 2021/06/10/15:19
 * @Description: 整数转罗马数字
 */
public class LeetCode_12 {
    public String intToRoman(int num) {
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String s = symbol[i];
            while (num >= value) {
                num -= value;
                res.append(s);
            }
            if (num == 0) {
                break;
            }
        }
        return res.toString();
    }
}
