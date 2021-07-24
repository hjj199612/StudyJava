package leetCode;

/**
 * @author huangjj24
 * @date 2021-7-8 17:20
 **/
public class Solution_60 {

    public static void main(String[] args) {

    }

    public String getPermutation(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        recurren(arr, k);
        return "";
    }

    private void recurren(int[] arr, int k) {
        if (k == 1)
            return;
    }
}
