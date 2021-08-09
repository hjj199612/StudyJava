package leetCode;

/**
 * @author hjj199612
 * @date 2021/8/9 9:14 下午
 * @description 剑指 Offer II 024. 反转链表
 * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
 */
public class Solution_Offer_II_024 {

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
