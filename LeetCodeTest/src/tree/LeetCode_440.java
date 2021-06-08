package tree;

/**
 * @Auther: Carl
 * @Date: 2021/06/08/14:59
 * @Description: 字典序的第K小数字
 */
public class LeetCode_440 {
    public int findKthNumber(int n, int k) {
        long cur = 1;
        k -= 1;
        while (k > 0) {
            int nodes = getNodes(n, cur);   //获取总结点数
            if (k >= nodes) {   //当前值比总结点数大，向右进行
                k -= nodes;
                cur++;
            } else {    //当前值比总结点数小，向下进行
                k -= 1;
                cur *= 10;
            }
        }
        return (int) cur;
    }

    /**
     * 计算当前层有多少个节点
     * @param n 节点总数量
     * @param cur 当前层数
     * @return
     */
    private int getNodes(int n, long cur) {
        long next = cur + 1;    //下一层
        long totalNodes = 0;
        while (cur <= n) {
            totalNodes += Math.min(n - cur + 1, next - cur);    //遍历到每一层的时候，有可能当前层因为字典序的原因数字不能到达最后一个位置，所以需要判断一下当前这层是不是最后一层，如果是就只要取这层有多少节点
            next *= 10;
            cur *= 10;
        }
        return (int) totalNodes;
    }
}
