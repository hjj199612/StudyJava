package src.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangjj24
 * @date 2021-6-19 11:27
 * 401. 二进制手表
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
 * 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
 * <p>
 * 小时不会以零开头：
 * <p>
 * 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
 * 分钟必须由两位数组成，可能会以零开头：
 * <p>
 * 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-watch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_401 {

    public static void main(String[] args) {
        System.out.println(Integer.bitCount(0));
        System.out.println(Integer.bitCount(1));
        System.out.println(Integer.bitCount(2));
        System.out.println(Integer.bitCount(3));
    }

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                    res.add(i + ":" + (j < 10 ? "0" + j : j));
                }
            }
        }
        return res;
    }
    // public List<String> readBinaryWatch(int turnedOn) {
    //     List<String> res = new ArrayList<>();
    //     dfsH(res, turnedOn, 0);
    //     return res;
    // }

    // public List<String> readBinaryWatch(int turnedOn) {
    //     List<String> res = new ArrayList<>();
    //     dfsH(res, turnedOn);
    //     return res;
    // }
    //
    // public void dfsH(List<String> res, int turnedOn) {
    //     for (int i = 0; i < 12; i++) {
    //         int count1 = Integer.bitCount(i);
    //         if (turnedOn < count1)
    //             continue;
    //         String h = i + ":";
    //         dfsM(res, turnedOn - count1, h);
    //     }
    // }
    //
    // public void dfsM(List<String> res, int turnedOn, String h) {
    //     for (int i = 0; i < 60; i++) {
    //         int count1 = Integer.bitCount(i);
    //         if (turnedOn != count1)
    //             continue;
    //         if (i < 10) {
    //             res.add(h + "0" + i);
    //         } else
    //             res.add(h + i);
    //     }
    // }
}