package com.baek.dfsbfs.gol12;

import java.io.*;
import java.util.*;


public class B17472 {
	static int N,M,cnt,max;
	static int[] get, rank;
	static int[][] arr, delta = {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean[][] field;
	static boolean[][][] visit; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		field = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				arr[i][j] = (arr[i][j]==1?-1:0);
			}
		}
		
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == -1) {
                    counting(i, j, ++cnt);
                }
            }
        }
		
		get = new int[cnt+1];
		rank = new int[cnt+1];
        for (int i = 1; i <= cnt; i++) {
            get[i] = i;
        }
		
		PriorityQueue <int[]> pq = new PriorityQueue<>((x, y) -> x[2]- y[2]);
		
		for (int i = 1; i <= cnt; i++) {
            for (int j = i + 1; j <= cnt; j++) {
                int cost = bridge(i, j);
                
                if (cost != 0)
                    pq.add(new int[] { i, j, cost });
            }
        }
		
		int ans = 0;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int x = findSet(now[0]);
            int y = findSet(now[1]);
            if (x != y) {
                union(now[0], now[1]);
                ans += now[2];
            }
        }

        boolean flag = true;
        int a = findSet(1);
        for (int i = 1; i <= cnt; i++) {
            if (findSet(i) != a) {
                flag = false;
                break;
            }
        }
		System.out.println(flag?ans:-1);
	}
	

	private static void counting(int i, int j, int k) {
		arr[i][j] = k;
        for (int d = 0; d < 4; d++) {
            int nx = i + delta[d][0];
            int ny = j + delta[d][1];
            if (inside(nx, ny) && arr[nx][ny] == -1) {
                counting(nx, ny, k);
            }
        }
	}
	
	private static int bridge(int start, int end) {
		visit = new boolean[N][M][4];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != start)
                    continue;
                for (int d = 0; d < 4; d++) {
                    int r = i + delta[d][0];
                    int c = j + delta[d][1];
                    if (!inside(r, c) || arr[r][c] != 0)
                        continue;
                    q.add(new int[] { r, c, 0, d });
                    visit[r][c][d] = true;
                }
            }
        }
        
        int ret = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (arr[now[0]][now[1]] == end) {
                if (now[2] == 1)
                    continue;
                ret = now[2];
                break;
            }
            int nr = now[0] + delta[now[3]][0];
            int nc = now[1] + delta[now[3]][1];

            if (inside(nr, nc) && !visit[nr][nc][now[3]]
                    && (arr[nr][nc] == 0 || arr[nr][nc] == end)) {
                visit[nr][nc][now[3]] = true;
                q.add(new int[] { nr, nc, now[2] + 1, now[3] });
            }
        }

        return ret;
	}
	

	private static int findSet(int a) {
		if(get[a]==a) return a;
		return get[a] = findSet(get[a]);
	}
	
	private static void union(int a, int b) {
		int aroot = findSet(a);
		int broot = findSet(b);
		if(rank[aroot] < rank[broot])
			get[aroot] = broot;
		else {
			get[broot] = aroot;
			if(rank[aroot]==rank[broot]) rank[aroot]++;
		}
	}
	
	public static boolean inside(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
