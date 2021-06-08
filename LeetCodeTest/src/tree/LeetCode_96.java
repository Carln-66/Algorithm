package tree;

/**
 * @Auther: Carl
 * @Date: 2021/06/08/17:47
 * @Description:
 */
public class LeetCode_96 {
    public int numTrees(int n) {
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}
