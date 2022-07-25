package leetCode;

public class Solution_1184 {

    public static void main(String[] args) {

    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int res1 = 0, res2 = 0;
        boolean flag = true;
        for (int i = 0; i < distance.length; i++) {
            if (start == i || destination == i) flag = !flag;
            if (flag) res1 += distance[i];
            else res2 += distance[i];
        }
        return Math.min(res1, res2);
    }
}
