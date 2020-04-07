package date1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo3 {

	public static void main(String[] args) {
		/*
		 *  Date를 지정된 형식의 문자열로 변환하기
		 */
		Date today = new Date();
		
		SimpleDateFormat df = new SimpleDateFormat("S");
		String formatedDateText = df.format(today);
		
		System.out.println(formatedDateText);
	}
}
/*
 * 	패턴						출력
 * ------------------------------------------------------------------------
 * 	yyyy(연도)				2020
 * 	MM(월)					04				1월~9월까지도 2자리로표현. ex) 01, 02, ..., 09로 표현
 * 	M(월)					4
 * 	dd(일)					06				1일~9일까지도 2자리로표현. ex) 01, 02, ..., 09로 표현
 * 	d(일)					6
 * 	yyyy-MM-dd				2020-04-06
 * 	yyyy.m.d				2020.4.6
 * 	yyyy년 M월 d일				2020년 4월 6일
 * 	E(요일)					월
 * 	EEEE(요일)				월요일
 * 	a(오전/오후)				오전
 * 	H(0~23시)				10
 * 	h(1~12시)				10
 * 	mm(분)					12
 * 	m						12
 * 	ss(초)					52
 * 	s						52
 *	S(천분의일초)				683
 */
