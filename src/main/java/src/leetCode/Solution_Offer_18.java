package src.leetCode;



/**
 * @author huangjj24
 * @date 2021-5-17 17:39
 * 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 **/
public class Solution_Offer_18 {

    public static void main(String[] args) {

    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode node = head;
        if(val==head.val) {
            head=head.next;
            node.next=null;
            return head;
        }
        ListNode last = head;
        while (node.next!=null){
            last=node;
            node=node.next;
            if(node.val==val) {
                last.next=node.next;
                break;
            }
        }
        return head;
    }

}
