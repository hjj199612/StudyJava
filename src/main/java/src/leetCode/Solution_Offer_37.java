package src.leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huangjj24
 * @date 2021-5-27 14:26
 * 剑指 Offer 37. 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 **/
public class Solution_Offer_37 {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        System.out.println(deserialize(serialize(n1)));
    }

    public static String serialize(TreeNode root) {
        if (root == null)
            return "[]";
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.append(']').toString();
    }

    public static TreeNode deserialize(String data) {
        if ("[]".equals(data))
            return null;
        String[] strings = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"null".equals(strings[i])) {
                node.left = new TreeNode(Integer.parseInt(strings[i]));
                queue.add(node.left);
            }
            i++;
            if (!"null".equals(strings[i])) {
                node.right = new TreeNode(Integer.parseInt(strings[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
    //if (data.equals("[]")) return null;
        //         String[] vals = data.substring(1, data.length() - 1).split(",");
    //         TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
    //         Deque<TreeNode> deque = new LinkedList() {{
    //             add(root);
    //         }};
    //         int i = 1;
    //         while (!deque.isEmpty()) {
    //             TreeNode node = deque.pop();
    //             if (!vals[i].equals("null")) {
    //                 node.left = new TreeNode(Integer.parseInt(vals[i]));
    //                 deque.add(node.left);
    //             }
    //             i++;
    //             if (!vals[i].equals("null")) {
    //                 node.right = new TreeNode(Integer.parseInt(vals[i]));
    //                 deque.add(node.right);
    //             }
    //             i++;
    //         }
    //         return root;
    //         if (root == null) return "[]";
    //         Deque<TreeNode> deque = new LinkedList() {{
    //             add(root);
    //         }};
    //         StringBuilder sb = new StringBuilder("[");
    //         while (!deque.isEmpty()) {
    //             TreeNode node = deque.pop();
    //             if (node != null) {
    //                 sb.append(node.val + ",");
    //                 deque.add(node.left);
    //                 deque.add(node.right);
    //             } else {
    //                 sb.append("null,");
    //             }
    //         }
    //         sb.deleteCharAt(sb.length() - 1);
    //         return sb.append(']').toString();
}
