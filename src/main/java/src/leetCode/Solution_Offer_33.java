package src.leetCode;

import java.util.LinkedList;

/**
 * @Description:剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * @Author: huangjj24
 * @CreateDate: 2021-4-25 11:33
 **/
public class Solution_Offer_33 {

    public static void main(String[] args) {

    }

    public boolean verifyPostorder(int[] postorder) {
        LinkedList<Integer> stack = new LinkedList<>();
        int preNum = Integer.MAX_VALUE;
        for (int i = postorder.length-1; i >= 0 ; i--) {
            if(postorder[i]>preNum) return false;
            while (!stack.isEmpty()&&postorder[i]<stack.peek()) preNum=stack.pop();
            stack.push(postorder[i]);
        }
        return true;
    }

}
