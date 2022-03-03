package com.baek.graph.gol123;

import java.io.*;
import java.util.*;

public class B2252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] deg = new int[N+1];
        ArrayList<Integer>[] list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<Integer>();
        }
        
        for(int i=0; i<M; i++){
        	st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            deg[y]++;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for(int i=1; i<=N; i++){
            if(deg[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            sb.append(queue.peek()).append(" ");
            int current = queue.poll();
            for(int i=0; i<list[current].size(); i++){
                int next = list[current].get(i);
                deg[next]--;
                if(deg[next]==0){
                    queue.add(next);
                }
            }
        }
        
        System.out.println(sb);
	}
}
