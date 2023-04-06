package practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileEx {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/Commendata.properties");
		Properties p=new Properties();
		p.load(fis);
		String brow=p.getProperty("browser");
		String ul=p.getProperty("url");
		String un=p.getProperty("username");
		String pw=p.getProperty("password");
		System.out.println(brow);
		System.out.println(ul);
		System.out.println(un);
		System.out.println(pw);
	}

}
