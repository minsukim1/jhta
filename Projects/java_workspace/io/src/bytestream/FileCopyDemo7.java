package bytestream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class FileCopyDemo7 {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL("https://lh3.googleusercontent.com/proxy/dkgkGF33Ow7gm510uy2U9N0yWsytmkxaNDf5FOAzwJtTpteCjg5hIo4oLKguYMx8u9vnGyS1aXtEr3xBNzVPLGxnLV6sTrN-mgmLqI_zNgPLcuI9RVWxTg10_EjXfFcMWW0");
		
		InputStream is = url.openStream();
		FileOutputStream fos = new FileOutputStream("c:/files/사진.jpg");
		
		IOUtils.copy(is, fos);
	}
}
