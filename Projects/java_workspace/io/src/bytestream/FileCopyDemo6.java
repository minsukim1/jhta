package bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class FileCopyDemo6 {

	public static void main(String[] args) throws IOException{
		FileInputStream fis = new FileInputStream("c:/files/AmaterasUML_1.3.4.zip");
		FileOutputStream fos = new FileOutputStream("c:/files/AmaterasUML_1.3.4-copy2.zip");
		
		IOUtils.copy(fis, fos);
	
	}
}