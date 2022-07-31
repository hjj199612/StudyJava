package sort;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @Description: 链表排序
 * @Author: huangjj24
 * @CreateDate: 2021-4-13 16:25
 **/
public class LinkedSortStudy {

    public static ListNode root;

    static {
        int count = (int) ((1 + Math.random()) * 400);
        root = new ListNode();
        root.val = 99999;
        ListNode node = root;
        for (int i = 0; i < count - 1; i++) {
            ListNode next = new ListNode();
            next.val = (int) (Math.random() * 2000);
            node.next = next;
            node = node.next;
        }
        printListNodes(root);
    }

    public static void main(String[] args) {
        LocalDateTime start;
        LocalDateTime end;
        Duration duration;

        //归并排序 时间复杂度O(nlog2n)
        ListNode mergeNode = root.clone();
        start = LocalDateTime.now();
        mergeNode = mergeSort(mergeNode);
        end = LocalDateTime.now();
        duration = Duration.between(start, end);
        System.out.println("归并排序耗时：" + duration.toNanos() + "纳秒");
        printListNodes(mergeNode);

        //选择排序 时间复杂度O(n2)
        ListNode selectNode = root.clone();
        start = LocalDateTime.now();
        selectNode = selectSort(selectNode);
        end = LocalDateTime.now();
        duration = Duration.between(start, end);
        System.out.println("选择排序耗时：" + duration.toNanos() + "纳秒");
        printListNodes(selectNode);

        //插入排序 时间复杂度O(n2)
        ListNode insertNode = root.clone();
        start = LocalDateTime.now();
        insertNode = insertSort(insertNode);
        end = LocalDateTime.now();
        duration = Duration.between(start, end);
        System.out.println("插入排序耗时：" + duration.toNanos() + "纳秒");
        printListNodes(insertNode);

        //快速排序 时间复杂度O(n*logN)
        ListNode quickNode = root.clone();
        start = LocalDateTime.now();
        quickNode = quickSort(quickNode);
        end = LocalDateTime.now();
        duration = Duration.between(start, end);
        System.out.println("快速排序耗时：" + duration.toNanos() + "纳秒");
        printListNodes(quickNode);

        check(mergeNode, selectNode, insertNode, quickNode);
    }

    private static void check(ListNode mergeNode, ListNode selectNode, ListNode insertNode, ListNode quickNode) {
        while (mergeNode != null && selectNode != null && insertNode != null && quickNode != null) {
            if (mergeNode.val != selectNode.val || selectNode.val != insertNode.val || insertNode.val != quickNode.val) {
                System.out.println("不对劲");
                break;
            } else {
                mergeNode = mergeNode.next;
                selectNode = selectNode.next;
                insertNode = insertNode.next;
                quickNode = quickNode.next;
            }
        }
    }


    public static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode midPre = head, mid = midPre.next, last = mid.next;
        while (last != null && last.next != null) {
            midPre = midPre.next;
            mid = midPre.next;
            last = last.next.next;
        }
        midPre.next = null;
        ListNode leftHead = mergeSort(head);
        ListNode rightHead = mergeSort(mid);
        ListNode newHead = new ListNode(), cur = newHead;
        while (leftHead != null && rightHead != null) {
            if (leftHead.val < rightHead.val) {
                cur.next = leftHead;
                leftHead = leftHead.next;
            } else {
                cur.next = rightHead;
                rightHead = rightHead.next;
            }
            cur = cur.next;
        }
        if (leftHead != null) cur.next = leftHead;
        if (rightHead != null) cur.next = rightHead;
        return newHead.next;
    }

    public static ListNode selectSort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head, last = null;
        while (cur != null) {
            ListNode max = cur, maxLeft = last, node = cur.next, nodeLeft = cur;
            while (node != null) {
                if (max.val < node.val) {
                    max = node;
                    maxLeft = nodeLeft;
                }
                node = node.next;
                nodeLeft = nodeLeft.next;
            }
            if (last == null) last = max;
            if (maxLeft == null) {
                cur = cur.next;
            } else if (cur == max) {
                last.next = cur.next;
                cur.next = head;
                head = cur;
                cur = last.next;
            } else {
                maxLeft.next = max.next;
                max.next = head;
                head = max;
            }
        }
        return head;
    }

    //插入排序
    public static ListNode insertSort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head.next, curLeft = head;
        while (cur != null) {
            ListNode node = head, nodeLeft = null;
            while (node.val < cur.val) {
                nodeLeft = node;
                node = node.next;
            }
            if (nodeLeft == null) {
                curLeft.next = cur.next;
                cur.next = head;
                head = cur;
                cur = curLeft.next;
            } else if (node == cur) {
                cur = cur.next;
                curLeft = curLeft.next;
            } else {
                curLeft.next = cur.next;
                cur.next = node;
                nodeLeft.next = cur;
                cur = curLeft.next;
            }
        }
        return head;
    }


    //快速排序
    public static ListNode quickSort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode i = head.next, j = head.next, iLeft = head;
        while (j != null) {
            if (j.val < head.val) {
                sweep(i, j);
                i = i.next;
                iLeft = iLeft.next;
            }
            j = j.next;
        }
        iLeft.next = null;
        sweep(head, iLeft);
        ListNode leftHead = quickSort(head);
        ListNode rightHead = quickSort(i);
        ListNode cur = leftHead;
        while (cur.next != null) cur = cur.next;
        cur.next = rightHead;
        return leftHead;
    }

    private static void sweep(ListNode i, ListNode j) {
        int temp = i.val;
        i.val = j.val;
        j.val = temp;
    }


    public static void cloneCheck() throws Exception {//确认是深克隆
        ListNode real = root.clone();
        ListNode node = root.clone();
        while (node != null && real != null) {
            if (real == node) {
                throw new Exception("深克隆失败");
            }
        }
        System.out.println();
    }

    public static void printListNodes(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
            if (node != null)
                System.out.print(" -> ");
        }
        System.out.println();
    }
}
