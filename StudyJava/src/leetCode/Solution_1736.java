package leetCode;

/**
 * @author hjj199612
 * @date 2021/7/24 5:06 下午
 * @description 1736. 替换隐藏数字得到的最晚时间
 * 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
 * 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
 * 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/latest-time-by-replacing-hidden-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_1736 {

    public static void main(String[] args) {

    }

    public String maximumTime(String time) {
        char[] carr = time.toCharArray();
        if(carr[0]=='?'){
            if(carr[1]>='4'&&carr[1]<='9'){
                carr[0]='1';
            }
            else {
                carr[0]='2';
            }
        }
        if(carr[1]=='?'){
            if(carr[0]=='2'){
                carr[1]='3';
            }else {
                carr[1]='9';
            }
        }
        if(carr[3]=='?'){
            carr[3]='5';
        }
        if(carr[4]=='?'){
            carr[4]='9';
        }
        return String.valueOf(carr);
    }
}
