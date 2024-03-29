package kr.co.jhta;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import kr.co.jhta.Dao.UserDao;
import kr.co.jhta.vo.User;

public class Main {

	public static void main(String[] args) {
		 String conf = "classpath:/spring/context.xml";
	      
	      GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(conf);
	      
	      UserDao userDao = ctx.getBean(UserDao.class);
	      
	      Scanner scanner = new Scanner(System.in);
	      
	      System.out.println("[사용자 관리]");
	      try {
	      while(true) {
	            System.out.println("--------------------------------------------------------------------------");
	            System.out.println("1.전체조회 2.조회(아이디) 3.조회(이름) 4.등록 5.삭제(아이디) 6.전체삭제 0.종료");
	            System.out.println("--------------------------------------------------------------------------");
	            
	            System.out.print("메뉴 선택> ");
	            int menuNo = scanner.nextInt();
	            
	            if (menuNo == 1) {
	               System.out.println("[전체조회]");
	               
	            } else if (menuNo == 2) {
	               System.out.println("[아이디로 조회]");
	               
	            } else if (menuNo == 3) {
	               System.out.println("[이름으로 조회]");
	               
	            } else if (menuNo == 4) {
	               System.out.println("[신규 사용자 등록]");
	               
	               System.out.print("아이디 입력> ");
	               String id = scanner.next();
	               System.out.print("비밀번호 입력> ");
	               String password = scanner.next();
	               System.out.print("이름 입력> ");
	               String name = scanner.next();
	               System.out.print("이메일 입력> ");
	               String email = scanner.next();
	               
	               User user = new User();
	               user.setId(id);
	               user.setPassword(password);
	               user.setName(name);
	               user.setEmail(email);
	               
	               userDao.insertUser(user);
	               System.out.println("<<사용자 등록 완료>>");
	               
	            } else if (menuNo == 5) {
	               System.out.println("[아이디로 삭제]");
	               
	            } else if (menuNo == 6) {
	               System.out.println("[전체 삭제]");
	               
	            } else if (menuNo == 0) {
	               System.out.println("[프로그램을 종료합니다.]");
	               ctx.destroy();
	               break;
	            }
	      }
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      }


	}

}
