package com.baek.dfsbfs.gol345;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B16234 {
	
	private static class Point{
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, L, R, nx,ny, cnt=0;
	static boolean flag;
	static int[][] arr, delta = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static boolean[][] visited; // bfs 하는 동안 방문 여부
	static Queue<Point> q;
	static Map<Set<Point>, Integer> union; // 방문한 곳과 평균 값 담을 것
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			flag = false;
			visited = new boolean[N][N]; 
			union = new HashMap<>(); 
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j]) {
						bfs(i,j);
					}
				}
			}
			
			if(!flag) break; // bfs 내 거리 조건에 한 번도 들어가지 않았다면 종료
			cnt++;
		}
		
		System.out.println(cnt);
	}

	private static void bfs(int x, int y) {
		int sum = 0, num=0;
		List<Point> list = new ArrayList<>();
		visited[x][y] = true;
	    q = new LinkedList<>();
	    q.offer(new Point(x,y));
	    
	    while(!q.isEmpty()) {
	    	Point p = q.poll();
	    	sum+=arr[p.x][p.y];
	    	num++;
	    	list.add(new Point(p.x,p.y));
	    	
	    	for(int i=0;i<4;i++) {
	    		nx = p.x+delta[i][0];
	    		ny = p.y+delta[i][1];
	    		if(inside(nx,ny)&&!visited[nx][ny]) {
	    			int dist = Math.abs(arr[p.x][p.y] - arr[nx][ny]);
	    			if(dist >=L && dist <=R) {
	    				flag = true;
	    				Point ps = new Point(nx,ny);
	    				q.offer(ps);
	    				visited[nx][ny] = true; 
	    			}
	    		}
	    	}
	    }
		int average = sum/num;
		for(Point p: list) {
			arr[p.x][p.y] = average;
		}
	}

	private static boolean inside(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
