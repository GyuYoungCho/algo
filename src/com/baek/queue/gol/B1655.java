package com.baek.queue.gol;

import java.util.*;
import java.io.*;

public class B1655 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1,o2) -> o2 - o1), minPQ = new PriorityQueue<>();

        for(int i=0; i<N; i++) {
            int a = Integer.parseInt(br.readLine());
            if(maxPQ.size() == minPQ.size()) {
                maxPQ.add(a);
                if(!minPQ.isEmpty() && maxPQ.peek() > minPQ.peek()) {
                    minPQ.add(maxPQ.poll());
                    maxPQ.add(minPQ.poll());
                }
            }
            else {
                minPQ.add(a);

                if(maxPQ.peek() > minPQ.peek()) {
                    minPQ.add(maxPQ.poll());
                    maxPQ.add(minPQ.poll());
                }
            }
            sb.append(maxPQ.peek()).append("\n");
        }
        System.out.println(sb);
	}

}
