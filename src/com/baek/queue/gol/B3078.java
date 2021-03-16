package com.baek.queue.gol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3078 {
	static int n, k;
	static long cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        Queue<Integer> q[] = new LinkedList[21];
        for(int i=0;i<21;i++) {
        	q[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
        	int len = br.readLine().length();

    		while (!q[len].isEmpty() && i - q[len].peek() > k) {
    			q[len].poll();
    		}
    		
    		cnt += q[len].size();
    		q[len].offer(i);
		}
        System.out.println(cnt);
	}

}
