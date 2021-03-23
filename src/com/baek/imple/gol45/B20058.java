package com.baek.imple.gol45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20058 {
	static int N, Q, sum, count, max;
	static int arr[][], delta[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static boolean[][] visit, check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		arr = new int[1<<N][1<<N];
		for (int i = 0; i < 1<<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 1<<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			int K  = Integer.parseInt(st.nextToken());
			rotate(K);
			melt();
		}
		
		visit = new boolean[1<<N][1<<N];
		
		for (int i = 0; i < 1<<N; i++) {
			for (int j = 0; j < 1<<N; j++) {
				visit[i][j] = true;
				sum+=arr[i][j];
				count=arr[i][j]!=0?1:0;
				counting(i,j);
				max = Math.max(count, max);
			}
		}
		
		System.out.println(sum+"\n"+max);
	}
	
	private static void rotate(int r) {
		int[][] copy  = new int[1<<N][1<<N];
		int k = 1<<r;
		for(int i=0;i<1<<N;i+=k) {
			for(int j=0;j<1<<N;j+=k) {
				for(int a = 0; a < k; a++) {
                    for(int b = 0; b < k ; b++) {
                        copy[i+b][j+k-a-1] = arr[i+a][j+b];
                    }
                }
			}
		}
		arr = copy;
	}
	
	public static void melt() {
        check = new boolean[1<<N][1<<N];
        for(int i = 0; i < 1<<N; i++) {
            for(int j = 0; j < 1<<N; j++) {
            	if(arr[i][j]==0) continue;
                int count = 0;
                for(int k = 0; k < 4; k++) {
                    int nx = i + delta[k][0];
                    int ny = j + delta[k][1];
                    
                    if(inside(nx, ny) && arr[nx][ny] >= 1)
                    	count++;
                }
                
                if(count < 3) {
                    check[i][j] = true;
                }
            }
        }
        
        for(int i = 0; i < 1<<N; i++) {
            for(int j = 0; j < 1<<N; j++) {
            	if(check[i][j]) arr[i][j]--;
            }
        }
    }
	
	private static void counting(int x, int y) {
		for(int d=0;d<4;d++) {
			int nx = x + delta[d][0];
			int ny = y + delta[d][1];
			
			if(inside(nx,ny)&&!visit[nx][ny] && arr[nx][ny]>=1) {
				visit[nx][ny] = true;
				count++;
				counting(nx,ny);
			}
		}
	}
    
    public static boolean inside(int x, int y) {
        return x >= 0 && y >= 0 && x < 1<<N && y < 1<<N;
    }
}
