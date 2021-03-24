package com.baek.tsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2098 {
	public static int n, map[][], d[][], MAX = 987654321;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int i, j, k;
		n = Integer.parseInt(in.readLine());
		map = new int[n][n];
		d = new int[n][1<<n]; 
		String line[];
		
		for(i=0;i<n;i++){
			line = in.readLine().split(" ");
			for(j=k=0;j<line.length;j++)
				if(line[j].length()>0) map[i][k++] = Integer.parseInt(line[j]);
			Arrays.fill(d[i], MAX); 
		}
		
		System.out.println(tsp(0,1));
	}
	
	private static int tsp(int cur, int visit){
		//모든 정점을 다 돌았으면 현재 위치에서 출발점(0)으로 돌아감
		if(visit == (1<<n)-1) return map[cur][0];
		
		//현 위치에서의 거리값이 0이 아니면 이미 계산된 것이므로 값을 리턴
		if(d[cur][visit]!=MAX) return d[cur][visit];
		
		for(int i=0;i<n;i++)
			if((visit&(1<<i))==0 && map[cur][i]!=0) //방문 안했으면서 길이 있으면 방문
				d[cur][visit] = Math.min(d[cur][visit], map[cur][i]+tsp(i, visit|(1<<i)));
		return d[cur][visit];
	}
}
