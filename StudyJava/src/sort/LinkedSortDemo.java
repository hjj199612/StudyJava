package sort;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @Description: 链表排序
 * @Author: huangjj24
 * @CreateDate: 2021-4-13 16:25
 **/
public class LinkedSortDemo {

    public static ListNode root;

    public static class ListNode implements Cloneable {//单链表
        public int val;
        public ListNode next;

        @Override
        public ListNode clone() {
            if (root == null)
                return null;
            ListNode node = new ListNode();
            ListNode clone = node;
            ListNode real = root;
            ListNode last = node;
            while (real != null) {
                if (node == null)
                    node = new ListNode();
                node.val = real.val;
                real = real.next;
                last.next = node;
                last = node;
                node = null;
            }
            return clone;
        }
    }

    static {
        int count = (int) ((1 + Math.random()) * 1000);
        root = new ListNode();
        root.val = (int) (Math.random() * 2000);
        ListNode node = root;
        for (int i = 0; i < count - 1; i++) {
            ListNode next = new ListNode();
            next.val = (int) (Math.random() * 2000);
            node.next = next;
            node = node.next;
        }
        node = new ListNode();
        node.val = 9999;
        node.next = root;
        root = node;
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
    }

    public static ListNode mergeSort(ListNode real) {
        ListNode last = real;
        while (last.next != null) {
            last = last.next;
        }
        return mergeSort(real, last);
    }

    public static ListNode mergeSort(ListNode start, ListNode end) {
        if (start == end) {
            start.next = null;
            return start;
        }
        ListNode mid = getMiddle(start, end);
        ListNode midNext = mid.next;
        ListNode node1 = mergeSort(start, mid);
        ListNode node2 = mergeSort(midNext, end);
        ListNode node = null;
        ListNode min = null;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                if (node == null) {
                    node = node1;
                } else {
                    node.next = node1;
                    node = node.next;
                }
                node1 = node1.next;
            } else {
                if (node == null) {
                    node = node2;
                } else {
                    node.next = node2;
                    node = node.next;
                }
                node2 = node2.next;
            }
            if (min == null)
                min = node;
        }
        if (node1 != null) {
            node.next = node1;
        }
        if (node2 != null) {
            node.next = node2;
        }
        return min;
    }

    public static ListNode getMiddle(ListNode start, ListNode end) {//返回中间节点
        ListNode mid = start;
        ListNode last = start;
        while (last != null && last.next != null && last != end) {
            last = last.next;
            if (last.next == null || last == end)
                break;
            mid = mid.next;
            last = last.next;
        }
        return mid;
    }

    public static ListNode selectSort(ListNode real) {
        ListNode head = real;
        ListNode last = null;
        while (real != null) {
            ListNode node = real.next;
            ListNode nodeLeft = real;
            ListNode max = real;
            ListNode maxLeft = last;
            while (node != null) {
                if (node.val > max.val) {
                    max = node;
                    maxLeft = nodeLeft;
                }
                nodeLeft = node;
                node = node.next;
            }
            if (last == null)
                last = max;
            if (real == max)
                real = real.next;
            if (maxLeft != null) {
                maxLeft.next = max.next;
                max.next = head;
                head = max;
            }
        }
        return head;
    }

    public ListNode insertionSortList(ListNode head) {
        return null;
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
