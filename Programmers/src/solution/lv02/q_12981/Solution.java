package solution.lv02.q_12981;

class Solution {
	
    public int[] solution(int n, String[] words) {
    	
        int[] answer = {};
        
        // 탈락자 발생 여부
        boolean failCheck = false;
        
        // 몇 번째 단어인지 카운트
        int count = 2;
        
        for(int i = 1; i < words.length; i++) {
        	
        	String previousWord = words[i-1];
        	
        	if(	previousWord.charAt(previousWord.length() - 1)
        		== words[i].charAt(0) ) { // 끝말잇기일 경우
        		
        		// 나왔던 단어인지 체크
        		boolean duplicateCheck = false;
        		
        		for(int j = 0;  j < i; j++) {
        			if(words[i].equals( words[j] )) {
        				duplicateCheck = true;
        				break;
        			}
        		}
        		
        		if (duplicateCheck) {
        			failCheck = true;
					break;
				} else {
					count++;
				}
        		
        	} else { // 끝말잇기가 아닐 경우
        		
        		failCheck = true;
        		break;
        	}
        }
        
        int[] temp = new int[2];
        // temp[0] : 가장 먼저 탈락하는 사람 번호
        // temp[1] : 자신의 몇 번째 차례에 탈락하는지
        
        
        if(!failCheck) {
        	return new int[] {0, 0};
        	
        } else {
        	temp[0] = (count%n != 0) ? (count%n) : n;
        	temp[1] = (count%n != 0) ? (count/n) + 1  : (count/n);
        }
        
        
        answer = temp;
        
        return answer;
    }
    
}
