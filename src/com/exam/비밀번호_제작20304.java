package com.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 비밀번호_제작20304 {
	static int N,M;
	static int [] attacks;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		attacks = new int[M];
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		for(int m=0;m<M;m++) {
			attacks[m] = Integer.parseInt(tokens.nextToken());
		}
		
		solution2();
	}
	
	private static void solution1() {
		int safe = Integer.MIN_VALUE;
		for(int n=0;n<=N;n++) {
			int minsafe = Integer.MAX_VALUE;
			for(int m=0;m<M;m++) {
				int xor = n^ attacks[m];
//				int tempdist = Integer.toBinaryString(xor).replaceAll("0", "").length();
				int tempdist =0;
				while(xor>0){
					if((xor&1)>0) {
						tempdist++;
					}
					xor >>=1;
				}
				minsafe =Math.min(minsafe, tempdist);
			}
			safe = Math.max(safe, minsafe);
		}
		System.out.println(safe);
	}
	
	private static void solution2() {
		Queue<Integer> queue = new LinkedList<>();
		boolean [] visited = new boolean[N+1];
		
		for(int m=0;m<M;m++) {
			queue.offer(attacks[m]);
			visited[attacks[m]] = true;
		}
		int depth = -1;
		while(!queue.isEmpty()){
			// queue에 원래 있던 애들만 돌리고 나머지는 넣기만 하기
			int size = queue.size();
			while(size-->0) {
				int front = queue.poll();
				
				// 자식 탐색을 위해 1을 왼쪽으로 이동
				for(int i=1;i<N;i<<=1) {
					int next = front^i;
//						int next;
//						if((i&front)>0) { // 비트를 가지고 있음 -> 비트빼기
//							next = front-i; // next = front & ~i
//						}else { // 없어서 넣기
//							next = front+i; // next = front | i;
//						}
					// next가 이미 사용, 범위 넘으면 아웃
					if(next<=N && !visited[next]) {
						visited[next]=true;
						queue.offer(next);
					}
				}
			}
			depth++;
		}
		System.out.println(depth);
	}
}
