package web_group3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WordCounter {private String urlStr;
private String content;

public WordCounter(String urlStr) {
	this.urlStr = urlStr;
}


private String fetchContent() throws IOException{
	String retVal = "";
	try{
	URL url = new URL(this.urlStr);
	URLConnection conn = url.openConnection();
	InputStream in = conn.getInputStream();
	BufferedReader br =  new BufferedReader(new InputStreamReader(in));
	String line = null;
	while((line = br.readLine()) != null) {
		retVal = retVal + line + "\n";
	}
	}catch(Exception e){
		retVal = "Shut a fuck up";
	}	
	return retVal;
	}
	
	


public int countKeyword(String keyword) throws IOException{
	if (content == null) {
		content = fetchContent();
	}
	
	content = content.toUpperCase();
	keyword = keyword.toUpperCase();
	
	
	int x = content.indexOf(keyword);
	int Value = 0;
	while (x != -1) {
		Value = Value + 1;
		x = content.indexOf(keyword, x+1);
	    }
	    return Value ;
}
}
