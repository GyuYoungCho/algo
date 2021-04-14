package com.baek.imple.gol45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17144 {
	static int N,M,S,ans;
	static int[][] arr, delta = {{1,0},{0,1},{-1,0},{0,-1}};
	static int[] con = new int[2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0,t=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==-1) con[t++] = i;
            }
        }
        
        for (int s = 0; s < S; s++) {
        	for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(arr[i][j]>0) q.add(new int[] {i,j,arr[i][j]});
                }
            }
        	
        	while(!q.isEmpty()) {
                int[] cur = q.poll();
                int cnt=0;
                int amount = cur[2] / 5;
                for(int i=0; i<4; i++) {
                    int nx = cur[0] + delta[i][0];
                    int ny = cur[1] + delta[i][1];
     
                    if(inside(nx,ny) && arr[nx][ny]!=-1) {
                        arr[nx][ny] +=  amount;
                    	cnt++;
                    }
                }
                
                arr[cur[0]][cur[1]] -= amount*cnt;
                if(arr[cur[0]][cur[1]]<0) arr[cur[0]][cur[1]]=0;
            }
        	
        	for (int i = con[0]-1; i > 0; i--) {
    			arr[i][0] = arr[i - 1][0];
    		}
    		// 왼쪽으로 당기기
    		for (int i = 0; i < M - 1; i++) {
    			arr[0][i] = arr[0][i + 1];
    		}
    		
    		for (int i = 0; i < con[0]; i++) {
    			arr[i][M - 1] = arr[i + 1][M - 1];
    		}
    		
    		for (int i = M - 1; i > 1; i--) {
    			arr[con[0]][i] = arr[con[0]][i-1];
    			if ( i== 2) arr[con[0]][i-1] =0;
    		}
    		
    		arr[con[0]][0] = -1;
    		
    		for (int i =con[1]+1; i < N-1; i++) {
    			arr[i][0] = arr[i + 1][0];
    		}
    		
    		for (int i = 0; i < M - 1; i++) {
    			arr[N-1][i] = arr[N-1][i + 1];
    		}
    		
    		for (int i = N-1; i > con[1]; i--) {
    			arr[i][M - 1] = arr[i - 1][M - 1];
    		}
    		
    		for (int i = M - 1; i > 1; i--) {
    		
    			arr[con[1]][i] =arr[con[1]][i - 1] ;
    			if ( i== 2) arr[con[1]][i-1] =0;
    		}
    		arr[con[1]][0] = -1;
    		
        }
        int ans=0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j]>0) ans+=arr[i][j];
            }
        }
        
        System.out.println(ans);
	}
	public static boolean inside(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
