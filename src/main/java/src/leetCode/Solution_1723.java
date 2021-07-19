package src.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangjj24
 * @date 2021-5-8 16:40
 * 1723. 完成所有工作的最短时间
 * 给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 * <p>
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 * <p>
 * 返回分配方案中尽可能 最小 的 最大工作时间 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_1723 {

    public static void main(String[] args) {
        int[] a = {5,15,4,9,15,8,8,9};
        System.out.println(minimumTimeRequired(a, 2));
    }

    public static int minimumTimeRequired(int[] jobs, int k) {
        int l = jobs.length;
        Arrays.sort(jobs);
        int sum = 0;
        for (int i = 0; i < l; i++) sum += jobs[i];
        int avg = sum / k;
        avg = avg * k == sum ? avg : avg + 1;
        int left = Math.max(jobs[l - 1], avg);
        int right = sum;
        while (left < right) {
            int mid = (left + right) / 2;
            if (isEmpty(jobs, k, mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private static boolean isEmpty(int[] jobs, int k, int mid) {
        List<Integer> workers = new ArrayList<>();
        for (int i = 0; i < jobs.length; i++) workers.add(jobs[i]);
        for (int j = 0; j < k; j++) {
            int res = mid;
            for (int i = workers.size() - 1; i >= 0; i--) {
                if (workers.get(i) <= res) {
                    res -= workers.get(i);
                    workers.remove(i);
                }
            }
        }
        return workers.isEmpty();
    }
}
