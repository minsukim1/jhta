
package date1;

import java.util.Date;

public class DateDemo1 {

	public static void main(String[] args) {
		
		// 시스템의 현재 시간정보를 포함하는 Date객체가 생성된다.
		Date now = new Date();
		System.out.println(now);
		
		long unixTime = now.getTime();
		
		// 1970-01-01 00:00:00 이후로부터 Date객체가 가르키는 시간까지의 밀리초값
		System.out.println(unixTime);
	
		unixTime = System.currentTimeMillis();
		System.out.println(unixTime);
	}
}

/*		Date
 * 		주요 생성자
 * 			new Date() 						// 현재 날짜와 시간정보를 포함하는 객체 생성
 * 			new Date(long Time) 			// 전달받은 유닉스타임에 해당하는 날짜/시간정보를 포함하는 객체 생성
 * 		주요 메소드		
 * 			long getTime()					// 유닉스타임을 반환
 * 			boolean before(Date when)		// when으로 전달받은 날짜보다 이전날짜이면 true반환
 * 			boolean after(Date when)		// when으로 전달받은 날짜보다 이후날짜이면 true반환
 * 
 * 		SimpleDateFormat
 * 			날짜를 지정된 형식의 텍스트로 변환
 * 			String format(Date day)
 * 			
 * 			지정된 형식의 텍스트를 날짜로 변환
 * 			Date parse(String text)
 * 			y 년
 *  		M 월
 *   		d 일
 *    		E 요일
 *     		a 오전/오후
 *      	H 시간(0~23)
 *       	h 시간(1~12)
 *        	m 분(0~59)
 *         	s 초(0~59)
 *          S 밀리초(0~999)
 */
