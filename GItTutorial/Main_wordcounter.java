import java.io.IOException;
import java.util.Scanner;

public class Main_wordcounter {
	public static void main(String[] args) throws IOException{
		System.out.println("Please Type: URL & Keyword:");
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String urlStr = sc.next();
			String keyword = sc.next();
			
			WordCounter counter = new WordCounter(urlStr);
			int count = counter.countKeyword(keyword);
			System.out.println(count);
		}
	}
}
