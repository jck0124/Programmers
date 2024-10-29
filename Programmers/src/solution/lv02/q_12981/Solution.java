package solution.lv02.q_12981;

class Solution {
	
    public int[] solution(int n, String[] words) {
    	
        int[] answer = {};
        
        // 탈락자 발생 여부
        boolean isFailed = false;
        
        // 몇 번째 단어인지, 첫 단어는 탈락할 일이 없음
        int count = 2;
        
        for(int i = 1; i < words.length; i++) {
        	
        	// 이전 단어
        	String previousWord = words[i-1];
        	
        	if(	previousWord.charAt(previousWord.length() - 1)
        		== words[i].charAt(0) ) { // 끝말잇기가 성립할 경우
        		
        		// 중복 단어 체크
        		boolean duplicateCheck = false;
        		
        		for(int j = 0;  j < i; j++) {
        			if(words[i].equals( words[j] )) {
        				duplicateCheck = true;
        				break;
        			}
        		}
        		
        		if (duplicateCheck) { // 중복 단어일 경우
        			isFailed = true;
					break;
					
				} else { // 중복 단어가 아닐 경우
					count++;
				}
        		
        	} else { // 끝말잇기가 성립되지 않을 경우
        		
        		isFailed = true;
        		break;
        	}
        }
        
        int[] temp = new int[2];
        // temp[0] : 가장 먼저 탈락하는 사람 번호
        // temp[1] : 자신의 몇 번째 차례에 탈락하는지
        
        
        if(!isFailed) { // 탈락자가 없음
        	return new int[] {0, 0};
        	
        } else { // 탈락자가 있음
        	if(count%n != 0) { // n번째 사람
        		temp[0] = count%n;
        		temp[1] = (count/n) + 1;
        		
        	} else { // n번째 사람이 아닌 경우
        		temp[0] = n;
        		temp[1] = count/n;
        	}
        }
        
        
        answer = temp;
        
        return answer;
    }
    
}
