package offer.dynamic;

import java.util.*;

/**
 * @Auther: Carl
 * @Date: 2021/04/15/18:33
 * @Description:    #38     字符串的排列
 */
public class offer_38 {
    char[] chars;   //该数组储存输入字符串s转换为的char型字符
    List<String> res = new LinkedList<>();  //结果集
    public String[] permutation(String s) {
        chars = s.toCharArray();    //转换为char型数组
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    void dfs(int x) {   //x代表当前递归的层数
        if (x == chars.length - 1) {    //递归中止条件，x到达最后一层
            res.add(String.valueOf(chars));     //将当前遍历的结果添加进结果集
            return;
        }
        Set<Character> set = new HashSet<>();   //set用于判断当前一层是否有重复的元素
        for (int i = x; i < chars.length; i++) {    //由于在当前层下，可能出现的结果只能由chars.length-x种，所以循环从x至chars.length，遍历所有可能出现的情况
            if (set.contains(chars[i])) continue;   //若set中已经包含当前字符，说明该情况下的所有情况已经被判断过一次了，为了去重需要进行剪枝
            set.add(chars[i]);  //若该字符是第一次出现，那么就将该字符加入当前层的set中
            swap(i, x);     //将i，x交换
            dfs(x + 1);     //当前层的数已被固定，进入下一层
            swap(x, i);     //在回溯过程中将位置变回来，保证回溯到第一层时始终是abc
        }
    }

    void swap(int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}
