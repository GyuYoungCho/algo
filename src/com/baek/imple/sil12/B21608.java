package com.baek.imple.sil12;

import java.io.*;
import java.util.*;

public class B21608 {
	
	static int[][] arr, emptySeat;
	static int N;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Student{
		int x, y;
		int[] flist;
		
		public Student(int x, int y, int[] flist) {
			this.x = x;
			this.y = y;
			this.flist = flist;
		}
	}
	
	static Map<Integer, Student> list = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
		int N2 = N*N, answer = 0;
		arr = new int[N][N];
		emptySeat = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int cnt = 4;
				if(i==0 || i==N-1) cnt--;
				if(j==0 || j==N-1) cnt--;
				emptySeat[i][j] = cnt;
			}
		}
		
		for(int i=0; i<N2; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int[] friends = new int[4];
			for (int j = 0; j < 4; j++) {
				friends[j] = Integer.parseInt(st.nextToken());
			}
			
			findSeat(num, friends);
		}
		
		for(int i=1; i<=N2; i++) {
			Student stu = list.get(i);
			int cnt = 0;
			for(int friend : stu.flist) {
				if(Math.abs(list.get(friend).x -stu.x) + Math.abs(list.get(friend).y - stu.y) == 1) {
					cnt++;
				}
			}
			
			if(cnt==1) answer+=1;
			else if(cnt==2) answer+=10;
			else if(cnt==3) answer+=100;
			else if(cnt==4) answer+=1000;
		}
		
		System.out.println(answer);
	}
	
	private static void findSeat(int num, int[] friends) {
		int[][] near = new int[N][N];
		for(int f : friends) {
			if(list.containsKey(f)) {
				Student s = list.get(f);
				int x = s.x;
				int y = s.y;
				
				for(int i=0; i<4; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					if(nx>=0 && nx <N && ny >=0 && ny < N && arr[nx][ny] == 0) {
						near[nx][ny]++;
					}
				}
			}
		}
		
		int cntmax=-1,nearmax = -1,cx = -1,cy = -1;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] != 0) continue;
				if(nearmax < near[i][j]) {
					cx = i;
					cy = j;
					nearmax = near[i][j];
					cntmax = emptySeat[i][j];
				} else if(nearmax == near[i][j] && cntmax < emptySeat[i][j]) {
					cntmax = emptySeat[i][j];
					cx = i;
					cy = j;
				}
			}
		}
		
		arr[cx][cy] = num;
		list.put(num, new Student(cx,cy, friends));
		
		for(int i=0; i<4; i++) {
			int nx = cx+dx[i];
			int ny = cy+dy[i];
			if(nx>=0 && nx <N && ny >=0 && ny < N && arr[nx][ny] == 0) {
				emptySeat[nx][ny]--;
			}
		}
	}
}
