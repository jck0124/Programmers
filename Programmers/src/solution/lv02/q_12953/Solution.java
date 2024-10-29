package solution.lv02.q_12953;

class Solution {
	
    public int solution(int[] arr) {
    	
    	// 현재 최소공배수(답)
        int answer = 0; 
        
        for(int i = 0; i < arr.length; i++) { 
        	
        	if(i == 0) {
        		answer = arr[i];
        		continue;
        	}
        	
        	int temp = answer;
        	
        	while(true) { // 현재 인덱스의 요소가 나누어 떨어질 때까지 temp 증가 
        		
        		if(temp%arr[i] == 0) { 
        			answer = temp;
        			break;
        			
        		} else {
        			temp += answer;
        		}
        		
        	}
        }
        
        return answer;
    }
    
}
