package leetCode;

/**
 * @Description:9. 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: huangjj24
 * @CreateDate: 2021-4-23 11:30
 **/
public class Solution_9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
//        char[] c = String.valueOf(x).toCharArray();
//        int i=0,j=c.length-1;
//        while (i<j){
//            if(c[i]!=c[j]) return false;
//            i++;j--;
//        }
//        return true;
        if(x<0) return false;
        int y=0,a=x;
        while (a>0){
            y=y*10+a%10;
            a/=10;
        }
        return x==y;
    }
}
