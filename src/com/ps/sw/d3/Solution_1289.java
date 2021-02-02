cpackage com.ps.sw.d3;

/**
 * @since
 * @author rbud613
 * @see : https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AXdbYpT6xskDFAUO&contestProbId=AV19AcoKI9sCFAZN&probBoxId=AXdbYpUKxsoDFAUO+&type=PROBLEM&problemBoxTitle=0201&problemBoxCnt=++1+#none
 * @mem 19,444 kb
 * @time 98ms
 * @caution
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Solution_1289 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 받아보기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++)
		{
			String s = br.readLine();
            char point = '0';
            int answer = 0;
            for (int i = 0; i < s.length(); i++) {
                if(point != s.charAt(i)) {
                    answer++;
                    point = s.charAt(i);
                }
            }
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		
		
	}
	static String src = "2\r\n" + 
			"0011\r\n" + 
			"100";
	
	static int solution1(String line) {
		boolean [] datas = new boolean[line.length()];
		for(int i=0;i<datas.length; i++) {
			datas[i] = line.charAt(i) =='1';
		}
		int cnt=0;
		for(int i=0;i<datas.length; i++) {
			if(datas[i]) {
				cnt++;
				for(int j=i+1; j<datas.length;j++) {
					datas[j] = !datas[j];
				}
			}
		}
		return cnt;
	}
}
