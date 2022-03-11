package com.baek.dfsbfs.gol12;

import java.io.*;
import java.util.*;

public class B16724 {
	static int r, c, cnt;
    static int[][] map, check;
    static boolean[][] visit;
    static int[] dy = {0, 0, -1, 1}, dx = {-1, 1, 0, 0};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        check = new int[r][c];
        visit = new boolean[r][c];
        for(int i=0; i<r; i++){
            char[] str = br.readLine().toCharArray();
            for(int j=0; j<c; j++){
                char c = str[j];

                if(c == 'U') map[i][j] = 0;
                else if(c == 'D') map[i][j] = 1;
                else if(c == 'L') map[i][j] = 2;
                else map[i][j] = 3;

                check[i][j] = -1;
            }
        }

        for(int i=0; i<r; i++)
            for(int j=0; j<c; j++)
                if(!visit[i][j])
                    dfs(i, j);

        System.out.println(cnt);
    }
	
	static int dfs(int x,int y){
		if(check[x][y] != -1) return check[x][y];
		
        if(visit[x][y]) return cnt++;
        visit[x][y] = true;

        int dir = map[x][y];
        int nx = x+dx[dir];
        int ny = y+dy[dir];

        check[x][y] = dfs(nx, ny);
        return check[x][y];
    }
}
