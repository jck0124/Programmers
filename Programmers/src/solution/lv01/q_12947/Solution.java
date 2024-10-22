package solution.lv01.q_12947;

class Solution {
	
    public boolean solution(int x) {
    	
        boolean answer = true;
        int origin = x;
        
        int sum = 0;
        
        while(true) {
        	if(x == 0) {
        		break;
        	} else {
        		sum += x%10;
        		x /= 10;
        	}
        }
        
        if(origin%sum == 0) {
        	answer = true;
        } else {
        	answer = false;
        }
        
        return answer;
    }
    
}