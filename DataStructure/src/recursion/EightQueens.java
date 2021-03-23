package recursion;

/**
 * @Auther: Carl
 * @Date: 2021/03/23/11:01
 * @Description:
 */
public class EightQueens {
    //定义一个max表示共有多少皇后
    int max = 8;

    //定义数组array，保存正解的结果
    int[] array = new int[max];

    //计数
    static int count = 0;

    public static void main(String[] args) {

        //测试
        EightQueens eightQueens = new EightQueens();
        eightQueens.setQueen(0);
        System.out.printf("共有%d种解法\n", count);
    }

    //方法：将皇后摆放的位置输出
    private void print(){
        count++;
        for (int j : array) {
            System.out.print(j + "\t");
        }
        System.out.println();
    }

    //方法：判断放置第n个皇后时，检测该皇后的位置是否与前面的皇后位置冲突
    private boolean isValid(int n){
        for (int i = 0; i < n; i++) {
            //判定条件：
            // array[i] == array[n]: 两皇后不能位于同一列
            // Math.abs(n - i) == Math.abs(array[n] - array[i]) 两皇后不能位于同一斜线（行差不能等于列差，若相等则必定处于同一斜线上）
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //方法：放置第n个皇后
    //****注意：setQueen()方法在每一次递归时，都会进入到该层中的for循环，因此会产生回溯
    private void setQueen(int n){
        //若n==8，则会再次进入循环放入第九个皇后，因此需要在循环内返回
        if (n == max) {
            print();
            return;
        }
        //依次放入皇后，判断是否冲突
        for (int i = 0; i < max; i++) {
            //当前皇后从第一列（i=0）开始依次放置
            array[n] = i;
            //判断第n个皇后放置在i列时候是否冲突
            if (isValid(n)) {   //不冲突
                //放置第n+1个皇后，即开始递归
                setQueen(n+1);
            }
            //若位置冲突，则会isValid()方法会会返回false，方法回溯至for循环，i会再加一，即放置在当前的后一个位置，继续进入判断。
        }
    }
}
