package oop5;

import java.util.Arrays;

public class OxQuizService {

	void calcu(String[] data) {
		int count =0;
		int sum =0;
		for(int i=0; i<data.length; i++) {
			if(data[i].equals("O")){
				count++;
				sum +=count;
			} else if(data[i].equals("X")) {
				count = 0;
			} else {
				System.out.println((i+1)+"번쨰에 다른 문자"+data[i]+"가 입력됐습니다!");
			}
		}
		System.out.println(Arrays.toString(data)+"--->"+sum);
		
	}
}
