package com.baek.dfsbfs.sil3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697 {
	private static class Point{
		int x,cnt;

		public Point(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}
	static int N,M;
	static Point start;
	static int[] stat;
	static boolean[] is = new boolean[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = new Point(Integer.parseInt(st.nextToken()),1);
		M = Integer.parseInt(st.nextToken());
		if(start.x == M) System.out.println(0);
		else bfs(start);
	}
	static void bfs(Point num) {
        Queue<Point> q = new LinkedList<>();
        q.add(num);
        is[num.x] = true;
        while(!q.isEmpty()) {
        	Point temp = q.poll();
        	stat = new int[3];
        	stat[0] = temp.x - 1;
        	stat[1] = temp.x + 1;
        	stat[2] = temp.x * 2;
        	for(int i =0; i<3;i++) {
        		if(stat[i]==M) {
        			System.out.println(temp.cnt);
        			return;
        		}
        		if(stat[i]>=0 && stat[i] < 100001 && !is[stat[i]]) {
        			q.add(new Point(stat[i],temp.cnt + 1));
        			is[stat[i]] = true;
        		}
        	}
        }
	}
}
