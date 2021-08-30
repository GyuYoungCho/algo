package pointer.gol;

import java.io.*;

public class B1484 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int g = Integer.parseInt(br.readLine());
		
		int start = 1;	
		int end = 2;
		
		while(start<end) {
			long wt = end*end - start*start;
			if(wt == g) {
				sb.append(end+"\n");
				start++;
				end++;
			}
			else if(wt > g) start++;
			else end++;
		}
		if(sb.length()==0) sb.append(-1);
		
		System.out.println(sb);
	}

}
