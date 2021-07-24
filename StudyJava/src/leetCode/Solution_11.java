package leetCode;

/**
 * @Description:11. 盛最多水的容器
 *  给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: huangjj24
 * @CreateDate: 2021-4-26 11:39
 **/
public class Solution_11 {

    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
       int max=0,i=0,j=height.length-1;
       while (i<j){
           max = Math.max(Math.min(height[i],height[j])*(j-i),max);
           if(height[i]<height[j]) i++;
           else j--;
       }
       return max;
//        int max = 0;
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i+1; j < height.length; j++) {
//                max = Math.max(max,Math.min(height[i],height[j])*(j-i));
//            }
//        }
//        return max;
    }
}
