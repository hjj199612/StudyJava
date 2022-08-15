package leetCode;


import java.util.*;

/**
 * 636. 函数的独占时间
 * 有一个 单线程 CPU 正在运行一个含有 n 道函数的程序。每道函数都有一个位于? 0 和 n-1 之间的唯一标识符。
 * <p>
 * 函数调用 存储在一个 调用栈 上 ：当一个函数调用开始时，它的标识符将会推入栈中。而当一个函数调用结束时，它的标识符将会从栈中弹出。标识符位于栈顶的函数是 当前正在执行的函数 。每当一个函数开始或者结束时，将会记录一条日志，包括函数标识符、是开始还是结束、以及相应的时间戳。
 * <p>
 * 给你一个由日志组成的列表 logs ，其中 logs[i] 表示第 i 条日志消息，该消息是一个按 "{function_id}:{"start" | "end"}:{timestamp}" 进行格式化的字符串。例如，"0:start:3" 意味着标识符为 0 的函数调用在时间戳 3 的 起始开始执行 ；而 "1:end:2" 意味着标识符为 1 的函数调用在时间戳 2 的 末尾结束执行。注意，函数可以 调用多次，可能存在递归调用 。
 * <p>
 * 函数的 独占时间 定义是在这个函数在程序所有函数调用中执行时间的总和，调用其他函数花费的时间不算该函数的独占时间。例如，如果一个函数被调用两次，一次调用执行 2 单位时间，另一次调用执行 1 单位时间，那么该函数的 独占时间 为 2 + 1 = 3 。
 * <p>
 * 以数组形式返回每个函数的 独占时间 ，其中第 i 个下标对应的值表示标识符 i 的函数的独占时间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/exclusive-time-of-functions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_636 {

    public static void main(String[] args) {
        Solution_636 solution_636 = new Solution_636();
        List<String> strings = Arrays.asList("0:start:0", "0:end:0", "1:start:1", "1:end:1", "2:start:2", "2:end:2", "2:start:3", "2:end:3");
        System.out.println(Arrays.toString(solution_636.exclusiveTime(3, strings)));
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<String[]> stack = new Stack<>();
        stack.push(logs.get(0).split(":"));
        String[] pre = logs.get(0).split(":");
        for (int i = 1; i < logs.size(); i++) {
            String[] cur = logs.get(i).split(":");
            if (cur[1].equals("start")) {
                if (pre[1].equals("start")) {
                    res[Integer.parseInt(pre[0])] += Integer.parseInt(cur[2]) - Integer.parseInt(pre[2]);
                } else {
                    if(stack.empty()){
                        res[Integer.parseInt(cur[0])] += Integer.parseInt(cur[2]) - Integer.parseInt(pre[2]) - 1;
                    }else {
                        String[] last = stack.peek();
                        res[Integer.parseInt(last[0])] += Integer.parseInt(cur[2]) - Integer.parseInt(pre[2]) - 1;
                    }
                }
                stack.push(cur);
            } else {
                String[] last = stack.pop();
                if (pre[1].equals("end")) {
                    res[Integer.parseInt(cur[0])] += Integer.parseInt(cur[2]) - Integer.parseInt(pre[2]);
                } else {
                    res[Integer.parseInt(cur[0])] += Integer.parseInt(cur[2]) - Integer.parseInt(pre[2]) + 1;
                }
            }
            pre = cur;
        }
        return res;
    }
}
