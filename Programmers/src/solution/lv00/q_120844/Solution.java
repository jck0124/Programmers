package solution.lv00.q_120844;

class Solution {
	
    public int[] solution(int[] numbers, String direction) {
        int[] answer = {};
        answer = new int[numbers.length];
        
        
        if( direction.equals("left") ) { // left
        	
        	for(int i = 0; i < answer.length; i++) {
        		
        		if(i != answer.length - 1) {
        			answer[i] = numbers[i + 1];
        		} else {
        			answer[i] = numbers[0];
        		}
        	}
        	
        } else { // right
        	
        	for(int i = 0; i < answer.length; i++) {
        		
        		if(i != 0) {
        			answer[i] = numbers[i - 1];
        		} else {
        			answer[i] = numbers[numbers.length - 1];
        		}
        	}
        	
        }
        
        // System.out.println(Arrays.toString(answer));
        return answer;
    }
    
}


