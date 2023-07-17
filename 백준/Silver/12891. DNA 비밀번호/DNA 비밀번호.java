import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int s_len;
	static int p_len;
	static char[] str;
	static int[] checkArr = new int[4];
	static int[] myArr = new int[4];
	static int checkCnt = 0; 
	static int answer = 0;  

	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		s_len = Integer.parseInt(st.nextToken());
		p_len = Integer.parseInt(st.nextToken());
		str = br.readLine().toCharArray(); // 
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < p_len; i++) { 
			if (str[i]=='A') myArr[0]++;
			if (str[i]=='C') myArr[1]++;
			if (str[i]=='G') myArr[2]++;
			if (str[i]=='T') myArr[3]++;
		}

		if (checkCounting())
			answer++; 
		
		int i = -1;
		
		for (int j = p_len; j < s_len; j++) { 
			i = j - p_len;
			
			if (str[i]=='A') myArr[0]--;
			if (str[i]=='C') myArr[1]--;
			if (str[i]=='G') myArr[2]--;
			if (str[i]=='T') myArr[3]--;
			
			if (str[j]=='A') myArr[0]++;
			if (str[j]=='C') myArr[1]++;
			if (str[j]=='G') myArr[2]++;
			if (str[j]=='T') myArr[3]++;
			
			if (checkCounting())
				answer++; 
		}

		System.out.println(answer);

	}

	public static boolean checkCounting() {
		for (int i = 0; i < 4; i++) {
			if (myArr[i] < checkArr[i])
				return false;
		}
		return true;
	}

}