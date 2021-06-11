package array;

/**
 * @Auther: Carl
 * @Date: 2021/06/11/20:08
 * @Description: 森林中的兔子
 */
public class LeetCode_781 {
    public int numRabbits(int[] answers) {
        int[] tmp = new int[1000];
        int res = 0;
        for (int i : answers) {
            if (tmp[i] == 0) {
                tmp[i] = i;
                res += i + 1;
            } else {
                tmp[i]--;
            }
        }
        return res;
    }
}
