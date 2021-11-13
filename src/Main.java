 import java.util.ArrayList;
 import java.util.ArrayList;
 import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        ArrayList<HashSet<Integer>> graph = new ArrayList<>();
        HashMap<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new HashSet<>());
        }
        for (int i = 1; i <= n; i++) {
            dict.put(i, i);
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int a = dict.get(x);
            int b = dict.get(y);
            dict.put(x, b);
            dict.put(y, a);
        }
        for (int i = 1; i < n; i++) {
            System.out.println(graph.get(dict.get(i)).size() + " ");
        }
        System.out.println(graph.get(dict.get(n)).size());
    }
}