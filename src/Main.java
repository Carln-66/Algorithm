import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String ans1 = "";
        String ans2 = "";
        String ans3 = "";
        String ans4 = "";
        int n = a.length();
        int flag = 2;
        if (a.charAt(0) >= 'A' && a.charAt(0) <= 'Z') {
            flag = 1;
        }
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) == '_') {
                flag = 3;
            }
            if (a.charAt(i) == '-') {
                flag = 4;
            }
        }
        if (flag == 1) {
            ans1 = a;
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    ans2 += (char) (a.charAt(i) + 32);
                    ans3 += (char) (a.charAt(i) + 32);
                    ans4 += (char) (a.charAt(i) + 32);
                } else {
                    if (a.charAt(i) >= 'A' && a.charAt(i) <= 'Z') {
                        ans2 += a.charAt(i);
                        ans3 += '_';
                        ans3 += (char) (a.charAt(i) + 32);
                        ans4 += '-';
                        ans4 += (char) (a.charAt(i) + 32);
                    } else {
                        ans2 += a.charAt(i);
                        ans3 += a.charAt(i);
                        ans4 += a.charAt(i);
                    }
                }
            }
        }
        if (flag == 2) {
            ans2 = a;
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    ans1 += (char) (a.charAt(i) - 32);
                    ans3 += a.charAt(i);
                    ans4 += a.charAt(i);
                } else {
                    if (a.charAt(i) >= 'A' && a.charAt(i) <= 'Z') {
                        ans1 += a.charAt(i);
                        ans3 += '_';
                        ans3 += (char) (a.charAt(i) + 32);
                        ans4 += '-';
                        ans4 += (char) (a.charAt(i) + 32);
                    } else {
                        ans1 += a.charAt(i);
                        ans3 += a.charAt(i);
                        ans4 += a.charAt(i);
                    }
                }
            }
        }
        if (flag == 3) {
            ans3 = a;
            int temp = 0;
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    ans1 += (char) (a.charAt(i) - 32);
                    ans2 += a.charAt(i);
                    ans4 += a.charAt(i);
                } else {
                    if (a.charAt(i) == '_') {
                        temp = 1;
                        ans4 += '-';
                    } else {
                        if (temp == 1) {
                            ans1 += (char) (a.charAt(i) -32);
                            ans2 += (char) (a.charAt(i) -32);
                            ans4 += a.charAt(i);
                            temp = 0;
                        } else {
                            ans1 += a.charAt(i);
                            ans2 += a.charAt(i);
                            ans4 += a.charAt(i);
                        }
                    }
                }
            }
        }
        if (flag == 4) {
            ans4 = a;
            int temp = 0;
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    ans1 += (char) (a.charAt(i) - 32);
                    ans2 += a.charAt(i);
                    ans3 += a.charAt(i);
                } else {
                    if (a.charAt(i) == '-') {
                        temp = 1;
                        ans3 += '_';
                    } else {
                        if (temp == 1) {
                            ans1 += (char) (a.charAt(i) -32);
                            ans2 += (char) (a.charAt(i) -32);
                            ans3 += a.charAt(i);
                            temp = 0;
                        } else {
                            ans1 += a.charAt(i);
                            ans2 += a.charAt(i);
                            ans3 += a.charAt(i);
                        }
                    }
                }
            }
        }
        System.out.println(ans1 + " " + ans2 + " " + ans3 + " " + ans4);
    }
}