package ex1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ExceptionDemo4 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.bloter.net/wp-content/uploads/2016/08/%EC%8A%A4%EB%A7%88%ED%8A%B8%ED%8F%B0-%EC%82%AC%EC%A7%84.jpg");
			InputStream in = url.openStream();
			System.out.println("해당 인터넷 리소스와 연결이 완료되었습니다.");
			
			System.out.println("사진 저장을 시작합니다.");
			FileOutputStream out = new FileOutputStream("c:/files/star.png");
			
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len=in.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
			out.close();
			
			System.out.println("사진이 저장완료되었습니다.");
		} catch (MalformedURLException e) {
			//e.printStackTrace();
			String errorMessage = e.getMessage();
			System.out.println("에러 메세지 : "+ errorMessage);
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			String errorMessage = e.getMessage();
			System.out.println("에러 메세지 : "+ errorMessage);
		} catch (IOException e) {
			//e.printStackTrace();
			String errorMessage = e.getMessage();
			System.out.println("에러 메세지 : "+ errorMessage);
		}
	}
}
