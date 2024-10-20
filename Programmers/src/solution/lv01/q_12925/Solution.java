package solution.lv01.q_12925;

class Solution {
	
    public int solution(String s) {
    	
        int answer = 0;
        
        if(s.charAt(0) == '-') {
        	String temp = s.substring(1, s.length());
        	answer = -1 * Integer.parseInt(temp);
        	
        } else {
        	answer = Integer.parseInt(s);
        }
        return answer;
    }
    
}