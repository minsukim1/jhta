package control;

public class WhileDemo5 {

	public static void main(String[] args) {

		// 1+ (-2) + 3 + (-4) + 5 + .... 몇까지 더하면 총합이 100이상 되는지 구하기
		
		int sum = 0;
		int num  = 1;
		while(sum<99) {
			// number 의 값이 홀수면 sum에 그냥 더하고, 아니면 -1을 곱한 후 더한다.
			// sum의 값이 100 이상이면 탈출한다.
			// number의 값을 1증가시킨다.
			
			num++;
			sum +=(num%2==0?-1:1)*num;
			
			/* 절대값으로 구하기
			 * if(num%2==1) {
				num = num*1;
			} else {
				num = num*-1;
			}
				sum +=num;
				num = Math.abs(num);
			 */
			
			/*  if문으로 구하기
			 *  if (number%2 == 0) {
			 *      sum += number*-1;
			 *  } else {
			 *      sum += number;
			 *  }
			 */
		}
		System.out.println("sum = "+sum+" num = "+num);
	}
}
