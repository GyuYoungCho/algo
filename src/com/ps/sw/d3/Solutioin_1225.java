package com.ps.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solutioin_1225 {
	
	public static void main(String[] args) throws IOException {
		Queue<Integer> queue = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int pee, min;
		int get = 0;
		String tc;
		
		
		while((tc=br.readLine())!=null) {
			st = new StringTokenizer(br.readLine());
			min = Integer.MAX_VALUE;
			for (int i = 0; i < 8; i++) {
				get =Integer.parseInt(st.nextToken());
				if(get/15 < min) {
                    min = get/15;
                }
				queue.offer(get);
			}
			
			for (int i = 0; i < 8; i++) {
				pee = queue.poll();
				queue.offer(pee%(15*(min-1)));
			}
			
			e:while(true) {
				for(int i=1;i<=5;i++) {
					pee = queue.poll();
					if(pee - i > 0)
						queue.offer(pee-i);
					else {
						queue.offer(0);
						break e;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ");
			
			while(!queue.isEmpty())
				sb.append(queue.poll()).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static String src="1\r\n" + 
			"9550 9556 9550 9553 9558 9551 9551 9551 \r\n" + 
			"2\r\n" + 
			"2419 2418 2423 2415 2422 2419 2420 2415 \r\n" + 
			"3\r\n" + 
			"7834 7840 7840 7835 7841 7835 7835 7838 \r\n" + 
			"4\r\n" + 
			"4088 4087 4090 4089 4093 4085 4090 4084 \r\n" + 
			"5\r\n" + 
			"2945 2946 2950 2948 2942 2943 2948 2947 \r\n" + 
			"6\r\n" + 
			"670 667 669 671 670 670 668 671 \r\n" + 
			"7\r\n" + 
			"8869 8869 8873 8875 8870 8872 8871 8873 \r\n" + 
			"8\r\n" + 
			"1709 1707 1712 1712 1714 1710 1706 1712 \r\n" + 
			"9\r\n" + 
			"10239 10248 10242 10240 10242 10242 10245 10235 \r\n" + 
			"10\r\n" + 
			"6580 6579 6574 6580 6583 6580 6577 6581 \r\n" + 
			"";
}
