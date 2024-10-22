package solution.lv01.q_258712;

class Solution {
	public int solution(String[] friends, String[] gifts) {
		int answer = 0;
		
		int[] giftsPoint = new int[friends.length]; // 선물 지수, 자신이 친구들에게 (준 선물수 - 받은 선물수)
		int[] giftsCount = new int[friends.length]; // 다음 달에 받을 선물 개수, max가 result
		int[][] giftsExchange = new int[friends.length][friends.length]; // 선물 주고 받은 횟수
		// giftsExchange[i][j] = i가 j에게 선물을 준 횟수
		
		// 주고 받은 내역 이중배열로?
		// 이번달에 두 사람이 주고 받은 내역이 있다면, 두 사람 사이에 선물을 더 많이 준 사람이 다음달에 선물을 하나 더 받는다 -> giftsExchange != 0이라면 giftsCount++ 
		// 만약 이번달에 주고 받은 적이 없거나, 같은 수를 주고 받았다면 다음달에 선물지수가 더 큰 사람이 하나 더 받는다 
		// 선물 지수도 같다면  다음달에 선물을 주고 받지 않는다

		
		// giftsExchange - 선물 주고 받은 횟수
		String[] giftsSlice; // gifts를 " "을 기준으로 나눠서 담을 배열
		
		for(int k = 0; k < gifts.length; k++) {
			giftsSlice = gifts[k].split(" ");
			for(int i = 0; i < friends.length; i++) {
				for(int j = 0; j < friends.length; j++) { // friends의 [i]번째가 [j]번째에게 선물을 준 횟수를 giftsExchange[i][j]에 대입
					if( giftsSlice[0].equals(friends[i]) && giftsSlice[1].equals(friends[j]) ) {
						giftsExchange[i][j]++;
					}
				}
			}
		}
		
		
		/*
			[i]번째 friends의 giftsPoint 
			giftsExchange의 [i]번째 배열의 합 - i번째를 제외한 나머지의 배열의(i번째 합) -> (sum1 - sum2) 
			
			0번째 : (2) - (3 + 1 + 1) = -3
			1번째 : (3) - (0 + 1 + 0) = 2
			2번째 : (2) - (2 + 0 + 0) = 0
			3번째 : (1) - (0 + 0 + 0) = 1
		*/
		
		int[] sum1 = new int[friends.length];
		for(int i = 0; i < giftsExchange.length; i++) {
			for(int j = 0; j < giftsExchange[i].length; j++) {
				sum1[i] += giftsExchange[i][j];
			}
		}
		
		int[] sum2 = new int[friends.length];
		// sum2[0] = giftsExchange[1][0] + giftsExchange[2][0] + giftsExchange[3][0]; // giftsExchange[0][0] 제외
		
		// sum2[1] = giftsExchange[0][1] + giftsExchange[2][1] + giftsExchange[3][1]; // giftsExchange[1][1] 제외
		for(int i = 0; i < giftsExchange.length; i++) {
			for(int j = 0; j < giftsExchange[i].length; j++) {
				if(j == i) {
					continue;
				}
				sum2[i] += giftsExchange[j][i];
			}
		}
		
		for(int i = 0; i < friends.length; i++) {
			giftsPoint[i] = sum1[i] - sum2[i];
		}
	
		
		for(int i = 0; i < friends.length; i++) {
			for(int j = 0; j < friends.length; j++) {
				
				if(j == i) { // i==j 자신이므로 제외
					continue;
				}
				
				if( giftsExchange[i][j] != 0 ) { // i가 j에게 선물을 준 적 있을 때
					if (giftsExchange[i][j] > giftsExchange[j][i] ) { // i가 j보다 더 많이 줬을때
						giftsCount[i]++; 
					} else if( giftsExchange[i][j] == giftsExchange[j][i] ) { // 선물을 주고 받은 횟수가 같을 때
						if(giftsPoint[i] > giftsPoint[j]) { // i의 선물지수가 더 높을 때
							giftsCount[i]++;
						} 
					}
					
				} else { // i가 j에게 선물을 준 적 없을 때, giftsExchange[i][j] == 0
					if( giftsExchange[i][j] == giftsExchange[j][i] ) { // 서로 주고 받은 적이 없음
						if(giftsPoint[i] > giftsPoint[j]) { // i의 선물지수가 더 높을 때
							giftsCount[i]++;
						}
					}
					
				}
			}
		}
		
		int max = 0;
		for(int i = 0; i < giftsCount.length; i++) {
			if(giftsCount[i] > max) {
				max = giftsCount[i];
			}
		}
		
//		System.out.print("giftsExchange : ");
//		System.out.println(Arrays.deepToString(giftsExchange));
//		System.out.print("giftsPoint : ");
//		System.out.println(Arrays.toString(giftsPoint));
//		System.out.print("giftsCount : ");
//		System.out.println(Arrays.toString(giftsCount));
		System.out.println(max);
		answer = max;
		return answer;
	}
}
