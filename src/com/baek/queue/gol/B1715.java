package com.baek.queue.gol;

import java.io.*;
import java.util.*;

public class B1715 {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++){
            int x = Integer.parseInt(br.readLine());
            pq.add(x);
        }
        int ans = 0;
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();

            ans += a+b;
            pq.add(a+b);
        }
        
        System.out.println(ans);
    }
}
