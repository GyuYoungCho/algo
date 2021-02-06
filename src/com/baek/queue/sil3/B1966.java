package com.baek.queue.sil3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1966 {

	static int T, N, M, cnt, col;
	static boolean max;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 
		
		for(int i=0;i<T;i++) {
			Queue<Printer> queue = new LinkedList<Printer>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			for(int k=0; k<N; k++) {
				col = Integer.parseInt(st.nextToken());
				queue.offer(new Printer( k, col));
				pq.offer(col);
			}
			
			cnt = 0;
			while(true) {
				if((pq.peek())!=(queue.peek().priority)) {
					queue.offer(queue.poll());
				}
				else {
					if(queue.peek().idx==M) {
						break;
					}
					queue.poll();
					pq.poll();
					cnt++;
				}
			}
			sb.append(cnt+1).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}

class Printer {
	int idx;
	int priority;
	Printer(int idx, int priority){
		this.idx=idx;
		this.priority=priority;
	}
}