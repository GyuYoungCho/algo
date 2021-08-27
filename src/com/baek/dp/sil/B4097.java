package dp.sil;

import java.io.*;

public class B4097 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N==0) break;
			int sum = 0;
			int max = Integer.MIN_VALUE;
			for(int i=0;i<N;i++) {
				int m = Integer.parseInt(br.readLine());
				sum+=m;
				max = Math.max(max, sum);
				if(sum<0) sum=0;
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}
