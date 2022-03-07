package com.baek.backtrack.gol;

import java.io.*;
import java.util.*;

public class B1799 {
	static boolean[][] area = new boolean[2][20];
    static int[][] map;
    static int max;
    static int n;

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int b=0;
        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0, 0, 0);
        b += max;
        max = 0;
        dfs(0, 1, 0, 1);
        b += max;
        System.out.println(b);
    }

    public static void dfs(int x, int y, int cnt, int color) {
        if(y >= n) {
            if(color == 0) {
                if((x+1) % 2 == 0) dfs(x+1, 0, cnt, color);
                else dfs(x+1, 1, cnt, color);
            }
            else {
                if((x+1) % 2 != 0) dfs(x+1, 0, cnt, color);
                else dfs(x+1, 1, cnt, color);
            }
            return;
        }

        if(x >= n) {
            max = Math.max(max, cnt);
            return;
        }

        if(map[x][y] == 1 && !area[0][(x-y)+(n-1)] && !area[1][x+y]) {
            area[0][(x-y)+(n-1)] = true;
            area[1][x+y] = true;

            dfs(x, y+2, cnt+1, color);

            area[0][(x-y)+(n-1)] = false;
            area[1][x+y] = false;
        }
        dfs(x, y+2, cnt, color);
    }
}

