package leetCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author huangjj24
 * @date 2021-7-31 13:43
 * 987. 二叉树的垂序遍历
 * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 * 对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。
 * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 * 返回二叉树的 垂序遍历 序列。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_987 {

    public static void main(String[] args) {

    }

    Map<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        verticalTraversal(root, 0, 0);

        // return map.values().stream().map(e ->
        //         e.values().stream().peek(l -> l.sort(Integer::compareTo)).flatMap(Collection::stream)
        //                 .collect(Collectors.toList())).collect(Collectors.toList());

        List<List<Integer>> res = new ArrayList<>(map.size());
        map.values().forEach(e -> {
            List<Integer> ls = new ArrayList<>();
            e.values().forEach(l -> {
                l.sort(Integer::compareTo);
                ls.addAll(l);
            });
            res.add(ls);
        });
        return res;
    }

    public void verticalTraversal(TreeNode root, int x, int y) {
        if (root == null)
            return;
        TreeMap<Integer, List<Integer>> treeMap = map.getOrDefault(x, new TreeMap<>());
        List<Integer> list = treeMap.getOrDefault(y, new ArrayList<>());
        list.add(root.val);
        treeMap.put(y, list);
        map.put(x, treeMap);
        verticalTraversal(root.left, x - 1, y + 1);
        verticalTraversal(root.right, x + 1, y + 1);
    }
}
