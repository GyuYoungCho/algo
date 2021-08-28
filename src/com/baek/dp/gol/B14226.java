package dp.gol45;

import java.io.*;
import java.util.*;

public class B14226 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visit = new boolean[N+1][N+1];
		q.offer(new int[] {1,0,0});
		visit[1][0] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int a = cur[0];
			int b = cur[1];
			if(cur[0]==N) {
				System.out.println(cur[2]);
				break;
			}
			
			if(!visit[a][a]) {
				visit[a][a] = true;
				q.offer(new int[] {a,a,cur[2]+1});
			}
			
			int sum = a + b;
			
			if(b!=0 && sum < N+1 && !visit[sum][b]) {
				visit[sum][b] = true;
				q.offer(new int[] {sum,b,cur[2]+1});
			}
			
			if(a>0 && !visit[a-1][b]) {
				visit[a-1][b] = true;
				q.offer(new int[] {a-1,b,cur[2]+1});
			}
		}
	}

}
