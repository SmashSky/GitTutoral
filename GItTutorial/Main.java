package web_group3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {public static void main(String[] args) throws IOException, InterruptedException {
	Scanner sc = new Scanner(System.in);
	HashMap<String, String>  map = new HashMap<String, String>();
	KeywordHeap heap= new KeywordHeap();
	while (sc.hasNextLine()) {
		String search = sc.next();
		GoogleQuery google = new GoogleQuery(search);
		map.putAll(google.query());
		for(Object key: map.keySet()) {
			//System.out.println(key+":"+map.get(key));
			String keyword ="sex";
			String urlStr =  map.get(key);
			WordCounter counter = new WordCounter(urlStr);
			//System.out.println(urlStr);
			int count = counter.countKeyword(keyword);
			String name =  (String) key;			
			String url = map.get(key);
			heap.add(new Keyword(name, -1*count, url));
			//System.out.println(count);
		}
		heap.output();
	//for(Object key: map.keySet()) {
		//System.out.println(key+":"+map.get(key));
		//String keyword = "iphone";
		//String urlStr = (String) map.get(key);
		//WordCounter counter = new WordCounter(urlStr);
		//int count = counter.countKeyword(keyword);
		//System.out.println(count);
		//System.out.println(map);
	}
	//HashMap<String,Integer> map2 = new HashMap<String,Integer>();
	sc.close();
}

}
