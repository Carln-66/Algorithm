package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Carl
 * @Date: 2021/05/02/16:54
 * @Description:    #3 无重复字符的最长子串
 */
public class LeetCode_3 {

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < len; end++) {    //start为滑动窗口起始位置0，end为结束位置，一旦遇到重复元素，start会递增到当前start位置的下一个位置
            char element = s.charAt(end);   //element为当前窗口末端所指向的元素，这个变量用来判断是否遇到了重复元素的情况
            if (map.containsKey(element)) { //如果当前end遇到了重复map集合中重复的元素，执行如下代码
                start = Math.max(map.get(element) + 1, start);  //以”deedf”为例，在经过第一轮判断重复，start和end同时指向第二个e的时候，end继续向后移，此时遇到了重复的d字符，但此时map中所包含的d的kv仍是第一个d的。此时为了避免start指针回到了第一个位置，所以需要判断最大值使得指针不会回到最开始的d的位置。简单来说，一旦start的位置变更之后，对于start之前的元素仍是在map集合中的，如果没有经过比较，一旦end遇到了重复元素的情况会优先从map中存储的前面的字符查找，这并不是期望的结果
            }
            max = Math.max(max, end - start + 1);   //计算最大值
            map.put(element, end);  //将当前字符的kv的信息新增/更新进map中
        }
        return max;
    }
}