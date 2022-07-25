package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution_109 {

    public static void main(String[] args) {

    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        else if (head.next == null) return new TreeNode(head.val);
        ListNode pre = head, mid = pre.next, last = mid.next;
        while (last != null && last.next != null) {
            pre = pre.next;
            mid = pre.next;
            last = last.next.next;
        }
        pre.next = null;
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }


//    public TreeNode sortedListToBST(ListNode head) {
//        List<Integer> list = getArr(head);
//        return getTree(list, 0, list.size() - 1);
//    }

    public TreeNode getTree(List<Integer> list, int start, int end) {
        if (start == end) return new TreeNode(list.get(start));
        if (start >= end) return null;
        int mid = (start + end) / 2;
        TreeNode head = new TreeNode(list.get(mid));
        head.left = getTree(list, start, mid - 1);
        head.right = getTree(list, mid + 1, end);
        return head;
    }

    public List<Integer> getArr(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }
}
