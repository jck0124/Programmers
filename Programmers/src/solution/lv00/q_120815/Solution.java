package solution.lv00.q_120815;

public class Solution {
	
    public int solution(int n) {
        int answer = 0;
        
        int count = 1;
        while(true) {
        	if( (count*6)%n == 0) {
        		break;
        	}
        	count++;
        }

        // System.out.println(count);
        answer = count;
        return answer;
    }
}



