package com.baek.brute.sil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B18428 {
	static int N;
	static char[][] map;
	static int[][] delta = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	
	static Queue<int[]> q = new LinkedList<>();
	static LinkedList<int[]> install = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j]=='T')	
					q.offer(new int[] { i, j });
				else if(map[i][j]=='X')	
					install.offer(new int[] { i, j });
			}
		}
		
		dfs(0,0);
		System.out.println("NO");
	}
	
	private static void dfs(int len, int idx)
	{
	    if (len == 3) {
	        for (int[] i : q) {
	            if (check(i)) {
	                return;
	            }
	        }
	        System.out.println("YES");
	        System.exit(0);
	    }
	 
	    for (int i = idx; i < install.size(); i++) {
	        map[install.get(i)[0]][install.get(i)[1]] = 'O';
	        dfs(len + 1, i + 1);
	        map[install.get(i)[0]][install.get(i)[1]] = 'X';
	    }
	}
	
	private static boolean check(int[] ch)
	{
	    for (int i = 0; i < 4; i++) {    
	        
	    	int nx = ch[0];
	    	int ny = ch[1];
	        while (true)
	        {
	            nx += delta[i][0];
	            ny += delta[i][1];
	            if(!inside(nx,ny)) break;
	            if (map[nx][ny] == 'O') {
	                break;
	            }
	            else if (map[nx][ny] == 'S') {
	                return true;
	            }
	        }
	    }
	    return false;
	}

	private static boolean inside(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
