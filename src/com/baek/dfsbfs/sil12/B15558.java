package com.baek.dfsbfs.sil12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B15558 {
	static int N,K;
	static char arr[][];	
	static boolean visit[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        arr = new char[2][N];
        visit = new boolean[2][N];
        arr[0] = br.readLine().toCharArray();
        arr[1] = br.readLine().toCharArray();
        
        int dc[] = {-1,1,K};
        boolean flag = false;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {0,0,0});
		visit[0][0]=true;
		e:while(!q.isEmpty()) {
			int cur[]= q.poll();
			for (int i = 0; i < 3; i++) {
				int nc = cur[1]+dc[i];
				int nr = cur[0];
				int time = cur[2];
				if(i==2) {
					if(cur[0]==1)
							nr = 0;
						else
							nr = 1;
				}
				if(nc>=N) {
					flag = true;
					break e;
				}
				if(nc <= time) continue;
				if(visit[nr][nc]) continue;
				if(arr[nr][nc]=='0') continue;
				visit[nr][nc]=true;
				q.add(new int[] {nr,nc,time+1});
			}
		}
		System.out.println(flag?1:0);
	}
}
