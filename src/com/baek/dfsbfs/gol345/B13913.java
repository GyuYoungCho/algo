package com.baek.dfsbfs.gol345;
import java.io.*;
import java.util.*;
public class B13913 {

	private static class Point{
		int x,cnt;

		public Point(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}
	static int N,M;
	static Point start;
	static int[] stat, parent = new int[100001];
	static boolean[] is = new boolean[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		start = new Point(N,1);
		M = Integer.parseInt(st.nextToken());
		if(start.x == M) System.out.println(0);
		else bfs(start);
		
		Stack<Integer> stack = new Stack<>();
        stack.push(M);
        int index = M;

        while (index != N) {
            stack.push(parent[index]);
            index = parent[index];
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb);
	}
	static void bfs(Point num) {
        Queue<Point> q = new LinkedList<>();
        q.add(num);
        is[num.x] = true;
        while(!q.isEmpty()) {
        	Point temp = q.poll();
        	stat = new int[3];
        	stat[0] = temp.x - 1;
        	stat[1] = temp.x + 1;
        	stat[2] = temp.x * 2;
        	for(int i =0; i<3;i++) {
        		if(stat[i]==M) {
        			parent[M] = temp.x;
        			System.out.println(temp.cnt);
        			return;
        		}
        		if(stat[i]>=0 && stat[i] < 100001 && !is[stat[i]]) {
        			q.add(new Point(stat[i],temp.cnt + 1));
        			is[stat[i]] = true;
        			parent[stat[i]] = temp.x;
        		}
        	}
        }
	}

}
