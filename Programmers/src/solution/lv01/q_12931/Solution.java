package solution.lv01.q_12931;

public class Solution {
	
    public int solution(int n) {
    	
        int answer = 0;
        int num = n;
        
        while(true) {
        	answer += num%10;
        	
        	if(num/10 != 0) {
        		num /= 10;
        		continue;
        	} else {
        		break;
        	}
        }
        
        return answer;
    }
    
}