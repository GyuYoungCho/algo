package com.ps.sw.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solutioin_5644 {
	static int T, N, M;
	static int [] user1, user2;
	static int[][] delta = {{0,0},{0,-1},{1,0},{0,1},{-1,0}};
	static class ap{
		int x,y,c,p;

		public ap(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}
	
	static List<ap> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
        	int ans = 0;
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			user1 = new int[N];
			user2 = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				user1[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				user2[i] = Integer.parseInt(st.nextToken());
			}
			
			list = new ArrayList<>();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				
				list.add(new ap(x,y,c,p));
			}
			int sx = 1, sy=1, ex=10, ey=10;
			
			ans+=result(sx,sy,ex,ey);
			for (int i = 0; i < N; i++) {
				sx+=delta[user1[i]][0];
				sy+=delta[user1[i]][1];
				ex+=delta[user2[i]][0];
				ey+=delta[user2[i]][1];
				ans+=result(sx,sy,ex,ey);
			}
			sb.append(ans).append("\n");
			
        }
        System.out.println(sb);
	}
	private static int result(int sx, int sy, int ex, int ey) {
		int[] arr1 = new int[M];
		int[] arr2 = new int[M];
		int cnt = 0;
		for(ap a : list){
	        int dis1 = Math.abs(a.x - sx) + Math.abs(a.y - sy);
	        int dis2 = Math.abs(a.x - ex) + Math.abs(a.y - ey);
	        if(dis1 <= a.c) arr1[cnt] = a.p;
	        if(dis2 <= a.c) arr2[cnt] = a.p;
	        cnt++;
	    }
		int sum = 0;
	    for(int i = 0; i < M; i++){
	        for(int j = 0; j < M; j++){
	            if(i == j){
	                sum = Math.max(sum, arr1[i]);
	                sum = Math.max(sum, arr2[i]);
	            }else{
	                sum = Math.max(sum , arr1[i] + arr2[j]);
	            }
	        }
	    }
	    return sum;
	}

}
