package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Carl
 * @Date: 2021/06/10/17:36
 * @Description: 电话号码的字母组合
 */
public class LeetCode_17 {
    public static void main(String[] args) {
        String s = "23";
        letterCombinations(s);
    }
    public static List<String> letterCombinations(String digits) {
        if (digits.length() < 1) return new ArrayList<>();
        HashMap<Character, String> map = new HashMap<Character, String>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        List<String> combinations = new ArrayList<>();
        combinationBetweenNums(combinations, digits, map, 0, new StringBuffer());
        return combinations;
    }

    private static void combinationBetweenNums(List<String> combinations, String digits, Map<Character, String> map, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char num = digits.charAt(index);
            String s = map.get(num);
            for (int i = 0; i < s.length(); i++) {
                combination.append(s.charAt(i));
                combinationBetweenNums(combinations, digits, map, index + 1 , combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
