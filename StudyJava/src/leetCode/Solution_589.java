package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:589. N 叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的 前序遍历 。
 * <p>
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * @Author: huangjj24
 * @CreateDate: 2021-4-25 11:25
 **/
public class Solution_589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {

    }

    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) return list;
        list.add(root.val);
        for (Node e : root.children){
            preorder(e);
        }
        return list;
    }

}
