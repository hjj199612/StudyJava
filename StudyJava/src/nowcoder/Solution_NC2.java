package nowcoder;

/**
 * @author hjj199612
 * @date 2021/8/9 9:34 下午
 * @description NC2 重排链表
 * 要求使用原地算法，不能只改变节点内部的值，需要对实际的节点进行交换。
 */
public class Solution_NC2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        Solution_NC2 solution_nc2 = new Solution_NC2();
        solution_nc2.reorderList(l1);
        System.out.println("1");
    }

    public void reorderList(ListNode head) {
        if(head==null) return;
        ListNode mid = head;
        ListNode last = head;
        while (last != null) {
            last = last.next;
            if (last == null) {
                break;
            }
            last = last.next;
            mid = mid.next;
        }
        ListNode pre = null;
        ListNode lHead = mid.next;
        mid.next = null;
        while (lHead != null) {
            ListNode node = lHead.next;
            lHead.next = pre;
            pre = lHead;
            lHead = node;
        }
        ListNode node = head;
        while (pre != null) {
            ListNode next = node.next;
            node.next = pre;
            ListNode preNext = pre.next;
            pre.next = next;
            pre = preNext;
            node = next;
        }
    }

}
