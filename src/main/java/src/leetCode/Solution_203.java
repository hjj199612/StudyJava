package src.leetCode;



/**
 * @author huangjj24
 * @date 2021-6-5 11:07
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 **/
public class Solution_203 {

    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode root = new ListNode();
        root.next = head;
        ListNode headLeft = root;
        while (head != null) {
            if (head.val == val) headLeft.next = head.next;
            else headLeft = head;
            head = head.next;
        }
        return root.next;
    }
}
