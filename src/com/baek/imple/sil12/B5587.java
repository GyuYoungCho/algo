package com.baek.imple.sil12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B5587 {
	static int N, next;
	static PriorityQueue<Integer> sang, gun, skip;
	static boolean[] card;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		sang = new PriorityQueue<>();
		gun = new PriorityQueue<>();
		card = new boolean[N * 2 + 1];
		for (int i = 0; i < N; i++) {
			int get = Integer.parseInt(br.readLine());
			card[get] = true;
			sang.add(get);
		}

		
		for (int i = 1; i < card.length; i++) {
			if (!card[i])
				gun.add(i);
		}
		next = 0;
		int get;
		boolean flag = false;
		
		while (!sang.isEmpty() && !gun.isEmpty()) {
			
			boolean notfound = false;
			if (!flag) {
				skip = new PriorityQueue<>();
				while (!sang.isEmpty()) {
					get = sang.poll();
					if (get > next) {
						next = get;
						notfound = true;
						break;
					} else
						skip.add(get);
				}
				while(!skip.isEmpty()) {
					sang.add(skip.poll());
				}
				if(!notfound) next=0;
			} 
			
			else {
				skip = new PriorityQueue<>();
				while (!gun.isEmpty()) {
					get = gun.poll();
					if (get > next) {
						next = get;
						notfound = true;
						break;
					} else
						skip.add(get);
				}
				while(!skip.isEmpty()) {
					gun.add(skip.poll());
				}
				if(!notfound) next=0;
			}
			flag = !flag;
		}
		
		System.out.println(gun.size());
		System.out.println(sang.size());
//		for(int i=0;i<gun.size();i++)
//			System.out.println(gun.poll());
	}
}
