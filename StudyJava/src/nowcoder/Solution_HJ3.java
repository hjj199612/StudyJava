package nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_HJ3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ns = br.readLine();
        int n = Integer.parseInt(ns);
        boolean[] arr = new boolean[501];
        while (n-- > 0) {
            String s = br.readLine();
            int x = Integer.parseInt(s);
            arr[x] = true;
        }
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]) System.out.println(i);
        }
    }
}
