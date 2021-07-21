package pack.info;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UrlInfo {
	private static UrlInfo instance = null;
	public static String url;
	
	Properties properties = new Properties();
	
	private UrlInfo() {
		try {
			InputStream file = new FileInputStream(new File("url.properties"));
			properties.load(file);
			url = properties.getProperty("URL");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static UrlInfo getInstance() {
		if (instance == null) {
			instance = new UrlInfo();
		}
		return instance;
	}
	
	public Properties getProperties() {
		return properties;
	}
}
