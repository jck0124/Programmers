package solution.lv01.q_12937;

class Solution {
	
    public String solution(int num) {
        String answer = "";
        
        if(num == 0) {
        	answer = "Even";
        	
        }else if (num%2 == 0) {
        	answer = "Even";
        	
        } else {
        	answer = "Odd";
        	
        }
        
        return answer;
    }
    
}