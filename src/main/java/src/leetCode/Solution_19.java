package src.leetCode;

/**
 * @Description:19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 * @Author: huangjj24
 * @CreateDate: 2021-5-1 15:44
 **/
public class Solution_19 {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode old = head;
        ListNode node = head;
        ListNode nodeLeft = null;
        while (head!=null){
            if(--n<0){
                nodeLeft=node;
                node=node.next;
            }
            head=head.next;
        }
        if(nodeLeft==null) old=old.next;
        else {
            nodeLeft.next=node.next;
        }
        return old;
    }
}
