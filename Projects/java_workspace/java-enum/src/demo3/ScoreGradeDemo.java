package demo3;

public class ScoreGradeDemo {

	public static void main(String[] args) {
		ScoreGrade grade1 = ScoreGrade.A;
		ScoreGrade grade2 = ScoreGrade.B;
		
		System.out.println("최저점수 : " + grade1.getLow() + " 최고점수 : "+ grade1.getHigh());
	}
}
