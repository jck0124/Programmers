package solution.lv00.q_120816;

class Solution {
    public int solution(int slice, int n) {
        int answer = 0;
        
        while(true) {
        	
        	if( (slice*answer) / n > 1 || (slice*answer) % n  == 0 ) {
        		break;
        	} else {
        		answer++;
        	}
        	
        }
        
        return answer;
    }
}