package leetCode;

/**
 * @author huangjj24
 * @date 2021-7-3 9:48
 * 451. 根据字符出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 **/
public class Solution_451 {

    public static void main(String[] args) {

    }

    public String frequencySort(String s) {
        int[] arr = new int[256];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) + 128]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 256; i++) {
            int max = i;
            for (int j = 0; j < 256; j++) {
                if (arr[max] < arr[j])
                    max = j;
            }
            while (arr[max]-- > 0) {
                sb.append((char) (max - 128));
            }
        }
        return sb.toString();
    }
}
