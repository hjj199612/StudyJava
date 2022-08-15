package leetCode;


import java.util.*;

/**
 * 636. �����Ķ�ռʱ��
 * ��һ�� ���߳� CPU ��������һ������ n �������ĳ���ÿ����������һ��λ��? 0 �� n-1 ֮���Ψһ��ʶ����
 * <p>
 * �������� �洢��һ�� ����ջ �� ����һ���������ÿ�ʼʱ�����ı�ʶ����������ջ�С�����һ���������ý���ʱ�����ı�ʶ�������ջ�е�������ʶ��λ��ջ���ĺ����� ��ǰ����ִ�еĺ��� ��ÿ��һ��������ʼ���߽���ʱ�������¼һ����־������������ʶ�����ǿ�ʼ���ǽ������Լ���Ӧ��ʱ�����
 * <p>
 * ����һ������־��ɵ��б� logs ������ logs[i] ��ʾ�� i ����־��Ϣ������Ϣ��һ���� "{function_id}:{"start" | "end"}:{timestamp}" ���и�ʽ�����ַ��������磬"0:start:3" ��ζ�ű�ʶ��Ϊ 0 �ĺ���������ʱ��� 3 �� ��ʼ��ʼִ�� ���� "1:end:2" ��ζ�ű�ʶ��Ϊ 1 �ĺ���������ʱ��� 2 �� ĩβ����ִ�С�ע�⣬�������� ���ö�Σ����ܴ��ڵݹ���� ��
 * <p>
 * ������ ��ռʱ�� ����������������ڳ������к���������ִ��ʱ����ܺͣ����������������ѵ�ʱ�䲻��ú����Ķ�ռʱ�䡣���磬���һ���������������Σ�һ�ε���ִ�� 2 ��λʱ�䣬��һ�ε���ִ�� 1 ��λʱ�䣬��ô�ú����� ��ռʱ�� Ϊ 2 + 1 = 3 ��
 * <p>
 * ��������ʽ����ÿ�������� ��ռʱ�� �����е� i ���±��Ӧ��ֵ��ʾ��ʶ�� i �ĺ����Ķ�ռʱ�䡣
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/exclusive-time-of-functions
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
