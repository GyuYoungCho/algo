package com.baek.sort.gol;

import java.io.*;
import java.util.*;

public class B1766 {
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        int[] indegree = new int[n+1];
 
        for(int i=0; i<n+1; i++)
            list.add(new ArrayList<Integer>());
 
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
 
            list.get(v1).add(v2);
            indegree[v2]++;
        }
        
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        
        for(int i=1; i<=n; i++){
            if(indegree[i]==0) q.add(i);  
        }
        
        while(!q.isEmpty()){
            int current = q.poll();
            sb.append(current).append(" ");
            for(int i=0; i<list.get(current).size(); i++){
                int next = list.get(current).get(i);
                indegree[next]--;

                if(indegree[next]==0){
                    q.add(next);
                }
            }
        }
        System.out.println(sb);
	}
}
