package com.baek.graph.gol123;

import java.io.*;
import java.util.*;

public class B9466 {
	static int T, N, cnt;
    static int[] arr;
    static boolean[] visited, finished;
    static int stoi(String s) { 
    	return Integer.parseInt(s);
    }
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	T = stoi(br.readLine());
    	 
        for(int t=0; t<T; t++) {
            N = stoi(br.readLine());
            arr = new int[N+1];
            visited = new boolean[N+1];
            finished = new boolean[N+1];
            cnt = 0;
            
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) 
                arr[i] = stoi(st.nextToken());
            for(int i=1; i<=N; i++)
                dfs(i);
 
            sb.append(N-cnt).append("\n");
        }
        
        System.out.println(sb);
	}
    
    public static void dfs(int node){
    	if(visited[node]) return;
    	
        visited[node] = true;
        int next = arr[node];

        if(!visited[next]) dfs(next);
        
        else{
            if(!finished[next]){
                cnt++;
                while(next!=node){
                    cnt++;
                    next = arr[next];;
                }
            }
        }
        finished[node] = true;
    }
}
