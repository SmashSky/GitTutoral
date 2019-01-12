package HW10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class GoogleQuery {
	public String searchKeyword;
	public String url;
	public String content;

	public GoogleQuery(String searchKeyword) {
		this.searchKeyword = searchKeyword;
		this.url = "http://www.google.com/search?q=" + searchKeyword + "&oe=utf8&num=100";
	}

	private String fetchContent() throws IOException, InterruptedException {
		String retVal = "";
		URL urlStr = new URL(this.url);
		URLConnection conn = urlStr.openConnection();
		conn.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
		conn.connect();
		InputStream in = conn.getInputStream();
		InputStreamReader inReader = new InputStreamReader(in, "utf-8");
		BufferedReader bf = new BufferedReader(inReader);

		String line = null;
		while ((line = bf.readLine()) != null) {
			retVal += line;
		}

		return retVal;
	}

	public HashMap<String, String> query() throws IOException, InterruptedException {
		if (this.content == null) {
			this.content = fetchContent();
		}

		HashMap<String, String> retVal = new HashMap<String, String>();
		Document doc = Jsoup.parse(this.content);
		Elements lis = doc.select("div.g");

		for (Element li : lis) {
			try {
				Element h3 = li.select("h3.r").get(0);
				String title = h3.text();

				Element cite = li.select("cite").get(0);
				String citeUrl = cite.text();
				System.out.println(title + " " + citeUrl);
				retVal.put(title, citeUrl);
			} catch (IndexOutOfBoundsException e) {
				// DO NOTHING
				// System.out.println(e);
			}
		}

		return retVal;
	}

}
