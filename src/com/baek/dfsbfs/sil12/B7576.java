package com.baek.dfsbfs.sil12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7576 {
	static int N,M, ans;
	static int[][] arr, delta = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1) q.offer(new int[] {i,j,0});
            }
        }
        
        while(!q.isEmpty()) {
        	
            int[] cur = q.poll();
            ans = cur[2];
            for(int i=0; i<4; i++) {
                int nx = cur[0] + delta[i][0];
                int ny = cur[1] + delta[i][1];
 
                if(0 <= nx && nx < M && 0 <= ny && ny < N) {
                    if(arr[nx][ny] == 0) {
                        arr[nx][ny] = 1;
                        q.add(new int[] {nx,ny,ans+1});
                    }
                }
            }
        }
        
        System.out.println(check()?ans:-1);
	}
	static boolean check() {
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

}
