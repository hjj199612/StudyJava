package src;

import java.math.BigDecimal;
import java.util.*;

public class Main extends Thread {

    public static void main(String[] args) {

        String tenant = "T20190823000160";
        System.out.println(String.format("%02d", Math.abs(tenant.hashCode() / 8 % 32)));
        System.out.println(Math.abs(tenant.hashCode() % 8));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length;
        int row = 0;
        while (row < matrix.length) {
            if (matrix[row][0] == target || matrix[row][col - 1] == target) {
                return true;
            }
            if (matrix[row][0] < target || matrix[row][col - 1] > target) {
                for (int j = 0; j < col; j++) {
                    if (matrix[row][j] == target) {
                        return true;
                    }
                }
                return false;
            }
            row++;
        }
        return false;
    }

    public static List<String> strangeSort(List<Integer> mapping, List<String> nums) {
        List<Integer> newMapping = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == mapping.get(j)) {
                    newMapping.add(j);
                    break;
                }
            }
        }
        Map<String, BigDecimal> map = new HashMap<>(nums.size());
        StringBuffer buff = new StringBuffer("");
        for (String e : nums) {
            for (int i = 0; i < e.length(); i++) {
                buff.append(newMapping.get(Integer.valueOf(String.valueOf(e.charAt(i)))));
            }
            map.put(e, new BigDecimal(buff.toString()));
            buff.delete(0, buff.length());
        }
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size() - i - 1; j++) {
                if (map.get(nums.get(j)).compareTo(map.get(nums.get(j + 1))) > 0) {
                    String x = nums.get(j);
                    nums.set(j, nums.get(j + 1));
                    nums.set(j + 1, x);
                }
            }
        }
        return nums;
    }

    public static int maximumGain(String s, int x, int y) {
        int sum = 0;
        int size = s.length();
        StringBuffer str = new StringBuffer(s);
        if (x >= y) {
            for (int i = 0; i < str.length() - 1; ) {
                if (str.charAt(i) == 'a' && str.charAt(i + 1) == 'b') {
                    str.delete(i, i + 2);
                    size = str.length();
                    sum += x;
                    if (i != 0) {
                        i--;
                    }
                } else {
                    i++;
                }
            }
            for (int i = 0; i < str.length() - 1; ) {
                if (str.charAt(i) == 'b' && str.charAt(i + 1) == 'a') {
                    str.delete(i, i + 2);
                    size = str.length();
                    sum += y;
                    if (i != 0) {
                        i--;
                    }
                } else {
                    i++;
                }
            }
        } else {
            for (int i = 0; i < str.length() - 1; ) {
                if (str.charAt(i) == 'b' && str.charAt(i + 1) == 'a') {
                    str.delete(i, i + 2);
                    size = str.length();
                    sum += y;
                    if (i != 0) {
                        i--;
                    }
                } else {
                    i++;
                }
            }
            for (int i = 0; i < str.length() - 1; ) {
                if (str.charAt(i) == 'a' && str.charAt(i + 1) == 'b') {
                    str.delete(i, i + 2);
                    size = str.length();
                    sum += x;
                    if (i != 0) {
                        i--;
                    }
                } else {
                    i++;
                }
            }

        }
        return sum;
    }

    public static int weightCapacity(int[] weights, int maxCapacity) {
        int n = weights.length;
        int[][] arr = new int[n][maxCapacity + 1];
        for (int i = 1; i <= maxCapacity; i++) {
            if (i >= weights[0]) {
                arr[0][i] = weights[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= maxCapacity; j++) {
                //要
                if (weights[i] <= j) {
                    int result1 = arr[i - 1][j - weights[i]] + weights[i];
                    //不要
                    int result2 = arr[i - 1][j];
                    arr[i][j] = result1 > result2 ? result1 : result2;
                } else {
                    arr[i][j] = arr[i - 1][j];
                }
            }
        }
        return arr[n - 1][maxCapacity];
    }

    public String evaluation(String expression) {
        // write your code here
        String[] arr = expression.split(" ");
        Stack<String> stock = new Stack<>();
        stock.push("true");
        stock.push("and");
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 1) {
                if (!"and".equals(arr[i]) && !"or".equals(arr[i])) {
                    return "error";
                }
                stock.push(arr[i]);
            } else {
                if (!"true".equals(arr[i]) && !"false".equals(arr[i])) {
                    return "error";
                }
                if ("and".equals(stock.peek())) {
                    stock.pop();
                    if ("true".equals(stock.peek())) {
                        stock.pop();
                        stock.push(arr[i]);
                    }
                } else if ("or".equals(stock.peek())) {
                    stock.push(arr[i]);
                }
            }
        }
        List<String> list = new ArrayList<>(stock.size());
        list.addAll(stock);
        for (String e : list) {
            if ("true".equals(e)) {
                return "true";
            }
        }
        return "false";
    }

    public static int maxWeightCapacity(int[] weights, int maxCapacity, int i, int[][] arr) {
        if (maxCapacity == 0) {
            return 0;
        }
        if (arr[maxCapacity][i] != -1) {
            return arr[maxCapacity][i];
        }
        if (i == weights.length - 1) {
            if (weights[i] > maxCapacity) {
                arr[maxCapacity][i] = 0;
            } else {
                arr[maxCapacity][i] = weights[i];
            }
            return arr[maxCapacity][i];
        }
        if (weights[i] > maxCapacity) {//要不了
            if (arr[maxCapacity][i + 1] == -1) {
                arr[maxCapacity][i + 1] = maxWeightCapacity(weights, maxCapacity, i + 1, arr);
            }
            return arr[maxCapacity][i + 1];
        } else {
            //要
            if (arr[maxCapacity - weights[i]][i + 1] == -1) {
                arr[maxCapacity - weights[i]][i + 1] = maxWeightCapacity(weights, maxCapacity - weights[i], i + 1, arr);
            }
            //不要
            if (arr[maxCapacity][i + 1] == -1) {
                arr[maxCapacity][i + 1] = maxWeightCapacity(weights, maxCapacity, i + 1, arr);
            }
            arr[maxCapacity][i] = (arr[maxCapacity - weights[i]][i + 1] + weights[i]) > arr[maxCapacity][i + 1] ? (arr[maxCapacity - weights[i]][i + 1] + weights[i]) : arr[maxCapacity][i + 1];
            return arr[maxCapacity][i];
        }
    }


    public static int solve(char[][] matrix) {
        // write code here
        return getNum(matrix, 0, matrix[0].length - 1, 0, matrix.length - 1);
    }

    public static int getNum(char[][] matrix, int is, int ie, int js, int je) {
        if (is > ie || js > je) return 0;
        if (is == ie || js == je) return 1;
        if (isSquart(matrix, is, ie, js, je)) {
            return (Math.min((ie - is), (je - js)) + 1) * (Math.min((ie - is), (je - js)) + 1);
        } else {
            int m1 = getNum(matrix, is, ie - 1, js, je - 1);
            int m2 = getNum(matrix, is + 1, ie, js, je - 1);
            int m3 = getNum(matrix, is, ie - 1, js + 1, je);
            int m4 = getNum(matrix, is + 1, ie, js + 1, je);
            int max = Math.max(m1, m2);
            max = Math.max(max, m3);
            max = Math.max(max, m4);
            return max;
        }
    }

    public static boolean isSquart(char[][] matrix, int is, int ie, int js, int je) {
        if ((ie - is) <= (je - js)) {
            for (int i = js, j = js + ie - is; i <= je && j <= je; i++, j++) {
                boolean f = false;
                for (int x = i; x <= j; x++) {
                    for (int y = is; y <= ie; y++) {
                        if (matrix[x][y] == 0) {
                            f = true;
                            break;
                        }
                    }
                    if (f) {
                        break;
                    }
                }
                if (!f) {
                    return true;
                }
            }
            return false;
        } else {
            for (int i = is, j = is + je - js; i <= ie && j <= je; i++, j++) {
                boolean f = false;
                for (int x = i; x <= j; x++) {
                    for (int y = js; y <= je; y++) {
                        if (matrix[x][y] == 0) {
                            f = true;
                            break;
                        }
                    }
                    if (f) {
                        break;
                    }
                }
                if (!f) {
                    return true;
                }
            }
            return false;
        }
    }

    public static String solve(int M, int N) {
        if (M == 0) return "0";
        boolean flag = true;
        if (M < 0) {
            M = -M;
            flag = false;
        }
        StringBuffer res = new StringBuffer();
        String hex = "0123456789ABCDEF";
        while (M != 0) {
            res.append(hex.charAt(M % N));
            M = M / N;
        }
        return flag == true ? res.reverse().toString() : "-" + res.reverse().toString();
    }

    public static long getMaxWater(int[] arr, int start, int end) {
        if (end - start <= 1) return 0;
        int first = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] > arr[first]) {
                first = i;
            }
        }
        int second = (end == first ? end - 1 : end);
        for (int i = end - 1; i >= start; i--) {
            if (arr[i] > arr[second] && (i != first)) {
                second = i;
            }
        }
        long middleValue = 0;
        long leftValue = 0;
        long rightValue = 0;
        if ((first - second) > 1 || (first - second) < -1) {
            for (int i = Math.min(first, second) + 1; i < Math.max(first, second) - 1; i++) {
                middleValue += (Math.min(arr[second], arr[first]) - arr[i]);
            }
        }
        if (Math.min(first, second) - start > 1) {
            leftValue = getMaxWater(arr, start, Math.min(first, second));
        }
        if (end - Math.max(first, second) > 1) {
            rightValue = getMaxWater(arr, Math.max(first, second), end);
        }
        return middleValue + leftValue + rightValue;
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList(k);
        for (int i = 0; i < k; i++) {
            res.add(Integer.MAX_VALUE);
        }
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < k; j++) {
                if (res.get(j) >= input[i]) {
                    for (int h = k - 1; h > j; h--) {
                        res.set(h, res.get(h - 1));
                    }
                    res.set(j, input[i]);
                    break;
                }

            }
        }
        return res;

    }

    private static long myHashCode(String str) {
        long h = 0;
        if (h == 0) {
            int off = 0;
            char val[] = str.toCharArray();
            long len = str.length();

            for (long i = 0; i < len; i++) {
                h = 31 * h + val[off++];
            }
        }
        return h;
    }

    public static int search(int[] A, int target) {
        // write code here
        int x = 0;
        int index = -1;
        int y = A[0];
        for (int i = 0; i < A.length; i++) {
            if (target == A[i]) {
                index = i;
            }
            if (i == A.length - 1) {
                if ((A[i] > A[0] && A[i] < A[i - 1]) ||
                        (A[i] < A[0] && A[i] > A[i - 1])) {
                    x = 0;
                }
            }
            if (i == 0) {
                if ((A[i] > A[A.length - 1] && A[i] < A[i + 1]) ||
                        (A[i] < A[A.length - 1] && A[i] > A[i + 1])) {
                    x = 0;
                }
            }
            if (i > 0 && i < A.length - 1) {
                if ((A[i] > A[i + 1] && A[i] < A[i - 1]) ||
                        (A[i] < A[i + 1] && A[i] > A[i - 1])) {
                    x = i;
                }
            }
        }
        return x + index;
    }

    public static String GeneSimilarity(String Gene1, String Gene2) {
        Set<Character> set = new HashSet<>(4);
        set.add('A');
        set.add('C');
        set.add('G');
        set.add('T');
        TreeMap<Integer, Character> treeMap = new TreeMap<>();
        StringBuffer count = new StringBuffer("");
        int sumAll = 0;
        for (int i = 0; i < Gene1.length(); i++) {
            if (set.contains(Gene1.charAt(i))) {
                int c = Integer.valueOf(count.toString());
                sumAll += c;
                treeMap.put(sumAll, Gene1.charAt(i));
                count.delete(0, count.length());
            } else {
                count.append(Gene1.charAt(i));
            }
        }
        List<Integer> list = new ArrayList<>();
        list.addAll(treeMap.keySet());
        sumAll = 0;
        int sum = 0;
        int j = 0;
        for (int i = 0; i < Gene2.length(); i++) {
            if (set.contains(Gene2.charAt(i))) {
                int c = Integer.valueOf(count.toString());
                for (; j < list.size(); ) {
                    char x = treeMap.get(list.get(j));
                    if (list.get(j) > sumAll) {
                        int a = list.get(j) - sumAll;
                        if (a >= c) {
                            if (Gene2.charAt(i) == x) {
                                sum += c;
                            }
                            sumAll += c;
                            if (a == c) {
                                j++;
                            }
                            break;
                        } else {
                            int m = list.get(j) - sumAll;
                            if (Gene2.charAt(i) == x) {
                                sum += m;
                            }
                            sumAll += m;
                            c -= m;
                        }
                    } else {
                        j++;
                    }
                }
                count.delete(0, count.length());
            } else {
                count.append(Gene2.charAt(i));
            }

        }
        return sum + "/" + sumAll;
    }

    public List<List<Integer>> twoSumVII(int[] nums, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    List<Integer> row = new ArrayList<>(2);
                    row.add(i);
                    row.add(j);
                    result.add(row);
                    continue;
                }
            }
        }
        return result;
    }
}