package src.leetCode;



/**
 * @author huangjj24
 * @date 2021-6-4 10:14
 * 160. 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 **/
public class Solution_160 {

    public static void main(String[] args) {
        System.out.println(null == null);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;

        //时间复杂度n2
//        while (headA != null) {
//            ListNode node = headB;
//            while (node != null) {
//                if (headA == node) return node;
//                node = node.next;
//            }
//            headA = headA.next;
//        }
//        return null;
    }
}
