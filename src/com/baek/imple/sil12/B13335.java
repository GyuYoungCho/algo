package com.baek.imple.sil12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B13335 {
	static int N, W, L, cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> qes = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			q.offer(Integer.parseInt(st.nextToken()));
		}
		for(int i=0;i<W-1;i++) {
			qes.offer(0);
		}
		int sum = q.peek();
		qes.offer(q.poll());
		
		while(!q.isEmpty()) {
			
			if(sum + q.peek() - qes.peek() > L) {
				qes.offer(0);
			}else {
				sum+=q.peek();
				qes.offer(q.poll());
			}
			sum-=qes.poll();
			cnt++;
		}
		cnt+=W;
		System.out.println(cnt+1);
	}

}
