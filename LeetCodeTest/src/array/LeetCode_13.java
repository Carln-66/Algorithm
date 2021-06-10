package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Carl
 * @Date: 2021/06/10/16:59
 * @Description: 罗马数字转整数
 */
public class LeetCode_13 {
    Map<Character, Integer> map = new HashMap<Character, Integer>(){{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = map.get(s.charAt(i));
            if (i < s.length() - 1 && value < map.get(s.charAt(i + 1))) {
                res -= value;
            } else {
                res += value;
            }
        }
        return res;
    }
}
