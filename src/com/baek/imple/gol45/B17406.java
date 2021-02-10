package com.baek.imple.gol45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class B17406 {
	static int N, M, K,R,C,S, nx, ny, temp, value, all_min = Integer.MAX_VALUE;
	static int[][] arr, rc;
	static int[][] delta = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		rc = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			rc[i][0] = Integer.parseInt(st.nextToken())-1;
			rc[i][1] = Integer.parseInt(st.nextToken())-1;
			rc[i][2] = Integer.parseInt(st.nextToken());
		}
		
		visited = new boolean[K];
		search(0, arr);
		System.out.println(all_min);
	}
	
	private static void search(int n,int[][] orig){
	    if(n == K){
	        getmin(orig);
	        return;
	    }
	
	    for(int i = 0; i < K; i++){
	        if(!visited[i]){
	            int[][] copy = deepCopy(orig);
	
	            int[] op = rc[i];
	            int r = op[0], c = op[1], s = op[2];
	
	            rotate(r,c,s,copy);
	            
	            visited[i] = true;
	            search(n + 1,copy);
	            visited[i] = false;
	        }
	    }
	}
	
	private static void rotate(int r,int c, int s,int[][] copy) {
		for (int i = 0; i < s; i++) {
			int x = r-s+i, y = c-s+i;
			temp = 0;
			value = copy[x][y];
			copy[x][y] = copy[x+1][y];
			int d = 0;
			while (d < 4) {
				nx = x + delta[d][0];
				ny = y + delta[d][1];
				if (nx >= r-s+i && ny >= c-s+i && nx <= r+s-i && ny <= c+s-i) {
					temp = copy[nx][ny];
					copy[nx][ny] = value;
					value = temp;
					x = nx;
					y = ny;
				}else
					d++;
			}
		}
	}
	
	
	static void getmin(int[][] orig) {
		int min = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			int sum = 0;
			for(int j=0;j<M;j++) {
				sum+= orig[i][j];
			}
			min = min > sum ? sum : min;
		}
		all_min = all_min > min ? min : all_min;
	}
	
	static int[][] deepCopy(int[][] orig) {
        if(orig == null) return null;
        int[][] cp1 = new int[orig.length][orig[0].length];
        
        for(int i=0; i<orig.length; i++){
            cp1[i] = orig[i].clone();
        }
        return cp1;
    }
}
