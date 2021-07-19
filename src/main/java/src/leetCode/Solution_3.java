package src.leetCode;

/**
 * @Description:给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @Author: huangjj24
 * @CreateDate: 2021-4-19 14:29
 **/
public class Solution_3 {
    public static void main(String[] args) {
        lengthOfLongestSubstring("abcaefab");
    }

    public static int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start=Math.max(start,last[index]+1);
            res=Math.max(res,i-start+1);
            last[index]=i;
        }
        return res;
//        char[] chars = s.toCharArray();
//        int max = chars.length==0?0:1;
//        for (int i = 0; i <chars.length ; i++) {
//            for (int j =i+1;j<chars.length;j++){
//                boolean flag = false;
//                for (int k = i; k < j; k++) {
//                    if(chars[k]==chars[j]) {
//                        flag=true;
//                        break;
//                    }
//                }
//                if(flag) {
//                    break;
//                }
//                max=max>(j-i+1)?max:(j-i+1);
//            }
//        }
//        return max;
    }
}
