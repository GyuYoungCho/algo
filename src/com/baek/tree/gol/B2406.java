package tree.gol123;
import java.io.*;
import java.util.*;
public class B2406 {
static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		
        for(int i=1; i<=N; i++)
            arr[i] = i;

        int E = 0;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(union(a, b)) E++;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> o1[2] - o2[2]);
        
        ArrayList<int[]> list = new ArrayList<>();
        int cost = 0;

        for(int i=1; i<=N; i++) {
        	st = new StringTokenizer(br.readLine());
            if(i==1) continue;
            for(int j=1; j<=i; j++) st.nextToken();
            for(int j=i+1; j<=N; j++) {
                pq.add(new int[] {i, j, Integer.parseInt(st.nextToken())});
            }
        }

        while(!pq.isEmpty() && E<=N-1) {
            int[] cur = pq.poll();
            int a = cur[0];
            int b = cur[1];

            if(!union(a,b)) continue;
            cost += cur[2];
            E++;
            list.add(new int[] {a, b});
        }

        sb.append(cost).append(" ").append(list.size()).append("\n");

        for(int[] cur : list) {
        	sb.append(cur[0]).append(" ").append(cur[1]).append("\n");
        }
        System.out.println(sb);
	}
	
	static int find(int a) {
		if(arr[a] == a) return a;
		return arr[a] = find(arr[a]);
	}
	static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if(a==b) return false;
        arr[b] = a;
        return true;
    }
}
