package src.leetCode;



import java.util.Deque;
import java.util.LinkedList;

/**
 * @author huangjj24
 * @date 2021-5-27 14:02
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_25 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(reverseKGroup(n1, 2));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        int s = k;
        Deque<ListNode> deque = new LinkedList<>();
        ListNode newHead = new ListNode();
        ListNode node = newHead;
        while (head != null) {
            if (s-- > 0) {
                deque.push(head);
                head = head.next;
            } else {
                s = k;
                while (deque.size() > 0) {
                    node.next = deque.pop();
                    node = node.next;
                }
            }
        }
        if(deque.size()==k){
            while (deque.size() > 0) {
                node.next = deque.pollFirst();
                node = node.next;
            }
        }else {
            while (deque.size() > 0) {
                node.next = deque.pollLast();
                node = node.next;
            }
        }
        node.next = null;
        return newHead.next;
    }
}
