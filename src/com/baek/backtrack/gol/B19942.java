package com.baek.backtrack.gol;

import java.io.*;
import java.util.*;

public class B19942 {
	
	static int N, m[] = new int[4], arr[][];
	static boolean check , visit[];
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			m[i] = stoi(st.nextToken());
		}
		arr = new int[N][5];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) 
				arr[i][j] = stoi(st.nextToken());
		}
		visit = new boolean[N];
		
	}
	
	public static void dfs(int index, int depth, int end) {
        if (depth == end) {
        	int p=0, f=0, s=0, v=0, cost=0;
        	StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                if (visit[i]) {
                    sb.append(i + 1).append(" ");
                    p += arr[i][0];
                    f += arr[i][1];
                    s += arr[i][2];
                    v += arr[i][3];
                    cost += arr[i][4];
                }
            }
             
            if (p >= m[0] && f >= m[1] && s >= m[2] && v >= m[3]) {
                check = true;
            }
            
            return;
        }

        for (int i = index; i < N; i++) {
            visit[i] = true;
            dfs(i + 1, depth + 1, end);
            visit[i] = false;
        }
    }
}
