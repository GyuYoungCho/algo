package com.baek.dfsbfs.gol12;
import java.io.*;
import java.util.*;
public class B17071 {

	private static class Point{
		int x,cnt;

		public Point(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}
	static int N,M;
	static Point start;
	static int[] stat, dist = new int[1001];
	static boolean[][] is = new boolean[500001][2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		start = new Point(N,1);
		M = Integer.parseInt(st.nextToken());
		dist[0] = M;
		for(int i=1;i<1000;i++) {
			dist[i] = dist[i-1] + i;
		}
		if(start.x == M) System.out.println(0);
		else bfs(start);
	}
	static void bfs(Point num) {
        Queue<Point> q = new LinkedList<>();
        q.add(num);
        is[num.x][0] = true;
        while(!q.isEmpty()) {
        	Point temp = q.poll();
        	if(dist[temp.cnt]>500000) {
    			System.out.println(-1);
    			return;
    		}
        	
        	if(is[dist[temp.cnt]][temp.cnt%2]) {
        		System.out.println(temp.cnt);
    			return;
        	}
        	stat = new int[3];
        	stat[0] = temp.x - 1;
        	stat[1] = temp.x + 1;
        	stat[2] = temp.x * 2;
        	for(int i =0; i<3;i++) {
        		if(stat[i]==dist[temp.cnt]) {
        			System.out.println(temp.cnt);
        			return;
        		}
        		if(stat[i]>=0 && stat[i] < 500001 && !is[stat[i]][(temp.cnt+1)%2]) {
        			q.add(new Point(stat[i],temp.cnt + 1));
        			is[stat[i]][(temp.cnt+1)%2] = true;
        		}
        	}
        }
	}

}
