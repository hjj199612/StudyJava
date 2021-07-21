package src.leetCode;

/**
 * @author huangjj24
 * @date 2021-7-21 8:58
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
 **/
public class Solution_Offer_52 {

    public static void main(String[] args) {

    }
    // 时间复杂度(n2)
    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     if (headA == null || headB == null)
    //         return null;
    //     ListNode n1 = headA;
    //     while (n1 != null) {
    //         ListNode n2 = headB;
    //         while (n1 != n2 && n2 != null) {
    //             n2 = n2.next;
    //         }
    //
    //         if (n1 == n2)
    //             break;
    //         n1 = n1.next;
    //     }
    //     return n1;
    // }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode n1 = headA, n2 = headB;
        while (n1 != n2) {
            n1 = n1 == null ? headB : n1.next;
            n2 = n2 == null ? headA : n2.next;
        }
        return n1;
    }
}
