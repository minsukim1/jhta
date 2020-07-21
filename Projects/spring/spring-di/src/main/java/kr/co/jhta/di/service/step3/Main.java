package kr.co.jhta.di.service.step3;

import kr.co.jhta.di.service.ConsoleOutput;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * Reporter객체는 더이상 자신이 의존하는 객체를 생성하지 않는다.
		 * Reporter객체는 필요한 객체를 전달받는 setter 메소드를 가지고 있다.
		 * Reporter의 주요 기능을 사용하기 위해서는 반드시 Reporter객체가 의존하는
		 * 객체를 제공해 줄 필요가 있다.
		 * Reporter객체는 더 이상 의존하는 객체에 대한 생성 책임이 없어진다.
		 */
		
		// 프로그램 실행에 필요한 객체 생성
		ConsoleOutput consoleOutput = new ConsoleOutput();
		
		// 프로그램 실행에 필요한 객체들끼리 조힙
		Reporter reporter = new Reporter();
		
		// 실제 작업 수행
		reporter.setOutput(consoleOutput);
		reporter.report("인터페이스 의존", "직접 의존하는 객체를 생성하지 않는다.");

	}

}
