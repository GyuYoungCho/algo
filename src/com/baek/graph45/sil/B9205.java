package com.baek.graph45.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B9205 {
	static int T, N;
	static boolean[][] visit;
	static ArrayList<int []> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()) + 2;
			visit = new boolean[N][N];
			list = new ArrayList<>();
			
			for (int i = 0; i <N; i++) {
				st = new StringTokenizer(br.readLine());
                list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int[] p1 = list.get(i);
                    int[] p2 = list.get(j);
                    
                    if (Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]) <= 1000)
                        visit[i][j] = true;
                }
            }
            
            for (int k = 0; k < N; k++) {
    			for (int i =0; i < N; i++) {
    				for (int j = 0; j < N; j++) {
    					visit[i][j] = (visit[i][k] && visit[k][j]) ? true: visit[i][j];
    				}
    			}
            }
            
			sb.append(visit[0][N-1]?"happy":"sad").append("\n");
		}
		
		System.out.println(sb);
	}

}
