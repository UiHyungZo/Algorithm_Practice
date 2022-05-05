package com.java.practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 문제 : 이상한 계산기는 두 가지 버튼과 숫자를 출력하는 화면으로 구성되어 있다. 숫자를 출력하는 화면은 총 5자리의 정수를 표현할 수 있다. 각 버튼은 현재까지의 계산 결과에 어떠한 연산을 할지를 나타내는 것으로, 각 버튼은 다음과 같이 연산을 수행한다.

		Mul : 현재까지의 계산 결과에 2를 곱한다
		Div : 현재까지의 계산 결과를 3으로 나눈다. 
		단, 결과가 정수가 아닐 경우, 소수점 이하를 모두 버린다. 
		계산기를 작동시키면, 현재까지의 계산 결과로써 1이 출력된다. 
		이후 사용자가 어떻게 버튼을 누르냐에 따라 출력되는 숫자가 달라진다. 
		예를 들어, 계산기를 작동시키면 1이 출력되고, 여기서 Mul를 누르면 2가 되며, 
		또 Mul을 누르면 4가 출력된다.
		영수는 이 계산기가 모든 숫자를 출력할 수 있는지 궁금해졌다. 
		하지만 영수는 버튼을 누르는 것 조차 매우 귀찮은 일이기 때문에, 
		계산기의 버튼을 최대한 적은 횟수만큼만 누르고 싶어 한다.
		 숫자 N이 주어질 때, 계산기를 작동시켜 숫자 N을 만들기 위하여 최소 몇 번 버튼을 눌러야 하는지를
		  구하는 프로그램을 작성하시오. 
		  예를 들어, 숫자 10을 만들기 위해서는 1 → 2 → 4 → 8 → 16 → 5 → 10 가 되게끔 버튼을 누르면
		   되므로, 버튼을 6번만 누르면 되고, 이것이 최솟값이다.
		    참고로, 이상한 계산기는 5자리 정수까지밖에 표현할 수 없으며, 
		    만약 연산 결과가 5자리를 넘어가는 경우에는 계산기가 고장나버린다.
		     따라서 항상 계산 결과를 최대 5자리로 유지해야 한다.
		     
	입력 : 첫째 줄에는 이상한 계산기로 만들고자 하는 숫자 N이 주어진다. 
		( 1 ≤ N ≤ 99,999 ) 단, 계산기로 만들 수 없는 값은 주어지지 않는다.
		
	출력 : 이상한 계산기로 숫자 N을 만들기 위해 눌러야 하는 최소 버튼 클릭 횟수를 출력한다.
	
	예제 입력
	10
	
	예제 출력
	6
 */

public class Strange_calculator {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] value = new int[1000000];
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		value[1] = 1;
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			int mul = temp*2;
			int div = temp/3;
			
			if(mul>0 && mul<=99999) {
				if(value[mul] == 0) {
					value[mul] = value[temp]+1;
					queue.add(mul);
				}else {
					value[mul] = Math.min(value[mul], value[temp]+1);
				}
				
				if(mul == n) {
					break;
				}
				
			}
			
			
			if(div>0 && div<=99999) {
				if(value[div] == 0) {
					value[div] = value[temp]+1;
					queue.add(div);
				}else {
					value[div] = Math.min(value[div], value[temp]+1);
				}
				
				if(div == n) break;
				
			}
			
			
		}
		
		System.out.println(value[n]-1);
		
	}
	

}
