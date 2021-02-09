package com.baek.math.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2749 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<>();
		long N = Long.parseLong(br.readLine()); 
		q.offer(0);q.offer(1);
		if(N>=2) {
			for(long i=2;i<=N;i++) {
				q.offer((q.poll() + q.peek())%1000000);
			}
			q.poll();
			System.out.println(q.poll());
		}else {
			System.out.println(1);
		}
	}

}
