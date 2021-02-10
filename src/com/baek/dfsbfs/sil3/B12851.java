package com.baek.dfsbfs.sil3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B12851 {
	private static class Point{
		int x,cnt;

		public Point(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}
	static int N,M, c=0, min = Integer.MAX_VALUE;
	static Point start;
	static int[] stat;
	static boolean[] is = new boolean[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = new Point(Integer.parseInt(st.nextToken()),1);
		M = Integer.parseInt(st.nextToken());
		if(start.x == M) System.out.println(0);
		else {
			bfs(start);
		}
	}
	static void bfs(Point num) {
        Queue<Point> q = new LinkedList<>();
        q.add(num);
        while(!q.isEmpty()) {
        	Point temp = q.poll();
        	is[temp.x] = true;
        	int twopoint = temp.x*2;
        	while (twopoint < 100001) {
        		if(twopoint==M) {
        			System.out.println(temp.cnt-1);
        			return;
        		}
        		if(!is[twopoint]) {
        			q.add(new Point(twopoint,temp.cnt));
        		}else break;
        		twopoint*=2;
        	}
        	stat = new int[2];
        	stat[0] = temp.x - 1;
        	stat[1] = temp.x + 1;
        	for(int i =0; i<2;i++) {
        		if(stat[i]==M) {
        			System.out.println(temp.cnt);
        			return;
        		}
        		if(stat[i]>=0 && stat[i] < 100001 && !is[stat[i]]) {
        			q.add(new Point(stat[i],temp.cnt + 1));
        		}
        	}
        }
	}
}
