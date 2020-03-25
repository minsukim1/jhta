package oop6;

public abstract class AbstractJobTemplate {
	
	// 템플릿 패턴
	//		- 어떤 작업을 처리할 때 전체 일을 수행하는 구조는 바뀌지 않으면서
	//		특정 단계에서 수행하는 내용을 바꾸는 패턴
	//		전체 작업 단계에서 동일한 작업들은 부모클래스에 미리 구현을 하고,
	//		- 각각의 작업마다 바뀌는 부분은 자식클래스에게 구현을 위임한다.
	//		이렇게 함으로써, 코드의 중복을 줄이고, 개발자의 구현부담을 감소시킬 수 있다.
	//		- 전체 작업의 단계가 복잡한 경우, 부모클래스에서 순서대로 작업의 단계를 실행시키는
	//		메소드를 구현해 놓으면, 개발자는 작업의 순서를 신경쓰지 않고,
	//		각 작업에 대한 구체적인 구현만 코딩하면 된다.
	void setup() {
		System.out.println("### 전처리 작업 시작 ###");
		System.out.println("데이터베이스 서버에 연결을 요청함.");
		System.out.println("데이터베이스와 연결이 완료됨");
		System.out.println("### 전처리 작업 완료 ###");
	}
	
	// 추상메소드
	// 자손 클래스에 실제 구현을 위임하기 위해서 메소드 설계(정의,선언)함
	abstract void work();
	
	void destroy() {
		System.out.println("### 후처리 작업 시작 ###");
		System.out.println("데이터베이스 서버에 연결해제를 요청함");
		System.out.println("데이터베이스와 연결이 해제됨");
		System.out.println("### 후처리 작업 완료 ###");
	}
	
	// 작업을 처리하기 위해서 순서에 맞게 메소드들을 실행하는 메소드
	void run() {
		setup();
		work();
		destroy();
	}
}
