package com.baek.graph45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17471 {
	static int N, min = 1000, num, partsum, sum;
	static int peo[];
	static boolean arr[][], visit[], visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		peo = new int[N+1];
		arr = new boolean[N+1][N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			peo[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			for (int j = 0; j < M; j++) {
				arr[i][Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		for(int i = 0; i<(N/2)+1; i++) { 
            num = i;
			visit = new boolean[N+1];
            select(1,0);
        }
		System.out.println(min==1000?-1:min);
	}

	private static void select(int start, int cnt) {
		if(cnt==num) {
//			sum = 1000;
			confirm();
			min = Math.min(min, sum);
			return;
		}
		
		for(int i = start; i<N+1; i++) {
            visit[i]=true;
            select(i+1,cnt+1);
            visit[i]=false;
        }
	}
	public static void confirm() {
        visited = new boolean[N+1];
        int people1 = 0;
        int people2 = 0;
        for(int i = 1; i<N+1; i++) {
            if(visit[i] && !visited[i]) {  
                partsum = 0;
                gary(i);
                people1 = partsum;
                break;
            }
        }
        
        for(int i = 1; i<N+1; i++) {
            if(!visit[i] && !visited[i]) {  
                partsum = 0;
                gary(i);
                people2 = partsum;
                break;
            }
        }
        
        for(int i = 1; i<N+1; i++) {
            if(!visited[i]) {
                return;
            }
        }
        
        sum = Math.abs(people2-people1);
    }
    
    public static void gary(int x) {
        visited[x] = true;
        partsum += peo[x];
        for(int i = 1; i<N+1; i++) {
            if(!visited[i] && visit[i] == visit[x] && arr[i][x]) {
                gary(i);
            }
        }
    }
}
