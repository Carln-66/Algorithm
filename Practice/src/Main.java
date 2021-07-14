import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.print(n + "=");
        List<Integer> list = new ArrayList<>();
        for (int k = 2; k <= n / 2; k++) {
            if (n % k == 0) {
                list.add(k);
                n /= k;
                k = 2;
            }
        }
        list.add(n);
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
                return;
            }
            System.out.print(arr[i] + "*");
        }
    }
}
