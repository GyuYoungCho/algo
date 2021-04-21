package com.baek.imple.gol45;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B20056 {
	static int N,M,K;
	static int delta[][] = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
	static List<int[]>[][] arr;
	static List<int[]> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new List[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				arr[i][j] = new ArrayList<>();
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list.add(new int[] {r,c,m,s,d});
		}
		
		for(int t = 0; t < K; t++) {
			if(list.isEmpty()) break;
			for(int [] cur : list) {
				int nx = (cur[0] + (delta[cur[4]][0] * cur[3])%N + N) % N;
				int ny = (cur[1] + (delta[cur[4]][1] * cur[3])%N + N) % N;
				cur[0] = nx;
				cur[1] = ny;
				arr[nx][ny].add(cur);
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					
					if(arr[i][j].size() < 2) {
						arr[i][j].clear();
						continue;
					}
					
					int msum = 0, ssum=0;
					boolean even = true, odd= true;
					
					for(int[] cur : arr[i][j]) {
						msum += cur[2];
						ssum += cur[3];
						even = even & cur[4] % 2 == 0 ? true : false;
						odd = odd & cur[4] % 2  == 1 ? true : false;
						list.remove(cur);
					}
					
					int nm = msum / 5;
					int ns = ssum / arr[i][j].size();
					arr[i][j].clear();
					if(nm == 0) continue;
					
					if(even || odd) {
						for(int k = 0; k < 8; k += 2) {
							list.add(new int[] {i, j, nm, ns, k});
						}
					} else {
						for(int k = 1; k < 8; k += 2) {
							list.add(new int[] {i, j, nm, ns, k});
						}
					}
					
				}
			}
		}
		
		int ans = 0;
		for(int [] cur : list) {
			ans+= cur[2];
		}
		
		System.out.println(ans);
	}

}
