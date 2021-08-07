import java.util.*;

public class Main {

    static Set<List<Integer>> res = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        boolean[] barr = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        backTrack(arr, 24, 0, new ArrayList<>());
        System.out.println(res.size());
    }

    static void backTrack(int[] arr, int target, int start, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
        }
        if (target <= 0) {
            return;
        }
        for (int i = start; i < arr.length; i++) {
            target -= arr[i];
            list.add(arr[i]);
            backTrack(arr, target, i + 1, list);
            list.remove(Integer.valueOf(arr[i]));
            target += arr[i];
        }
    }
}
