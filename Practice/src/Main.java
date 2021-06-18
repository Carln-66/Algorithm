import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
                recur(res, digits, map, new StringBuilder(), 0);
        return res;
    }

    private void recur(List<String> res, String digits, Map<Character, String> map, StringBuilder sb, int level) {
        if (level == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char num = digits.charAt(level);
        String s = map.get(num);
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            recur(res, digits, map, sb, level + 1);
            sb.deleteCharAt(level);
        }
    }
}
