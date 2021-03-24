package com.baek.dfsbfs.gol345;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1600 {
	static int N,M,K;
	static int[][] arr , m_delta = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } }
				, h_delta = {{-2,-1},{2,-1},{-2,1},{2,1},{1,2},{-1,2},{1,-2},{-1,-2}};
	static boolean visit[][][];
	static class Node{
	    int x,y,cnt,jump;
	    Node(int x, int y, int cnt, int jump){
	        this.x=x;
	        this.y=y;
	        this.cnt=cnt;
	        this.jump=jump;
	    }
	}
				
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visit = new boolean[N][M][K+1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		Queue<Node> q = new LinkedList<>();
		
		q.add(new Node(0,0,0,0));
        visit[0][0][0] = true;
        while(!q.isEmpty()) {
            Node node = q.poll();
            
            if(node.x ==N-1 && node.y==M-1) {
                System.out.println(node.cnt);
                return;
            }
            
            for(int i=0; i<4; i++) {
                int nx = node.x+m_delta[i][0];
                int ny = node.y+m_delta[i][1];
                if(inside(nx,ny)) {
                    if(!visit[nx][ny][node.jump] && arr[nx][ny]!=1) {
                        visit[nx][ny][node.jump]=true;
                        q.add(new Node(nx,ny,node.cnt+1,node.jump));
                    }
                }
            }
            if(node.jump<K) {
                for(int i=0; i<8; i++) {
                    int nx = node.x+h_delta[i][0];
                    int ny = node.y+h_delta[i][1];
                    if(inside(nx,ny)) {
                        if(!visit[nx][ny][node.jump+1] && arr[nx][ny]!=1) {
                        	visit[nx][ny][node.jump+1]=true;
                            q.add(new Node(nx,ny,node.cnt+1,node.jump+1));
                        }
                    }
                }
            }
        }
        System.out.println(-1);
	}
	public static boolean inside(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
