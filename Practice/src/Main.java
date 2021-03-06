import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 2, 3};
        System.out.println(findNum(arr));
    }

    public static int findNum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int[] arr = new int[map.size()];
        int ptr = 0;
        for (int num : map.values()) {
            arr[ptr] = num;
            ptr++;
        }
        Arrays.sort(arr);
        int key = 0;
        int num = arr[arr.length - 2];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (num == entry.getValue()) {
                key = entry.getKey();
            }
        }
        return key;
    }
}
