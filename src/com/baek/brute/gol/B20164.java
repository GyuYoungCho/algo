package com.baek.brute.gol;

import java.io.*;
import java.util.*;

public class B20164 {

	static int n;
    static int min, max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        max = 0;
        dfs(n, getOddCnt(n));
        sb.append(min).append(" ").append(max);
        System.out.println(sb);
    }

    static void dfs(int num, int cnt) {
        if (num <= 9) {
            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
            return;
        }

        if (num <= 99) {
            int next = (num / 10) + (num % 10);
            dfs(next, getOddCnt(next) + cnt);
        }

        String s = Integer.toString(num);

        for (int i = 0; i < s.length() - 2; i++) {
            for (int j = i + 1; j < s.length() - 1; j++) {
                String x1 = s.substring(0, i + 1);
                String x2 = s.substring(i + 1, j + 1);
                String x3 = s.substring(j + 1, s.length());

                int nx = Integer.parseInt(x1) + Integer.parseInt(x2) + Integer.parseInt(x3);
                dfs(nx, getOddCnt(nx) + cnt);
            }
        }
    }

    static int getOddCnt(int x) {
        int ret = 0;
        while (x > 0) {
            int digit = x % 10;
            if (digit % 2 == 1) ret++;
            x /= 10;
        }
        return ret;
    }
}
