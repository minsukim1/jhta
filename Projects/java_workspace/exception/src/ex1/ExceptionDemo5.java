package ex1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ExceptionDemo5 {

	public static void main(String[] args) {
		try {
			ExceptionDemo5
				.saveImage("https://www.bloter.net/wp-content/uploads/2016/08/%EC%8A%A4%EB%A7%88%ED%8A%B8%ED%8F%B0-%EC%82%AC%EC%A7%84.jpg");
		} catch (Exception e) {
			
		}
	}
	
	private static void saveImage(String path) throws Exception {
		try {
			URL url = new URL(path);
			
			InputStream in = url.openStream();
			FileOutputStream out = new FileOutputStream("c:/files/iu.jpg");
			
			byte[] buf = new byte[1024];
			int len = 0;
			while((in.read(buf)) != -1) {
				out.write(buf,0,len);
			}
			out.close();
		} catch (FileNotFoundException e) {
			Exception ex = new Exception("파일을 찾을 수 없습니다.");
			throw ex;
		} catch (MalformedURLException e) {
			Exception ex = new Exception("URL이 올바른 형식이 아닙니다.");
			throw ex;
		} catch (IOException e) {
			Exception ex = new Exception("I/O작업중 오류가 발생했습니다.");
			throw ex;
		}
	}
}
