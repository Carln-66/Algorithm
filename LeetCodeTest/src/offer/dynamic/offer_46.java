package offer.dynamic;

/**
 * @Auther: Carl
 * @Date: 2021/04/21/16:02
 * @Description:
 */
public class offer_46 {

    public static void main(String[] args) {
        offer_46.translateNum(111);
    }

    public static int translateNum(int num) {
        if (num <= 9) {
            return 1;
        }
        int end = num % 100;
        if (end <= 9 || end >= 26) {
            return translateNum(num / 10);
        } else {
            return  translateNum(num / 10) + translateNum(num / 100);
        }
    }
}
