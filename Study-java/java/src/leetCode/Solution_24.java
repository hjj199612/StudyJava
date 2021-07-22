package src.leetCode;



/**
 * @author huangjj24
 * @date 2021-5-28 16:57
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 **/
public class Solution_24 {

    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode();
        ListNode node = newHead;
        while (head != null && head.next != null) {
            node.next = head.next;
            node=head;
            head = head.next.next;
            node.next.next = node;
        }
        node.next=head;
        return newHead.next;
    }
}
