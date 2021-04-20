package offer.array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Auther: Carl
 * @Date: 2021/04/20/16:20
 * @Description: #50     第一个只出现一次的字符
 */
public class offer_50 {
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(offer_50.firstUniqChar(s));
    }

    //常规遍历
    public static char firstUniqChar(String s) {
        if (s.length() == 1) {
            return s.charAt(0);
        }
        ArrayList<Character> arrayList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            boolean flag = true;
            char letter = s.charAt(i);
            int j = i + 1;
            if (arrayList.contains(letter)) {
                continue;
            } else {
                while (j < s.length()) {
                    if (letter == s.charAt(j)) {
                        arrayList.add(letter);
                        flag = false;
                        break;
                    }
                    j++;
                }
            }
            if (flag) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    //利用HashMap
    public static char firstUniqChar1(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, !map.containsKey(c));
        }
        for (char c : s.toCharArray()) {
            if (map.get(c)) return c;
        }
        return ' ';
    }

    //调用lastIndexOf
    public char firstUniqChar2(String s) {
        // 因为在字符串中只出现了小写字符
        int bound = s.length();
        for (char c = 'a'; c <= 'z'; c++){
            int index = s.indexOf(c);
            if (index != -1 && index == s.lastIndexOf(c) && index < bound){
                // 如果当前字符串存在这个字符并且它只出现了一次并且它在当前范围之内，也就是比上一个只出现一次的字符更加靠前，更新范围
                bound = index;
            }
        }
        return bound == s.length() ? ' ' : s.charAt(bound);
    }
}
