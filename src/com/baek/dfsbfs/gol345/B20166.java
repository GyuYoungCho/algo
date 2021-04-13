package com.baek.dfsbfs.gol345;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B20166 {
	static int N,M,K;
	static char[][] arr;
	static String[] likestr;
	static int[][] delta = {{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
	static HashMap<String, Integer> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		likestr = new String[K];
		for(int i=0;i<N;i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				String key = Character.toString(arr[i][j]);
				map.put(key,map.getOrDefault(key,0) + 1);
				go(i,j,1,key);
			}
		}
		
		for(int i=0;i<K;i++) {
			sb.append(map.getOrDefault(br.readLine(), 0)).append("\n");
		}
		System.out.println(sb);
	}
	private static void go(int x, int y, int depth, String key) {
		if(depth==5) return;
		
		for(int d=0;d<8;d++) {
			int nx = x + delta[d][0];
			int ny = y + delta[d][1];
			
			if (nx < 0) nx = N-1;
			if (ny < 0) ny = M-1;
			if (nx > N-1) nx = 0;
			if (ny > M-1) ny = 0;
			

			String newkey = key + arr[nx][ny];
			map.put(newkey, map.getOrDefault(newkey, 0) + 1);
			go(nx,ny,depth+1,newkey);
		}
	}

}
