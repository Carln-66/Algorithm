package tree;

/**
 * @Auther: Carl
 * @Date: 2021/07/21/21:41
 * @Description:
 */
public class My24Points {

}

class T {
    int[] can = new int[4];

    public static void main(String[] args) {
        T tf = new T(8, 4, 5, 7);
        System.out.println(tf.getResult());
    }

    public T(int a, int b, int c, int d) {
        can[0] = a;
        can[1] = b;
        can[2] = c;
        can[3] = d;
    }

    public String getResult() {
        double result1 = 0;
        double result2 = 0;
        double result3 = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (i != j) {
                        result1 = cal(can[i], can[j], k);
                        for (int l = 0; l < 4; l++) {
                            for (int m = 0; m < 4; m++) {
                                if (i != l && j != l) {
                                    result2 = cal(result1, can[l], m);
                                    for (int n = 0; n < 4; n++) {
                                        for (int o = 0; o < 4; o++) {
                                            if (i != n && j != n && l != n) {
                                                result3 = cal(result2, can[n], o);
                                                if (result3 == 24) {
                                                    return result(can[i], k, can[j], m, can[l], o, can[n]);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    private String result(int can1, int op1, int can2, int op2, int can3, int op3, int can4) {
        return "" + can1 + convert(op1) + can2 + convert(op2) + can3 + convert(op3) + can4;
    }

    private String convert(int opr) {
        if (opr == 0) {
            return "+";
        } else if (opr == 1) {
            return "-";
        } else if (opr == 2) {
            return "*";
        } else if (opr == 3) {
            return "/";
        }
        return "";
    }

    private double cal(double a, double b, int opr) {
        if (opr == 0) {
            return a + b;
        } else if (opr == 1) {
            return a - b;
        } else if (opr == 2) {
            return a * b;
        } else if (opr == 3) {
            return a / b;
        }
        return 0;
    }
}
