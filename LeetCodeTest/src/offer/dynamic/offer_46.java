package offer.dynamic;

/**
 * @Auther: Carl
 * @Date: 2021/04/21/16:02
 * @Description:    把数字翻译成字符串
 */
public class offer_46 {

    public static void main(String[] args) {
        offer_46.translateNum(111);
    }

    public static int translateNum(int num) {
        if (num <= 9) { //若最末位只剩一位数时返回
            return 1;
        }
        int end = num % 100;    //取最末两位数
        if (end <= 9 || end >= 26) {    //若最末两位数小于9或大于26，则只能有唯一一种拆分方式
            return translateNum(num / 10);
        } else {    //最后两位数在10-26之间，则有两种拆分方式
            return  translateNum(num / 10) + translateNum(num / 100);
        }
    }
}
