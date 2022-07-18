package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头
 * @Author: huangjj24
 * @CreateDate: 2021-4-19 13:46
 **/
public class Solution_2 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(4, n1);
        ListNode n3 = new ListNode(2, n2);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(6, n4);
        ListNode n6 = new ListNode(5, n5);
        Solution_2 solution_2 = new Solution_2();
        ListNode listNode = solution_2.addTwoNumbers(n3, n6);
        System.out.println(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int j = 0;
        ListNode res = l1;
        ListNode l1Left = null;
        while (l1 != null && l2 != null) {
            int v = l1.val + l2.val + j;
            l1.val = v % 10;
            j = v / 10;
            l1Left = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int v = l1.val + j;
            l1.val = v % 10;
            j = v / 10;
            l1Left = l1;
            l1 = l1.next;
        }
        if (l2 != null) {
            l1Left.next = l2;
            while (l1Left.next != null) {
                l1Left = l1Left.next;
                int v = l1Left.val + j;
                l1Left.val = v % 10;
                j = v / 10;
            }
        }
        if (j != 0) {
            l1Left.next = new ListNode(j);
        }
        return res;
    }


    public ListNode revers(ListNode head) {
        ListNode last = null;
        while (head.next != null) {
            ListNode next = head.next;
            head.next = last;
            last = head;
            head = next;
        }
        head.next = last;
        return head;
    }

}
