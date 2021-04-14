package com.ps.sw.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5656 {
	static int T, N, W, H, min;
	static int[][] arr, delta = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			arr = new int[H][W];
			int total = 0;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j]!=0) total++;
				}
			}
			min = H*W +1;
			
			dfs(0,total);
			sb.append(min).append("\n");
		}
		
		System.out.println(sb);
	}
	
	
	private static void dfs(int cnt,int total) {
		if (total == 0) {
            min = 0;
			return;
        }
		
		if(cnt == N) {
			min = Math.min(min,total);
            return;
        }
		
		for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                if (arr[j][i] != 0) {
                	int [][] temp = copy(arr);
                    crush(j,i,arr[j][i]);
                	dfs(cnt+1, push());
                    arr = copy(temp);
                    break;
                }
            }
        }
	}


	private static void crush(int j, int i, int value) {
		if(value == 1) {
            int idx = j;
            while(arr[idx][i] != 0 && idx > 0) {
                arr[idx][i] = arr[idx-1][i];
                idx--;
            }
            if(idx == 0) arr[idx][i] = 0;
            return;
        }
        
        arr[j][i] = 0;
        
        for(int d = 0; d < 4; d++) {
            int x = j;
            int y = i;
            for(int k = 1; k < value; k++) {
                x += delta[d][0];
                y += delta[d][1];
                if(x < 0 || y < 0 || x >= H || y >= W) break;
                if(arr[x][y] > 1) crush(x, y, arr[x][y]);
                else arr[x][y] = 0;
            }
        }
	}


	private static int push() {        
        int amount = 0;
         
        for(int i = 0; i < W; i++) {
            int idx = H-1; 
            int h = H-1;
            while(h >= 0) {
                if(arr[h][i] != 0) {
                    arr[idx--][i] = arr[h][i];
                    amount++;
                }
                h--;
            }
            while(idx >= 0) {
                arr[idx--][i] = 0;
            }
        }
         
        return amount;        
    }
	
	static int[][] copy(int[][] map) {
        int[][] temp = new int[H][W];
        
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                temp[i][j] = map[i][j];
            }
        }
        return temp;
    }
}

//4 12 15
//9 9 9 9 9 9 9 9 9 9 9 9
//9 9 9 9 9 9 9 9 9 9 9 9
//9 9 9 9 9 9 9 9 9 9 9 9
//9 9 9 9 9 9 9 9 9 9 9 9
//9 9 9 9 9 9 9 9 9 9 9 9
//9 9 9 9 9 9 9 9 9 9 9 9
//9 9 9 9 9 9 9 9 9 9 9 9
//9 9 9 9 9 9 9 9 9 9 9 9
//9 9 9 9 9 9 9 9 9 9 9 9
//9 9 9 9 9 9 9 9 9 9 9 9
//9 9 9 9 9 9 9 9 9 9 9 9
//9 9 9 9 9 9 9 9 9 9 9 9
//9 9 9 9 9 9 9 9 9 9 9 9
//9 9 9 9 9 9 9 9 9 9 9 9
//9 9 9 9 9 9 9 9 9 9 9 9