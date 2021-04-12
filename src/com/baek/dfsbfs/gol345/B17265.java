package com.baek.dfsbfs.gol345;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17265 {
	static int N,max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static char arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        
        for (int i = 0; i <N; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j <N; j++) {
				arr[i][j] = st.nextToken().charAt(0);
			}
		}
        
        dfs(0, 0, arr[0][0]-'0', arr[0][0]);
		System.out.println(max + " " + min);
	}
	
	public static void dfs(int x, int y, int result, char oper) {
		int get = arr[x][y] - '0';
		if(get >= 0 && get <= 5) {
			if(oper == '+')
				result += get;
			else if(oper == '-')
				result -= get;
			else if(oper == '*')
				result *= get;
		} else { 
			oper = arr[x][y];
		}
		
		if(x == N-1 && y == N-1) {
			max = Math.max(result, max);
			min = Math.min(result, min);
			return;
		}

		if(x < N-1) {
			dfs(x+1, y, result, oper);
		}

		if(y < N-1) {
			dfs(x, y+1, result, oper);
		}
	}
}
