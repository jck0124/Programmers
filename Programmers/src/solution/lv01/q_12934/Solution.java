package solution.lv01.q_12934;

class Solution {
	
    public long solution(long n) {
    	
        long answer = 0;
        
        if( Math.sqrt(n)%1 == 0 ) {
        	answer = (long)Math.pow( Math.sqrt(n) + 1 , 2);
        } else {
        	answer = -1;
        }
        
        return answer;
    }
    
}