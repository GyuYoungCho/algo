package com.test;

import java.io.*;

class SCO3 {
	static char[][] arr;
	static boolean[][] visit;
	static int[] count;
	static int all, N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr= new char[N][N];
		count = new int[N+1];
		visit = new boolean[N][N];
		for(int i=0;i<N;i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=0;j<N;j++) {
				for (int k = 0; k < N; k++) {
					if(arr[j][k]=='1' && check(j,k,i))
						count[i]++;
				}
			}
		}
		int end=0;
		for(int i=1;i<=N;i++) {
			if(count[i]==0) {
				end = i-1;
				break;
			}
			all+=count[i];
		}
		end = end!=0?end:N;
		sb.append("total: ").append(all).append("\n");
		for(int i=1;i<=end;i++) {
			sb.append("size[").append(i).append("]: ").append(count[i]).append("\n");
		}
		System.out.println(sb);
	}
	private static boolean check(int x,int y,int size) {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(x+i>=N || y+j >= N) return false;
				if(arr[x+i][y+j]=='0') return false;
			}
		}
		return true;
	}
}
