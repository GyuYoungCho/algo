package com.ps.sw.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// dfs + core¿¡¼­ 4¹æ..?

public class Solution_1767 {

	static class Core {
		int x, y;

		public Core(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int T, N, cnt, coremax, distmin;
	static boolean[][] arr;
	static int[][] delta = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static List<Core> corelist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine().trim());

		for (int t = 1; t <= T; t++) {
			cnt = 0;
			distmin = 144;
			coremax = 0;
			corelist = new ArrayList<>();
			N = Integer.parseInt(br.readLine().trim());
			arr = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = st.nextToken().charAt(0) == '1';
					if (arr[i][j] && (i != 0 && i != N - 1 && j != 0 && j != N - 1)) {
						cnt++;
						corelist.add(new Core(i, j));
					}
				}
			}
			
			dfs(0, 0, 0);
			sb.append("#").append(t).append(" ").append(distmin).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int idx, int core, int line) {
		if(idx ==cnt) {
			if(coremax < core) {
				coremax = core;
				distmin = line;
			}
			else if(coremax==core) {
				if(distmin > line) distmin = line;
			}
			
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			
			boolean flag = true;
			int nx = corelist.get(idx).x;
            int ny = corelist.get(idx).y;
            int len = 0;
            while (true) {
            	nx += delta[i][0];
                ny += delta[i][1];
                if(!inside(nx,ny)) {
                	break;
                }
                if(arr[nx][ny]) {
                	flag = false;
                	break;
                }
                
                len++;
                arr[nx][ny] = true;
            }
            
            if(flag) {
            	dfs(idx+1,core+1,line + len);
            	
            	int getx = corelist.get(idx).x;
                int gety = corelist.get(idx).y;
                
            	while (true) {
                	getx += delta[i][0];
                    gety += delta[i][1];
                    if(!inside(getx,gety)) {
                    	break;
                    }
                    arr[getx][gety] = false;
                }
            	
            }else
            	dfs(idx+1,core,line);
        }

	}

	private static boolean inside(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}
