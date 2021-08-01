package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huangjj24
 * @date 2021-7-29 8:55
 * 1104. 二叉树寻路
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 * <p>
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 * <p>
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_1104 {

    public static void main(String[] args) {
        System.out.println((int) (Math.log(1) / Math.log(2)));
        System.out.println((int) (Math.log(2) / Math.log(2)));
        System.out.println((int) (Math.log(3) / Math.log(2)));
        System.out.println((int) (Math.log(4) / Math.log(2)));
        System.out.println((int) (Math.log(5) / Math.log(2)));
    }

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new LinkedList<>();
        int floor = (int) (Math.log(label) / Math.log(2));
        while (label > 0) {
            res.add(0, label);
            label /= 2;
            int max = (int) Math.pow(2, floor--) - 1;
            int min = (int) Math.pow(2, floor);
            label = max + min - label;
        }
        return res;
    }
}
