package offer.strings;

/**
 * @Auther: Carl
 * @Date: 2021/04/28/18:04
 * @Description: #01    判定字符是否唯一
 */
public class offer_01 {
    public boolean isUnique(String astr) {
        for (int i = 0; i < astr.length(); i++) {
            String s = astr;
            s = s.replace(s.valueOf(s.charAt(i)), "");
            if (s.length() != astr.length() - 1) return false;
        }
        return true;
    }
}
