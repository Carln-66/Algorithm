package string;

/**
 * @Auther: Carl
 * @Date: 2021/05/17/22:22
 * @Description:
 */public class LeetCode_415 {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int endOfNum1 = num1.length() - 1;
        int endOfNum2 = num2.length() - 1;
        int carry = 0;
        while (endOfNum1 >= 0 || endOfNum2 >= 0) {
            int n1 = endOfNum1 >= 0 ? num1.charAt(endOfNum1) - '0' : 0;
            int n2 = endOfNum2 >= 0 ? num2.charAt(endOfNum2) - '0' : 0;
            int temp = (n1 + n2) + carry;
            carry = temp / 10;
            res.append(temp % 10);
            endOfNum1--;
            endOfNum2--;
        }
        if (carry > 0) {
            res.append(1);
        }
        return res.reverse().toString();
    }
}
