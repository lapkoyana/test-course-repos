package pack.info;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UrlInfo {
	public String url;
	
	public UrlInfo() {
		try {
			InputStream file = new FileInputStream(new File("url.properties"));
			Properties properties = new Properties();
			properties.load(file);
			url = properties.getProperty("URL");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
