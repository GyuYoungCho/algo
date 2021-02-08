package com.baek.dfsbfs.sil3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B20304 {
	
	private static class Point {
		int num, cnt;

		Point(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
	
	static int N,M, max = 0;
	static int[] visit;
	static Queue<Point> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입력
		StringTokenizer st; // 숫자 나누기
		
		N = Integer.parseInt(br.readLine()); 
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		visit = new int[N+1];
		Arrays.fill(visit,-1);
		while(st.hasMoreTokens()) {
			int k = Integer.parseInt(st.nextToken());
			q.offer(new Point(k,0));
			visit[k] = 0;
		}
		
		gogo();
		System.out.println(max);
		System.out.println(Arrays.toString(visit));
	}
	
	static void gogo() {
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int temp = 1; temp <= N; temp <<= 1) {
				int num = (p.num & temp) > 0 ? (p.num - temp) : (p.num + temp);
				if (num <= N && visit[num] == -1) {
					visit[num] = p.cnt + 1;
					q.add(new Point(num, p.cnt + 1));
					max = Math.max(max, p.cnt + 1);
				}
			}
		}
	}

}




