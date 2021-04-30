package com.baek.imple.gol123;

import java.io.*;
import java.util.*;

public class B21611 {
	static int N,M,D,P,ans;
	static int arr[][];
	static int dir[] = {3,1,0,2};
	static LinkedList<Integer> q = new LinkedList<>(); 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int dx=1,dy=-1,sx=N/2,sy=N/2;
		e:for (int i = 1; i < N; i++) {
			for (int j = 0; j < 2*i; j++) {
				if(j<i) {
					sy+=dy;
					if(arr[sx][sy]==0) break e;
					q.add(arr[sx][sy]);
				}else {
					sx+=dx;
					if(arr[sx][sy]==0) break e;
					q.add(arr[sx][sy]);
				}
			}
			dy*=-1;
			dx*=-1;
		}
		for (int i = N-2; i >=0; i--) {
			if(arr[0][i]==0) break;
			q.add(arr[0][i]);
		}
		
		for (int i = 0; i <M; i++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken())-1;
			P = Integer.parseInt(st.nextToken());
			simulate(D,P);
		}
		System.out.println(ans);
	}
	
	
	private static void simulate(int d, int p) {
		int idx = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= p; i++){
			idx+=dir[d]*(2*i);
			list.add(idx);
			idx+=(3-dir[d])*(2*i) + (2*i+1);
		}
		
		for(int i=p-1;i>=0;i--) {
			if(list.get(i)<q.size()) {
				q.remove(list.get(i).intValue());
			}
		}
		
		boolean flag;
		while(!q.isEmpty()) {
			flag = false;
			int size=q.size()-1;
			if(size<2) break;
			int a = q.poll();
			int cnt=1;
			while(size-->0) {
				int cur = q.poll();
				if(cur==a) cnt++;
				else {
					if (cnt<4) {
						while(cnt-->0) q.offer(a);
					}else {
						flag = true;
						ans+=cnt*a;
					}
					cnt=1;
				}
				a= cur;
			}
			if (cnt<4) {
				while(cnt-->0) q.offer(a);
			}else {
				ans+=cnt*a;
				flag = true;
			}
			
			cnt=1;
			if(!flag) break;
		}
		
		if(!q.isEmpty()) {
			int size=q.size()-1;
			int a = q.poll();
			int cnt=1;
			int s=0;
			while(!q.isEmpty() && size-->0) {
				int cur = q.poll();
				if(cur==a) cnt++;
				else {
					q.offer(cnt);
					q.offer(a);
					s+=2;
					cnt=1;
				}
				a= cur;
				if (s==N*N-1) {
					while(size-->0) q.poll();
				}
			}
			if (s < N*N-1) {
				q.offer(cnt);
				q.offer(a);
			}
		}
	}
}
